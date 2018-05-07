import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<Pet>();
        pets.add(new Dog("Jimmy"));
        pets.add(new Cat("Whiskers"));
        pets.add(new LoudDog("Jerome"));

        Kennel kennel = new Kennel(pets);
        kennel.allSpeak();
    }
}
