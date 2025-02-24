import java.util.ArrayList;

public class SuppressWarningsExample {
    @SuppressWarnings("unchecked")
    void useRawArrayList() {
        ArrayList rawList = new ArrayList();
        rawList.add("Hello");
        rawList.add(100);
        System.out.println(rawList);
    }

    public static void main(String[] args) {
        SuppressWarningsExample example = new SuppressWarningsExample();
        example.useRawArrayList();
    }
}
