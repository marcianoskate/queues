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
public class Deque<I> implements Iterable<I> {

    private boolean debuggin = true;

    /** index of the first item. */
    private int first;
    /** index of the last item. */
    private int last;
    /** counter of items in the Deque. */
    private int count;
    /** item array. */
    private Object[] items;

    /**
     * Constructs an empty deque with 10 reserved positions.
     */
    public Deque() {

        items = new Object[10];
        first = -1;
        last = -1;
        count = 0;
    }

    /**
     * Returns wheter the Deque is empty or not
     * 
     * @return True if it is empty, false otherwise
     */
    public boolean isEmpty() {

        return false;
    }

    /**
     * Returns the size of the Deque
     * 
     * @return Item count holded by the Deque
     */
    public int size() {

        return -1;
    }

    /**
     * Adds an item I to the front of the Deque
     * 
     * @param item
     *            The item to add to the Deque
     */
    public void addFirst(I item) {

        validateParamNotNull(item);
    }

    /**
     * Adds and item I to the end of the Deque
     * 
     * @param item
     *            The item to add to the Deque
     */
    public void addLast(I item) {

        validateParamNotNull(item);
    }

    /**
     * Deletes and returns the item at the front
     * 
     * @return The item at the front
     */
    public I removeFirst() {

        validateDequeIsNotEmpty();
        return null;
    }

    /**
     * Deletes and returns the item at the end
     * 
     * @return The item at the end
     */
    public I removeLast() {

        validateDequeIsNotEmpty();
        return null;
    }

    /**
     * Returns an iterator over items of a Deque in order from front to end.
     */
    public Iterator<I> iterator() {

        return new Iterator<I>() {

            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public I next() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void remove() {

                throw new UnsupportedOperationException(
                        "You can't remove from an iterator.");
            }

        };
    }

    private void validateParamNotNull(I item) {

        if (item == null) {
            throw new NullPointerException("Item can't be null.");
        }
    }

    private void validateDequeIsNotEmpty() {

        if (count == 0) {
            throw new NoSuchElementException("The Deque can't be empty");
        }
    }
}
