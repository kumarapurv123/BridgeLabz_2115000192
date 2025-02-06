import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        Book book1 = new Book("Harry", "Harry");
        Book book2 = new Book("1984", "Jack");
        Book book3 = new Book("Tom", "Tom");

        Library library1 = new Library("City Library");
        Library library2 = new Library("University Library");

        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book3);

        library1.displayBooks();
        library2.displayBooks();
    }
}
