class Book {
    private String title;
    private String author;
    private String genre;
    private int bookId;
    private boolean isAvailable;
    private Book next;
    private Book prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Book getNext() {
        return next;
    }

    public void setNext(Book next) {
        this.next = next;
    }

    public Book getPrev() {
        return prev;
    }

    public void setPrev(Book prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Book Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Book ID: " + bookId
                + ", Availability: " + (isAvailable ? "Available" : "Not Available");
    }
}

class DoublyLinkedListLibrary {
    private Book head;
    private Book tail;
    private int count;

    public DoublyLinkedListLibrary() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.setNext(head);
            head.setPrev(newBook);
            head = newBook;
        }
        count++;
    }

    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            newBook.setPrev(tail);
            tail.setNext(newBook);
            tail = newBook;
        }
        count++;
    }

    public void addBookAtPosition(int position, String title, String author, String genre, int bookId,
            boolean isAvailable) {
        if (position <= 0) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book current = head;
        for (int i = 1; i < position && current != null; i++) {
            current = current.getNext();
        }
        if (current != null) {
            newBook.setNext(current.getNext());
            newBook.setPrev(current);
            if (current.getNext() != null) {
                current.getNext().setPrev(newBook);
            } else {
                tail = newBook;
            }
            current.setNext(newBook);
        }
        count++;
    }

    public void removeBookById(int bookId) {
        if (head == null)
            return;
        if (head.getBookId() == bookId) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.getNext();
                head.setPrev(null);
            }
            count--;
            return;
        }
        Book current = head;
        while (current != null && current.getBookId() != bookId) {
            current = current.getNext();
        }
        if (current != null) {
            if (current.getPrev() != null) {
                current.getPrev().setNext(current.getNext());
            }
            if (current.getNext() != null) {
                current.getNext().setPrev(current.getPrev());
            } else {
                tail = current.getPrev();
            }
            count--;
        }
    }

    public Book searchBookByTitle(String title) {
        Book current = head;
        while (current != null) {
            if (current.getTitle().equalsIgnoreCase(title)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public Book searchBookByAuthor(String author) {
        Book current = head;
        while (current != null) {
            if (current.getAuthor().equalsIgnoreCase(author)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void updateBookAvailability(int bookId, boolean isAvailable) {
        Book book = searchBookById(bookId);
        if (book != null) {
            book.setAvailable(isAvailable);
        }
    }

    public Book searchBookById(int bookId) {
        Book current = head;
        while (current != null) {
            if (current.getBookId() == bookId) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void displayAllBooks() {
        Book current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    public void displayAllBooksInReverse() {
        Book current = tail;
        while (current != null) {
            System.out.println(current);
            current = current.getPrev();
        }
    }

    public int countTotalBooks() {
        return count;
    }
}

public class LibraryManagementMain {
    public static void main(String[] args) {
        DoublyLinkedListLibrary library = new DoublyLinkedListLibrary();
        library.addBookAtBeginning("title1", "Author1", "genre1", 101, true);
        library.addBookAtEnd("title2", "Author2", "genre2", 102, true);
        library.addBookAtPosition(1, "title3", "author3", "genre", 103, true);
        library.displayAllBooks();
        System.out.println();
        library.displayAllBooksInReverse();
        System.out.println();
        System.out.println(library.searchBookByTitle("1984"));
        System.out.println();
        library.updateBookAvailability(102, false);
        library.displayAllBooks();
        System.out.println();
        library.removeBookById(101);
        library.displayAllBooks();
        System.out.println();
        System.out.println(library.countTotalBooks());
    }
}