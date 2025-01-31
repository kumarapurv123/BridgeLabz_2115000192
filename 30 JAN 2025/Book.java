public class Book {
    private String title;
    private String author;
    private int price;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getAuthorName() {
        System.out.println("Author Name of Book is : " + this.author);
        return this.author;
    }

    public void setAuthorName(String newAuthorName) {
        this.author = newAuthorName;
    }

    public String getTitle() {
        System.out.println("Title of Book is : " + this.title);
        return this.title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public int getPrice() {
        System.out.println("Price of Book is : " + this.price);
        return this.price;
    }

    public void setPrice(int newPrice) {
        this.price = newPrice;
    }

    public void displayDetails() {
        System.out.println("Author Name of Book is : " + this.author);
        System.out.println("Title of Book is : " + this.title);
        System.out.println("Price of Book is : " + this.price);
    }

}