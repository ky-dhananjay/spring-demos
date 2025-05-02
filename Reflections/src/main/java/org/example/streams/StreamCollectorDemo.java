package org.example.streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.util.stream.Collectors.mapping;

public class StreamCollectorDemo {
    public static void main(String[] args) {
        System.out.println(groupingByWeight());
    }
    public static Map<String, List<String>> groupingByWeight(){
        List<Employee> list = Employee.getAllEmployees();
        Function<Employee, String> classifier = e -> {
            if(e.getWeight() > 0.0 && e.getWeight() < 3.0){
                return "A";
            }
            if(e.getWeight() >= 3.0 && e.getWeight() < 5.0){
                return "B";
            }
            return "C";
        };
        return list.stream().collect(Collectors.groupingBy(classifier, mapping(Employee :: getFirstName , Collectors.toList())));
    }
    public static Map<Integer, List<Employee>> groupingBySalary(){
        // Group a list of employee by their salary.
        List<Employee> list = Employee.getAllEmployees();
        return list.stream().collect(Collectors.groupingBy(Employee::getSalary));
    }
    public static List<String> sortStrings(){
        List<String> list = List.of("bunty", "dj");
        // sorted :: Sort a list of strings in reverse alphabetical order.
        return list.stream().sorted().collect(Collectors.toList());
    }
    public static List<String> sortStrings_reverse(){
        List<String> list = List.of("bunty", "dj");
        // Sort a list of strings in reverse alphabetical order.
        return list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
    public static List<Employee> sortAListOfObjectsByASpecificField(){
        // Sort a list of objects by a specific field.
        List<Employee> list = Employee.getAllEmployees();
        return list.stream().sorted((a,b) -> a.getSalary() > b.getSalary() ? -1 : 1).collect(Collectors.toList());
    }

    public static List<String> findUniqueWords(List<String> list){
        // distinct :: Find unique words in a string.
        return list.stream().distinct().collect(Collectors.toList());
    }
    public static List<Integer> removeDuplicatesFromList(List<Integer> list){
        // distinct :: remove duplicates from a list
        return list.stream().distinct().collect(Collectors.toList());
    }
    public static String findLongestStringInList(List<String> list){
        // Find the longest string in a list.
        return list.stream().reduce("", (a,b) -> {
            if(a.length() > b.length()){
                return a;
            }
            return b;
        });
    }
    public static Integer findSumOfAllElements(Integer [] arr){
        // Find the sum of all elements in a list of integers.
        return Arrays.stream(arr).reduce(0,(a,b) -> {
            System.out.println(a + " " + b);
            return a + b;
        });
    }
    public static List<String> stringToUpper(List<String> stringList){
        return stringList.stream().map(String :: toUpperCase).collect(Collectors.toList());
    }
    public static List<String> stringStartsWith(String str, List<String> stringList){
        return stringList.stream().filter(s -> s.startsWith(str)).collect(Collectors.toList());
    }
    public static List<Integer> evenNumbers_filter_predicate_class(List<Integer> list){
        EvenNumberPredicate evenNumberPredicate = new EvenNumberPredicate();
        return list.stream().filter(evenNumberPredicate).collect(Collectors.toList());
    }
    public static List<Integer> evenNumbers_filter_predicate_lambda(List<Integer> list){
        Predicate<Integer> evenPredicate = (num) -> num % 2 == 0;
        return list.stream().filter(evenPredicate).collect(Collectors.toList());
    }
    public static void findPrimesInRange(){
        int [] arr = IntStream.range(5, 100).toArray();
        IntStream primes = Arrays.stream(arr)
            .filter(num -> IntStream.range(2, num).allMatch(num1 -> num%num1 != 0));
        primes.forEach(num -> System.out.print(num + " "));
    }
    public static void decimalTOBinary(int x){
       if(x <= 0){
           return;
       }
       decimalTOBinary(x/2);
       System.out.print(x%2);
    }

}
