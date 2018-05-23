public class Crossword {

    private Square[][] puzzle;

    public Crossword(boolean[][] blackSquares) {
        Square[][] puzzle = new Square[blackSquares.length][blackSquares[0].length];

        int num = 1;
        for (int r = 0; r < puzzle.length; r++) {
            for (int c = 0; c < puzzle[r].length; c++) {
                if (toBeLabeled(r, c, blackSquares)) {
                    puzzle[r][c] = new Square(blackSquares[r][c], num);
                    num++;
                } else {
                    puzzle[r][c] = new Square(blackSquares[r][c], -1);
                }
            }
        }

        this.puzzle = puzzle;
    }

    public Square[][] getPuzzle() {
        return puzzle;
    }

    private boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
        // checks if black square
        if (blackSquares[r][c]) return false;

        // checks if in first column
        if (c == 0) return true;

        // checks if in first row
        if (r == 0) return true;

        // checks if black square to the left
        if (blackSquares[r][c-1]) return true;

        // checks if black square above it
        if (blackSquares[r-1][c]) return true;

        return false;
    }
}
