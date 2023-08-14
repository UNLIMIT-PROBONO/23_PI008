from django.db import models

# Create your models here.
from django.db import models

class Electricity(models.Model):
    usage = models.IntegerField()
    user = models.ForeignKey('auth.User', on_delete=models.CASCADE, related_name='electricity', null=True)
    created_at = models.CharField(max_length=255, null=True)

    class Meta:
        db_table = 'electricity'  # 실제 데이터베이스의 테이블 이름
