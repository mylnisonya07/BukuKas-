/*
 BukuKas 
 */
package bukukas1;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 *  @author MAYLA AYYUNI SONYA (20523241) 
 */
public class modelTransaksi {
    private String judul;      
    private String kategori;   
    private int rpjual;   
    private int rppokok;     
    private String tgltransaksi;    
    private String pelanggan;  
    private String catatan;   
    private int untung;      
          

    //konstruktor

    public modelTransaksi(String judul, String kategori, int rpjual, int rppokok, String tgltransaksi, String pelanggan, String catatan, int untung) {
        this.judul = judul;
        this.kategori = kategori;
        this.rpjual = rpjual;
        this.rppokok = rppokok;
        this.tgltransaksi = tgltransaksi;
        this.pelanggan = pelanggan;
        this.catatan = catatan;
        this.untung = untung;
    }
    // method getter setter

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

    public String getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(String pelanggan) {
        this.pelanggan = pelanggan;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public int getUntung() {
        return untung;
    }

    public void setUntung(int untung) {
        this.untung = untung;
    }
    
    
    
    
    
}