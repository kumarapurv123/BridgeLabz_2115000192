import java.util.Scanner;

class Product {
    private String productName;
    private double price;
    private static int totalProducts = 0;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }

    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }
}

public class MainProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Product Name:");
        String productName1 = sc.nextLine();
        System.out.println("Enter the Price:");
        double price1 = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter the Product Name:");
        String productName2 = sc.nextLine();
        System.out.println("Enter the Price:");
        double price2 = sc.nextDouble();

        Product product1 = new Product(productName1, price1);
        Product product2 = new Product(productName2, price2);

        product1.displayProductDetails();
        product2.displayProductDetails();
        Product.displayTotalProducts();
    }
}