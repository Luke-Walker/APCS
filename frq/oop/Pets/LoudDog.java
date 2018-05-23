public class LoudDog extends Dog {

    public LoudDog(String name) {
        super(name);
    }

    public String speak() {
        return getDogSound() + " " + getDogSound();
    }
}
