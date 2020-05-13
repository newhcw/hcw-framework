预览版：该功能在当前版本可以使用，如果效果不是很好的话，可能以后的其他版本就会删去该功能。
最终版：该功能在之前版本效果很好，之后的每个版本中都会存在该功能

1、Switch（最终版）
2、垃圾回收器（更新优化）
3、Record（预览功能）
4、货币格式（优化）
5、NIO的Channel通道
6、删除功能
    ···
    1、CMS垃圾收集器已被删除。-XX:UseConcMarkSweepGC和别名-Xconcgc，-Xnoconcgc以及所有CMS特定选项（太多，无法列出）都已废弃。
    2、删除了安全库java.security.acl API
    ···
7、instanceof的模式匹配（预览版）
8、弃用功能
垃圾回收器：
    弃用ParallelScavenge + SerialOld GC组合，任何UseParallelOldGC用于启用此垃圾回收算法组合的命令行选项的使用，都会引起弃用警告。嵌入式替换是通过-XX:+UseParallelGC在命令行上使用ParallelScavenge + ParallelOld垃圾收集器。
线程：

    不建议使用线程挂起、删除，下面的方法中涉及的线程挂起Thread,并且Thread已在本版本中晚期弃用,Thread.suspend(),Thread.
resume(),ThreadGroup.suspend(),ThreadGroup.resume(),ThreadGroup.allowThreadSuspension(boolean)这些方法将在将来的版本中删除。    

椭圆曲线:
security-libs / javax.crypto,已过时的旧椭圆曲线去除。

