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
        Position[][] positions = new Position[arr.length][arr.length];
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions[i].length; j++) {
                int num = arr[i][j];
                positions[i][j] = findPosition(num+1, arr);
            }
        }
        return positions;
    }
}
