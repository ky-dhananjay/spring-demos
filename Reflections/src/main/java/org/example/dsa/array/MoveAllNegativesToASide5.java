package org.example.dsa.array;


import org.example.utils.ArrayUtils;

public class MoveAllNegativesToASide5 implements ArrayUtils {
    // two pointers approach
    public void moveAllNegativesToASide(int [] arr){
        if(arr.length == 0){
            return;
        }
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            if(arr[left] < 0){
                left++;
            } else if(arr[right] >= 0){
                right--;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;right--;
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = new int []{1,2,3,4,-10,0,-3,-5,5};
        MoveAllNegativesToASide5 ob = new MoveAllNegativesToASide5();
        ob.moveAllNegativesToASide(arr);
        ob.printArray(arr);
    }
}
