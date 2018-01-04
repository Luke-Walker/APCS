package city;

public class HomeBuilding extends Building {

    private int residents;

    public HomeBuilding(int residents) {
        super();
        this.residents = residents;
    }

    @Override
    public String toString() {
        return super.toString() + " : " + residents + " residents";
    }
}
