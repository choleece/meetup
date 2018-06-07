package cn.choleece.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * set demo1, 说明set 的存取顺序并不一致，而且值不能重复，如果重复，则添加失败,如果是对象，则会比较hashCode && equals，只有两者为true时，才会判断为重复
 * @author choleece
 * @description: cn.choleece.sets
 * @date 2018/6/7 17:12
 */
public class Demo1 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        System.out.println(set.add("1"));
        System.out.println(set.add("2"));
        System.out.println(set.add("3"));
        System.out.println(set.add("3"));
        System.out.println(set.add("0"));
        // [0, 1, 2, 3]
        System.out.println(set);
        Iterator<String> iterable = set.iterator();
        while (iterable.hasNext()) {
            System.out.println(iterable.next());
        }
    }
}
