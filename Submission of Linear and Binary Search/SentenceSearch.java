public class SentenceSearch {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "The sun is shining brightly.",
                "I love programming in Java.",
                "Today is a great day to learn something new.",
                "Let's go for a walk in the park."
        };

        String wordToSearch = "Java";
        String result = findSentenceWithWord(sentences, wordToSearch);

        System.out.println(wordToSearch + "" + result);
    }
}
