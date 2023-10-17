import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from statsmodels.tsa.arima.model import ARIMA
from statsmodels.tsa.stattools import adfuller
from sklearn.metrics import mean_absolute_error, mean_squared_error

# 데이터 불러오기
data = pd.read_csv('electricity_usage_data.csv', parse_dates=['date'], index_col='date')

# 시계열 데이터가 정상성을 만족하는지 확인, 시계열 데이터를 입력 받음
def test_stationarity(timeseries):
    # 이동평균과 이동 표준편차 계산
    moving_avg = timeseries.rolling(window=14).mean()
    moving_std = timeseries.rolling(window=14).std()

    # 원본 시계열과 이동평균 및 이동 표준편차 시각화
    plt.figure(figsize=(10, 6))
    plt.plot(timeseries, color='blue', label='Original')
    plt.plot(moving_avg, color='red', label='Rolling Mean')
    plt.plot(moving_std, color='green', label='Rolling Std')
    plt.legend()
    plt.title('Moving Average & Standard Deviation')
    plt.show()

    # Augmented Dickey-Fuller Test를 통한 정상성 확인
    result = adfuller(timeseries, autolag='AIC')
    print('ADF Statistic:', result[0])
    print('p-value:', result[1])
    print('Critical Values:')
    for key, value in result[4].items():
        print(f'   {key}: {value}')

# 정상성 검정 수행 - 1번 그래프
test_stationarity(data['usage'])

# 데이터 차분 수행 --> 1차 차분 - 2번 그래프(1차 차분을 적용한 후 데이터 시각화)
data_diff = data['usage'] - data['usage'].shift(1)
data_diff.dropna(inplace=True)

# 1차 차분된 데이터 정상성 검정 수행
test_stationarity(data_diff)

# ARIMA 모델 학습과 예측
p, d, q = 1, 1, 1
model = ARIMA(data['usage'], order=(p, d, q))
result = model.fit()

# 다음날 예상 전기 사용량 예측
next_day_prediction = result.forecast(steps=1)

print("다음날 예상 전기 사용량:", next_day_prediction[0])

# 예측 결과와 실제 값 비교 시각화
plt.figure(figsize=(10, 6))
plt.plot(data['usage'], color='blue', label='Original')
plt.plot(result.fittedvalues, color='red', label='Fitted')
plt.plot(next_day_prediction, color='green', label='Next Day Prediction')
plt.xlim(data.index[-14], data.index[-1])  # 최근 2주치 데이터만 보이도록 x축 범위 제한
plt.legend()
plt.title('ARIMA Model Forecast')
plt.show()

# 예측의 정확도 측정 (최근 2주 데이터를 사용)
fitted_values = result.fittedvalues.dropna()
num_samples = min(14, len(fitted_values))
mae = mean_absolute_error(data['usage'][-14:], fitted_values[-num_samples:])
rmse = np.sqrt(mean_squared_error(data['usage'][-14:], fitted_values[-num_samples:]))
print("MAE:", mae)
print("RMSE:", rmse)

# 예측값의 신뢰 구간 시각화
stderr = np.std(fitted_values[-num_samples:] - data['usage'][-14:])
confidence_interval = 2.33 * stderr   # 98% 신뢰구간 
lower_bound = next_day_prediction[0] - confidence_interval
upper_bound = next_day_prediction[0] + confidence_interval

plt.figure(figsize=(10, 6))
plt.plot(data['usage'][-30:], color='blue', label='Original')
plt.plot(data.index[-1] + pd.Timedelta(days=1), next_day_prediction, color='red', marker='o', markersize=8, label='Forecast')
plt.fill_between(data.index[-1:], lower_bound, upper_bound, color='gray', alpha=0.3, label='Confidence Interval (95%)')
plt.legend()
plt.title('Next Day Electricity Usage Forecast with Confidence Interval')
plt.show()

print("예상 정확도 구간 (98% 신뢰 구간):", (next_day_prediction[0] - confidence_interval, next_day_prediction[0] + confidence_interval))