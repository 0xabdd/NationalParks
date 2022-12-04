
package question4.Queue;

public class TestQueue {
    public static void main(String[] args) {
             
        int totalTime= 0;
        int musteriSayisi= 11;
        int x = 0;
        while(x < 11){
             /* 
            Müşterilen sırada bekleme sürelerinin hesaplanılması için böyle bir algoritma oluşturdum. 
            Her müşterinin sırası gelince kuyruk yeniden oluşturuluyor ve müşterinin sırasına göre remove işlemi tekrarlanıyor.
            Böylece Müşterinin sırada kaç saniye beklediğini hesaplayabiliyoruz.
            */
            Queue queue = new Queue(11);   
            queue.insert(8);
            queue.insert(9);
            queue.insert(6);
            queue.insert(7);
            queue.insert(10);
            queue.insert(1);
            queue.insert(11);
            queue.insert(5);
            queue.insert(3);
            queue.insert(4);
            queue.insert(2);
       
            for(int i= 0; i<=x ; i++){
                int y = queue.remove();
                totalTime += y*3;
            }
            x++;
            
        }
        
        System.out.println("Toplam işlem tamamlama süresi: " + totalTime + " saniye.");
        System.out.println("Ortalama işlem tamamlama süresi: "+ totalTime/musteriSayisi + " saniye");
        
    }
}
