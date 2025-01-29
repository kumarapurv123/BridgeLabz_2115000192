public class WordReplace {

    public static void main(String[] args) {
        String sentence = "Apple";
        String oldWord = "Apple";
        String newWord = "orange";
        String ans = replaceWord(sentence, oldWord, newWord);
        System.out.println(ans);
    }

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        return sentence.replace(oldWord, newWord);
    }
}