from django.db import models

# Create your models here.
from django.db import models

class Water(models.Model):
    user = models.ForeignKey('auth.User', on_delete=models.CASCADE, related_name='water', null=True) # Users 모델과의 외래키 관계
    created_at = models.CharField(max_length=255, null=True)
    usage = models.IntegerField()

    class Meta:
        db_table = 'water'  # 실제 데이터베이스의 테이블 이름
