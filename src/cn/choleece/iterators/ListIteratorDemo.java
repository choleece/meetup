package cn.choleece.iterators;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author choleece
 * @description: cn.choleece.iterators
 * @date 2018/7/13 13:39
 */
public class ListIteratorDemo {
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
}
