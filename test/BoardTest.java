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
}
