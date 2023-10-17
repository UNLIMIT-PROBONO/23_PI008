from django.db import models

# Create your models here.
from django.db import models

class Users(models.Model):
    # id = models.BigAutoField(primary_key=True)
    is_activated = models.BooleanField(default=True)  # 기본값이 YES인 경우 default=True 추가
    created_at = models.CharField(max_length=255, blank=True, null=True)
    updated_at = models.CharField(max_length=255, blank=True, null=True)
    address = models.CharField(max_length=255)
    birth = models.CharField(max_length=255)
    user_check = models.CharField(max_length=255, db_column="check", blank=True)  # 원래 컬럼명이 "check"이므로 db_column 사용
    gender = models.CharField(max_length=255)
    health = models.CharField(max_length=255)
    name = models.CharField(max_length=255)
    phone_num = models.CharField(max_length=255)

    class Meta:
        db_table = 'users'
# class Managers(models.Model):
#     login_id = models.CharField(max_length=255)
#     password = models.CharField(max_length=255)
#     name = models.CharField(max_length=255)
#     admin_area = models.CharField(max_length=255)
#     phone_num = models.CharField(max_length=20)
#     created_at = models.DateTimeField(auto_now_add=True)
#     updated_at = models.DateTimeField(auto_now=True)
#     is_activated = models.BooleanField(default=True)

#     class Meta:
#         db_table = 'Managers'
