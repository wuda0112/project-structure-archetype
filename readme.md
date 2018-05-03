# 简介
定义了一种组织项目结构的样例。此结构要达到的目的是
- 做到业务与显示分离，一套业务，多种视图方式。比如RESTful，MVC（在本文档中,MVC指由java web项目提供视图,比如jsp,freemarker等），RPC。
- 做到业务与核心基础类分离。经常看见同一个功能，散落在项目的各个地方，并且这些功能与业务也没有关系，这些功能应该作为基础功能放在lang模块中。
- 做到部署与业务分离，比如RESTful，MVC，RPC，可以分别部署，尤其是RPC服务，必须单独部署，因为每个RPC框架都有自身的部署方式，比如集群部署，直连。
- 做到方便的扩展成spring cloud项目。由于使用的是spring boot方式，因此只要你熟悉和搭建了spring cloud环境，这些单个的spring boot项目，进过一些相对简单的改造后，很容易就加入到spring cloud中。根据我的亲身经历，这绝对不是问题。

# quick start
- 多个微服务之间一般都会有公共内容，因此我把这些公共内容放到了另外一个项目[common](https://github.com/wuda0112/project-common)中，所以先把这个项目下载下来，然后maven clean install，把jar包安装到本地，不然会找不到依赖，除了这个依赖，其他都可以从中心仓库下载


- **运行RESTful和MVC**
- - 下载源码到你本地
- - 运行web模块的com.wuda.web.WebApplication.java，启动服务
- - 在浏览器中输入以下地址，即可看见暴露的接口
```
http://localhost:8080/swagger-ui.html
```
- - 如果调用**pingMysql**服务，必须先配置你的mysql datasource,默认是localhost:3306,配置文件在src/main/resources/application.properties


- **运行RPC**
- - 下载源码到你本地
- - 运行rpc-server模块的com.wuda.rpc.server.DubboProvider.java，启动rpc服务
- - 运行rpc-client模块的com.wuda.rpc.client.DubboConsumer.java，调用rpc服务端
- - 如果调用**pingMysql**服务，必须先配置你的mysql datasource,默认是localhost:3306,配置文件在src/main/resources/application.properties


# 说明
项目完全按照spring boot项目方式运行，因此各种配置，比如tomcat的端口,数据库datasource等的配置，完全就是spring boot方式配置

# UI,用户界面
- web
- - RESTful,MVC；MVC指由java web项目提供视图,比如jsp,freemarker
- RPC
- - 由于service层的API与实现分离，所以可以很容易的使用上dubbo,motan等RPC框架

- 职责
- - 这一层不做任何业务,只负责请求分发，然后将结果展示给终端。
- - 参数检查也不处理，理由是:如果有两种web,比如rpc和RESTful,难道两个地方都执行大同小异的检查？
当然与这种接口特定的，而且与业务逻辑无关的参数，可以分别处理。

# service
顾名思义，就是处理产品业务逻辑。分成两大部分,service-model-api和service-impl，分成两部分的理由是：**兼容RPC编程模型**。

- service-model-api
- - 和名字一样，包含model和api两部分
- service-impl
- - 和名字一样，就是实现


- 职责
- - 参数检查，保证接口的健壮性
- - 处理产品业务逻辑
- - 返回此业务逻辑的结果

- 细节
- - 如果是本业务特有的逻辑，并且需要访问数据库，队列，缓存等存储时，建立和此业务同名的数据访问对象，比如xxxDAO.java，不以表聚合，而是以业务聚合

# lang
包括项目中的基础类，而且是不包含任何业务逻辑的类，供上层使用。lang这个名称，参考了java.lang的语义。
- 职责
- - 不能包含任何产品业务逻辑，比如根据用户id查询用户名称这样的操作，这种接口很多业务都会调用，但是不管什么业务，对于这个接口来说都不需要关心。

- 细节
- - 如果需要访问数据库，队列，缓存等存储时，建立和此业务同名的数据访问对象，比如xxxDAO.java，不以表聚合，而是以类的职责聚合。

# dao
数据访问层，可以是dao-mysql，dao-mongodb，dao-redis等等，将各种数据访问的处理细节与业务分离。

-　注意
- - 如果使用mybatis访问数据库，==使用注解的方式处理sql语句==，不要使用xml配置文件，理由是：注解的方式更直观，更易于维护，想象下spring的发展，从以前很多配置文件，到现在的基本上不用配置文件，绝大部分都是使用注解的方式，如果叫你再去使用配置文件开发spring应用，你愿意返回去吗？


# RPC
由于service层的API和实现是分离的，因此你不需要做任何改变就可以轻易的使用上RPC，选择你熟悉的RPC框架就可以了。更重要的是，你可以完全独立的部署，调优RPC服务。样例中使用了**dubbo**

- rpc-server
- - 以spring boot方式运行，对已有的serice没有任何侵入性，几乎只需要把精力完全放在配置和优化rpc框架本身。
- rpc-client
- - 对server端提供的服务做一个整合，做到调用方引入后，直接通过方法调用即可。当然，服务端的IP地址等信息还是要配置的，但仅仅只是配置这些即可。剩下的就是把精力放在RPC框架本身的调优。

# 公共模块
多个微服务之间，绝大部分都会有公共信息，因此这些公共信息在项目[common](https://github.com/wuda0112/project-common)中。
