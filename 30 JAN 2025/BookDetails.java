public class BookDetails {
    public static void main(String[] args) {
        Book book = new Book("C Programming", "Apurv Kumar", 100);
        book.getAuthorName();
        book.getTitle();
        book.getPrice();
        book.displayDetails();
    }
}