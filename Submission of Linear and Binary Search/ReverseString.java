public class ReverseString{
    public static void main(String[] args) {
        String str = "Hello World";
        String reversed = reverse(str);
        System.out.println( reversed);
    }

    public static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }
}