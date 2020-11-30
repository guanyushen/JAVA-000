## GC日志打印
* 串行GC代码：

使用512m内存：java -XX:+UseSerialGC -Xms512m -Xmx512m -Xloggc:serial.512m.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

使用1G内存：java -XX:+UseSerialGC -Xms1g -Xmx1g -Xloggc:serial.1g.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

* 并行GC代码：

使用512m内存：java -XX:+UseParallelGC -Xms512m -Xmx512m -Xloggc:parallel.512m.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

使用1G内存：java -XX:+UseParallelGC -Xms1g -Xmx1g -Xloggc:parallel.1g.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

* CMS GC代码：

使用512m内存：java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -Xloggc:cms.512m.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

使用1G内存：java -XX:+UseConcMarkSweepGC -Xms1g -Xmx1g -Xloggc:cms.1g.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

* G1 GC代码：

使用512m内存：java -XX:+UseG1GC -Xms512m -Xmx512m -Xloggc:g1.512m.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

使用1G内存：java -XX:+UseG1GC -Xms1g -Xmx1g -Xloggc:g1.1g.gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

```

  第 3 课作业实践
  1、使用 GCLogAnalysis.java 自己演练一遍串行/并行/CMS/G1的案例。
  2、使用压测工具（wrk或sb），演练gateway-server-0.0.1-SNAPSHOT.jar 示例。
  3、(选做)如果自己本地有可以运行的项目，可以按照2的方式进行演练。
  根据上述自己对于1和2的演示，写一段对于不同 GC 的总结，提交到 Github。
  
  第四节课作业实践
  1、（可选）运行课上的例子，以及 Netty 的例子，分析相关现象。
  2、写一段代码，使用 HttpClient 或 OkHttp 访问 http://localhost:8801，代码提交到
  Github。
```




