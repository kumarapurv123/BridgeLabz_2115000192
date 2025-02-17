public class FibonacciComparison {

    public static void main(String[] args) {
        int n = 30;

        long recursiveTime = measureRecursiveFibonacci(n);
        long iterativeTime = measureIterativeFibonacci(n);

        System.out.println("Recursive Fibonacci Time: " + recursiveTime + " ns");
        System.out.println("Iterative Fibonacci Time: " + iterativeTime + " ns");
    }

    private static long measureRecursiveFibonacci(int n) {
        long startTime = System.nanoTime();
        fibonacciRecursive(n);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    private static long measureIterativeFibonacci(int n) {
        long startTime = System.nanoTime();
        fibonacciIterative(n);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}