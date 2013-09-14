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

        Node<I> node = getNode(item);
        if (size == indexes.length) {

            resizeIndexes(indexes.length * 2);
        }
        indexes[size] = node;
        if (size != 0) {

            Node<I> prevLast = last;
            last = node;
            prevLast.setNext(last);
            last.setPrev(prevLast);
        } else {

            first = node;
            last = node;
        }

        size++;
    }

    private void resizeIndexes(int newSize) {

        Object[] newArray = new Object[newSize];

        int pos = 0;
        for (Object current : indexes) {

            newArray[pos] = current;
        }

        indexes = newArray;
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
            I item = current.getItem();
            current = current.getNext();
            return item;
        }

        @Override
        public void remove() {

            throw new UnsupportedOperationException(
                    "You can't remove from an iterator.");
        }

    }
}
