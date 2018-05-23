public class Alg9 {

    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 2;
        nums[1] = 6;
        nums[2] = 8;
        nums[3] = 10;
        for (int i = nums.length - 2; i > 1; i--) {
            nums[i+1] = nums[i];
        }
        nums[1] = 4;

        for (int i : nums) {
            System.out.print(i + ", ");
        }
    }
}
