package org.example.utils;

import java.util.Scanner;

public interface ArrayUtils {
    default void printArray(int [] arr){
        int len = 0;
        for (int i : arr) {
            System.out.print(i);
            if(len++ != arr.length){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    default int [] takeArrayInputs(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of testcases: ");
        int numOfTestcases = sc.nextInt();
        if(numOfTestcases == 0){
            return new int[5];
        }
        int [] arr = null;
        while(numOfTestcases-- > 0){
            System.out.println("Size of Array: ");
            int sizeOfArray = sc.nextInt();
            arr = new int[sizeOfArray];
            int i = 0;
            while(sizeOfArray-- > 0){
                arr[i++] = sc.nextInt();
            }
        }
        return arr;
    }
}
