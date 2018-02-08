public class TrailRunner {

  public static void main(String[] args) {

    int[] elevations = {100, 150, 105, 120, 90, 80, 50, 75, 75, 70, 80, 90, 100 };
    Trail trail = new Trail(elevations);

    System.out.println("trail.isLevelTrailSegment(7, 10) should print: true");
    System.out.println("\tYour code produces: " + trail.isLevelTrailSegment(7, 10));

    System.out.println("trail.isLevelTrailSegment(2, 12) should print: false");
    System.out.println("\tYour code produces: " + trail.isLevelTrailSegment(2, 12));

    System.out.println("trail.isDifficult() should print: true");
    System.out.println("\tYour code produces: " + trail.isDifficult());

  }

}
