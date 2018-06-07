package cn.choleece.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author choleece
 * @description: cn.choleece.sets
 * @date 2018/6/7 17:22
 */
public class Demo2 {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        System.out.println(set.add(new Person("choleece", "1")));
        System.out.println(set.add(new Person("chaoli", "2")));
        System.out.println(set.add(new Person("zcl", "3")));
        System.out.println(set.add(new Person("choleece", "1")));
        System.out.println(set.add(new Person("cl", "2")));
        System.out.println(set);
        Iterator<Person> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static class Person {
        private String name;

        private String sex;

        public Person() {
        }

        public Person(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Person)) {
                return false;
            }

            Person person = (Person) o;

            if (getName() != null ? !getName().equals(person.getName()) : person.getName() != null) {
                return false;
            }
            return getSex() != null ? getSex().equals(person.getSex()) : person.getSex() == null;
        }

        @Override
        public int hashCode() {
            int result = getName() != null ? getName().hashCode() : 0;
            result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }
}
