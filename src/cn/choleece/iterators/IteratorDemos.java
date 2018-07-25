package cn.choleece.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author choleece
 * @description: cn.choleece.iterators
 * @date 2018/7/13 8:32
 */
public class IteratorDemos {

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
            /**
             * 此顺序为正确顺序，不会抛异常
             */
//            System.out.println(iterator.next());
//            iterator.remove();

            /**
             * 此顺序会报错，iterator.next返回的是当前循环的下一个，在一次循环里，只能被执行一次，后边的打印是执行了第二次，所以会抛出异常
             */
            iterator.remove();
//            System.out.println(iterator.next());
        }
        System.out.println(list.size());
    }
}
