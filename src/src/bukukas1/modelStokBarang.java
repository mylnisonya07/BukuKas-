/*
 BukuKas 
 */
package bukukas1;
/*
 * @author DIMAS ZAECA WARDANA (20523003)
 */

public class modelStokBarang {
    String Nama;
    String Jumlah;
    
    public modelStokBarang(){
       // this ("","",0,0);
    }
    //buat konstruktor yang isinya ada variable lokal
    public modelStokBarang(String x, String y){
        this.Nama = x;
        this.Jumlah = y;
    }

    public String getNama() {
        return Nama;
    }

    public String getJumlah() {
        return Jumlah;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public void setJumlah(String Jumlah) {
        this.Jumlah = Jumlah;
    }
    
    
    
}
