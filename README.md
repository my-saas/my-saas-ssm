# my-saas-ssm
## 背景
原有框架为单体架构(SSM),随着业务增加，越来越臃肿，存在以下缺点
* 1.复杂性高(所有业务耦合在一起)
* 2.部署不灵活且耦合(类似于全量更新服务，万一出现问题，会影响其他服务)
* 3.扩展能力受限
* 4.阻碍技术创新

## 集成nacos
* 访问URL: 
> http://localhost:8080/echo/ss
> http://localhost:8080/discovery/get?serviceName=my-saas-ssm
```json
[
    {
        "instanceId": "127.0.0.1#8080#DEFAULT#DEFAULT_GROUP@@my-saas-ssm",
        "ip": "127.0.0.1",
        "port": 8080,
        "weight": 1.0,
        "healthy": true,
        "enabled": true,
        "ephemeral": true,
        "clusterName": "DEFAULT",
        "serviceName": "my-saas-ssm",
        "metadata": {},
        "instanceHeartBeatTimeOut": 15000,
        "ipDeleteTimeout": 30000,
        "instanceIdGenerator": "simple",
        "instanceHeartBeatInterval": 5000
    }
]
```

