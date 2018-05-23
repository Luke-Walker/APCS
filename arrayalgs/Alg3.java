public class Alg3 {

    public static void main(String[] args) {
        int[] nums = {43,45,43,40,41,45,43,45,42,43,40,47,45,38,32,34,58,66,56,54,58,54,53,55,50,50,53,54,53};

        int greater = 0;
        int equal = 0;
        int containsFive = 0;
        for (int i : nums) {
            if (i > 45) greater++;
            if (i == 45) equal++;
            if ((i%5)%2 == 1) containsFive++;
        }

        System.out.println("Greater than 45: " + greater);
        System.out.println("Equal to 45: " + equal);
        System.out.println("Contains a 5: " + containsFive);
    }
}
