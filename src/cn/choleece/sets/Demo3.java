package cn.choleece.sets;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet 采用红黑数结构，默认会对String自然排序
 * @author choleece
 * @description: cn.choleece.sets
 * @date 2018/6/8 9:19
 */
public class Demo3 {

    /**
     * TreeSet的有序性
     * @param args
     */
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("cccc");
        set.add("aaa");
        set.add("000");
        set.add("ddd");
        System.out.println(set);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
