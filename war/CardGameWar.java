import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.util.*;
import java.io.*;
//import java.io.IOException;

public class CardGameWar {

  private static ArrayList<Card> player1Cards = new ArrayList<Card>();
  private static ArrayList<Card> player2Cards = new ArrayList<Card>();
  private static GameBoardPanel gamePanel = new GameBoardPanel();
  private static int cardsInPlay = -1;

  public static void main(String[] args) {

      JFrame window = new JFrame("War!");

      window.add(gamePanel);
      window.setSize(400, 400);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setVisible(true);
      window.setLocationRelativeTo(null);

      Deck deck = new Deck();
      deck.shuffle();

      for (int i = 0; i < 26; i++) {
        player1Cards.add(deck.deal());
        player2Cards.add(deck.deal());
      }

      gamePanel.setPoints(player1Cards.size(), player2Cards.size());
      gamePanel.repaint();

      /*
      while (!isEmptyHand(player1Cards, player2Cards)) {
        Card c1 = player1Cards.remove(0);
        Card c2 = player2Cards.remove(0);

        System.out.println("\nPlayer1: " + c1);
        System.out.println("Player2: " + c2);




        ArrayList<Card> warCards1 = new ArrayList<Card>();
        ArrayList<Card> warCards2 = new ArrayList<Card>();
        warCards1.add(c1);
        warCards2.add(c2);

        int winner = checkWinner(c1, c2);

        while (winner == 0 && !isEmptyHand(player1Cards, player2Cards)) {
          System.out.println("Cards have same value ... War!");

          for (int i = 0; i < 3 && !isEmptyHand(player1Cards, player2Cards); i++) {
            warCards1.add(player1Cards.remove(0));
            warCards2.add(player2Cards.remove(0));
          }
          c1 = warCards1.get(warCards1.size()-1);
          c2 = warCards2.get(warCards2.size()-1);
          winner = checkWinner(c1, c2);
        }

        if (winner == 1) {
          System.out.println("Player 1 wins turn");
          addCards(player1Cards, warCards1, warCards2);
        }
        if (winner == 2) {
          System.out.println("Player 2 wins turn");
          addCards(player2Cards, warCards2, warCards1);
        }

        System.out.println("\np1: " + player1Cards.size());
        for (Card c : player1Cards)
          System.out.print(c + "  ");
        System.out.println("\n\np2: " + player2Cards.size());
        for (Card c : player2Cards)
          System.out.print(c + "  ");

        Scanner kb = new Scanner(System.in);
        System.out.print("\n\nKeep playing (y/n) ");
        String input = kb.nextLine();

        if (input.substring(0,1).equals("n")) break;

      }
      */

  }

  protected static void playCard() {
    if (isEmptyHand(player1Cards, player2Cards)) return;

    cardsInPlay *= -1;

    if (cardsInPlay == -1) {
      gamePanel.setPoints(player1Cards.size(), player2Cards.size());
      gamePanel.setWinner(0);
      gamePanel.setCards(null, null);
      gamePanel.repaint();
      return;
    }

    Card c1 = player1Cards.remove(0);
    Card c2 = player2Cards.remove(0);

    System.out.println("\nPlayer1: " + c1);
    System.out.println("Player2: " + c2);

    ArrayList<Card> warCards1 = new ArrayList<Card>();
    ArrayList<Card> warCards2 = new ArrayList<Card>();
    warCards1.add(c1);
    warCards2.add(c2);

    int winner = checkWinner(c1, c2);

    gamePanel.setCards(c1, c2);
    gamePanel.setPoints(player1Cards.size(), player2Cards.size());
    gamePanel.repaint();

    while (winner == 0 && !isEmptyHand(player1Cards, player2Cards)) {
      System.out.println("Cards have same value ... War!");

      for (int i = 0; i < 3 && !isEmptyHand(player1Cards, player2Cards); i++) {
        warCards1.add(player1Cards.remove(0));
        warCards2.add(player2Cards.remove(0));
      }
      c1 = warCards1.get(warCards1.size()-1);
      c2 = warCards2.get(warCards2.size()-1);
      winner = checkWinner(c1, c2);
    }

    gamePanel.setWinner(winner);
    gamePanel.repaint();

    if (winner == 1) {
      System.out.println("Player 1 wins turn");
      addCards(player1Cards, warCards1, warCards2);
    }
    if (winner == 2) {
      System.out.println("Player 2 wins turn");
      addCards(player2Cards, warCards2, warCards1);
    }

    System.out.println("\np1: " + player1Cards.size());
    for (Card c : player1Cards)
      System.out.print(c + "  ");
    System.out.println("\n\np2: " + player2Cards.size());
    for (Card c : player2Cards)
      System.out.print(c + "  ");





  }

