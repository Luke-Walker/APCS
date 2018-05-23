public class Alg1 {

    public static void main(String[] args) {
        int[] nums = new int[15];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i*i;
            System.out.println(i + "-" + nums[i]);
        }
    }
}
