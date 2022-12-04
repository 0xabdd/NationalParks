
package nationalparks.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import nationalparks.MilliPark;



public class NationalParks {

    
    public static void main(String[] args) {
        // Dosyadan çekilen verileri ayrı ayrı listelerde tutup Objeleri listeler üzerinden oluşturmayı tercih ettim.
        List<String> parkIsimleri = new ArrayList<>();
        List<String> parkMekanlari = new ArrayList<>();
        List<Integer> parkYillari = new ArrayList<>();
        List<Integer> parkYuzOlcumleri = new ArrayList<>();
        
        
        // Dosya okuma işlemi
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
					"/Users/abd/Desktop/milliparklar.txt"));
            String line = reader.readLine();
            while (line != null) {
                    
                String[] token = line.split(";");
                // Dosyadan çekilen verileri listelere ekleme işlemi
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
        // Oluşturulan objeleri bir listede toplama 
        MilliPark[] milliParklar = new MilliPark[parkIsimleri.size()];
        // Generic listelerde oluşan 2  elemanlı Array oluşturma işlemi
        List[] arrayOfList = new List[2];
        List<MilliPark> kucukMp = new ArrayList<MilliPark>();
        List<MilliPark> buyukMp = new ArrayList<MilliPark>();
        arrayOfList[0] = kucukMp;
        arrayOfList[1] = buyukMp;
        // Verileri ayırmak için kullanılacak değişkenlerin oluşturulması
        int kucukParklarYuzOlcum = 0;
        int buyukParklarYuzOlcum = 0;
        // Dosyadan çekilen verilerle oluşturulan listeleri kullanarak objelerin oluşturulması ve listelere eklenmesi.
        for(int i = 0; i < parkIsimleri.size(); i++){
            milliParklar[i] = new MilliPark(parkIsimleri.get(i), parkMekanlari.get(i), parkYillari.get(i), parkYuzOlcumleri.get(i));
            if(milliParklar[i].yuzOlcum < 15000){
               kucukMp.add(milliParklar[i]);
            }
            else{
               buyukMp.add(milliParklar[i]);
            
        }
        }
        // İstenilen verilerin ekrana yazdırılması.
        System.out.println("----------- KUCUK MILLI PARKLAR --------");
        for(int j = 0; j< kucukMp.size(); j++){
            System.out.println("Isim: " + kucukMp.get(j).isim);
            System.out.println("Konum: " + kucukMp.get(j).mekan);
            System.out.println("Acilis Yili: " + kucukMp.get(j).yil);
            System.out.println("Yuz Olcum (Hektar): " + kucukMp.get(j).yuzOlcum); 
            kucukParklarYuzOlcum += kucukMp.get(j).yuzOlcum;
            System.out.println("-------------------------------------");
            
        }
        
        System.out.println("----------- BUYUK MILLI PARKLAR --------");
        for (int y= 0; y< buyukMp.size(); y++){
            System.out.println("Isim: " + buyukMp.get(y).isim);
            System.out.println("Konum: " + buyukMp.get(y).mekan);
            System.out.println("Acilis Yili: " + buyukMp.get(y).yil);
            System.out.println("Yuz Olcum (Hektar): " + buyukMp.get(y).yuzOlcum); 
            buyukParklarYuzOlcum += buyukMp.get(y).yuzOlcum;
            System.out.println("-------------------------------------");
            
        }
        System.out.println("Kucuk Parklar Yuz Olcum Toplami (Hektar) = " + kucukParklarYuzOlcum);
        System.out.println("Buyuk Parklar Yuz Olcum Toplami (Hektar) = " + buyukParklarYuzOlcum);
       
        
    }
       
    

    
}
