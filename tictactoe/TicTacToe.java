import java.util.*;

public class TicTacToe {

  public static void main(String[] args) {

    int[][] grid = new int[3][3];
    Scanner kb = new Scanner(System.in);

    int player = 1;
    int round = 1;
    int winner = 0;

    while (winner == 0 && round <= 9) {
      String playerSymbol = "X";
      if (player == -1) playerSymbol = "O";

      showBoard(grid);

      System.out.println(playerSymbol + "'s turn\n'");
      System.out.print("What row (1-3): ");
      int row = Integer.parseInt(kb.nextLine()) - 1;
      System.out.print("What column (1-3): ");
      int col = Integer.parseInt(kb.nextLine()) - 1;

      grid[row][col] = player;

      winner = checkWinner(grid);

      if (winner != 0) {
        System.out.println(playerSymbol + " wins!!!");
        break;
      }

      player *= -1;     // change players at the end of the turn.
    }

  }

    public static void showBoard(int[][] grid) {
        for (int y = 0; y < 3; y++) {
            String msg = "";
            for (int x = 0; x < 3; x++) {
                int player = grid[y][x];
                msg += "[" + (player == 1 ? "X" : player == -1 ? "O" : " ") + "]";
            }
            System.out.println(msg);
        }
    }

  /* Complete this method

   It should search the grid for a winner in the vertical, horizontal,
   and diagonal directions.

   if player 1 wins, it should return 1
   if player -1 wins, it should return -1
   if there isn't a winner, it should return 0
      */
      public static int checkWinner(int[][] grid) {
          for (int x = 0; x < 3; x++) {
              int sum = 0;
              for (int y = 0; y < 3; y++) {
                  sum += grid[x][y];
              }

              if (sum == -3 || sum == 3) {
                  return sum/3;
              }
          }

          for (int y = 0; y < 3; y++) {
              int sum = 0;
              for (int x = 0; x < 3; x++) {
                  sum += grid[x][y];
              }

              if (sum == -3 || sum == 3) {
                  return sum/3;
              }
          }

          int sum = 0;
          for (int i = 0; i < 3; i++) {
              sum += grid[i][i];
          }
          if (sum == -3 || sum == 3) {
              return sum/3;
          } else {
              sum = 0;
          }

          for (int i = 2; i >= 0; i--) {
              sum += grid[i][i];
          }
          if (sum == -3 || sum == 3) {
              return sum/3;
          }

          return 0;
      }
}
