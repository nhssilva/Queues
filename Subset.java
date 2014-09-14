public class Subset {
    public static void main(String[] args) 
    {
        int k = Integer.parseInt(args[0]);
        String[] inputLine = StdIn.readLine().split(" ");
        RandomizedQueue<String> randomQueue = new RandomizedQueue<String>();
        
        for (String inputString: inputLine) 
        {    randomQueue.enqueue(inputString);
        }
        
        for (int i = 0; i < k; i++) 
        {    StdOut.println(randomQueue.dequeue());
        }
    }
}