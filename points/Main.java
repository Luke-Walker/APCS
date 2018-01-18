package points;

public class Main {

    public static void main(String[] args) {
        LineSegment ls = new LineSegment(new Point(Integer.parseInt(args[0]),Integer.parseInt(args[1])), new Point(Integer.parseInt(args[2]),Integer.parseInt(args[3])));
        System.out.println(ls);
        System.out.println(ls.getDistance());
        System.out.println(ls.getSlope());
    }
}
