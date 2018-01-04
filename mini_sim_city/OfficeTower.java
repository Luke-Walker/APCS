public class OfficeTower extends Building {

	int stories;
	String name;

	public OfficeTower() {
		super();
		name = "Sky Scraper";
		stories = 20;
	}

	public OfficeTower(int x, int y, String symb, int occ, String n, int s) {
		super(x, y, symb, occ);
		name = n;
		stories = s;
	}

	public String toString() {
		return name + " " + stories + " stories tall";
	}

}
