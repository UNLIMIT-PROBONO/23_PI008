from django.apps import AppConfig

class ElectricityappConfig(AppConfig):
    default_auto_field = "django.db.models.BigAutoField"
    name = "ElectricityApp"

    def ready(self):
        # 앱이 준비될 때 실행할 코드를 여기에 작성합니다.
        pass
