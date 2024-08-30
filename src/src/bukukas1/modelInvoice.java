/*
 BukuKas 
 */
package bukukas1;

/**
 *
 * @author MAYLA AYYUNI SONYA (20523241) 
 */
public class modelInvoice {
    private String judul;      
    private String kategori;   
    private int rpjual;   
    private int rppokok;     
    private String tgltransaksi;     
    private String catatan;   
    private String untung; 

    public modelInvoice(String judul, String kategori, int rpjual, int rppokok, String tgltransaksi, String catatan, String untung) {
        this.judul = judul;
        this.kategori = kategori;
        this.rpjual = rpjual;
        this.rppokok = rppokok;
        this.tgltransaksi = tgltransaksi;
        this.catatan = catatan;
        this.untung = untung;
    }

    
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getRpjual() {
        return rpjual;
    }

    public void setRpjual(int rpjual) {
        this.rpjual = rpjual;
    }

    public int getRppokok() {
        return rppokok;
    }

    public void setRppokok(int rppokok) {
        this.rppokok = rppokok;
    }

    public String getTgltransaksi() {
        return tgltransaksi;
    }

    public void setTgltransaksi(String tgltransaksi) {
        this.tgltransaksi = tgltransaksi;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getUntung() {
        return untung;
    }

    public void setUntung(String untung) {
        this.untung = untung;
    }
    
    
    
}
