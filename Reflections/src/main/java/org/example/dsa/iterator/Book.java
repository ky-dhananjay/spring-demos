package org.example.dsa.iterator;

class Book implements Comparable<Book>{
    int id;
    String name,author,publisher;
    int quantity;
    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
    // implementing the abstract method
    // necessary for using TreeSet or TreeMap
    public int compareTo(Book b) {
        return Integer.compare(id, b.id);
    }
}
