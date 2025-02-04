class Product {
    private static double discount = 10.0;
    private final String productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, String productID, double price, int quantity) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayDetails() {
        if (this instanceof Product) {
            System.out.println("Product Name: " + productName);
            System.out.println("Product ID: " + productID);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }
}

public class MainProduct {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", "123", 1500.00, 2);
        Product product2 = new Product("Smartphone", "456", 800.00, 5);
        product1.displayDetails();
        product2.displayDetails();
        Product.updateDiscount(15.0);
        product1.displayDetails();
        product2.displayDetails();
    }
}
