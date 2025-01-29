import java.time.LocalDate;

public class DateArithmetic {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2025, 1, 29);
        LocalDate updatedDate = date.plusDays(7).plusMonths(1).plusYears(2);
        updatedDate = updatedDate.minusWeeks(3);
        System.out.println("Original Date: " + date);
        System.out.println("Updated Date: " + updatedDate);
    }
}
