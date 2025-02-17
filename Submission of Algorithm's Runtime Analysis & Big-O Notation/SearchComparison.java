import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    public static void main(String[] args) {
        int[] sizes = { 1000, 10000, 1000000 };
        Random random = new Random();
        for (int n : sizes) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = random.nextInt(n * 10);
            }
            int target = data[random.nextInt(n)];
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long endTime = System.nanoTime();
            double linearTime = (endTime - startTime) / 1e6;
            Arrays.sort(data);
            startTime = System.nanoTime();
            binarySearch(data, target);
            endTime = System.nanoTime();
            double binaryTime = (endTime - startTime) / 1e6;
            System.out.println(n);
            System.out.println(linearTime);
            System.out.println(binaryTime);
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
