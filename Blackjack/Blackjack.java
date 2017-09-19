import java.util.*;

public class Blackjack {

    public static void main(String[] args) {
        if (args.length == 0) return;

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < args.length; i++) {
            System.out.println("Player " + i + "'s name: ");
            new Player(scan.nextLine());
        }

        
    }
}
