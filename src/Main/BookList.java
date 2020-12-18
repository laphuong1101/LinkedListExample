package Main;

import entity.Book;
import util.MyList;

import java.util.Scanner;

public class BookList {
    private MyList listBook;

    public BookList() {
        this.listBook = new MyList();
    }

    public MyList getListBook() {
        return listBook;
    }

    public void addFistBook(Scanner sc) {
        Book book = getBook(sc);
        if (book == null) {
            return;
        }
        listBook.addFirst(book);
    }

    public void addLastBook(Scanner sc) {
        Book book = getBook(sc);
        if (book == null) {
            return;
        }
        listBook.addLast(book);
    }

    public void displayBooks() {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "Code", "Title", "Quantity", "Lender", "Price", "Value");
        listBook.printList();
    }

    public Book getBook(Scanner sc) {
        System.out.println("Enter Code: ");
        String id = sc.nextLine();
        boolean isExists = listBook.checkExistId(id);
        if (isExists) {
            System.out.println("ID Book Is Exist !");
            return null;
        }
        System.out.println("Enter Book Name :");
        String name = sc.nextLine();
        System.out.println("Enter Total Book: ");
        int total = sc.nextInt();
        System.out.println("Enter Price Book: ");
        float price = sc.nextFloat();
        sc.nextLine();
        System.out.println("Enter Lender Name: ");
        String lender = sc.nextLine();

        Book book = new Book(id, name, total, price, lender);
        return book;
    }

    public void search(Scanner sc) {
        System.out.println("Enter your code !");
        String id = sc.nextLine();
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "Code", "Title", "Quantity", "Lender", "Price", "Value");
        listBook.search(id);
    }

    public void addAfter(Scanner sc) {
        System.out.println("Enter infomation of a book :");
        Book book = getBook(sc);
        if (book == null) {
            return;
        }
        System.out.println("Enter Index :");
        int index = sc.nextInt();
        sc.nextLine();
        listBook.addAfter(index, book);
    }

    public void deleteAt(Scanner sc) {
        System.out.println("Enter Index :");
        int index = sc.nextInt();
        sc.nextLine();
        listBook.deleteAt(index);
    }

}
