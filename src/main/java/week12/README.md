# 

```
    redis主从实现：
   - 1.下载gz后解压复制三份redis文件，修改三个文件夹命名 
   
   - 2.修改master 7000  redis.conf
   shell script
   bind 0.0.0.0 #任意ip都可以连接
   
   protected-mode no #关闭保护，允许非本地连接
   
   port 7000 #端口号
   
   daemonize yes #后台运行
   
   pidfile /var/run/redis_7000.pid #进程守护文件，就是存放该进程号相关信息的地方
   
   dir /Users/guanys/Documents/soft/redis/redis-master/data #db等相关目录位置
   
   logfile "/Users/guanys/Documents/soft/redis/log/redis-master/redis.log"
   
   appendonly yes #开启日志形式
   
   requirepass XX #密码
   
   - 3.修改slave1 7001  redis.conf
    shell script
      bind 0.0.0.0 #任意ip都可以连接
      
      protected-mode no #关闭保护，允许非本地连接
      
      port 7001 #端口号
      
      daemonize yes #后台运行
      
      pidfile /var/run/redis_7001.pid #进程守护文件，就是存放该进程号相关信息的地方
      
      dir /Users/guanys/Documents/soft/redis/redis-slave1/data #db等相关目录位置
      
      logfile "/Users/guanys/Documents/soft/redis/log/redis-slave1/redis.log"
      
      appendonly yes #开启日志形式
      
      requirepas XX #密码
   
   
   - 4.修改slave2 7002  redis.conf
    shell script
     bind 0.0.0.0 #任意ip都可以连接
     
     protected-mode no #关闭保护，允许非本地连接
     
     port 7002 #端口号
     
     daemonize yes #后台运行
     
     pidfile /var/run/redis_7002.pid #进程守护文件，就是存放该进程号相关信息的地方
     
     dir /Users/guanys/Documents/soft/redis/redis-slave2/data #db等相关目录位置
     
     logfile "/Users/guanys/Documents/soft/redis/log/redis-slave2/redis.log"
     
     appendonly yes #开启日志形式
     
     requirepas XX #密码
    
   - 5.启动
   
   cd /Users/guanys/Documents/soft/redis/redis-master
   
   redis-server  ./redis.conf
   
   cd /Users/guanys/Documents/soft/redis/redis-slave1
   
   redis-server  ./redis.conf
   
   cd /Users/guanys/Documents/soft/redis/redis-slave2
   
   redis-server  ./redis.conf

```

```
    redis高可用实现（哨兵模式）：
   - 1.下载gz后解压复制三份redis文件，修改三个文件夹命名 
   
   - 2.修改master 17000  sentinel.conf
   shell script
   bind 127.0.0.1 192.168.1.1
   protected-mode no
   port 17000
   daemonize yes
   pidfile /var/run/redis-sentinel_17000.pid
   logfile "/Users/guanys/Documents/soft/redis/log/redis-17000/redis.log"
   dir /Users/guanys/Documents/soft/redis/log/redis-17000/tmp
   #设置 主名称 ip地址 端口号 参入选举的哨兵数
   #配置哨兵需要监控的主节点ip和端口，最后的2代表，如果有2个哨兵主观认为主节点down了，
   #那么就客观认为主节点down掉了，开始发起投票选举新主节点的操作。多个主节点配置多个。
   sentinel monitor mymaster 127.0.0.1 17000 2
   
   - 3.修改slave1 17001  sentinel.conf
   shell script
   bind 127.0.0.1 192.168.1.1
   protected-mode no
   port 17001
   daemonize yes
   pidfile /var/run/redis-sentinel_17001.pid
   logfile "/Users/guanys/Documents/soft/redis/log/redis-17001/redis.log"
   dir /Users/guanys/Documents/soft/redis/log/redis-17001/tmp
   #设置 主名称 ip地址 端口号 参入选举的哨兵数
   #配置哨兵需要监控的主节点ip和端口，最后的2代表，如果有2个哨兵主观认为主节点down了，
   #那么就客观认为主节点down掉了，开始发起投票选举新主节点的操作。多个主节点配置多个。
   sentinel monitor myslave1 127.0.0.1 17001 2
   
   
   - 4.修改slave2 17002  sentinel.conf
    shell script
    bind 127.0.0.1 192.168.1.1
    protected-mode no
    port 17002
    daemonize yes
    pidfile /var/run/redis-sentinel_17002.pid
    logfile "/Users/guanys/Documents/soft/redis/log/redis-17002/redis.log"
    dir /Users/guanys/Documents/soft/redis/log/redis-17002/tmp
    #设置 主名称 ip地址 端口号 参入选举的哨兵数
    #配置哨兵需要监控的主节点ip和端口，最后的2代表，如果有2个哨兵主观认为主节点down了，
    #那么就客观认为主节点down掉了，开始发起投票选举新主节点的操作。多个主节点配置多个。
    sentinel monitor myslave2 127.0.0.1 17002 2
            
     

```

```    
   第 23 课作业实践 
   1、（必做）配置redis的主从复制，sentinel高可用，Cluster集群。 
   提交如下内容到github： 
   1）config配置文件， 
   2）启动和操作、验证集群下数据读写的命令步骤。 
   2、（选做）练习示例代码里下列类中的作业题： 
   08cache/redis/src/main/java/io/kimmking/cache/RedisApplication.java 
   3、（挑战☆）练习redission的各种功能； 
   4、（挑战☆☆）练习hazelcast的各种功能； 
   5、（挑战☆☆☆）搭建hazelcast3节点集群，写入100万数据到一个map，模拟和演 示高可用，测试一下性能；

```