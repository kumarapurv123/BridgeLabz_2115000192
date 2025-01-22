public class ProfitCalculator {
    public static void main(String[] args) {
        double CP = 129;
        double SP = 191;
        double profit = SP - CP;
        double profitPercentage = (profit / CP) * 100;
        System.out.println("The Cost Price is INR " + CP +
                " and Selling Price is INR " + SP + ".\n" +
                "The Profit is INR " + profit +
                " and the Profit Percentage is " + profitPercentage + "%.");

    }
}