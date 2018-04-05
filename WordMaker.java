import java.util.HashMap;

public class WordMaker {

    public static void main(String[] args) {
        char[][] letters = new char[4][4];
        letters[0] = new char[]{'C','A','T','L'};
        letters[1] = new char[]{'H','I','O','O'};
        letters[2] = new char[]{'I','N','T','R'};
        letters[3] = new char[]{'P','T','E','Y'};

        for (int y = 0; y < letters.length; y++) {
            for (int x = 0; x < letters[0].length; x++) {
                System.out.print(letters[y][x]);
            }
            System.out.println();
        }
        for (int x = 0; x < letters.length; x++) {
            for (int y = 0; y < letters[0].length; y++) {
                System.out.print(letters[y][x]);
            }
            System.out.println();
        }
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i][i]);
        }
        System.out.println();
        for (int y = letters.length-1; y >= 0; y--) {
            System.out.print(letters[y][letters.length-1-y]);
        }
        System.out.println();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int vowels = 0;
        int consonants = 0;
        char highest = 0;
        int high_x = 0;
        int high_y = 0;
        char lowest = letters[0][0];
        int low_x = 0;
        int low_y = 0;
        for (int y = 0; y < letters.length; y++) {
            for (int x = 0; x < letters[0].length; x++) {
                char c = letters[y][x];

                if (!map.containsKey(c)) map.put(c, 1);
                else map.put(c, map.get(c)+1);

                if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                    vowels++;
                } else {
                    consonants++;
                    if (c > highest) {
                        highest = c;
                        high_x = x;
                        high_y = y;
                    }
                    if (c < lowest) {
                        lowest = c;
                        low_x = x;
                        low_y = y;
                    }
                }
            }
        }
        letters[high_y][high_x] = lowest;
        letters[low_y][low_x] = highest;
        System.out.println("HIGHEST: " + highest + " | LOWEST: " + lowest);
        System.out.println("# OF VOWELS: " + vowels + " | # OF CONSONANTS: " + consonants);
        
        char used = ' ';
        int num = 0;
        for (char c : map.keySet()) {
            if (map.get(c) > num) {
                used = c;
                num = map.get(c);
            }
        }
        System.out.println("MOST USED LETTER: " + used + " USED " + num + " TIMES");
    }
}
