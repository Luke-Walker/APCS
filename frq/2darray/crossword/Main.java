public class Main {

    public static void main(String[] args) {
        Crossword cw = new Crossword(new boolean[][]{
            {true, false, false, true, true, true, false, false, false},
            {false, false, false, false, true, false, false, false, false},
            {false, false, false, false, false, false, true, true, true},
            {false, false, true, false, false, false, true, false, false},
            {true, true, true, false, false, false, false, false, false},
            {false, false, false, false, true, false, false, false, false},
            {false, false, false, true, true, true, false, false, true}
        });

        for (int r = 0; r < cw.getPuzzle().length; r++) {
            for (int c = 0; c < cw.getPuzzle()[r].length; c++) {
                Square sq = cw.getPuzzle()[r][c];
                if (sq.isBlack()) System.out.print("B ");
                else if (sq.getNum() != -1) System.out.print(sq.getNum() + " ");
                else System.out.print("W ");
            }
            System.out.println();
        }
    }
}
