import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> 
{
    private class Node {
        private Item item;
        private Node previousNode;
        private Node nextNode;
        Node(Item item, Node previousNode, Node nextNode) {
            this.item = item;
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }
    }
    // For tracking the linked list of Nodes
    private Node firstNode;
    private Node lastNode;
    
    // For keeping track of Node count
    private int totalNodes;
    
    
    public Deque() 
    {    // construct an empty deque
         //Initialize my attributes
         firstNode = null;
         lastNode = null;
         totalNodes = 0;
    }
    
    public boolean isEmpty() 
    {    // is the deque empty?  
         return (totalNodes <= 0);
    }
    
    public int size() 
    {    // return the number of items on the deque
         return totalNodes;
    } 
    
    public void addFirst(Item item) 
    {   // insert the item at the front
        if (item == null) throw new java.lang.NullPointerException();
        
        Node tempNode = firstNode;
        
        firstNode = new Node(item, null, tempNode);
        totalNodes++;
        
        if (lastNode == null)
        {    lastNode = firstNode;
        }
        else
        {    tempNode.previousNode = firstNode;
        }
    } 
    
    public void addLast(Item item) 
    {   // insert the item at the end
        if (item == null) throw new java.lang.NullPointerException();
        
        Node tempNode = lastNode;
        
        lastNode = new Node(item, tempNode, null);
        totalNodes++;
        
        if (firstNode == null)
        {    firstNode = lastNode;
        }
        else
        {    tempNode.nextNode = lastNode;
        }
    }
    
    public Item removeFirst() 
    {   // delete and return the item at the front
        if (isEmpty()) throw new java.util.NoSuchElementException();
        
        Item item = firstNode.item;
        
        firstNode = firstNode.nextNode;
        totalNodes--;
        
        if (firstNode == null)
        {    lastNode = null;
        }
        else
        {    firstNode.previousNode = null;
        }
        return item;
    }
    
    public Item removeLast() 
    {   // delete and return the item at the end
        if (isEmpty()) throw new java.util.NoSuchElementException();  
        
        Item item = lastNode.item;
        lastNode = lastNode.previousNode;
        totalNodes--;
        
        
        if (lastNode == null)
        {    firstNode = null;
        }
        else
        {    lastNode.nextNode = null;
        }
        return item;
    }
    
   
    
    private class NodeIterator implements Iterator<Item> {
        private Node nodeReference;
        public NodeIterator() { nodeReference = firstNode; }
        public boolean hasNext() { return (nodeReference != null); }
       
        public Item next() {
            if (hasNext())
            {   Item item = nodeReference.item;
                nodeReference = nodeReference.nextNode;
                return item;
            }
            else
            {    throw new java.util.NoSuchElementException("null - next");
            }
        }
            
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove not supported");
        }
    }
    
     public Iterator<Item> iterator() 
    {    // return an iterator over items in order from front to end
         return new NodeIterator();
    }
    
    public static void main(String[] args) {}// unit testing
}