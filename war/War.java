import java.util.*;

public class War {

    private static ArrayList<Card> player = new ArrayList<Card>();
    private static ArrayList<Card> playerInPlay = new ArrayList<Card>();
    private static ArrayList<Card> cpu = new ArrayList<Card>();
    private static ArrayList<Card> cpuInPlay = new ArrayList<Card>();

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        for (int i = 0; i < deck.cards.length; i++) {
            if (i <= 25) {
                player.add(deck.deal());
            } else {
                cpu.add(deck.deal());
            }
        }

        Scanner scan = new Scanner(System.in);

        while (player.size() > 0 && cpu.size() > 0) {
            playerInPlay.add(player.get(0));
            cpuInPlay.add(cpu.get(0));

            player.remove(0);
            cpu.remove(0);

            System.out.println("Player (" + player.size() + "): " + playerInPlay.get(0) + "\n");
            System.out.println("CPU (" + cpu.size() + "): " + cpuInPlay.get(0) + "\n");

            if (playerInPlay.get(0).getValue() > cpuInPlay.get(0).getValue()) {
                player.addAll(playerInPlay);
                player.addAll(cpuInPlay);
                playerInPlay.clear();
                cpuInPlay.clear();
                System.out.println("Player wins! \n");
            } else if (playerInPlay.get(0).getValue() < cpuInPlay.get(0).getValue()) {
                cpu.addAll(playerInPlay);
                cpu.addAll(cpuInPlay);
                playerInPlay.clear();
                cpuInPlay.clear();
                System.out.println("CPU wins! \n");
            } else if (playerInPlay.get(0).getValue() == cpuInPlay.get(0).getValue()) {
                System.out.println("War!");
                War.war();
            }

            System.out.println("ENTER TO CONTINUE");
            scan.nextLine();
            System.out.print("\n\n\n");
        }

        if (player.size() == 0) {
            System.out.println("CPU wins the game!");
        } else {
            System.out.println("Player wins the game!");
        }
    }

    private static void war() {
        while (true) {
            for (int i = 0; i < 3; i++) {
                try {
                    playerInPlay.add(player.get(0));
                    player.remove(0);
                    cpuInPlay.add(cpu.get(0));
                    cpu.remove(0);
                } catch (IndexOutOfBoundsException ex) {
                    break;
                }
            }

            if (playerInPlay.get(playerInPlay.size()-1).getValue() > cpuInPlay.get(cpuInPlay.size()-1).getValue()) {
                player.addAll(playerInPlay);
                player.addAll(cpuInPlay);
                playerInPlay.clear();
                cpuInPlay.clear();
                System.out.println("Player wins! \n\n\n");
                return;
            } else if (playerInPlay.get(playerInPlay.size()-1).getValue() < cpuInPlay.get(cpuInPlay.size()-1).getValue()) {
                cpu.addAll(playerInPlay);
                cpu.addAll(cpuInPlay);
                playerInPlay.clear();
                cpuInPlay.clear();
                System.out.println("CPU wins! \n\n\n");
                return;
            }
        }
    }
}
