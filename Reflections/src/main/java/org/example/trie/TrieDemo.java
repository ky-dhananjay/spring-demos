package org.example.trie;

import java.util.List;
import java.util.Scanner;

public class TrieDemo {
    // insert
    public void insertToTrie(String word, TrieNode root){
        TrieNode current = root;

        for (char c : word.toCharArray()){
            current.children.computeIfAbsent(c, k -> new TrieNode());
            current = current.children.get(c);
        }

        current.isEndOfWord = true;
    }
    // search
    public boolean search(String word, TrieNode root){
        TrieNode current = root;

        for(char c : word.toCharArray()){
            if(current.children.get(c) == null)
                return false;
            current = current.children.get(c);
        }
        return current.isEndOfWord;
    }
    public boolean wordBreak(String word, TrieNode root){
        TrieNode current = root;

        for(char c : word.toCharArray()){
            if(current.children.get(c) == null && !current.isEndOfWord) {
                return false;
            }
            if(current.isEndOfWord){
                if(root.children.get(c) == null){
                    return false;
                } else {
                    current = root.children.get(c);
                }
            } else {
                current = current.children.get(c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TrieDemo trieDemo = new TrieDemo();
        List<String> words = List.of("positive", "possessive", "position", "post", "shiv", "shiva", "ship", "shape", "sea");

        TrieNode rootNode = new TrieNode();
        List.of("cats","dog","sand","and","cat").forEach(word -> trieDemo.insertToTrie(word, rootNode));

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter the word to search");
//        String word = scanner.nextLine();

        System.out.println(trieDemo.wordBreak("catsandog", rootNode));
    }

}
