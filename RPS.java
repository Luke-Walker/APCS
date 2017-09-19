import java.util.*;

public class RPS {

    private static int rounds = -1;
    private static int wins, losses = 0;

    public static void main(String[] args) {
        if (args.length > 0) rounds = Integer.parseInt(args[0]);

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        for (int round = rounds; round != 0; round--) {
            System.out.println("R, P, S | E to exit");
            int player = -1;
            int comp = rand.nextInt(3);
            switch (scan.nextLine().toLowerCase()) {
                case "r":
                    player = 1;
                    break;
                case "p":
                    player = 2;
                    break;
                case "s":
                    player = 3;
                    break;
                case "e":
                    System.exit(0);
                default:
                    System.exit(0);
            }

            int result = checkRound(player, comp);
            if (result == 0) {
                System.out.println("Tie!");
            } else if (result == 1) {
                System.out.println("You win!");
                wins++;
            } else if (result == 2) {
                System.out.println("You lost!");
                losses++;
            }

            System.out.println("The current score is " + wins + "-" + losses);
            if (rounds != -1) System.out.println("There are " + (round-1) + " rounds left.");
        }

        System.out.println("The final score was " + wins + "-" + losses);
    }

    // returns: tie - 0 | player - 1 | computer - 2
    private static int checkRound(int player, int comp) {
        if (comp == player) {
            return 0;
        }
        if (comp == 1) {
            if (player == 2) {
                return 1;
            } else if (player == 3) {
                return 2;
            }
        } else if (comp == 2) {
            if (player == 1) {
                return 2;
            } else if (player == 3) {
                return 1;
            }
        } else if (comp == 3) {
            if (player == 1) {
                return 1;
            } else if (player == 2) {
                return 2;
            }
        }

        return 0;
    }
}
