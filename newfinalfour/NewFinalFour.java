import java.util.ArrayList;

public class NewFinalFour {
    public static void main(String[] args) {
        /* PART I: setup the Elite Eight teams */
        ArrayList<Team> eliteEight = new ArrayList<Team>();
        eliteEight.add( new Team("Loyola (Chicago)", true) );
        eliteEight.add( new Team("Kansas State", true) );
        eliteEight.add( new Team("Michigan") );
        eliteEight.add( new Team("Florida State", true) );
        eliteEight.add( new Team("Villanova") );
        eliteEight.add( new Team("Texas Tech") );
        eliteEight.add( new Team("Kansas") );
        eliteEight.add( new Team("Duke") );
        /* PART II: pick random teams for Final Four */
        Team[] finalFour = new Team[4];
        for (int i = 0; i < 4; i++)
            finalFour[i] = eliteEight.remove( (int)(Math.random()*eliteEight.size()) );
        System.out.println("\nThe teams in the Final Four are:");
        System.out.println("--------------------------------");
        for (Team t : finalFour) {
            System.out.print(t + " ");
        }
        /* PART III: set up the game list - each team should play eachother only once*/
        String games = "Here's the schedule of games:\n";
        games += "----------------------------\n";
        for (int team1 = 0; team1 < 4; team1++) {
            for (int team2 = team1+1; team2 < 4; team2++) {
                if (team1 == team2) continue;
                games += finalFour[team1] + " vs " + finalFour[team2] + "\n";
            }
        }
        System.out.println("\n\n\n" + games);
        /* PART IV: are there any underdogs in the Final Four? */
        boolean anyCinderellas = false;
        for (Team t : finalFour) {
            if (t.isUnderdog()) anyCinderellas = true;
        }
        System.out.print("Are there any cinderellas in the Final Four? ");
        if (anyCinderellas)
            System.out.println("YES!");
        else
            System.out.println("NO");
    }
}
