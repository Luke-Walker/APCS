public class SequenceAnalyzer {

    public static final String[][] organisms = {{"TCCAAACCCAGCTCTATTTTAGTGGTCATGGGTTCTGGTCCCCCCGAGCC"},
                                                {"TCCAAACCCAGCTCTAATTAAGTGGTCAAGCGTTCTGGTCCCCCCGAGGC"},
                                                {"AAACCCCTCTAGTGGTCATCTGGTCCGCCGAGC"},
                                                {"TCCAACCTCAGCTCTCTTTCAGTGGTCATGGGTTCTGGTACCACCGGACC"},
                                                {"TTCAAATCCAGCTCTGTTTTAGTAGCCATGGGTTCTGGCCCCCCCGAGCC"},
                                                {"CCCAAACCCATCTCTAGTTTCGTGGGCATGGGTTTTGGTCACCCCTAGCC"}};

    public static void main(String[] args) {
        // #1
        System.out.println("Similarity Percentage between (" + organisms[0][0] + ") and (" + organisms[1][0] + "):");
        System.out.println(calculateSimilarity(organisms[0], organisms[1]) + "%\n\n");

        // #2


        // #3


        // #4
        double highest = 0;
        int seq1 = 0;
        int seq2 = 0;
        for (int i = 0; i < organisms.length-1; i++) {
            for (int j = 0; j < organisms.length; j++) {
                if (i == 2 || j == 2 || i == j) continue;

                double similarity = calculateSimilarity(organisms[i], organisms[j]);

                if (similarity > highest) {
                    highest = similarity;
                    seq1 = i;
                    seq2 = j;
                }
            }
        }
        System.out.println("Largest similarity within the organisms is " + highest + "% between Organism #" + seq1 + " (" + organisms[seq1][0] + ") and Organism #" + seq2 + " (" + organisms[seq2][0] + ").\n\n");

        // #9
        System.out.println("Longest Match between (" + organisms[0][0] + ") and (" + organisms[2][0] + "):");
        System.out.println(longestMatch() + "\n\n");
    }

    // #5
    public static double calculateSimilarity(String[] list1, String[] list2) {
        int similarities = 0;
        for (int i = 0; i < list1[0].length(); i++) {
            char c = list1[0].charAt(i);
            if (c == list2[0].charAt(i)) similarities++;
        }

        return (double)similarities/list1[0].length()*100;
    }

    // #9
    public static int longestMatch() {
        int best = 0;
        int count = 0;
        for (int i = 0; i < organisms[0][0].length(); i++) {
            char c = organisms[0][0].charAt(i);
            if (c == organisms[2][0].charAt(count)) {
                count++;
            } else {
                if (count > best) best = count;
                count = 0;
            }
        }

        return best;
    }
}
