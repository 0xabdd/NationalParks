package nationalparks.PriorityQueue;

import java.util.ArrayList;
import nationalparks.MilliPark;


public class PriorityQueue {
    // Ödevde benden istenilen özelliklere sahip Öncelikli kuyruk yapısının tasarlanması.
    private int maxSize;
    private ArrayList<MilliPark> queList = new ArrayList<MilliPark>();
    private int nItems;
    
    public PriorityQueue(){
        nItems = 0;
    }
    public void insert(MilliPark mp){
    // Son gelen eleman sona ekleniyor bir öncelik yok.
        queList.add(mp);
        nItems++;
     
    }
    
    // remove işleminde en küçük yüz ölçümüne sahip obje en önce çıkarılıyor.
    public MilliPark remove(){ 
        MilliPark smallest = queList.get(0);
        
        int j;
        for(j= nItems-1; j>= 0; j-- ){
            if(queList.get(j).yuzOlcum < smallest.yuzOlcum){
                smallest = queList.get(j);
                }
            }
        queList.remove(smallest);
        nItems--;
        return smallest;
    }
    
    public boolean isEmpty() {
        return (nItems==0);
    }
    public boolean isFull(){
         return (nItems == maxSize);
    }
}
