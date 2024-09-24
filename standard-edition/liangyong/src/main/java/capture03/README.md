# 第3章 选择
## 3.1 引言
程序可以基于条件决定执行哪些语句。

## 3.2 boolean 数据类型
表3-1 关系操作符
Java操作符     数学符号        名称      示例（半径为5)        结果
<               <            小于       radius < 0          false
<=                          小于等于     radius <= 0        false
`>`               >           大于      radius > 0          true
`>=`                          大于等于    radius >= 0         true
=               =             等于      radius == 0         false
!=                           不等于      radius != 0         true

### 程序清单 3-1 AdditionQuiz.java

## 3.3 if 语句

if ( 布尔表达式）{
    语句（组）：
}

### 程序清单3-2 SimpleIfDemo.java
给出一个程序，提示用户输入一个半径求圆的面积

## 3.4 双分支if-else 语句

if (布尔表达式) {
    布尔表达式为其时执行的语句（组）；
}
else{
    布尔表达式为假时执行的语句（组）；
}

### 程序清单3-2 SimpleIfDemo.java

## 3.5 嵌套的if语句和多分支if-else语句
1f(i > k){
    if (j > k)
        System.out.println("i and»j are greater than k");
}
else
    System.out.println("i is less than or equal to k");

## 3.6 常见错误和陷阱
略

## 3.7 产生随机数
可以使用Math.random()来获得一个[0,1.0)之间的双精度浮点数。

### 程序清单 3-3 SubtractionQuiz.java 
程序随机产生两个一位整数(0-9之间)：
numberl 和number2，且满足numberl>=number2。程序向学生显示问题，例如，“ What is 9-2?” 。当学生输入答案之后，程序会显示一个消息表明该答案是否正确。

## 3.8 示例学习：计算身体质量指数
略
BMI                 说明
BMI< 18.5           偏瘦
18.5 ≤ BMI < 25.0   正常
25.0 ≤ BMI < 30.0   超重
30.0 ≤ BMI          过胖

## 3.9 示例学习：计算税率
略  

## 3.10 逻辑操作符 
