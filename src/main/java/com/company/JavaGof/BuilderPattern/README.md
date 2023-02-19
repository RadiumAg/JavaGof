## 建造者模式

##### 定义

​	指将一个复杂对象的构造和它的表示分离，使同样的构造过程可以创建不同的表示。

##### 模式的结构

​	建造者模式的主要角色如下：

1.产品角色(Pruduct):它是包含多个组件部分的复杂对象，由具体建造者来创建各个零部件。

2.抽象建造者(Builder):它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法getResult()。

3.具体建造者(Concrete Builder):实现Builder接口，完成复杂产品的各个部件的具体创建方法。

4.指挥者(Director):它调用建造者对象的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。

##### 结构图

![](C:\Users\Iloveprpr\IdeaProjects\JavaGof\JavaGof\src\com\company\JavaGof\BuilderPattern\1620978068(1).jpg)

