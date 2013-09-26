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
    public void hamming() {
        
        Board board = getExampleBoard();
        assertEquals(4, board.hamming());
    }
    
}
