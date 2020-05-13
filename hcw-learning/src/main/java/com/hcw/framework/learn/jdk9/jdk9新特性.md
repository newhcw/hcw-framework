1、Java9新特性之目录结构
2、Java9新特性之JShell工具
      怎么理解，怎么用呢？这个只是针对于java9来说，相当于cmd工具，你可以和cmd一样，直接写方法等等，不过我认为只是适用于初学者做一些最简单的运算和写一些方法，在cmd中打开这个工具：
        jshell
3、Java9新特性之模块化
        一个大型的项目，比如淘宝商城等，都会包含多个模块，比如订单模块，前台模块，后台管理模块，广告位模块，会员模块.....等等，各个模块之间会相互调用，不过这种情况下会很少，只针对特殊情况，如果一个项目有30个模块系统进行开发，但是只要某个单独模块运行时，都会带动所有的模块，这样对于jvm来说在内存和性能上会很低，所以，java9提供了这一个特性，某一个模块运行的时候，jvm只会启动和它有依赖的模块，并不会加载所有的模块到内存中，这样性能大大的提高了。写法上如下：

4、Java9新特性之多版本兼容Jar包
 怎么理解呢？

       好多公司用的JDK大部分还是老版本，JDK6、7都有，他们都不敢升级主要是因为兼容的问题，但是JDK9做到了这一点，就是不管公司的项目是用的JDK6、7、8甚至5，他都可以兼容不出错，打个比方，你之前用的是iphone5，现在出现了iPhone6，iphone7，iphon8和iphone9，但是你不敢买9，因为你自己已经适应了iphone5的所有手机的运行流程，6,7,8每个手机的运行流程不一样，但是这个9很强大，它能够识别你现在所用的版本iphone是5，所以当你升级到iphone9的时候，你的这个手机运行流程还是iphone5的流程，只是在原有基础上拥有了更多的iphone9的所有优势。
5、Java9新特性之接口Interface的升级
6、Java9新特性之钻石操作符的升级
//java6及以前
Map<String,String> map7 = new HashMap<String,String>();
//java7和8 <>没有了数据类型
Map<String,String> map8 = new HashMap<>();
//java9 添加了匿名内部类的功能 后面添加了大括号{}  可以做一些细节的操作
Map<String,String> map9 = new HashMap<>(){};
7、Java9新特性之异常处理try升级
//java9及 每一个流打开的时候都要关闭,但是在try的括号中来进行关闭，在
//java8的基础上进一步升级 直接在try括号中直接写入 变量就好，如果有多个流，就用分号隔开
//try(reader;writer){}
@Test
public void test7(){
    InputStreamReader reader =new InputStreamReader(System.in);
    try(reader){
        reader.read();
    }catch (IOException e){
        e.printStackTrace();
    }

8、Java9新特性之特殊标识符增加限制
      JDK8之前 String _ ="hello";  这样的标识符可以用，JDK9就用不到。

9、Java9新特性之String底层存储结构更换
      JDK8之前 String的底层结构类型都是 char[] ,但是JDK9 就替换成 byte[] 这样来讲，更节省了空间和提高了性能。

10、Java9新特性之Stream API 新方法的添加
      在原有Stream API 新添加了4个方法，takeWhile dropWhile ofNullable iterate(新重载方法)

11、Java9新特性之引进HttpClient
以往我们都是通过maven添加httpclient ,java9直接引入即可

      Java9所有特性都是为了提高性能和内存。。