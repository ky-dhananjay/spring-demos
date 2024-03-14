package org.example.trie;

import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode(){
        children = new HashMap<>();
        isEndOfWord = false;
    }
}