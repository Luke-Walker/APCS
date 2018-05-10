public class Successors {

    public static Position findPosition(int num, int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == num) return new Position(i, j);
            }
        }
        return null;
    }

    public static Position[][] getSuccessorArray(int[][] arr) {
        return null;
    }
}
