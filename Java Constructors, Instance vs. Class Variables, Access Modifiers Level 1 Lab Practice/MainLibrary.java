class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayEBookDetails() {
        System.out.println("EBook ISBN: " + ISBN);
        System.out.println("EBook Title: " + title);
    }
}

public class MainLibrary {
    public static void main(String[] args) {
        Book book = new Book("43535242", "Java Programming", "John Doe");
        book.displayDetails();
        book.setAuthor("Jane Smith");
        System.out.println("Updated Author: " + book.getAuthor());

        EBook eBook = new EBook("4536256", "Advanced Java", "Alice Johnson");
        eBook.displayEBookDetails();
    }
}