import java.util.*;

public class MagicSquares {

    public static final int[][] threeByThree = {{7,0,5},
                                                {2,4,6},
                                                {3,8,1}};

    public static final int[][] fourByFour = {{1,15,14,4},
                                              {12,6,7,9},
                                              {8,10,11,5},
                                              {13,3,2,16}};

    public static int[][] square = null;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Select an option:");
        System.out.println("1. 3x3");
        System.out.println("2. 4x4");
        System.out.println("3. Custom");
        System.out.println("4. Exit");

        while (square == null) {
            switch (scan.nextLine()) {
                case "1":
                    square = threeByThree;
                    break;
                case "2":
                    square = fourByFour;
                    break;
                case "3":
                    System.out.print("Enter dimension for Magic Square: ");
                    square = createMagicSquare(Integer.parseInt(scan.nextLine()));
                    System.out.println();
                    break;
                case "4":
                    System.exit(0);
                default:
                    break;
            }
        }

        System.out.println(checkMagicSquare(square) ? "That is a Magic Square." : "That is not a Magic Square.");
    }

    public static int[][] createMagicSquare(int dimensions) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = new int[dimensions][dimensions];

        for (int y = 0; y < dimensions; y++) {
            for (int x = 0; x < dimensions; x++) {
                System.out.print("Value for " + (x+1) + "x" + (y+1) + ": ");
                matrix[x][y] = Integer.parseInt(scan.nextLine());
            }
        }

        return matrix;
    }

    public static boolean checkMagicSquare(int[][] matrix) {
        int num = 0;

        // vertical
        for (int x = 0; x < matrix.length; x++) {
            int sum = 0;
            for (int y = 0; y < matrix.length; y++) {
                sum += matrix[x][y];
            }
            if (num == 0) num = sum;
        }

        // horizontal
        for (int y = 0; y < matrix.length; y++) {
            int sum = 0;
            for (int x = 0; x < matrix.length; x++) {
                sum += matrix[x][y];
            }

            if (sum != num) return false;
        }

        // diagonal: top-left to bottom-right
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        if (sum != num) return false;

        // diagonal: top-right to bottom-left
        sum = 0;
        for (int i = matrix.length-1; i >= 0; i--) {
            sum += matrix[i][i];
        }
        if (sum != num) return false;

        return true;
    }
}
