# 不再维护，不再维护，不再维护，不再维护，不再维护

# 简介
定义了一种组织项目结构的样例。此结构要达到的目的是
- 做到业务与显示分离，一套业务，多种视图方式。比如RESTful，MVC（在本文档中,MVC指由java web项目提供视图,比如jsp,freemarker等），RPC。
- 做到业务与核心基础类分离。经常看见同一个功能，散落在项目的各个地方，并且这些功能与业务也没有关系，这些功能应该作为基础功能放在lang模块中。
- 做到部署与业务分离，比如RESTful，MVC，RPC，可以分别部署，尤其是RPC服务，必须单独部署，因为每个RPC框架都有自身的部署方式，比如集群部署，直连。
- 做到方便的扩展成spring cloud项目。由于使用的是spring boot方式，因此只要你熟悉和搭建了spring cloud环境，这些单个的spring boot项目，进过一些相对简单的改造后，很容易就加入到spring cloud中。根据我的亲身经历，这绝对不是问题。

# quick start
1. 下载[project-common](https://github.com/wuda0112/project-common)项目
```
git clone https://github.com/wuda0112/project-common.git
```
然后 maven clean install

2. 下载本项目
```
git clone https://github.com/wuda0112/project-structure-archetype.git
```

3. 运行 RESTful
```
服务端 : com.wuda.web.rest.server.RestApplication
客户端 : com.wuda.web.rest.client.api.SystemClientTest
```

4. 运行 rpc
```
服务端 : com.wuda.rpc.server.DubboProvider
客户端 : com.wuda.rpc.client.DubboConsumer
```
5. 运行 mvc
```
服务端 : com.wuda.web.mvc.MvcApplication
浏览器输入 : http://localhost:8080/swagger-ui.html
```
6. 如果调用**pingMysql**服务，必须先配置你的mysql datasource,默认是localhost:3306,配置文件在src/main/resources/application.properties

7. 说明
项目完全按照spring boot项目方式运行，因此各种配置，比如tomcat的端口,数据库datasource等的配置，完全就是spring boot方式配置

# uml设计图

![image](https://github.com/wuda0112/project-structure-archetype/blob/master/diagram.png)

# 前端控制器
- web
- - rest-server，提供RESTFul服务
- - rest-client，以接口形式调用rest-server服务
- - mvc-server，MVC指由java web项目提供视图,比如jsp,freemarker
- - web-model，为RESTFul和mvc提供model
- RPC
- - rpc-server，rpc服务端
- - rpc-client，rpc客户端
- - 由于service层的API与实现分离，所以可以很容易的使用上dubbo,motan等RPC框架

- 职责
- - 这一层不做任何业务,只负责请求分发，然后将结果展示给终端。
- - 参数检查也不处理，理由是:如果有两种web,比如rpc和RESTful,难道两个地方都执行大同小异的检查？
当然与这种接口特定的，而且与业务逻辑无关的参数，可以分别处理。

# service

- service-api
- - 和名字一样，包含服务接口部分
- service-impl
- - 和名字一样，就是实现
- service-model
- - 输入输出需要的model


- 职责
- - 参数检查，保证接口的健壮性
- - 处理产品业务逻辑
- - 返回此业务逻辑的结果

# lang
包括项目中的基础类，而且是不包含任何业务逻辑的类，供上层使用。lang这个名称，参考了java.lang的语义。
- 职责
- - 不能包含任何产品业务逻辑，比如根据用户id查询用户名称这样的操作，这种接口很多业务都会调用，但是不管什么业务，对于这个接口来说都不需要关心。

# dao
数据访问层，可以是dao-mysql，dao-mongodb，dao-redis等等，将各种数据访问的处理细节与业务分离。

-　注意
- - 如果使用mybatis访问数据库，==使用注解的方式处理sql语句==，不要使用xml配置文件，理由是：注解的方式更直观，更易于维护，想象下spring的发展，从以前很多配置文件，到现在的基本上不用配置文件，绝大部分都是使用注解的方式，如果叫你再去使用配置文件开发spring应用，你愿意返回去吗？

- 编码约定
- - 建立和业务同名的数据访问对象，比如,有个XxxService,则XxxMapper.java与之对应，不以表聚合，而是以类的职责聚合。

# 公共模块
多个微服务之间，绝大部分都会有公共信息，因此这些公共信息在项目[project-common](https://github.com/wuda0112/project-common)中。

# 各层领域模型规约
- 当参数较少时，尽量不用对象类型的参数，而是把各个参数列出来。
- 对于这些领域对象，只能包含属性，getter/setter，toString,equals方法，
方法中不能包含任何业务逻辑。

# 技术框架
- spring
- feign
- dubbo
- thymeleaf
- swagger2
- jackson
- mybatis
- tomcat-jdbc
- lombok
