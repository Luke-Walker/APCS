import java.util.Random;

public class RandomString {

    private String[] words;

    public RandomString(String[] words) {
        this.words = words;
    }

    public String getNext() {
        Random rand = new Random();
        int r = rand.nextInt(words.length);
        String word = words[r];
        boolean none = true;

        while (word == "") {
            for (String s : words) {
                if (s != "") none = false;
            }
            if (none) {
                return "NONE";
            }
            r = rand.nextInt(words.length);
            word = words[r];
        }
        words[r] = "";
        return word;
    }
}
