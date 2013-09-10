import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * TestUnit that tests the Deque implementation
 * 
 * @author marcianoskate
 * 
 */
public class DequeTest {

    private Deque deque;

    @Before
    public void setUp() {

        deque = new Deque();
    }

    @Test(expected = NullPointerException.class)
    public void throwsNullIfNullIsAddedToTheFront() {

        deque.addFirst(null);
    }

    @Test(expected = NullPointerException.class)
    public void throwsNullIfNullIsAddedToTheEnd() {

        deque.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void throwsNoSuchIfRemoveFOnEmptyDeck() {

        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void throwsNoSuchIfRemoveLastOnEmptyDeck() {

        deque.removeLast();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void throwsUnsupportedExceptionWhenRemovingFromIterator() {

        deque.iterator().remove();
    }
}
