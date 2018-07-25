### Iterator 和 Iterable 迭代器

首先看名字我们就大致能发现这两个东西的不同，一个是迭代器，一个是可迭代的，下面我们来了解下这两个东西

#### Iterator

Iterator是一个接口，部分源码如下:

```
public interface Iterator<E> {
    // 判断集合中是否还有元素，如果还有元素可以迭代，就返回true
    boolean hasNext();

    // 返回迭代的下一个原色，注意：如果没有下一个元素时，调用next()会抛出NoSuchElementException
    E next();

    // 从迭代器指向的结合中移除地带其返回的最后一个元素，这个也是迭代器常用的方法，在迭代的过程中去掉删除掉某个元素
    // 从这个方法可以看出，interface的方法是可以有方法体的（从JDK1.8后开始支持，方法前必须用static 或者 default修饰，）
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
```

迭代器的出现，是为了更好的处理集合中的元素，屏蔽集合的内部细节。

迭代器遍历：

```
public static void main(String[] args) {
    List list = new ArrayList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
        System.out.println(iterator.next());
    }
}
```

上述例子为迭代器简单的遍历过程，下面我们来看下删除：

```
public static void main(String[] args) {
    List list = new ArrayList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
        System.out.println(iterator.next());
        itetator.remove();
    }
}
```

上述方法会正常执行，执行完后，list会变成空集合，再看看下面的代码：

```
public static void main(String[] args) {
    List list = new ArrayList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
        itetator.remove();
        System.out.println(iterator.next());
    }
}
```

上述代码会抛出IllegalStateException，调用remove之前没有调用next是不合法的。

#### Iterable 

Iterable也是一个接口，表明继承了Iterable的类是可迭代的，并且支持增强for循环

Iterable的部分源码如下：

```
public interface Iterable<T> {
    Iterator<T> iterator();
}
``` 

继承了Iterable的类是可以返回一个Iterator迭代器的，也就包含了Iterator的操作行为。
