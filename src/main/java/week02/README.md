##GC日志打印
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






