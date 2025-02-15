public class ConcatenateString {
    public static String concatenateStrings(String[] words) {
        StringBuffer result = new StringBuffer();
        for (String word : words) {
            result.append(word);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] words = { "Hello", " ", "World", "!", " Welcome", " to", " India" };
        System.out.println(concatenateStrings(words));
    }
}
