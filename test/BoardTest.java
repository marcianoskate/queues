import static org.junit.Assert.*;

import org.junit.Test;


public class BoardTest {

    @Test
    public void constructs0x0Board() {
        
        int[][] values = new int[0][0];
        Board board = new Board(values);
        
        assertEquals(0, board.dimension());
    }
    
    @Test
    public void constructs8x8Board() {
        
        int[][] values = new int[8][8];
        Board board = new Board(values);
        
        assertEquals(8, board.dimension());
    }
    
    private Board getExampleBoard() {
        
        int[][] values = 
            {{0, 1, 3},
             {4, 2, 5},
             {7, 8, 6}};
        return new Board(values);
    }
    
    private Board getCrazyBoard() {
        
        int[][] values = 
            {{5, 7, 8},
                {6, 3, 4},
                {2, 0, 1}};
        return new Board(values);
    }

    private Board getSolvedBoard() {
        
        int[][] values = 
            {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}};
        return new Board(values);
    }

    private Board getEmptlyTopLeftBoard() {
        int[][] values = 
            {{0, 1, 3},
             {4, 2, 5},
             {7, 8, 6}};
        return new Board(values);
    }

    @Test
    public void hammingInSolvedMustBeZero() {
        
        Board board = getSolvedBoard();
        assertEquals(0, board.hamming());
    }
    
    @Test
    public void hammingInExampleMustBeFour() {
        
        Board board = getExampleBoard();
        assertEquals(4, board.hamming());
    }
    
    @Test
    public void manhattanInSolvedMustBeZero() {
        
        Board board = getSolvedBoard();
        assertEquals(0, board.manhattan());
    }
    
    @Test
    public void manhattanInExampleMustBeFour() {
        
        Board board = getExampleBoard();
        assertEquals(4, board.manhattan());
    }
    
    @Test
    public void manhattanInCrazyBoard() {
        
        
        Board board = getCrazyBoard();
        assertEquals(21, board.manhattan());
    }
    
    @Test
    public void exampleBoardIsGoal() {
        
        Board board = getExampleBoard();
        assertFalse(board.isGoal());
    }
    
    @Test
    public void solvedBoardIsGoal() {
        
        Board board = getSolvedBoard();
        assertTrue(board.isGoal());
    }
    
    @Test
    public void twin() {
        
        System.out.println("==== EXAMPLE TWIN ====");
        Board board = getExampleBoard();
        System.out.println(board.toString());
        
        Board twin = board.twin();
        System.out.println(twin.toString());
    }
    
    
    @Test
    public void twinSecond() {
        
        System.out.println("==== CRAZY TWIN ====");
        Board board = getCrazyBoard();
        System.out.println(board.toString());
        
        Board twin = board.twin();
        System.out.println(twin.toString());
    }
    
    @Test
    public void equalsNull() {
        
        Board board = getExampleBoard();
        assertFalse(board.equals(null));
    }
    
    @Test
    public void equalsReflexive() {
        
        Board board = getExampleBoard();
        assertTrue(board.equals(board));
    }
    
    @Test
    public void equalsSymmetric() {
        
        Board board1 = getExampleBoard();
        Board board2 = getExampleBoard();
        assertTrue(board1.equals(board2));
        assertTrue(board2.equals(board1));
    }
    
    @Test
    public void equalsTransitiveTrue() {
        
        Board board1 = getExampleBoard();
        Board board2 = getExampleBoard();
        Board board3 = getExampleBoard();
        assertTrue(board1.equals(board2));
        assertTrue(board2.equals(board3));
        assertTrue(board1.equals(board3));
    }
    
    @Test
    public void equalsTransitiveFalse() {
        
        Board board1 = getExampleBoard();
        Board board2 = getExampleBoard();
        Board board3 = getSolvedBoard();
        assertTrue(board1.equals(board2));
        assertFalse(board2.equals(board3));
        assertFalse(board1.equals(board3));
    }
    
    @Test
    public void equalsExampleAndCrazyBoards() {
        
        Board board1 = getExampleBoard();
        Board board2 = getCrazyBoard();
        assertFalse(board1.equals(board2));
    }
    
    @Test
    public void neighborsLeftTop() {
        
        Board board = getEmptlyTopLeftBoard();
        assertNotNull(board.neighbors());
        // When the empty tile is in the top left corner, there is only 2 
        // valid moves. Therefore, the neighbors must be 2
        int cont = 0;
        for (Board actual : board.neighbors()) {
            cont++;
        }
        assertEquals(2, cont);
    }
}
