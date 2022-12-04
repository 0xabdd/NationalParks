
package nationalparks.Stack;

import nationalparks.MilliPark;

// İstenilen Yığıt yapısının yazılması.
public class Stack {
    private int maxSize;
    private MilliPark[] stackArray; 
    private int top;
    
    public Stack(int s){ 
        maxSize = s;
        stackArray = new MilliPark[maxSize];
        top = -1;
    }
    
    public void push(MilliPark mp){ 
        stackArray[++top] = mp; 
        
    }
    public MilliPark pop(){ 
        return stackArray[top--]; 
    }
    public MilliPark peek(){ 
        return stackArray[top];
    }
    
    public boolean isEmpty(){
        return (top == -1);
    }
    public boolean isFull(){
        return (top == maxSize-1);
    }
    
}
