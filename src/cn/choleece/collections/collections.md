### Java 集合内容

集合在Java里大致分为两种形式，一个是存储单个对象的，一个是以Key-Value的形式存在的，存储单个对象的对应的是Collection那一支，存储Key-Value的是对应的Map那一支。Collection和Map都是顶级接口。下面这篇文章就开始介绍Collection和Map这两个顶级接口下的内容。

#### Java集合和数组的区别：
1. 数组长度在初始化时指定，意味着之只能保存定长的数据。而集合可以保存数量上不确定的数据。同时可以保存具有映射关系的数据（即关联数组，键值对key-value）。
2. 数组元素即可以是基本类型的值，也可以是对象。集合里只能保存对象（实际上保存对象的引用变量），基本数据类型的变量要转换成对应的包装类才能放入集合类中。
[以上出处区别](https://www.jianshu.com/p/589d58033841)

#### 1. Collection

Collection接口继承了Iterable接口，表明Collection是可以迭代的，关于Iterable的知识，可以查看[Iterable](www.baidu.com)

