import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Deques represents a generalization of a stack and a queue that supports
 * inserting and removing items from either the front or the back of the data
 * structure.
 * 
 * @author marcianoskate
 * 
 * @param <I>
 *            The items to hold in the Deque
 */
public final class Deque<I> implements Iterable<I> {

    private boolean debuggin = true;

    /** index of the first item. */
    private Node<I> first = null;
    /** index of the last item. */
    private Node<I> last = null;
    /** counter of items in the Deque. */
    private int size = 0;
    

    /**
     * Constructs an empty deque with 10 reserved positions.
     */
    public Deque() {

    }

    /**
     * Returns wheter the Deque is empty or not
     * 
     * @return True if it is empty, false otherwise
     */
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * Returns the size of the Deque
     * 
     * @return Item count holded by the Deque
     */
    public int size() {

        return size;
    }

    private void addFirstNode(Node<I> node) {
    
        first = node;
        last = node;
    }

    /**
     * Adds an item I to the front of the Deque
     * 
     * @param item
     *            The item to add to the Deque
     */
    public void addFirst(I item) {

        if (item == null) {
            throw new NullPointerException("Item can't be null.");
        }
        assert item != null;
        
        Node<I> node = getNode(item);
        
        if (size == 0) {
            addFirstNode(node);
        } else {
            
            Node<I> prevFirst = first;
            node.setNext(prevFirst);
            prevFirst.setPrev(node);
            first = node;
        }
        
        size++;
    }

    /**
     * Adds and item I to the end of the Deque
     * 
     * @param item
     *            The item to add to the Deque
     */
    public void addLast(I item) {

        if (item == null) {
            throw new NullPointerException("Item can't be null.");
        }
        assert item != null;
        
        Node<I> node = getNode(item);
        
        if (size == 0) {
            addFirstNode(node);
        } else {

            Node<I> prevLast = last;
            prevLast.setNext(node);
            node.setPrev(prevLast);
            last = node;
        }
        size++;
    }

    /**
     * Deletes and returns the item at the front
     * 
     * @return The item at the front
     */
    public I removeFirst() {

        validateDequeIsNotEmpty();
        
        I item = first.getItem();
        first = first.getNext();
        size--;
        return item;
    }

    /**
     * Deletes and returns the item at the end
     * 
     * @return The item at the end
     */
    public I removeLast() {

        validateDequeIsNotEmpty();
        
        I item = last.getItem();
        last = last.getPrev();
        size--;
        return item;
    }

    /**
     * Returns an iterator over items of a Deque in order from front to end.
     */
    public Iterator<I> iterator() {

        return new DequeIterator();
    }

    private void validateDequeIsNotEmpty() {

        if (size == 0) {
            throw new NoSuchElementException("The Deque can't be empty");
        }
    }

    final class DequeIterator implements Iterator<I> {
        
        private Node<I> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public I next() {

            if (!hasNext()) {
                throw new NoSuchElementException(
                        "There is no more elements to retrieve");
            }
            I item  = current.getItem();
            current = current.getNext();
            return item;
        }

        @Override
        public void remove() {

            throw new UnsupportedOperationException(
                    "You can't remove from an iterator.");
        }
        
    }
    
    private <I> Node<I> getNode(I item) {
        
        return new Node<I>(item);
    }
    
    private final class Node<I> {
        
        private final I item;
        private Node<I> next;
        private Node<I> prev;
        
        public Node(I item) {
            this.item = item;
        }
        
        public I getItem() {
            return item;
        }
        
        public void setNext(Node<I> newNext) {
            
            this.next = newNext;
        }
        
        public Node<I> getNext() {
            
            return this.next;
        }
        
        public void setPrev(Node<I> newPrev) {
            
            this.prev = newPrev;
        }

        public Node<I> getPrev() {
            return prev;
        }
    }
}

