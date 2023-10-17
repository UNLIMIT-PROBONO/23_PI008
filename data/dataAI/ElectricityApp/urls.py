from django.urls import path
from . import views

urlpatterns = [
    path('api/electricity/', views.electricity_list, name='electricity_list'),
]
