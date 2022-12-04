
package nationalparks.Queue;

import nationalparks.MilliPark;

// Ödevde istneilen kuyruk yapısının yazılması.
public class Queue {
    private int maxSize;
    private MilliPark[] queArray;
    private int front;
    private int rear;
    private int nItems;
    
    public Queue(int s){
        maxSize = s;
        queArray = new MilliPark[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
        
    }
    
    public void insert(MilliPark mp){
        if(rear == maxSize-1)
            rear = -1;
        queArray[++rear] = mp;
        nItems++;
        
    }
    
    public MilliPark remove(){
        MilliPark temp = queArray[front++];
        if(front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }
    
    public MilliPark peekFront(){
        return queArray[front];
    }
    public boolean isEmpty(){
        return (nItems==0);
    }
    public boolean isFull()
    {
        return (nItems==maxSize);
    }    
    
    public int size(){
        return nItems;
    }
}
