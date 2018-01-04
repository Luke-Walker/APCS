package city;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        if (args.length == 1) {
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                System.out.println(new Building());
            }
        }

        Player player = Player.getInstance();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Money: $" + player.getMoney() + " | Property: $" + (player.getNetWorth()-player.getMoney()) + " | Net Worth: $" + player.getNetWorth());
            System.out.println("1. Review property");

            switch (Integer.parseInt(scan.nextLine())) {
                case 1:
                    break;
                default:
                    break;
            }
        }
    }
}
