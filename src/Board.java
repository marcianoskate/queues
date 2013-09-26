
public class Board {
    
    private final int   n;
    private final int[] board;

    public Board(int[][] values) {
        
        this.n = values.length;
        this.board = new int[n*n];
    }

    public Object dimension() {
        return n;
    }


    public static void main(String[] args) {
        
        int[][] bla = new int[4][6];
        System.out.println(bla.length);
    }

    public int haming() {
        
        
        return 0;
    }
}
