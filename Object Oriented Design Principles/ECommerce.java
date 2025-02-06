import java.util.ArrayList;
import java.util.List;

class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{id=" + productId + ", name='" + name + "', price=" + price + "}";
    }
}

class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double totalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order{id=" + orderId + ", customer=" + customer.getName() + ", totalPrice=" + totalPrice() + "}";
    }
}

class Customer {
    private int customerId;
    private String name;
    private List<Order> orders;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{id=" + customerId + ", name='" + name + "'}";
    }
}

public class ECommerce {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Laptop", 1000);
        Product product2 = new Product(2, "Smartphone", 700);

        Customer customer = new Customer(1, "Customer1");

        Order order = new Order(1, customer);

        order.addProduct(product1);
        order.addProduct(product2);

        customer.placeOrder(order);

        System.out.println(order);
    }
}
