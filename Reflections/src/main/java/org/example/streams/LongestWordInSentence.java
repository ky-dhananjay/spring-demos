package org.example.streams;

import java.util.stream.Stream;

public class LongestWordInSentence {
    public static void main(String[] args) {
        String s  = "Third party login provider like google, facebook integration with react a";

        String[] words = s.split(" ");

        String result = Stream.of(words)
            .reduce("", (longestWord, currentWord) -> longestWord.length() > currentWord.length()
            ? longestWord : currentWord);

        System.out.println(result);
    }
}
