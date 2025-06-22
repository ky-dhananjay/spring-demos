package org.example.dsa.array;

import org.example.utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

public class UnionAndIntersectionOfTwoSortedArray implements ArrayUtils {

    public int[][] getUnionAndIntersectionOfTwoSortedArrays(int[] arr1, int[] arr2){
        int[][] arr = new int[2][arr1.length + arr2.length];
        Map<Integer, Integer> map = new HashMap<>();

        for(int element : arr1){
            if(!map.containsKey(element)){
                map.put(element, 0);
            }
            map.put(element, map.get(element) + 1);
        }
        for(int element : arr2){
            if(!map.containsKey(element)){
                map.put(element, 0);
            }
            map.put(element, map.get(element) + 1);
        }
        int unionIndex=0, intersectionIndex=0;
        for(int key : map.keySet()){
            if(map.get(key) > 1){
                arr[0][unionIndex++] = key;
            }
            if(map.get(key) == 1){
                arr[1][intersectionIndex++] = key;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] arr1 = new int []{1,2,3,4,-10,0,-3,-5,5};
        int [] arr2 = new int []{1,2,3,4,-10,0,-5,5};
        UnionAndIntersectionOfTwoSortedArray ob = new UnionAndIntersectionOfTwoSortedArray();
        int[][] arr = ob.getUnionAndIntersectionOfTwoSortedArrays(arr1, arr2);
        ob.printArray(arr[0]);
        ob.printArray(arr[1]);
    }
}
