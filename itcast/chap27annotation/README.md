# Java Annotation 注解
Java5开始Java增加对元数据的支持, 也就是注解. 注解与注释右一定区别, 可以理解为代码里的特殊标记.
标记可以再编译, 类加载和运行时被读取, 并执行响应的处理. 开发人员可通过注释在不改变原有代码的逻辑的情况下
在源码中嵌入补充信息.
## Java Annotation 简介
例如@overrid 同class和interface一样,注解也属于一种类型.
注解不改变程序的结果,也不影响程序性能.

注解可以元数据这个词解释, 即描述数据的数据.

## Java @Override注解

用来指定方法重写的,修饰方法,不能修饰其他元素, 强制子类必须重写父类方法或者实现接口的方法.
如果不加@Override注解,即便方法编译错误,编译器也不会提醒.

## Java @Deprecated注解
表示过时的,当使用已过时注解标识的元素,编译器将给出警告.
Java9新特性为@Deprecated新增两个属性
1.forRemoval: 该不二类型属性指定该API在将来是否会被删除
2.since: 该String类型的属性标识API自那个版本被标记过时;

## Java @SuppressWarnings抑制编译器警告
用于取消编译器残生的警告

## Java元注解的作用及使用
元注解, 负责对其他注解进行说明的注解.
### @Documented
是一个标记注解, 会被javaDoc工具提取成文档

### @Target
注解用来指定注解的使用范围, 即被@Target修饰后可以用在说明地方
@Target只有一个成员变量 (value) 用来设置适用目标
java.lang.annotation.ElementType枚举类型的数组
- PACKAGE 用于包
- METHOD 用于方法
- TYPE 用于类接口或者Enum声明, 注解.

### @Retention
描述注解的声明周期
三个美剧藏龙
- SOURCE: 源文件中有效(即源文件保留)
- CLASS: 源文件中有效(即class保留)
- RUNTIME: 运行时有效(运行时保留)
大小比较
SOURCE> CLASS> RUNTIME> 前者可以使用到的地方后者一定可以用到, 如果需要运行时获取注解信息, 那就只能RUNTIME注解.
编译时预处理操作就用CLASS
检查性工作,@Override之类的可用SOURCE

### @Inherited
标记注解, 用来指定该注解可以被继承, 使用@Inherited注解的class类, 标识这个注解可以用于来Class的子类

### @Repeatbale
@Repeatbale JDK8新增的, 允许相同程序元素中重复注解,
需要对同一种注解多次使用时, 往往需要借助@Repeatbale注解. Jdk8以前, 同一个程序元素前最多智能有一个相同的注解.
