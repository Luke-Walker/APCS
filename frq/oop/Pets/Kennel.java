import java.util.*;

public class Kennel {

    private List<Pet> pets;

    public Kennel(List<Pet> pets) {
        this.pets = pets;
    }

    public void allSpeak() {
        for (Pet p : pets) {
            System.out.println(p.getName() + ": " + p.speak());
        }
    }
}
