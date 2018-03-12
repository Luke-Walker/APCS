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


        // #4
        

        // #3


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
