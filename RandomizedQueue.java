import java.util.*;

public class RandomizedQueue<Item> implements Iterable<Item> 
{   private int queueSize;
    
    private int capacity;
    private Item[] queueItems;
    
    
    public RandomizedQueue() 
    {   capacity = 1; 
        queueSize = 0;
        queueItems = (Item[]) new Object[capacity];
    }
    
    public boolean isEmpty() 
    {    return( queueSize == 0 );
    }
    
    public int size() 
    {    return queueSize;
    }
    
    private void resize(int capacity)
    {    this.capacity = capacity;
         Item[] queueItemsCopy = (Item[]) new Object[capacity];
         for (int i = 0; i < queueSize; i++)
         {    queueItemsCopy[i] = queueItems[i];
         }
         queueItems = queueItemsCopy;
    }
    
    private void swap(int i, int j) 
    {    Item tempItem = queueItems[i];
         queueItems[i] = queueItems[j];
         queueItems[j] = tempItem;
    }
    
    public void enqueue(Item item) 
    {    if (item == null) 
        {    throw new java.lang.NullPointerException("enqueue-null item");
    }
         if (queueSize == capacity) 
         {    resize(capacity * 2);
         }
         queueItems[queueSize++] = item;
    }
    
    public Item dequeue() 
    {    if (queueSize == 0) 
         {    throw new java.util.NoSuchElementException("deque-zero size");
         }
         int r = StdRandom.uniform(queueSize);
         swap(queueSize - 1, r);
         Item item = queueItems[--queueSize];
         queueItems[queueSize] = null;
         if (queueSize > 8 && queueSize == capacity / 4)
         {    resize(capacity / 2);
         }
         return item;
    }
    public Item sample() 
    {    if (queueSize == 0) 
         {    throw new java.util.NoSuchElementException("sample-zero size");
         }
         int r = StdRandom.uniform(queueSize);
         return queueItems[r];
    }
    
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }
    
    private class RandomizedQueueIterator implements Iterator<Item> 
    {    private int current = 0;
         private Item[] items;
        
        public RandomizedQueueIterator() 
        {    items = (Item[]) new Object[queueSize];
             for (int i = 0; i < queueSize; i++) 
             {    items[i] = queueItems[i];
             }
             StdRandom.shuffle(items);
        }
        public boolean hasNext() 
        {    return current != queueSize;
        }
        public Item next() 
        {   if (!hasNext())
            {    throw new java.util.NoSuchElementException("item-no next");
            }
             return items[current++];
        }
        public void remove() 
        {    throw new java.lang.UnsupportedOperationException("remove not supported");
        }
    }
}