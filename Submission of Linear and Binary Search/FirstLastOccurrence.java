public class FirstLastOccurrence {
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int[] findFirstAndLast(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);
        return new int[] { first, last };
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 4, 4, 6, 8, 10 };
        int target = 4;

        int[] result = findFirstAndLast(arr, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
