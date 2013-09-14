import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
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
    
    @Test
    public void canIterateOverTheQueue() {
        
        RandomizedQueue<String> queue;
        queue = getNewQueue();
        
        String item = "hello";
        queue.enqueue(item);
        
        Iterator<String> iterator = queue.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(item, iterator.next());
    }
    
    @Test
    public void enqueueMultipleValues() {
        
        String[] values = {"one", "two", "three", "four", "five"};
        
        RandomizedQueue<String> queue;
        queue = getNewQueue();

        for (String item : values) {
            
            queue.enqueue(item);
        }
        
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(5, queue.size());
    }
    
    @Test
    public void addingMoreThanTenValues() {
        
        String[] values = {"one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen"};
        
        RandomizedQueue<String> queue;
        queue = getNewQueue();

        for (String item : values) {
            
            queue.enqueue(item);
        }
        
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(15, queue.size());
        
        System.out.println(">>> Iterating over 15 items");
        int count = 0;
        for (String item : queue) {
            
            Assert.assertEquals(values[count++], item);
            System.out.println(item);
        }
    }
    
    @Test
    public void iteratingOverMultipleValues() {
        
        String[] values = {"one", "two", "three", "four", "five"};
        
        RandomizedQueue<String> queue;
        queue = getNewQueue();

        for (String item : values) {
            
            queue.enqueue(item);
        }
        
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(5, queue.size());
        
        System.out.println(">>> Iterating over five items");
        int count = 0;
        for (String item : queue) {
            
            Assert.assertEquals(values[count++], item);
            System.out.println(item);
        }
    }
    
    @Test
    public void removesAnRandomItem() {
        
        String[] values = {"one", "two", "three", "four", "five"};
        List<String> list = Arrays.asList(values);
        
        RandomizedQueue<String> queue;
        queue = getNewQueue();
        
        for (String item : values) {
            
            queue.enqueue(item);
        }
        
        System.out.println(">>> Enqueing");
        while (!queue.isEmpty()) {
            
            String removed = queue.dequeue();
            System.out.println(removed);
            Assert.assertTrue(list.contains(removed));
        }
        System.out.println("=================");
        
        
    }
    
}
