public class CitySimLite {

  public static void main(String[] args) {

    Building bldg1 = new Building();
    CityObject bldg2 = new Building(1, 1, "Bldg", 25);
    Building bldg3 = new OfficeTower(0, 1, "Tow1", 275, "Office Tower1", 15);
    OfficeTower bldg4 = new OfficeTower();

    System.out.println(bldg1);
    System.out.println(bldg2);
    System.out.println(bldg3);
    System.out.println(bldg4);

  }

}
