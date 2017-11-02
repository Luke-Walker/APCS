import java.util.*;

public class ShapeCreator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Welcome to the shape creator! Enter a shape name (rectangle, right triangle, isosceles, or exit to close the program): ");
            String shape = scan.nextLine().toLowerCase();
            System.out.print("Dimensions (<length>x<height>): ");
            String[] dimensions = scan.nextLine().split("x");
            int length = Integer.parseInt(dimensions[0]);
            int height = Integer.parseInt(dimensions[1]);

            if (shape.equals("q")) return;

            switch (shape) {
                case "rectangle":
                    for (int l = 0; l < length; l++) {
                        for (int h = 0; h < height; h++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case "right triangle":
                    for (int h = 1; h <= height; h++) {
                        for (int l = 1; l <= h; l++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case "isosceles triangle":
                    for (int h = 1; h <= height/2; h++) {
                        for (int l = 1; l <= h; l++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    for (int h = height/2; h >= 0; h--) {
                        for (int l = h; l >= 0; l--) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
