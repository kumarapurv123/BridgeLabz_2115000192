import java.util.*;

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Electronics extends Product implements Taxable {
    private double discountRate;
    private double taxRate;

    public Electronics(int productId, String name, double price, double discountRate, double taxRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
        this.taxRate = taxRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + taxRate * 100 + "%";
    }
}

class Clothing extends Product implements Taxable {
    private double discountAmount;
    private double taxRate;

    public Clothing(int productId, String name, double price, double discountAmount, double taxRate) {
        super(productId, name, price);
        this.discountAmount = discountAmount;
        this.taxRate = taxRate;
    }

    @Override
    public double calculateDiscount() {
        return discountAmount;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + taxRate * 100 + "%";
    }
}

class Groceries extends Product implements Taxable {
    private double discountRate;

    public Groceries(int productId, String name, double price, double discountRate) {
        super(productId, name, price);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: 5%";
    }
}

interface Taxable {
    double calculateTax();

    String getTaxDetails();
}

public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Electronics laptop = new Electronics(1, "Laptop", 80000, 0.10, 0.18);
        Clothing shirt = new Clothing(2, "Shirt", 1500, 200, 0.12);
        Groceries apple = new Groceries(3, "Apple", 100, 0.05);

        products.add(laptop);
        products.add(shirt);
        products.add(apple);

        calculateAndPrintFinalPrice(products);
    }

    public static void calculateAndPrintFinalPrice(List<Product> products) {
        for (Product product : products) {
            product.displayDetails();
            double discount = product.calculateDiscount();
            double tax = ((Taxable) product).calculateTax();
            double finalPrice = product.getPrice() + tax - discount;

            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
            System.out.println();
        }
    }
}
