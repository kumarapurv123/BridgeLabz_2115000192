import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class ExpensiveService {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    int computeSquare(int number) {
        if (cache.containsKey(number)) {
            System.out.println(number);
            return cache.get(number);
        }
        System.out.println(number);
        int result = number * number;
        cache.put(number, result);
        return result;
    }
}

public class CustomCachingExample {
    public static void main(String[] args) {
        ExpensiveService service = new ExpensiveService();

        System.out.println(service.computeSquare(5));
        System.out.println(service.computeSquare(5));
        System.out.println(service.computeSquare(10));
        System.out.println(service.computeSquare(10));
    }
}
