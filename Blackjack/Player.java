import java.lang.*;

public class Player {

    public static ArrayList<Player> players = new ArrayList<Player>();

    private String name;
    private int number, tokens;

    public Player(String name) {
        this.name = name;
        this.number = players.size() + 1;

        players.add(this);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getTokens() {
        return tokens;
    }

    public void addTokens(int tokens) {
        this.tokens += tokens;
    }

    public void removeTokens(int tokens) {
        this.tokens -= tokens;
    }
}
