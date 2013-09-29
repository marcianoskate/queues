import java.util.Arrays;

public class Board {

    private static final int EMPTY_TILE = 0;
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

    private Board(int[] board, int n) {
        
        this.n = n;
        this.board = Arrays.copyOf(board, board.length);
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
        for (int value : board) {

            if (value != EMPTY_TILE && value != cont) {
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
            if (value != EMPTY_TILE) {

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

    public boolean isGoal() {
        
        int cont = 1;
        for (int value : board) {
            
            if (value != EMPTY_TILE && value != cont) {
                return false;
            }
            cont++;
        }
        return true;
    }

    public Board twin() {
        
        int[] copy = Arrays.copyOf(board, board.length);
        int firstIndex = -1;
        int secondIndex = -1;
        for (int i = 0; i < copy.length; i++) {
            
            if (i % n == 0) {
                firstIndex = -1;
                secondIndex = -1;
            }
            
            if (copy[i] != EMPTY_TILE) {
                
                if (firstIndex == -1) {
                    
                    firstIndex = i;
                } else if (secondIndex == -1) {
                    
                    secondIndex = i;
                }
            }
            
            if (firstIndex != -1 && secondIndex != -1) {
                
                swap(copy, firstIndex, secondIndex);
                break;
            }
        }
        return new Board(copy, n);
    }

    private void swap(int[] copy, int firstIndex, int secondIndex) {
        int aux = copy[firstIndex];
        copy[firstIndex] = copy[secondIndex];
        copy[secondIndex] = aux;
    }
    
    @Override
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        s.append(n + "\n");
        for (int i = 0; i < board.length; i++) {
            s.append(String.format("%2d ", board[i]));
            if ((i + 1) % n == 0) s.append("\n");
        }
        return s.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof Board)) return false;
        
        Board newBoard = (Board) obj;
        if (this.n != newBoard.n) return false;
        
        for (int i = 0; i < n*n; i++) {
            
            if (this.board[i] != newBoard.board[i])
                return false;
        }
        return true;
    }
}
