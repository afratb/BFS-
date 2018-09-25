package BFS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.*;
import java.lang.String;

class Uye{
    int renk; //0 beyaz 1 siyah
    char deger; // A,B,C,D,E char'ları tutuluyor.
    Uye sonraki;
    int sira; 
}

public class Main {
    static public Scanner sc = new Scanner(System.in);
    static ArrayList<Uye> dugum = new ArrayList(); 
    public static void main(String[] args) throws IOException {
        File file = new File("dosya.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String satir = reader.readLine();
        int str=0;
            while (satir!=null) {
                Uye yeni = new Uye();
                switch(str){ // satır satır okuyup listeye düğümleri yerleştiriyor.
                    case 0 :{ yeni.deger='A'; yeni.sonraki=null; yeni.renk=0; yeni.sira=1; dugum.add(yeni);break;}
                    case 1 :{ yeni.deger='B'; yeni.sonraki=null; yeni.renk=0; yeni.sira=2; dugum.add(yeni); break;}
                    case 2 :{ yeni.deger='C'; yeni.sonraki=null; yeni.renk=0; yeni.sira=3; dugum.add(yeni); break;}
                    case 3 :{ yeni.deger='D'; yeni.sonraki=null; yeni.renk=0; yeni.sira=4; dugum.add(yeni); break;}
                    case 4 :{ yeni.deger='E'; yeni.sonraki=null; yeni.renk=0; yeni.sira=5; dugum.add(yeni); break;}
                }
                for(int i=0;i<satir.length();i++){ // sütunlardaki komşu verilerini bağlı liste şeklinde düğümlere ekliyor.
                    if(satir.charAt(i)=='1'){
                        Uye komsu = new Uye();
                        if(i==0){
                            komsu.deger='A';
                            komsu.sonraki=null;
                            komsu.renk=0;
                            komsu.sira=1;
                            if(yeni.sonraki==null)yeni.sonraki=komsu;
                            else yeni=yeni.sonraki; yeni.sonraki=komsu;
                        }
                        if(i==2){
                            komsu.deger='B';
                            komsu.sonraki=null;
                            komsu.renk=0;
                            komsu.sira=2;
                            if(yeni.sonraki==null)yeni.sonraki=komsu;
                            else yeni=yeni.sonraki; yeni.sonraki=komsu;
                        }
                        if(i==4){
                            komsu.deger='C';
                            komsu.sonraki=null;
                            komsu.renk=0;
                            komsu.sira=3;
                            if(yeni.sonraki==null)yeni.sonraki=komsu;
                            else yeni=yeni.sonraki; yeni.sonraki=komsu;
                        }
                        if(i==6){
                            komsu.deger='D';
                            komsu.sonraki=null;
                            komsu.renk=0;
                            komsu.sira=4;
                            if(yeni.sonraki==null)yeni.sonraki=komsu;
                            else yeni=yeni.sonraki; yeni.sonraki=komsu;
                        }
                        if(i==8){
                            komsu.deger='E';
                            komsu.sonraki=null;
                            komsu.renk=0;
                            komsu.sira=5;
                            if(yeni.sonraki==null)yeni.sonraki=komsu;
                            else yeni=yeni.sonraki; yeni.sonraki=komsu;
                        }
                    }
                }
                str++;
                satir = reader.readLine();
            }
        while(true){ //menü
        System.out.println("1-Komşuluk Listesi\n2-Düğüm Dereceleri\n3-Sona Kadar BFS ile Dolaşma\n4-İstenilen Düğüme Kadar BFS ile Dolaşma\n5-Çıkış");
        int sec = sc.nextInt();
        switch(sec){
            case 1 : Komsuluk_List(); break;
            case 2 : Derece_Hesap(); break;
            case 3 : {
                System.out.println("[a-e]kök düğümü seçiniz");
                String num = sc.next(); 
                if(num.equals("a")) { BFS(0); break; }
                else if(num.equals("b")){ BFS(1); break; }
                else if(num.equals("c")){ BFS(2); break; }
                else if(num.equals("d")){ BFS(3); break; }
                else if(num.equals("e")){ BFS(4); break; }
                 }
            case 4 :{
                System.out.println("[a-e] kök düğüm seçiniz");
                String num = sc.next(); 
                System.out.println("[a-e] varılacak düğüm seçiniz");
                String num2 = sc.next();
                if(num.equals("a")) { Sartli_BFS(0,num2.substring(0,1).toUpperCase().charAt(0)); break; }
                else if(num.equals("b")){ Sartli_BFS(1,num2.substring(0,1).toUpperCase().charAt(0)); break; }
                else if(num.equals("c")){ Sartli_BFS(2,num2.substring(0,1).toUpperCase().charAt(0)); break; }
                else if(num.equals("d")){ Sartli_BFS(3,num2.substring(0,1).toUpperCase().charAt(0)); break; }
                else if(num.equals("e")){ Sartli_BFS(4,num2.substring(0,1).toUpperCase().charAt(0)); break; }
                 }
            case 5 : exit(0);
        }
        }
    }
    public static void Sartli_BFS(int num,char sart){ //istenilen düğüme kaç adımda olduğunu ve gezilen düğümleri yazıyor.
        int uzk=0; // uzaklık için sayaç
        Uye tmp = new Uye();
        if(dugum.get(num).renk==0){
        System.out.println(dugum.get(num).deger+" "+"Atası = NULL" +" "+"Uzaklık : "+uzk);
        dugum.get(num).renk=1;}
        renk(dugum.get(num).deger);
        int kucuk=4;
        int bl=0;
        for(int i=1;i<dugum.size()+1;i++)
        {
                   tmp=dugum.get(num);
                   while(tmp.sonraki!=null ){
                       tmp=tmp.sonraki;
                       if(tmp.renk==0)
                       {
                       int sira = renk(tmp.deger);
                               kucuk = kucuk<=sira ? kucuk : sira ; //küçük olan komşuyu seçip ordan devam ediyor.
                          
                       System.out.println(tmp.deger+" "+"Atası ="+dugum.get(num).deger +" "+"Uzaklık : "+(uzk+1));
                       bl=uzk+1;
                       if(String.valueOf(tmp.deger).equals(String.valueOf(sart))){
                           System.out.println(bl+"  Adımda ulaşıldı."); return;
                       }
                           
                       }
                   }
                   uzk++;
                   num=kucuk; 
        }
        System.out.println(bl+"  Adımda ulaşıldı.");

        
    }
    public static int renk(char rnk){ // gezilen komşu ve düğümlerin renklerini 1(siyah) yapıyor.
        Uye yeni = new Uye();
        int m=0;
        for(int j=0;j<dugum.size();j++) {
            yeni=dugum.get(j);
           
                           if(String.valueOf(dugum.get(j).deger).equals(String.valueOf(rnk))){ 
                               dugum.get(j).renk =  1; 
                               m=j;
                           }
                                while(yeni.sonraki!=null ){
                                    yeni=yeni.sonraki;
                                   if(yeni.renk==0 && String.valueOf(yeni.deger).equals(String.valueOf(rnk)))
                                       yeni.renk=1; 
                                   
                               }
                           
        }
        return m;
    }
    public static void BFS(int num){ // graf sonuna kadar düğümleri geziyor.
        int uzk=0;
        Uye tmp = new Uye();
        if(dugum.get(num).renk==0){
        System.out.println(dugum.get(num).deger+" "+"Atası = NULL" +" "+"Uzaklık : "+uzk);
        dugum.get(num).renk=1;}
        renk(dugum.get(num).deger);
        int kucuk=4;
        for(int i=1;i<dugum.size()+1;i++)
        {
                   tmp=dugum.get(num);
                   while(tmp.sonraki!=null  ){
                       tmp=tmp.sonraki;
                       if(tmp.renk==0)
                       {
                       int sira = renk(tmp.deger);
                               kucuk = kucuk<=sira ? kucuk : sira ;
                          
                       System.out.println(tmp.deger+" "+"Atası ="+dugum.get(num).deger +" "+"Uzaklık : "+(uzk+1));
                               }
                   }
                   uzk++;
                   num=kucuk; 
                 
        }
    }
    public static void Derece_Hesap(){ // komşu sayılarına göre derecelerini hesaplıyor.
        Uye tmp = new Uye();
        for(int i=0;i<dugum.size();i++){
            tmp=dugum.get(i);
            int say=0;
            while(tmp.sonraki!=null){
                tmp=tmp.sonraki;
                say++;
            }
            System.out.println(dugum.get(i).deger+"   :"+say);
        }
    }
    public static void Komsuluk_List(){ //komşularını ekrana yazdırıyor.
            for(int y=0;y<dugum.size();y++){
                System.out.print(dugum.get(y).deger+"--->");
                while(dugum.get(y).sonraki!=null){
                    dugum.set(y, dugum.get(y).sonraki);
                    System.out.print(dugum.get(y).deger+" ");
                }
                System.out.println(" ");
            }
    }
    
}