  private static int checkWinner(Card one, Card two) {
    if (one.getValue() > two.getValue()) {
      return 1;
    }
    else if (one.getValue() < two.getValue()) {
      return 2;
    }
    else {
      return 0;
    }
  }

  private static void addCards(ArrayList<Card> hand, ArrayList<Card> winnings1, ArrayList<Card> winnings2) {
    for (int i = 0; i < winnings1.size(); i++) {
      hand.add(winnings1.get(i));
      hand.add(winnings2.get(i));
    }
  }

  private static boolean isEmptyHand(ArrayList<Card> one, ArrayList<Card> two) {
    return one.size() == 0 || two.size() == 0;
  }

}

class GameBoardPanel extends JPanel implements MouseListener {

  private Card p1Card;
  private Card p2Card;
  private int p1Points;
  private int p2Points;
  private BufferedImage p1Img;
  private BufferedImage p2Img;
  private BufferedImage cardBackImg;
  private int winner;

  public GameBoardPanel() {
    addMouseListener(this);
    try {
         cardBackImg = ImageIO.read(new File("./cards/back1.gif"));
    } catch (IOException ex) {}
  }

  public void paint(Graphics g) {
    g.setColor(new Color(5,120,40));
    g.fillRect(0,0,400,400);

    g.setColor(Color.WHITE);
    g.setFont(g.getFont().deriveFont(14.0f));
    String p1Msg = "Player One";
    if (winner == 1) p1Msg += " Wins Round";
    g.drawString(p1Msg, 50, 25);
    g.drawImage(cardBackImg, 50, 40, null);
    String p2Msg = "Player Two";
    if (winner == 2) p2Msg += " Wins Round";
    g.drawString(p2Msg, 50, 200);
    g.drawImage(cardBackImg, 50, 215, null);
    g.setFont(g.getFont().deriveFont(30.0f));
    g.drawString(""+p1Points, 65, 75);
    g.drawString(""+p2Points, 65, 250);

    if (p1Card != null)
      g.drawImage(p1Img, 140, 40, null);
    if (p2Card != null)
      g.drawImage(p2Img, 140, 215, null);

  }

  public void setCards(Card p1, Card p2) {
    p1Card = p1;
    p2Card = p2;
    if (p1 != null && p2 != null) {
      try {
        String value = ""+p1.getValue();
        if (value.equals("1") || value.equals("14")) value = "ace";
        value = value.replace("11", "jack");
        value = value.replace("12", "queen");
        value = value.replace("13", "king");
        String filename = value + p1.getSuit().toLowerCase() + ".gif";
        p1Img = ImageIO.read(new File("./cards/"+filename));

        value = ""+p2.getValue();
        if (value.equals("1") || value.equals("14")) value = "ace";
        value = value.replace("11", "jack");
        value = value.replace("12", "queen");
        value = value.replace("13", "king");
        filename = value + p2.getSuit().toLowerCase() + ".gif";
        p2Img = ImageIO.read(new File("./cards/"+filename));
      } catch (IOException ex) {}
    }
    else {
      p1Img = null;
      p2Img = null;
    }
  }

  public void setPoints(int p1, int p2) {
    p1Points = p1;
    p2Points = p2;
  }

  public void setWinner(int player) {
    winner = player;
  }

  public void mouseClicked(MouseEvent e) {
     //System.out.println(e.getX());
     CardGameWar.playCard();
  }

  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
}
