import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int[] sizes = { 1000, 10000, 1000000 };
        Random random = new Random();

        for (int n : sizes) {
            int[] data = new int[n];

            for (int i = 0; i < n; i++) {
                data[i] = random.nextInt(n * 10);
            }

            int[] bubbleData = Arrays.copyOf(data, data.length);
            int[] mergeData = Arrays.copyOf(data, data.length);
            int[] quickData = Arrays.copyOf(data, data.length);

            long startTime, endTime;
            double timeTaken;

            if (n <= 10000) {
                startTime = System.nanoTime();
                bubbleSort(bubbleData);
                endTime = System.nanoTime();
                timeTaken = (endTime - startTime) / 1e6;
                System.out.println("Dataset Size: " + n);
                System.out.println("Bubble Sort Time: " + timeTaken + " ms");
            } else {
                System.out.println("Dataset Size: " + n);
                System.out.println("Bubble Sort Time: Unfeasible (>1hr)");
            }

            startTime = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            endTime = System.nanoTime();
            timeTaken = (endTime - startTime) / 1e6;
            System.out.println("Merge Sort Time: " + timeTaken + " ms");

            startTime = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            endTime = System.nanoTime();
            timeTaken = (endTime - startTime) / 1e6;
            System.out.println("Quick Sort Time: " + timeTaken + " ms");

        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
