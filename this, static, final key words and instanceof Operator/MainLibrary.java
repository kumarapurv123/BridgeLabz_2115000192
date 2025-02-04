class Book {
    private static String libraryName = "Central Library";
    private final String isbn;
    private String title;
    private String author;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Library Name: " + libraryName);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }
}

public class MainLibrary {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "Telusko", "111111");
        Book book2 = new Book("C Programming", "Jane Smith", "12345677");
        book1.displayDetails();
        book2.displayDetails();
        Book.displayLibraryName();
    }
}
