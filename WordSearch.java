public class WordSearch {

    public static final String[][] matrix = {{"g","b","o","w","c"},
                                             {"d","i","b","o","k"},
                                             {"a","c","v","r","j"},
                                             {"n","m","o","d","e"},
                                             {"p","y","h","q","c"}};

    public static final String horizontal = "mode";
    public static final String vertical = "word";

    public static void main(String[] args) {
        String horiz = "";
        // horizontal
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                String letter = matrix[x][y];

                if (horizontal.replaceFirst(horiz, "").startsWith(letter)) horiz += letter;
            }
        }

        // vertical
        String vert = "";
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                String letter = matrix[x][y];

                if (vertical.replaceFirst(vert, "").startsWith(letter)) vert += letter;
            }
        }

        System.out.println("Horizontal: " + horiz);
        System.out.println("Vertical: " + vert);
    }
}
