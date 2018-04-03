public class SequenceAnalyzer {

    /*
        points: 21/30
        #1 (8): done
        #2 (8): done
        #3 (8): incomplete
        #4 (3): done
        #5 (2): done
        #8 (2): incomplete (fix)
    */

    public static final char[][] organisms = {{'T', 'C', 'C', 'A', 'A', 'A', 'C', 'C', 'C', 'A', 'G', 'C', 'T', 'C', 'T', 'A', 'T', 'T', 'T', 'T', 'A', 'G', 'T', 'G', 'G', 'T', 'C', 'A', 'T', 'G', 'G', 'G', 'T', 'T', 'C', 'T', 'G', 'G', 'T', 'C', 'C', 'C', 'C', 'C', 'C', 'G', 'A', 'G', 'C', 'C'},
                                              {'T', 'C', 'C', 'A', 'A', 'A', 'C', 'C', 'C', 'A', 'G', 'C', 'T', 'C', 'T', 'A', 'A', 'T', 'T', 'A', 'A', 'G', 'T', 'G', 'G', 'T', 'C', 'A', 'A', 'G', 'C', 'G', 'T', 'T', 'C', 'T', 'G', 'G', 'T', 'C', 'C', 'C', 'C', 'C', 'C', 'G', 'A', 'G', 'G', 'C'},
                                              {'A', 'A', 'A', 'C', 'C', 'C', 'C', 'T', 'C', 'T', 'A', 'G', 'T', 'G', 'G', 'T', 'C', 'A', 'T', 'C', 'T', 'G', 'G', 'T', 'C', 'C', 'G', 'C', 'C', 'G', 'A', 'G', 'C'},
                                              {'T', 'C', 'C', 'A', 'A', 'C', 'C', 'T', 'C', 'A', 'G', 'C', 'T', 'C', 'T', 'C', 'T', 'T', 'T', 'C', 'A', 'G', 'T', 'G', 'G', 'T', 'C', 'A', 'T', 'G', 'G', 'G', 'T', 'T', 'C', 'T', 'G', 'G', 'T', 'A', 'C', 'C', 'A', 'C', 'C', 'G', 'G', 'A', 'C', 'C'},
                                              {'T', 'T', 'C', 'A', 'A', 'A', 'T', 'C', 'C', 'A', 'G', 'C', 'T', 'C', 'T', 'G', 'T', 'T', 'T', 'T', 'A', 'G', 'T', 'A', 'G', 'C', 'C', 'A', 'T', 'G', 'G', 'G', 'T', 'T', 'C', 'T', 'G', 'G', 'C', 'C', 'C', 'C', 'C', 'C', 'C', 'G', 'A', 'G', 'C', 'C'},
                                              {'C', 'C', 'C', 'A', 'A', 'A', 'C', 'C', 'C', 'A', 'T', 'C', 'T', 'C', 'T', 'A', 'G', 'T', 'T', 'T', 'C', 'G', 'T', 'G', 'G', 'G', 'C', 'A', 'T', 'G', 'G', 'G', 'T', 'T', 'T', 'T', 'G', 'G', 'T', 'C', 'A', 'C', 'C', 'C', 'C', 'T', 'A', 'G', 'C', 'C'}};

    public static void main(String[] args) {
        System.out.println();
        for (int i = 0; i < organisms.length; i++) {
            System.out.println("Organism #" + (i+1) + ": " + organismToString(organisms[i]));
        }
        System.out.println("\n");

        // #1
        System.out.println("Similarity Percentage between Organism #1 and Organism #2:");
        System.out.println(calculateSimilarity(organisms[0], organisms[1]) + "%\n\n");

        // #2
        System.out.println("The following sequences are found in Organism #1:");
        if (containsSequence(organisms[0], new char[]{'A','A','A','C','C','C'})) System.out.println("AAACCC");
        if (containsSequence(organisms[0], new char[]{'C','T','C','T','A'})) System.out.println("CTCTA");
        if (containsSequence(organisms[0], new char[]{'C','C','G','A','G','C'})) System.out.println("CCGAGC");

        System.out.println("\nThe following sequences are found both in Organism #1 and Organism #2:");
        if (containsSequence(organisms[0], new char[]{'A','A','A','C','C','C'}) && containsSequence(organisms[1], new char[]{'A','A','A','C','C','C'})) System.out.println("AAACCC");
        if (containsSequence(organisms[0], new char[]{'C','T','C','T','A'}) && containsSequence(organisms[1], new char[]{'C','T','C','T','A'})) System.out.println("CTCTA");
        if (containsSequence(organisms[0], new char[]{'C','C','G','A','G','C'}) && containsSequence(organisms[1], new char[]{'C','C','G','A','G','C'})) System.out.println("CCGAGC");
        System.out.println("\n");

        // #3


        // #4
        double highest = 0;
        int org1 = 0;
        int org2 = 0;
        for (int i = 0; i < organisms.length-1; i++) {
            for (int j = 0; j < organisms.length; j++) {
                if (i == 2 || j == 2 || i == j) continue;

                double similarity = calculateSimilarity(organisms[i], organisms[j]);

                if (similarity > highest) {
                    highest = similarity;
                    org1 = i;
                    org2 = j;
                }
            }
        }
        System.out.println("Largest similarity within the organisms is " + highest + "% between Organism #" + (org1+1) + " and Organism #" + (org2+1) + ".\n\n");

        // #8
        char[][] cross = crossOrganisms(organisms[0], organisms[1]);
        System.out.println("Organism #1 x Organism #2:");
        System.out.println(organismToString(cross[0]));
        System.out.println(organismToString(cross[1]));
    }

    // #2
    public static boolean containsSequence(char[] seq1, char[] seq2) {
        int length = 0;
        for (int i = 0; i < seq1.length; i++) {
            if (seq1[i] == seq2[length])
                length++;
            else
                length = 0;

            if (length == seq2.length)
                return true;
        }

        return false;
    }

    // #5
    public static double calculateSimilarity(char[] org1, char[] org2) {
        int similarities = 0;
        for (int i = 0; i < org1.length; i++) {
            if (org1[i] == org2[i]) similarities++;
        }

        return (double)similarities/org1.length*100;
    }

    // #8 *FIX*
    public static char[][] crossOrganisms(char[] seq1, char[] seq2) {
        char[] cross1 = new char[seq1.length];
        char[] cross2 = new char[seq2.length];

        for (int i = 0; i < seq1.length/2; i++)
            cross1[i] = seq1[i];

        for (int i = seq1.length/2; i < seq1.length; i++)
            cross2[i] = seq2[i];

        for (int i = 0; i < seq2.length/2; i++)
            cross2[i] = seq2[i];

        for (int i = seq2.length/2; i < seq2.length; i++)
            cross1[i] = seq2[i];

        return new char[][]{cross1, cross2};
    }

    public static String organismToString(char[] org) {
        String str = "";
        for (char c : org) {
            str += String.valueOf(c);
        }

        return str;
    }
}
