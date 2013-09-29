import java.util.Arrays;

public class Board {

    private static final int EMPTY_TILE = 0;
    private final int n;
    private final int[] board;
    private int emptyTileIndex = -1;

    private int hamming = 0;

    /**
     * Constructs a nuew inmutable board of NxN tiles.
     * 
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
                if (col == 0) {
                    emptyTileIndex = pos;
                }
                y++;
            }

            x++;
        }
    }

    private Board(int[] board) {

        this.n = (int) Math.sqrt(board.length);
        this.board = Arrays.copyOf(board, board.length);
    }

    private Board swapedTilesBoard(int pos1, int pos2) {
        
        int[] newBoard = cloneBoard();
        swap(newBoard, pos1, pos2);
        return new Board(newBoard);
    }

    /**
     * Returns the size of the board.
     * 
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
     * 
     * @return sum of the blocks out of place
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
     * 
     * @return sum of Manhattan distances between blocks and goal
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

//        int[] copy = cloneBoard();
        int firstIndex = -1;
        int secondIndex = -1;
        for (int i = 0; i < board.length; i++) {

            if (i % n == 0) {
                firstIndex = -1;
                secondIndex = -1;
            }

            if (board[i] != EMPTY_TILE) {

                if (firstIndex == -1) {

                    firstIndex = i;
                } else if (secondIndex == -1) {

                    secondIndex = i;
                }
            }

            if (firstIndex != -1 && secondIndex != -1) {

                break;
            }
        }
        
        return swapedTilesBoard(firstIndex, secondIndex);
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
            if ((i + 1) % n == 0)
                s.append("\n");
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Board))
            return false;

        Board newBoard = (Board) obj;
        if (this.n != newBoard.n)
            return false;

        for (int i = 0; i < n * n; i++) {

            if (this.board[i] != newBoard.board[i])
                return false;
        }
        return true;
    }

    public Iterable<Board> neighbors() {

        Queue<Board> queue = new Queue<>();
        
        Board leftNeighbor = boardLeft();
        if (leftNeighbor != null) {
            
            queue.enqueue(leftNeighbor);
        }
        
        Board rightNeighbor = boardRight();
        if (rightNeighbor != null) {
            
            queue.enqueue(rightNeighbor);
        }
        
        Board topNeighbor = boardTop();
        if (topNeighbor != null) {
            
            queue.enqueue(topNeighbor);
        }
        
        Board botNeighbor = boardBot();
        if (botNeighbor != null) {
            
            queue.enqueue(botNeighbor);
        }
        
        return queue;
    }

    private Board boardBot() {
        int botPos = emptyTileIndex + n;
        if (!isPositionInsideBoard(botPos)) {
            return null;
        }
        return swapedTilesBoard(emptyTileIndex, botPos);
    }

    private Board boardTop() {
        int topPos = emptyTileIndex - n;
        if (!isPositionInsideBoard(topPos)) {
            return null;
        }
        return swapedTilesBoard(emptyTileIndex, topPos);
    }

    private Board boardRight() {

        int rightPos = emptyTileIndex + 1;
        return moveInRow(rightPos);
    }

    private Board boardLeft() {

        int leftPos = emptyTileIndex - 1;
        return moveInRow(leftPos);
    }

    /**
     * Creates a new board with the tile in pos swaped with the empty tile
     * in the same row.
     * @param pos position of the tile to swap with empty tile
     * @return new board with the empty tile in the new position 
     * as long as both tiles are in the same row.
     */
    private Board moveInRow(int pos) {
        if (!isPositionInsideBoard(pos)) {
            return null;
        }
        if (!isInSameRow(emptyTileIndex, pos)) {
            
            return null;
        }
        return swapedTilesBoard(emptyTileIndex, pos);
    }

    private int[] cloneBoard() {
        return Arrays.copyOf(board, board.length);
    }

    /**
     * Returns wheter pos is inside the board or not.
     * @param pos Position to check
     * @return true in case it is inside, false otherwise
     */
    private boolean isPositionInsideBoard(int pos) {
        return pos >= 0 && pos < board.length;
    }

    /**
     * Returns wheter pos1 and pos2 are in the same row.
     * For the following board the positions 1 and 2 would be in the same
     * row, but the position 2 and 3 wouldn't
     * <pre>
     *  | 1 3 - |
     *  | 4 2 5 |
     *  | 7 8 6 |
     * </pre>
     * @param pos1
     * @param pos2
     * @return
     */
    private boolean isInSameRow(int pos1, int pos2) {
        
        int pos1Row = pos1 / n;
        int pos2Row = pos2 / n;
        return pos1Row == pos2Row;
    }
}
