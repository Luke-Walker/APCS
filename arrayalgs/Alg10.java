public class Alg10 {

    public static void main(String[] args) {
        int[] nums = {2,4,6,8,10};
        for (int i = 0; i < nums.length-1; i++) {
            nums[i] = nums[i+1];
        }
        nums[nums.length-1] = 0;

        for (int i : nums) {
            System.out.print(i + ", ");
        }
    }
}
