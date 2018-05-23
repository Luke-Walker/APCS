public class Alg4 {

    public static void main(String[] args) {
        int[] nums = {43,45,43,40,41,45,43,45,42,43,40,47,45,38,32,34,58,66,56,54,58,54,53,55,50,50,53,54,53};

        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }

        System.out.println(min + " - " + max);
    }
}
