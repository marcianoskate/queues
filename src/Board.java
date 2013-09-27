
public class Board {
    
    private final int   n;
    private final int[] board;
    private final int[] solved;
    
    private int hamming = 0;

    public Board(int[][] values) {
        
        this.n = values.length;
        this.board = new int[n*n];
        this.solved = new int[n*n];
        
        int x = 0;
        int count = 1;
        for (int[] row : values) {
            
            int y = 0;
            for (int col : row) {
                
                int pos = y + x * n;
                board[pos] = col;
                solved[pos] = count % (solved.length + 1); //last value must be 0
                count++;
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

    public int manhattan() {
        return 0;
    }
}
