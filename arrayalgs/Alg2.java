public class Alg2 {

    public static void main(String[] args) {
        int[] nums = {43,45,43,40,41,45,43,45,42,43,40,47,45,38,32};
        System.out.println(nums[0]);
        System.out.println(nums[nums.length-1]);
        System.out.println(nums[nums.length/2]);

        int total = 0;
        for (int i : nums) {
            total += i;
        }

        System.out.println("Average: " + (total/nums.length));
    }
}
