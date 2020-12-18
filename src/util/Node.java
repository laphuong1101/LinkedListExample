package util;

import entity.Book;

public class Node {

    private Book data;
    private Node next;

    public Node(Book data) {
        this.data = data;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void printInfoNode () {
        System.out.printf("%-15s%-15s%-15d%-15s%-15f%-15f\n", data.getId(), data.getName(), data.getTotal(), data.getLender(), data.getPrice(), data.getValue());
    }

    public Book getData() {
        return data;
    }
}
