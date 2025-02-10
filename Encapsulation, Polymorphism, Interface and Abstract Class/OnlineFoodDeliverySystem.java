import java.util.*;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

class VegItem extends FoodItem implements Discountable {
    private double discountRate;

    public VegItem(String itemName, double price, int quantity, double discountRate) {
        super(itemName, price, quantity);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateTotalPrice() {
        double totalPrice = getPrice() * getQuantity();
        return totalPrice - (totalPrice * discountRate);
    }

    @Override
    public void applyDiscount() {
        System.out.println("Applying discount: " + discountRate * 100 + "% on Veg Item");
    }

    @Override
    public String getDiscountDetails() {
        return "Discount Rate: " + discountRate * 100 + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double additionalCharges;
    private double discountRate;

    public NonVegItem(String itemName, double price, int quantity, double additionalCharges, double discountRate) {
        super(itemName, price, quantity);
        this.additionalCharges = additionalCharges;
        this.discountRate = discountRate;
    }

    @Override
    public double calculateTotalPrice() {
        double totalPrice = (getPrice() * getQuantity()) + additionalCharges;
        return totalPrice - (totalPrice * discountRate);
    }

    @Override
    public void applyDiscount() {
        System.out.println("Applying discount: " + discountRate * 100 + "% on Non-Veg Item");
    }

    @Override
    public String getDiscountDetails() {
        return "Discount Rate: " + discountRate * 100 + "%";
    }
}

interface Discountable {
    void applyDiscount();

    String getDiscountDetails();
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> foodItems = new ArrayList<>();

        VegItem vegItem = new VegItem("Panner ", 200, 2, 0.10);
        NonVegItem nonVegItem = new NonVegItem("chicken", 300, 1, 50, 0.05);

        foodItems.add(vegItem);
        foodItems.add(nonVegItem);

        processOrder(foodItems);
    }

    public static void processOrder(List<FoodItem> foodItems) {
        for (FoodItem item : foodItems) {
            item.getItemDetails();
            double totalPrice = item.calculateTotalPrice();
            System.out.println("Total Price: " + totalPrice);

            Discountable discountableItem = (Discountable) item;
            discountableItem.applyDiscount();
            System.out.println(discountableItem.getDiscountDetails());
            System.out.println();
        }
    }
}
