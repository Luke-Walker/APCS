public class SequenceAnalyzer {

    public static final String[] organisms = {"TCCAAACCCAGCTCTATTTTAGTGGTCATGGGTTCTGGTCCCCCCGAGCC",
                                              "TCCAAACCCAGCTCTAATTAAGTGGTCAAGCGTTCTGGTCCCCCCGAGGC",
                                              "AAACCCCTCTAGTGGTCATCTGGTCCGCCGAGC"};

    public static void main(String[] args) {
        // #1
        int similarities = 0;
        for (int i = 0; i < organisms[0].length(); i++) {
            char c = organisms[0].charAt(i);
            if (c == organisms[1].charAt(i)) similarities++;
        }

        double percent = (double)similarities/organisms[0].length()*100;
        System.out.println("Similarity Percentage between (" + organisms[0] + ") and (" + organisms[1] + "):");
        System.out.println(percent + "%\n");

        // #2

    }
}
