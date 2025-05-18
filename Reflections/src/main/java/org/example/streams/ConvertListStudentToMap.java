package org.example.streams;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConvertListStudentToMap {
    public static void main(String[] args) {
        List<Employee> l = Employee.getAllEmployees();
        System.out.println(l.stream().collect(Collectors.toMap(employee -> employee, Employee::getFirstName)));
    }
}
