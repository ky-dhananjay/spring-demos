package org.example.dsa.recurssion;

import java.util.Scanner;

public class CountAndSay {
    // https://leetcode.com/problems/count-and-say/description/?envType=problem-list-v2&envId=string


    public static String compressAndSay(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int count = 1;
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    count++;
                } else {
                    break;
                }
            }
            sb.append(count);
            sb.append(s.charAt(i));
            i = i + count - 1;
        }
        return sb.toString();
    }

    public static String countAndSay(String n){
        System.out.println("for n: " + n);
        if(n.equals("1"))
            return "1";
        String small = countAndSay(String.valueOf(Integer.parseInt(n) - 1));
        System.out.println("For n" + n);
        System.out.printf("For n= %s, received small: %s%n", n, small);
        String compressedString = compressAndSay(small);
        System.out.printf("For n= %s, received compressed: %s%n", n, compressedString);
        return compressedString;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(countAndSay(String.valueOf(n)));
        //System.out.println(compressAndSay("1111222223"));
    }
}
