
package nationalparks.Queue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import nationalparks.MilliPark;


public class NationalParkQueue {
    public static void main(String[] args) {
        // Dosyadan çekilen verileri ayrı ayrı listelerde tutup Objeleri listeler üzerinden oluşturmayı tercih ettim.
        List<String> parkIsimleri = new ArrayList<>();
        List<String> parkMekanlari = new ArrayList<>();
        List<Integer> parkYillari = new ArrayList<>();
        List<Integer> parkYuzOlcumleri = new ArrayList<>();
        
        
        // Dosya okuma işlemi ve listelere elemanların eklenilmesi.
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
					"/Users/abd/Desktop/milliparklar.txt"));
            String line = reader.readLine();
            while (line != null) {
                    
                String[] token = line.split(";");
                // Listelere eleman ekleme işlemi.
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
        MilliPark[] milliParklar = new MilliPark[parkIsimleri.size()];
        Queue queue = new Queue(milliParklar.length);
        //create objects and push to stack
        for(int i = 0; i < parkIsimleri.size(); i++){
            milliParklar[i] = new MilliPark(parkIsimleri.get(i), parkMekanlari.get(i), parkYillari.get(i), parkYuzOlcumleri.get(i));
            queue.insert(milliParklar[i]);
        }
        // İstenilen verilerin ekrana yazdırılması.
        while (!(queue.isEmpty())) {            
            MilliPark mp = queue.remove(); 
            System.out.println("Isim: " + mp.isim);
            System.out.println("Konum: " + mp.mekan);
            System.out.println("Acilis Yili: " + mp.yil);
            System.out.println("Yuz Olcum (Hektar): " + mp.yuzOlcum); 
            System.out.println("-------------------------------------");
        }
    }
}
