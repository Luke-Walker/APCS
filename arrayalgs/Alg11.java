public class Alg11 {

    public static void main(String[] args) {
        int[] nums = {1,2};
        int[] swap = new int[2];
        swap[0] = nums[1];
        swap[1] = nums[0];

        for (int i : swap) {
            System.out.print(i + " ");
        }
    }
}
