
public class Board {
    
    private final int   n;
    private final int[] board;
    
    private int hamming = 0;

    public Board(int[][] values) {
        
        this.n = values.length;
        this.board = new int[n*n];
        
        int x = 0;
        for (int[] row : values) {
            
            int y = 0;
            for (int col : row) {
                
                board[y + x * n] = col;
                y++;
            }
            
            x++;
        }
    }

    public Object dimension() {
        return n;
    }


    public static void main(String[] args) {
        
        int[][] bla = new int[4][6];
        System.out.println(bla.length);
    }

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
}
