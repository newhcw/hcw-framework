1、JDK12之Shenandoah低暂停时间垃圾收集器（实验性）
  添加一个名为Shenandoah的新垃圾收集（GC）算法，通过与正在运行的Java线程同时进行疏散工作
来减少GC暂停时间。使用Shenandoah的暂停时间与堆大小无关，这意味着无论堆是200MB还是200GB，都
将具有相同的一致暂停时间
作为实验性功能，Shenandoah将
-XX:+UnlockExperimentalVMOptions
在命令行中要求。Shenandoah构建系统会自动禁用不受
支持的配置。下游建设者可以选择
--with-jvm-features=-shenandoahgc
在其他支持的平台上禁用构建Shenandoah。
要启用/使用Shenandoah GC，需要以下JVM选项：
-XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC

2、JDK12之Microbenchmark Suite
在JDK源代码中添加一套基本的微基准测试，使开发人员可以轻松运行现有的微基准测试并创
建新的基准测试。

3、JDK12之Switch表达式（预览版）
T result = switch (arg) {
    case L1 -> e1;
    case L2 -> e2;
    default -> e3;
};
4、JDK12之JVM常量API
引入API来模拟关键类文件和运行时工件的名义描述，特别是可从常量池加载的常量。
5、JDK12之一个AArch64端口，而不是两个
arm64在保留32位ARM端口和64位aarch64端口的同时，删除与端口相关的所有源。
6、JDK12之默认CDS档案
在64位平台上使用默认类列表增强JDK构建过程以生成类数据共享（CDS）归档。
7、JDK12之G1的可流动混合收集
如果G1混合集合可能超过暂停目标，则使其可以中止。
8、JDK12之从G1中立即返回未使用的已提交内存
增强G1垃圾收集器，以便在空闲时自动将Java堆内存返回给操作系统。
9、核心库java.lang中支持Unicode11
10、核心库java.text支持压缩数字格式
例如：NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
String result = fmt.format(1000); 
    上面的例子导致“1
12、安全库java.security
      禁止并允许java.security.manager系统属性的选项 

13、安全库javax.net.ssl
14、安全库/ org.ietf.jgss
15、删除项
      核心库/ java.util.jar中，删除java.util.ZipFile / Inflator / Deflator中的finalize方法 
      核心库/ java.io，从FileInputStream和FileOutputStream中删除finalize方法 
      工具/ javac的删除javac支持6 / 1.6源，目标和发布值 



