public class Square {

  // X, Y coordinate system assumes the origin is in the upper left
  private Point upperLeft;
  private Point lowerRight;

  public Square() {
    upperLeft = new Point(0,0);
    lowerRight = new Point(1,1);
  }

  public Square(Point a, Point b) {
    upperLeft = a;
    lowerRight = b;
  }

  public int getSideLength() {   // q4,5
    int side = lowerRight.x - upperLeft.x;
    return side;
  }

  public int area() {    // q6,7
    int side = getSideLength();
    return side * side;
  }

  public void scale(double scaleFactor) {
    int newSide = (int)(getSideLength() * scaleFactor);
    lowerRight = new Point(upperLeft.x + newSide, upperLeft.y + newSide);
  }

  public Point findCenter() {
    int centerX = upperLeft.x + getSideLength() / 2;
    int centerY = upperLeft.y + getSideLength() / 2;
    return new Point(centerX, centerY);    // q11
  }

  public double findDistance(Square other) {
    LineSegment ab = new LineSegment(findCenter(), other.findCenter());   // q12
    return ab.distance();
  }

  public String toString() {
    return "UL:" + upperLeft + ", LR:" + lowerRight + " : side length " + getSideLength();
  }


}
