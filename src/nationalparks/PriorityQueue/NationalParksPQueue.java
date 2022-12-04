
package nationalparks.PriorityQueue;

import nationalparks.PriorityQueue.PriorityQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import nationalparks.MilliPark;


public class NationalParksPQueue {
    public static void main(String[] args) {
        // Dosyadan çekilen verileri ayrı ayrı listelerde tutup Objeleri listeler üzerinden oluşturmayı tercih ettim.

        List<String> parkIsimleri = new ArrayList<>();
        List<String> parkMekanlari = new ArrayList<>();
        List<Integer> parkYillari = new ArrayList<>();
        List<Integer> parkYuzOlcumleri = new ArrayList<>();
        
        
        // Dosya okuma ve listelere ekleme işlemi.
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
					"/Users/abd/Desktop/milliparklar.txt"));
            String line = reader.readLine();
            while (line != null) {
                    
                String[] token = line.split(";");
                parkIsimleri.add(token[0]);
                parkMekanlari.add(token[1]);
                parkYillari.add(Integer.parseInt(token[2]));
                parkYuzOlcumleri.add(Integer.parseInt(token[3]));
                line = reader.readLine();
                    
		}
            reader.close();
            } catch (IOException e) {
			e.printStackTrace();
		}
        // Milli parkları tutacak olan generic array oluşturulması.
        MilliPark[] milliParklar = new MilliPark[parkIsimleri.size()];
        // Öncelikli kuyruk yapısının oluşturulması.
        PriorityQueue pQueue = new PriorityQueue();
        
        // listelerdeki verileri kullnarak objelerin oluşturulması ve kuyruğa eklenmesi.
        for(int i = 0; i < parkIsimleri.size(); i++){
            milliParklar[i] = new MilliPark(parkIsimleri.get(i), parkMekanlari.get(i), parkYillari.get(i), parkYuzOlcumleri.get(i));
            pQueue.insert(milliParklar[i]);
        }
        // İstenilen verilerin ekrana yazdırılması.
        while (!(pQueue.isEmpty())) {            
            MilliPark mp = pQueue.remove(); 
            System.out.println("Isim: " + mp.isim);
            System.out.println("Konum: " + mp.mekan);
            System.out.println("Acilis Yili: " + mp.yil);
            System.out.println("Yuz Olcum (Hektar): " + mp.yuzOlcum); 
            System.out.println("-------------------------------------");
        }
    }
}
