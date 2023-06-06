# 23_PI008
## 배포 방법
```cmd
// 도커 설치
sudo amazon-linux-extras install docker
sudo service docker start
sudo usermod -a -G docker ec2-user

// 도커 컴포즈 설치
sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
```

### docker-compose 빌드
```
docker-compose build .
```
### docker-comopse 실행
```
docker-compose -f docker-compose.yml up
```