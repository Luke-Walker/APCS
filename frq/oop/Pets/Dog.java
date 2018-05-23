public class Dog extends Pet {

    private String dog_sound = "woof";

    public Dog(String name) {
        super(name);
    }

    public String speak() {
        return dog_sound;
    }

    public String getDogSound() {
        return dog_sound;
    }
}
