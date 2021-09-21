### 服务组件
1. Service register & config center ： nacos
2. Service invocation: Feign
3. Service Circuit Breaking ： Alibaba Sentinel
4. Service Gate: Spring Gate Way
6. Tracing Analysis: Sleuth
9. Message Broker: Spring Cloud Stream
10. Message BUS: SpringCloud bus
11. Restful : p
12. Spring JPA : spring-data-commons

### 待开发模块
1. Swagger
### 注意事项
#### 1. 网关uri配置事项
```
在gateway中配置uri配置有三种方式，包括
第一种：ws(websocket)方式: uri: ws://localhost:9000
第二种：http方式: uri: http://localhost:8130/
第三种：lb(注册中心中服务名字)方式: uri: lb://brilliance-consumer
```
- 跨域配置可以在配置类中 也可以在配置文件中配置
### 2. sentinel配置注意事项
#### 1. 可以配置规则的位置
- 在网关中配置限流的自定义API、限流规则、自定义异常处理（参考gateway模块）
- 在sentinel 控制台配置限流熔断等规则
- 在每个子项目中配置sentinel(不推荐)
#### 2. 持久化规则配置
默认的规则是存在内存中的，一旦sentinel重启，规则将消失，我们可以考虑将规则存入nacos
### 3. 配置文件
1. 默认bootstrap.yaml
2. 子模块的配置文件可以通过
```yaml
 1. Redission 配置，特殊情况
 Config config = Config.fromYAML(RedisConfiguration.class.getClassLoader().getResource("redisson-config.yml"));
 2. 普通的配置文件
spring:
  profiles:
    active: dev, core
#   include: dev,core


```
多个配置文件中有同一个值，以下情况获取值的效果：
1. 启动命令不带--spring.profiles.active参数以application.properties首先启动
按顺序所有文件第一个配置的spring.profiles.active属性中指定的最后一个文件中含有该属性的值为准
如果所有文件都没有spring.profiles.active，那么以pring.profiles.include配置的最后一个属性文件中的值为准
2. 启动命令带--spring.profiles.active参数以参数指定的属性文件首先启动
此情况，已命令指定的配置文件中的值为准，其他文件中再配置spring.profiles.active也不会生效，如果不存在值，那么会以pring.profiles.include指定的最后一个文件中的值为准

###### 简要说
启动命令spring.profiles.active指定文件中的值 > 文件中spring.profiles.active指定的文件列表中最后一次出现的值 > 文件中spring.profiles.include指定的文件列表中最后一次出现的值

（注意：无论是否配置启动命令参数指定文件，最后都会加载application.properties，它里边配置的信息也很关键）