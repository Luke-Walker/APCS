public class Main {

    public static final int[][] numArray = new int[][]{{15,5,9,10},
                                                       {12,16,11,6},
                                                       {14,8,13,7}};

    public static void main(String[] args) {
        Position pos = Successors.findPosition(16, numArray);
        System.out.println(pos.getR() + " | " + pos.getC());
    }
}
