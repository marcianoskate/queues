import java.util.NoSuchElementException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * TestUnit that tests the Deque implementation
 * 
 * @author marcianoskate
 * 
 */
public class RandomizedQueueTest {

    @Before
    public void setUp() {

    }

    private <T> RandomizedQueue<T> getNewQueue() {

        return new RandomizedQueue<T>();
    }

    @Test(expected = NullPointerException.class)
    public void throwsNullIfNullIsAddedToTheFront() {

        RandomizedQueue<String> queue;
        queue = getNewQueue();
        queue.enqueue(null);
    }
    
    @Test(expected = NoSuchElementException.class)
    public void throwsNoSuchElementWhenSamplingEmptyQueue() {
        
        RandomizedQueue<String> queue;
        queue = getNewQueue();
        queue.sample();
    }
    
    @Test(expected = NoSuchElementException.class)
    public void throwsNoSuchElementWhenDequeingEmptyQueue() {
        
        RandomizedQueue<String> queue;
        queue = getNewQueue();
        queue.dequeue();
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void throwsUnsupportedOperationWhenRemovingFromTheIterator() {
        
        RandomizedQueue<String> queue;
        queue = getNewQueue();
        queue.iterator().remove();
    }
    
    @Test(expected = NoSuchElementException.class)
    public void throwsNoSuchElementWhenExecutingNextOnAnEmptyQueue() {
        
        RandomizedQueue<String> queue;
        queue = getNewQueue();
        queue.iterator().next();
    }
    
    @Test
    public void newQueueIsEmpty() {
        
        RandomizedQueue<String> queue;
        queue = getNewQueue();
        
        Assert.assertTrue(queue.isEmpty());
        Assert.assertEquals(0, queue.size());
    }
    
    @Test
    public void whenAddingAnItemItIncrements() {
        
        RandomizedQueue<String> queue;
        queue = getNewQueue();
        
        queue.enqueue("hello");
        
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(1, queue.size());
    }
}
