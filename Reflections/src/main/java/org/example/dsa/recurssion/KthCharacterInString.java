package org.example.dsa.recurssion;

public class KthCharacterInString {
    public static String generateKLengthString(int k, String s){
        if(s.length() >= k){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < s.length(); i++){
            sb.append((char)(s.charAt(i) + 1));
        }
        return generateKLengthString(k, s.concat(sb.toString()));
    }
    public static char kthCharacter(int k) {
        String s = generateKLengthString(k , "a");
        System.out.println(s);
        return s.charAt(k-1);
    }

    public static void main(String[] args) {
        System.out.println(kthCharacter(5));
    }
}
