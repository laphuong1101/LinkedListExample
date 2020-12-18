package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookList bookList = new BookList();
        String choice;

        while (true) {
            System.out.println("==========Book List==========");
            System.out.println("1.Input Book and add to the End");
            System.out.println("2.Display books");
            System.out.println("3.Search by code");
            System.out.println("4.Input Book and add to beginning");
            System.out.println("5.Add Book after position k");
            System.out.println("6.Delete Book at position k");
            System.out.println("0.Exit");
            System.out.println("------------------------------------");

            System.out.println("Enter your choice !");
            choice = sc.nextLine();
            if (choice.equals("0")) {
                System.out.println("End !");
                break;
            }
            switch (choice) {
                case "1":
                    bookList.addLastBook(sc);
                    break;
                case "2":
                    bookList.displayBooks();
                    break;
                case "3":
                    bookList.search(sc);
                    break;
                case "4":
                    bookList.addFistBook(sc);
                    break;
                case "5":
                    bookList.addAfter(sc);
                    break;
                case "6":
                    bookList.deleteAt(sc);
                    break;
                default:
                    System.out.println("Please enter your choice correctly");
            }
        }
    }
}
