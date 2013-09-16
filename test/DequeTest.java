import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * TestUnit that tests the Deque implementation
 * 
 * @author marcianoskate
 * 
 */
public class DequeTest {

    @Before
    public void setUp() {

    }

    private Deque<String> getNewDeque() {

        return new Deque<String>();
    }

    @Test(expected = NullPointerException.class)
    public void throwsNullIfNullIsAddedToTheFront() {

        Deque<String> deque;
        deque = getNewDeque();
        deque.addFirst(null);
    }

    @Test(expected = NullPointerException.class)
    public void throwsNullIfNullIsAddedToTheEnd() {

        Deque<String> deque;
        deque = getNewDeque();
        deque.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void throwsNoSuchIfRemoveFOnEmptyDeck() {

        Deque<String> deque;
        deque = getNewDeque();
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void throwsNoSuchIfRemoveLastOnEmptyDeck() {

        Deque<String> deque;
        deque = getNewDeque();
        deque.removeLast();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void throwsUnsupportedExceptionWhenRemovingFromIterator() {

        Deque<String> deque;
        deque = getNewDeque();
        deque.iterator().remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void throwsNoSuchElementWhenClientNextAndThereNoMoreItems() {

        Deque<String> deque;
        deque = getNewDeque();
        deque.iterator().next();
    }

    @Test
    public void aNewDequeMustHaveZeroSize() {

        Deque<String> deque;
        deque = getNewDeque();
        Assert.assertEquals("The size of a new Deque should be zero", 0,
                deque.size());
    }

    @Test
    public void whenAddingFirstSizeOfDequeIncrements() {

        Deque<String> deque;
        deque = getNewDeque();
        Assert.assertEquals("The size of a new Deque should be zero", 0,
                deque.size());

        deque.addFirst("hello");
        Assert.assertEquals(
                "The size of the Deque after adding First must be 1", 1,
                deque.size());

    }

    @Test
    public void whenAddingLastSizeOfDequeIncrements() {

        Deque<String> deque;
        deque = getNewDeque();
        Assert.assertEquals("The size of a new Deque should be zero", 0,
                deque.size());

        deque.addLast("world");
        Assert.assertEquals(
                "The size of the Deque after adding First must be 1", 1,
                deque.size());
    }

    @Test
    public void iterateAfterAddFirst() {

        Deque<String> deque;
        deque = getNewDeque();
        String item = "hello";
        deque.addFirst(item);

        Iterator<String> iterator = deque.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("The next item should be the same added", item,
                iterator.next());
    }

    @Test
    public void iterateAfterAddLast() {

        Deque<String> deque;
        deque = getNewDeque();
        String item = "hello";
        deque.addLast(item);

        Iterator<String> iterator = deque.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("The next item should be the same added", item,
                iterator.next());
    }

    @Test
    public void whenDequeNewIsEmpty() {

        Deque<String> deque;
        deque = getNewDeque();
        Assert.assertTrue("Deque should be empty", deque.isEmpty());
    }

    @Test
    public void whenAddingItemDequeIsNotEmpty() {

        Deque<String> deque;
        deque = getNewDeque();
        deque.addFirst("hello");
        Assert.assertFalse(deque.isEmpty());

        deque = getNewDeque();
        deque.addLast("world");
        Assert.assertFalse(deque.isEmpty());
    }

    @Test
    public void whenEmptiedWithRemoveFirstItIsActualyEmpty() {

        Deque<String> deque;
        deque = getNewDeque();

        String item = "hello";
        deque.addFirst(item);
        Assert.assertFalse(deque.isEmpty());

        String removed = deque.removeFirst();
        Assert.assertTrue(deque.isEmpty());
        Assert.assertEquals(0, deque.size());
        Assert.assertEquals(item, removed);
    }

    @Test
    public void whenEmptiedWithRemoveLastItIsActualyEmpty() {

        Deque<String> deque;
        deque = getNewDeque();
        deque.addFirst("hello");
        Assert.assertFalse(deque.isEmpty());

        String item = deque.removeLast();
        Assert.assertTrue(deque.isEmpty());
        Assert.assertEquals(0, deque.size());
        Assert.assertEquals("hello", item);
    }

    @Test
    public void fiveItemsAddedFirstThenIterated() {

        String[] values = { "one", "two", "three", "four", "five" };

        Deque<String> deque;
        deque = getNewDeque();

        for (String toAdd : values) {

            deque.addFirst(toAdd);
        }

        Assert.assertEquals(values.length, deque.size());

        System.out.println("Iterating after adding first.");
        int count = values.length - 1;
        for (String removed : deque) {

            Assert.assertEquals(values[count--], removed);
            System.out.println(removed);
        }
        Assert.assertEquals(-1, count);
        Assert.assertEquals(5, deque.size());
        Assert.assertFalse(deque.isEmpty());
        System.out.println("===============");
    }

    @Test
    public void fiveItemsAddedLastThenIterated() {

        String[] values = { "one", "two", "three", "four", "five" };

        Deque<String> deque;
        deque = getNewDeque();

        for (String toAdd : values) {

            deque.addLast(toAdd);
        }

        Assert.assertEquals(values.length, deque.size());

        System.out.println("Iterating after adding Last.");
        int count = 0;
        for (String removed : deque) {

            Assert.assertEquals(values[count++], removed);
            System.out.println(removed);
        }
        Assert.assertEquals(5, count);
        Assert.assertEquals(5, deque.size());
        Assert.assertFalse(deque.isEmpty());
        System.out.println("===============");
    }

    @Test
    public void fiveItemsAddedFirstAndRemovedFirst() {

        String[] values = { "one", "two", "three", "four", "five" };

        Deque<String> deque;
        deque = getNewDeque();

        for (String toAdd : values) {

            deque.addFirst(toAdd);
        }

        Assert.assertEquals(values.length, deque.size());

        System.out.println("Removing first.");
        int count = values.length;
        while (!deque.isEmpty()) {

            String removed = deque.removeFirst();
            System.out.println(removed);
            Assert.assertEquals(values[--count], removed);
        }

        Assert.assertEquals(0, count);
        Assert.assertEquals(0, deque.size());
        Assert.assertTrue(deque.isEmpty());
        System.out.println("===============");

    }
    
    @Test
    public void fiveItemsAddedFirstAndRemovedLast() {
        
        String[] values = { "one", "two", "three", "four", "five" };
        
        Deque<String> deque;
        deque = getNewDeque();
        
        for (String toAdd : values) {
            
            deque.addFirst(toAdd);
        }
        
        Assert.assertEquals(values.length, deque.size());
        
        System.out.println("Removing Last.");
        int count = 0;
        while (!deque.isEmpty()) {
            
            String removed = deque.removeLast();
            System.out.println(removed);
            Assert.assertEquals(values[count++], removed);
        }
        
        Assert.assertEquals(5, count);
        Assert.assertEquals(0, deque.size());
        Assert.assertTrue(deque.isEmpty());
        System.out.println("===============");
        
    }
    
    @Test
    public void fiveItemsAddedLastAndRemovedFirst() {
        
        String[] values = { "one", "two", "three", "four", "five" };
        
        Deque<String> deque;
        deque = getNewDeque();
        
        for (String toAdd : values) {
            
            deque.addLast(toAdd);
        }
        
        Assert.assertEquals(values.length, deque.size());
        
        System.out.println("Removing Last.");
        int count = 0;
        while (!deque.isEmpty()) {
            
            String removed = deque.removeFirst();
            System.out.println(removed);
            Assert.assertEquals(values[count++], removed);
        }
        
        Assert.assertEquals(5, count);
        Assert.assertEquals(0, deque.size());
        Assert.assertTrue(deque.isEmpty());
        System.out.println("===============");
        
    }
    
    @Test
    public void fiveItemsAddedLastAndRemovedLast() {
        
        String[] values = { "one", "two", "three", "four", "five" };
        
        Deque<String> deque;
        deque = getNewDeque();
        
        for (String toAdd : values) {
            
            deque.addLast(toAdd);
        }
        
        Assert.assertEquals(values.length, deque.size());
        
        System.out.println("Removing Last.");
        int count = values.length;
        while (!deque.isEmpty()) {
            
            String removed = deque.removeLast();
            System.out.println(removed);
            Assert.assertEquals(values[--count], removed);
        }
        
        Assert.assertEquals(0, count);
        Assert.assertEquals(0, deque.size());
        Assert.assertTrue(deque.isEmpty());
        System.out.println("===============");
        
    }
    
    @Test
    public void iteratorsShouldBeIndependent() {
        
        String[] values = { "one", "two", "three", "four", "five" };
        
        Deque<String> deque;
        deque = getNewDeque();
        
        for (String toAdd : values) {
            
            deque.addLast(toAdd);
        }
        
        Assert.assertEquals(values.length, deque.size());
        
        System.out.println("> Iterators independent");
        
        int outerCount = 0;
        for (String outer : deque) {
            
            System.out.print("> ");
            System.out.println(outer);
            Assert.assertEquals(values[outerCount++], outer);
            int innerCount = 0;
            for (String inner : deque) {
                
                System.out.print(">>> ");
                System.out.println(inner);
                Assert.assertEquals(values[innerCount++], inner);
            }
        }
        
        System.out.println("===============");
        
    }
    
    // Test 10: Check iterator() after intermixed calls to addFirst(),
    // addLast(), removeFirst(), and removeLast()
    @Test
    public void intermixedCallsToAddFirstLastRemoveFirstLast() {
        
        Deque<String> deque;
        deque = getNewDeque();
        
        deque.addFirst("Hello");
        deque.addLast("World");
        deque.addFirst("This");
        deque.addLast("is");
        deque.addFirst("Carlos");
        Assert.assertEquals(5, deque.size());
        
        deque.removeFirst();
        deque.removeLast();
        deque.removeFirst();
        deque.removeLast();
        deque.removeFirst();
        Assert.assertEquals(0, deque.size());
        
        for (String item : deque) { 
            System.out.println(item);
        }
    }
}
