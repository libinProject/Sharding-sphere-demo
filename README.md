### 该项目是 分布式数据库 sharding sphere 结合 mybatis 的使用demo

#### 1. 引用 pom文件

>```xml
><dependency>
>            <groupId>io.shardingsphere</groupId>
>            <artifactId>sharding-proxy</artifactId>
>            <version>3.0.0.M1</version>
>        </dependency>
>        <dependency>
>            <groupId>io.shardingsphere</groupId>
>            <artifactId>sharding-jdbc-spring-boot-starter</artifactId>
>            <version>3.0.0.M1</version>
>        </dependency>
>```



#### 2. 配置多个数据源 已经分库分表规则

>```yml
>#分库数据库设置
>sharding.jdbc.datasource.names: sphere-0,sphere-1
>#数据分片设置
>sharding.jdbc.datasource.sphere-0:
>  type: org.apache.commons.dbcp.BasicDataSource
>  driver-class-name: com.mysql.jdbc.Driver
>  url: jdbc:mysql://localhost:3306/sharing-sphere-0?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true
>  username: root
>  password: mis
>
>sharding.jdbc.datasource.sphere-1:
>  type: org.apache.commons.dbcp.BasicDataSource
>  driver-class-name: com.mysql.jdbc.Driver
>  url: jdbc:mysql://localhost:3306/sharing-sphere-1?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true
>  username: root
>  password: mis
>
>#分库规则配置 分库键不要使用自增的主键
>sharding.jdbc.config.sharding.default-database-strategy.inline:
>  sharding-column: user_id
>  algorithm-expression: sphere-$->{user_id % 2}
>
>#t_order表分片规则配置 分片键不要使用自增的主键
>sharding.jdbc.config.sharding.tables.t_order:
>  actual-data-nodes: sphere-$->{0..1}.t_order_$->{0..1}
>  table-strategy.inline:
>    sharding-column: order_id
>    algorithm-expression: t_order_$->{order_id % 2}
>    key-generator-column-name: order_id
>```



#### 4. 分库分表规则解释

#### 5. spring boot 中 controller 返回字符串的时候，接口会执行俩次？？

>测试发现，当controller 直接返回OK的时候
>
>controller 会执行俩次
>
>因此，之前分表会导致多次执行

