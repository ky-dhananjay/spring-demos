package org.example.dsa;

import java.util.List;
import java.util.stream.IntStream;

public class LinkedListDS {
    public static void main(String[] args) {
        Node<Integer> head = createLinkedList_withData();
        printLinkedList(head);
    }
    public static void printLinkedList(Node<Integer> head){
        if(head == null){
            return;
        }
        System.out.print(head.data + " -> ");
        if(head.next == null){
            System.out.println("null");
        }
        printLinkedList(head.next);
    }
    public static Node<Integer> createLinkedList_withData(){
        Node<Integer> head = new Node<>(0);
        Node<Integer> prev = head;
        for(int i = 1; i < 50 ; i++){
            Node<Integer> newNode = new Node<>(i);
            prev.next = newNode;
            prev = newNode;
        }
        return head;
    }
}

class Node<T>{
    T data;
    Node next;

    public Node(T data) {
        this.data = data;
    }
}

