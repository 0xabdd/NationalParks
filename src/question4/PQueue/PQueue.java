
package question4.PQueue;

import java.util.ArrayList;
import nationalparks.MilliPark;

// 3. soruda kullanılan öncelikli kuyruk yapısının revize edilmesi.
public class PQueue {
    private int maxSize;
    private ArrayList<Integer> queList = new ArrayList<Integer>();
    private int nItems;
    
    public PQueue(){
        nItems = 0;
    }
    public void insert(int i){
        
        queList.add(i);
        nItems++;
     
    }
    public int remove(){  // en küçük değeri en önce çıkartıcak.
        int smallest = queList.get(0);

        for(int j= nItems-1; j>0; j-- ){
            if(queList.get(j)< smallest){
                smallest = queList.get(j);
                }
            }
        queList.remove(queList.indexOf(smallest));
        nItems--;
        return smallest;
    }
    public void removeAll(){
        for(int i = 0; i < queList.size(); i++){
            queList.remove(i);
        }
    }
    
    public boolean isEmpty() {
        return (nItems==0);
    }
    public boolean isFull(){
         return (nItems == maxSize);
    }
}
