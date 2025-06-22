package org.example.dsa.strings;

import java.util.ArrayList;
import java.util.List;

public class PrintStringSubsequence {

    // recursive (backtracking approach
    public static void printSubsequences(String s, int index,StringBuilder currentSubseq){
        if(index == s.length()){
            System.out.println(currentSubseq.toString());
            return;
        }

        // skip the current character
        printSubsequences(s, index + 1, currentSubseq);

        // include the current character
        currentSubseq.append(s.charAt(index));

        printSubsequences(s, index + 1, currentSubseq);

        currentSubseq.deleteCharAt(currentSubseq.length() - 1);

    }

    public static void main(String[] args) {
        String s = "abc";
        int index = 0;
        printSubsequences(s, index, new StringBuilder());
    }
}
