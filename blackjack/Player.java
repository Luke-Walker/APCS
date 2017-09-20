package blackjack;

import java.lang.*;

public class Player {

    public static ArrayList<Player> players = new ArrayList<Player>();

    private String name;
    private int number, points, tokens, bet;
    private boolean stand;

    public Player(String name) {
        this.name = name;
        this.number = players.size() + 1;
        this.points = 0;
        this.tokens = 0;
        this.bet = 0;
        this.stand = false;

        players.add(this);
    }

    public int getBet() {
        return bet;
    }

    public void bet(int bet) {
        this.bet = bet;
    }

    public void resetBet() {
        this.bet = 0;
    }

    public void win() {
        addTokens(bet);
    }

    public void lose() {
        removeTokens(bet);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void resetPoints() {
        this.points = 0;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public void addTokens(int tokens) {
        this.tokens += tokens;
    }

    public void removeTokens(int tokens) {
        this.tokens -= tokens;
    }

    public boolean isStanding() {
        return stand;
    }

    public void setStanding(boolean stand) {
        this.stand = stand;
    }
}
