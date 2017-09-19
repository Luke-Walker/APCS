package blackjack;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) return;

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < args.length; i++) {
            System.out.println("Player " + i + "'s name: ");
            new Player(scan.nextLine());
        }

        System.out.println("How many tokens should each person start with? ");
        int startingTokens = Integer.parseInt(scan.nextLine());
        for (Player player : Player.players) {
            player.setTokens(startingTokens);
        }

        while (true) {
            for (Player player : Player.players) {
                System.out.println("Player " + player.getNumber() + ": " + player.getPoints() + " Points | "
                    + player.getTokens() + " Tokens");
                System.out.println("What would you like to do? (bet <number>, hit, stand)");
            }
        }
    }

    private static newRound() {
        for (Player player : Player.players) {
            player.resetPoints();
        }
    }
}
