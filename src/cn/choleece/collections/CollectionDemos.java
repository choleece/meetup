package cn.choleece.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合相关的内容 Java 集合都在java.util包下
 * @author choleece
 * @description: cn.choleece.collections
 * @date 2018/7/13 12:55
 */
public class CollectionDemos {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        Integer[] array = {3, 4, 5, 6};
        Integer[] a = list.toArray(array);
        System.out.println(a.length);
        for (int aa : a) {
            System.out.println(aa);
        }
    }
}
