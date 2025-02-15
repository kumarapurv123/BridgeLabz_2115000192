public class ComparePerformance {
    public static void main(String[] args) {
        long startTime, endTime;
        startTime = System.nanoTime();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            sbBuffer.append("hello");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer: " + (endTime - startTime) + " ns");
        startTime = System.nanoTime();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sbBuilder.append("hello");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder: " + (endTime - startTime) + " ns");
    }
}