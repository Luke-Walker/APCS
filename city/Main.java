package city;

public class Main {

    public static void main(String[] args) {
        if (args.length == 1) {
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                System.out.println(new Building());
            }
        }
    }
}
