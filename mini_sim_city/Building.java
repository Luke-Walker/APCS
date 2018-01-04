public class Building extends CityObject {

  private int occupancy;

  public Building() {
    super();
    occupancy = 5;
  }

  public Building(int x, int y, String symb, int occ) {
    super(x, y, symb);
    occupancy = occ;
  }

  public String toString() {
    return super.toString() + " occupancy: " + occupancy;
  }

}
