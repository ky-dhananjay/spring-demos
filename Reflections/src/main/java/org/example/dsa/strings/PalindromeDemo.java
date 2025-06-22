package org.example.dsa.strings;

public class PalindromeDemo {
    public static void main(String[] args) {
        String s = "h";

        StringBuilder sb = new StringBuilder(s);
        String rev = String.valueOf(sb.reverse());
        if(s.equals(rev)){
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }

        char[] arr = s.toCharArray();
        int left=0, right=arr.length - 1;
        boolean isPalindrome = true;
        while(left < right){
            if(arr[left] == arr[right]){
                left++;
                right--;
            } else {
                isPalindrome = false;
                break;
            }
        }
        if(isPalindrome){
            System.out.println("palind");
        } else {
            System.out.println("not palin");
        }
    }
}
