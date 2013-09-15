public class Subset {

    /**
     * @param args
     */
    public static void main(String[] args) {

        if (args.length != 1) {
            throw new IllegalArgumentException("One argument expected");
        }

        int subset = Integer.valueOf(args[0]);

        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            String read = StdIn.readString();
            //System.out.println("> enquing " + read);
            queue.enqueue(read);
        }
        
        while (subset > 0) {
            
            String removed = queue.dequeue();
            System.out.println(removed);
            subset--;
        }
    }

}
