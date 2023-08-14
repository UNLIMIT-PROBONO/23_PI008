from django.shortcuts import render

from rest_framework.response import Response
from rest_framework.decorators import api_view
from .models import Electricity
from .serializers import ElectricitySerializer
import pandas as pd
from statsmodels.tsa.arima.model import ARIMA



@api_view(['GET', 'POST'])
def electricity_list(request):
    if request.method == 'GET':
        data = Electricity.objects.all()
        serializer = ElectricitySerializer(data, many=True)
        return Response(serializer.data)

    elif request.method == 'POST':
        user_id = request.data.get('user_id')
        
        # 최근 2주간의 데이터를 가져옵니다.
        recent_data = Electricity.objects.filter(user_id=user_id).order_by('-created_at')[:14]

        if not recent_data.exists():
          return Response({"error": "Not enough data for the user"}, status=400)
    
        # 이 데이터를 pandas DataFrame으로 변환합니다.
        df = pd.DataFrame(list(recent_data.values()))
    
        # 'created_at'의 데이터 타입을 datetime으로 변환합니다.
        df['created_at'] = pd.to_datetime(df['created_at'], format="%Y/%m/%d %H:%M")
        df.set_index('created_at', inplace=True)
        df = df.sort_index()  # 이 부분을 추가하여 날짜 인덱스를 정렬합니다.
        df.index = pd.DatetimeIndex(df.index).to_period('D')
        
        # ARIMA 모델 설정
        model = ARIMA(df['usage'], order=(1, 1, 1))
        result = model.fit() 

        # 다음날의 예상 전기 사용량을 예측합니다.
        forecast = result.forecast(steps=1)
        prediction = forecast[forecast.index[0]] 
        
        return Response({"prediction": prediction})  # 예측 결과를 반환합니다.
