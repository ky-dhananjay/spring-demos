package org.example.dsa.iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {

    public void iterateLinkedHashSet(){
        // insertion order maintained, duplicate not allowed
        // Keeping the insertion order in the LinkedHashset has some
        // additional costs, both in terms of extra memory and extra CPU cycles
        // incase of primitives(along with wrapper classes) and string the content is compared
        Set<Double> set=new LinkedHashSet<>();
        set.add(1.1);
        set.add(1.1);// duplicate insertion
        set.add(1.3);
        set.add(2.3);


        // in case of non primitives reference is compared
        Employee employee = new Employee("abc","abc@gmail.com", 1);
        Employee e1 = employee, e2 = employee, e3 = employee;
        Set<Employee> set1 = new HashSet<>();
        set1.add(employee);
        set1.add(e1);
        set1.add(e2);
        set1.add(e3);

        Iterator<Double> i=set.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
    }
}
