import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private double price;

    public Book() {
        this.title = "";
        this.author = "";
        this.price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class MainBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Title of the Book");
        String Title = sc.nextLine();
        System.out.println("Enter the Author of the Book");
        String Author = sc.nextLine();
        System.out.println("Enter the Price (in Rs) of the Book");
        double Price = sc.nextDouble();

        Book defaultBook = new Book();

        Book parameterizedBook = new Book(Title, Author, Price);
        System.out.println("=== Default Book ===");
        defaultBook.displayDetails();
        System.out.println("\n=== Parameterized Book ===");
        parameterizedBook.displayDetails();
    }
}