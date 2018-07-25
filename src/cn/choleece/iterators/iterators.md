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

### ListIterator 

我们查看ListIterator的源码可以看到，ListIterator是继承Iterator的，所以Iterator有的功能ListIterator都有，ListIterator的部分源码如下:

```
public interface ListIterator<E> extends Iterator<E> {
    boolean hasNext();
    
    E next();
    
    boolean hasPrevious();
    
    E previous();
    
    int nextIndex();
    
    int previousIndex();
    
    void remove();
    
    void set(E e);
    
    void add(E e);
}
```

我们可以从源码可以看到，ListIterator里同样也有next()，hasNext()，remove()方法，但是同时，我们可以看到ListIterator也有previous()，hasPrevious()等方法，所以我们可以得知Iterator是一个单向的迭代，而ListIterator是一个双向的。
另外，Iterator还有其他的几个方法，我们下边来分别介绍下：

```
public static void main(String[] args) {
    List list = new ArrayList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);

    ListIterator li = list.listIterator();

    System.out.println(li.previousIndex());

    // 向后遍历
    while (li.hasNext()) {
        System.out.println(li.next());
    }
    System.out.println("向后遍历完，接着执行set 0");
    li.set(0);
    System.out.println("set 0 完毕，执行next index");
    System.out.println(li.nextIndex());
    System.out.println("next index 完毕，执行add");
    li.add(7);
    System.out.println("add 0 完毕，执行next index");
    System.out.println(li.nextIndex());
    System.out.println("next index 完毕，执行previous index");
    System.out.println(li.previousIndex());
    while (li.hasPrevious()) {
        System.out.println(li.previous());
    }
}
```

运行上述结果，会发现，在刚开始的时候，执行previousIndex，返回的是-1,此时迭代“指针”还处于初始位置，如果此时执行set操作会报错，在后边的set方法中，set进去的值会替换掉当前位置的值，如果是add，则是添加一个值到list当中去

