import java.util.*;

public class Alg7 {

    public static void main(String[] args) {
        int[] nums = {43,45,43,40,41,45,43,45,42,43,40,47,45,38,32};
        int[] copyArr = new int[15];
        for (int i = 0; i < nums.length; i++) {
            copyArr[i] = nums[i];
            System.out.println(copyArr[i]);
        }

        System.out.println();

        ArrayList<Integer> copyList = new ArrayList<Integer>();
        for (int i : nums) {
            copyList.add(i);
            System.out.println(copyList.get(copyList.size()-1));
        }
    }
}
