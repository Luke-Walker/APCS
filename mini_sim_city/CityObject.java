public class CityObject {

  private int x;
  private int y;
  private String symbol;

  public CityObject() {
    x = 0;
    y = 0;
    symbol = "CiOb";
  }

  public CityObject(int x, int y, String symb) {
    this.x = x;
    this.y = y;
    symbol = symb;
  }

  public String getSymbol() {
    return symbol;
  }

  public String toString() {
    return symbol + " located at: " + x + "," + y;
  }

}
