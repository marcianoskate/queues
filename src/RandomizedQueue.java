import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<I> implements Iterable<I> {

    private int size = 0;
    private Node<I> first;
    private Node<I> last;

    private Object[] indexes;

    public RandomizedQueue() {

        indexes = new Object[2];
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public int size() {

        return size;
    }

    public void enqueue(I item) {

        if (item == null) {
            throw new NullPointerException("Can't add a null item.");
        }
        assert item != null;
    }

    public I dequeue() {

        if (size == 0) {
            throw new NoSuchElementException("The Queue is empty");
        }

        return null;
    }

    public I sample() {

        if (size == 0) {
            throw new NoSuchElementException("The Queue is empty");
        }
        return null;
    }

    public Iterator<I> iterator() {

        return new RandomizedQueueIterator();
    }

    final class RandomizedQueueIterator implements Iterator<I> {

        @Override
        public boolean hasNext() {
//            return current != null;
            return false;
        }

        @Override
        public I next() {

            if (!hasNext()) {
                throw new NoSuchElementException(
                        "There is no more elements to retrieve");
            }
//            I item = current.getItem();
//            current = current.getNext();
//            return item;
            return null;
        }

        @Override
        public void remove() {

            throw new UnsupportedOperationException(
                    "You can't remove from an iterator.");
        }

    }
}
