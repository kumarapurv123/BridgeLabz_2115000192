import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] arr, int maxRange) {
        int[] count = new int[maxRange + 1];
        int[] output = new int[arr.length];

        for (int num : arr)
            count[num]++;
        for (int i = 1; i <= maxRange; i++)
            count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] ages = { 15, 12, 17, 10, 18, 14, 13, 11 };
        countingSort(ages, 18);
        System.out.println(Arrays.toString(ages));
    }
}
