package points;

public class LineSegment {

    private Point point1, point2;

    public LineSegment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public double getDistance() {
        return Math.sqrt((point2.x-point1.x)^2+(point2.y-point1.y)^2);
    }

    public double getSlope() {
        return (point2.y-point1.y)/(point2.x-point1.x);
    }

    @Override
    public String toString() {
        return point1 + "," + point2;
    }
}
