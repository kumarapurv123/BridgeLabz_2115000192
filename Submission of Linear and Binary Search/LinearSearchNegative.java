public class LinearSearchNegative {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = { 3, 7, 1, 9, -5, 2, -8 };
        int index = findFirstNegative(numbers);
        System.out.println(index);
    }
}