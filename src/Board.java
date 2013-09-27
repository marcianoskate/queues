public class Board {

    private final int n;
    private final int[] board;

    private int hamming = 0;

    /**
     * Constructs a nuew inmutable board of NxN tiles.
     * @param values
     */
    public Board(int[][] values) {

        this.n = values.length;
        this.board = new int[n * n];

        int x = 0;
        for (int[] row : values) {

            int y = 0;
            for (int col : row) {

                int pos = y + x * n;
                board[pos] = col;
                y++;
            }

            x++;
        }
    }

    /**
     * Returns the size of the board.
     * @return
     */
    public Object dimension() {
        return n;
    }

    public static void main(String[] args) {

        int[][] bla = new int[4][6];
        System.out.println(bla.length);
    }

    /**
     * Calculates the number of blocks out of place
     * @return
     *  sum of the blocks out of place
     */
    public int hamming() {

        int cont = 1;
        for (int number : board) {

            if (number != 0 && number != cont) {
                hamming++;
            }
            cont++;
        }
        return hamming;
    }

    /**
     * Calculates the sum of Manhattan distances between blocks and goal.
     * @return
     *  sum of Manhattan distances between blocks and goal
     */
    public int manhattan() {

        int manhattan = 0;
        int currPos = 0;

        while (currPos < board.length) {

            int value = board[currPos];
            if (value != 0) {

                int expectedX = (value - 1) / n;
                int expectedY = (value - 1) % n;
                int currentX = currPos / n;
                int currentY = currPos % n;

                int distanceX = Math.abs(expectedX - currentX);
                int distanceY = Math.abs(expectedY - currentY);

                manhattan += distanceX + distanceY;
            }
            currPos++;
        }
        return manhattan;
    }
}
