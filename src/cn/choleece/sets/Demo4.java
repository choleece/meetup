package cn.choleece.sets;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet 存储对象
 * @author choleece
 * @description: cn.choleece.sets
 * @date 2018/6/8 10:57
 */
public class Demo4 {
    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person("choleece", 14, "M"));
        treeSet.add(new Person("aaa", 13, "M"));
        treeSet.add(new Person("bbb", 13, "F"));
        treeSet.add(new Person("choleece", 13, "G"));
        System.out.println(treeSet);
        Iterator<Person> it = treeSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static class Person implements Comparable {
        private String name;

        private int age;

        private String gender;

        public Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public int compareTo(Object o) {
            Person p = (Person) o;
            if (this.age > p.age) {
                return 1;
            }
            if (this.age < p.age) {
                return -1;
            }
            return this.name.compareToIgnoreCase(p.name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }
}
