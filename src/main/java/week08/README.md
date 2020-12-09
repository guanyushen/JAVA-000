# 

```

   分库分表使用sharding-proxy实现，需要先去官网下载
   下载地址： https://mirrors.tuna.tsinghua.edu.cn/apache/shardingsphere/4.1.0/apache-shardingsphere-4.1.0-sharding-proxy-bin.tar.gz
   下完后解压，将自己的jar包复制到 sharding proxy 的 lib/ 目录下，
   修改 sharding proxy 的 conf/ 目录下server.yaml和config-sharding.yaml
   启动在 sharding proxy 的 lib/ 目录下的start.sh
```

```
   
   第 15 节课作业实践
   1、（选做）分析前面作业设计的表，是否可以做垂直拆分。 
   2、（必做）设计对前面的订单表数据进行水平分库分表，拆分2个库，每个库16张表。
   并在新结构在演示常见的增删改查操作。代码、sql 和配置文件，上传到 Github。 
   3、（选做）模拟1000万的订单单表数据，迁移到上面作业2的分库分表中。 
   4、（选做）重新搭建一套4个库各64个表的分库分表，将作业2中的数据迁移到新分库
   
   
   第 16 课作业实践 1、（选做）列举常见的分布式事务，简单分析其使用场景和优缺点。 
   2、（必做）基于hmily TCC或ShardingSphere的Atomikos XA实现一个简单的分布式 事务应用demo（二选一），提交到github。 
   3、（选做）基于ShardingSphere narayana XA实现一个简单的分布式事务demo。 
   4、（选做）基于seata框架实现TCC或AT模式的分布式事务demo。 
   5、（选做☆）设计实现一个简单的XA分布式事务框架demo，只需要能管理和调用2 个MySQL的本地事务即可，不需要考虑全局事务的持久化和恢复、高可用等。 
   6、（选做☆）设计实现一个TCC分布式事务框架的简单Demo，需要实现事务管理器， 不需要实现全局事务的持久化和恢复、高可用等。 
   7、（选做☆）设计实现一个AT分布式事务框架的简单Demo，仅需要支持根据主键id 进行的单个删改操作的SQL或插入操作的事务。
   
```