package org.example.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EqualsAndHashCodeDemo {

    public static void main(String[] args) {
        overrideEqualsMethodOnly();
        System.out.println("=================================");
        overrideBothEqualsAndHashcodeMethod();
    }

    public static void overrideEqualsMethodOnly(){
        Employee s1 = new Employee("1", "john", "deer");
        Employee s2 = new Employee("2", "john", "deer");
        Employee s3 = new Employee("1", "john", "deer");

        System.out.println(s1); // org.example.collections.Employee@2e5d6d97
        System.out.println(s2); // org.example.collections.Employee@238e0d81
        System.out.println(s3); // org.example.collections.Employee@31221be2
        System.out.println(s1 == s3); // false

        Set<Employee> set = new HashSet<>(List.of(s1, s2, s3));
        System.out.println(set); // set with 3 elements

        Map<String, Employee> map = new HashMap<>();
        map.put(s1.getId(), s1);
        map.put(s2.getId(), s2);
        map.put(s3.getId(), s3);

        System.out.println(map.get(s3.getId()));
    }
    public static void overrideBothEqualsAndHashcodeMethod(){
        Student s1 = new Student("1", "john", "deer");
        Student s2 = new Student("2", "john", "deer");
        Student s3 = new Student("1", "john", "deer");

        System.out.println(s1); // org.example.collections.Student@bde9bc9
        System.out.println(s2); // org.example.collections.Student@a0230aca
        System.out.println(s3); // org.example.collections.Student@bde9bc9
        System.out.println(s1 == s3); // false

        Set<Student> set = new HashSet<>(List.of(s1, s2, s3));
        System.out.println(set); // set with 2 elements

        Map<String, Student> map = new HashMap<>();
        map.put(s1.getId(), s1);
        map.put(s2.getId(), s2);
        map.put(s3.getId(), s3);

        System.out.println(map.get(s3.getId()));

    }
    /**
     * hashcode method is basically used by hash based collections like HashSet and HashMap
     * hence to let HashSet and HashMap function properly, while overriding equals method,
     * hashcode method also needs to be overridden
     */
}
