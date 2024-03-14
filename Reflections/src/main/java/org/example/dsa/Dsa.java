package org.example.dsa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dsa {
    public static void main(String[] args) {

    }
    public static String reverseString_recursion(String str){
        if(str.length() == 0 || str == null){
            return "";
        }
        String temp = reverseString_recursion(str.substring(1));
        return temp + str.charAt(0);
    }
    public static void reverseString_StringBuilder(String str){
        StringBuilder stringBuilder = new StringBuilder();
        // stringBuilder.reverse();
        int i = str.length() - 1;
        while(i>=0){
            stringBuilder.append(str.charAt(i));
            i--;
        }
        System.out.println(stringBuilder.toString());
    }
    public void reverseArrays(int [] arr){

    }
}
class Demo{
    private String name;

    public Demo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
