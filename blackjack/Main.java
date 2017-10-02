package blackjack;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    private static boolean round = true;

    /*
        0: hit/stand choice
        1: placing bets
        2: starting tokens
    */
    private static boolean[] loops = {false, false, false};

    public static void main(String[] args) {
        if (args.length == 0) return;
		if (Integer.parseInt(args[0]) < 2) return;

        Card.initCards();

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
            System.out.print("Player " + i + "'s name: ");
            new Player(scan.nextLine());
        }

        int startingTokens = 100;
        do {
            System.out.print("How many tokens should each person start with? ");
            try {
                startingTokens = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException ex) {
                continue;
            }
            loops[2] = true;
        } while (!loops[2]);

        for (Player player : Player.players) {
            player.setTokens(startingTokens);
            Player.remainingPlayers.add(player);
        }
        System.out.print("\n");
        round = true;
        while (true) {
            for (Player player : Player.players) {
                if (player.isBusted() || player.isStanding()) continue;

                System.out.println(player.getName() + ": "  + player.getPoints() + " Points | "
                    + player.getTokens() + " Tokens | " + player.getBet() + " Bet");
                if (player.getBet() == 0) {
                    do {
                        System.out.print("How many tokens would you like to bet? ");
                        try {
                            player.bet(Integer.parseInt(scan.nextLine()));
                        } catch (NumberFormatException ex) {
                            continue;
                        }
                        loops[1] = true;
                    } while (!loops[1]);
                }
                do {
                    System.out.print("What would you like to do? (hit, stand): ");
                    String response = scan.nextLine().toLowerCase();
                    switch (response) {
                        case "hit":
                            Card.playCard(player);
                            loops[0] = true;
                            break;
                        case "stand":
                            player.setStanding(true);
                            loops[0] = true;
                            break;
                        default:
                            break;
                    }
                } while (!loops[0]);

                System.out.print("\n");

                if (player.isStanding() || player.isBusted()) Player.remainingPlayers.remove(player);

                if (Player.remainingPlayers.size() <= 1) break;
            }

            if (Player.remainingPlayers.size() <= 1) {
                ArrayList<Player> winners = new ArrayList<Player>();
                for (Player player : Player.players) {
                    if ((player.isStanding() || Player.remainingPlayers.size() == 1) && !player.isBusted()) {
                        if (winners.size() == 0) {
                            winners.add(player);
                            continue;
                        }
                        if (player.getPoints() > winners.get(0).getPoints()) {
                            winners.clear();
                            winners.add(player);
                        } else if (player.getPoints() == 21) {
                            if (winners.get(0).getPoints() != 21) {
                                winners.clear();
                            }
                            winners.add(player);
                        }
                    }
                }
                for (Player player : winners) {
                    System.out.println(player.getName() + " won " + player.getBet()*2 + " tokens!\n\n");
                    player.win();
                    round = false;
                }
            }
            if (!round) newRound();
        }
    }

    private static void newRound() {
        Player.remainingPlayers.clear();
        ArrayList<Player> out = new ArrayList<Player>();
        for (Player player : Player.players) {
            if (player.getTokens() <= 0) {
                System.out.println(player.getName() + " is out of tokens!");
                out.add(player);
                continue;
            }

            player.resetPoints();
            player.resetBet();
            player.setStanding(false);
            player.setBusted(false);

            Player.remainingPlayers.add(player);
        }
        for (Player player : out) Player.players.remove(player);

        if (Player.players.size() == 1) {
            System.out.println(Player.players.get(0).getName() + " won the game!");
            System.exit(0);
        }

        ArrayList<Card> used = new ArrayList<Card>();
        for (Card card : Card.usedCards) used.add(card);
        for (Card card : used) {
            Card.usedCards.remove(card);
            Card.cards.add(card);
        }
        round = true;
    }
}
