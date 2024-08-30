/*
 BukuKas 
 */
package bukukas1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MAYLA AYYUNI SONYA (20523241) 
 */
public class conTransaksi implements Initializable {

    @FXML
    private TextField tfJudul;
    @FXML
    private ChoiceBox kategori;
    @FXML
    private TextField tfPenjualan;
    @FXML
    private TextField tfhargaPokok;
    @FXML
    private DatePicker dpTglTransaksi;
    private String tglTransaksi;
    @FXML
    private TextField tfPelanggan;
    @FXML
    private TextField tfCatatan;
    @FXML
    private Label keuntungan;
    @FXML
    private RadioButton btGoppay;
    @FXML
    private RadioButton btOvo;
    @FXML
    private RadioButton btDana;
    
 
    modelInvoice modelinvoice;
    XStream vc = new XStream(new StaxDriver());

    @FXML
    private void simpanTransaksi(ActionEvent event){
        LocalDate date = dpTglTransaksi.getValue();
        modelinvoice = new modelInvoice(tfJudul.getText(),kategori.getValue().toString(), Integer.parseInt(tfPenjualan.getText()),
                                        Integer.parseInt(tfhargaPokok.getText()), date.toString(), 
                                        tfCatatan.getText(), keuntungan.getText());
        String xml = vc.toXML(modelinvoice);
        FileOutputStream save = null;
        try {
            save = new FileOutputStream("invoice.xml");
            byte[] bytes = xml.getBytes("UTF-8");
            save.write(bytes);
        } 
        catch (Exception e) {
            System.err.println("Perhatian: " + e.getMessage());
        } 
        finally {
            if (save != null) {
                try {
                    save.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informasi");
        alert.setHeaderText("data transaksi Anda telah tersimpan.");
        alert.setContentText("Berikut data anda: "+"\nTransaksi--> "
                            +tfJudul.getText()+"\nKeuntungan--> "+keuntungan.getText());
              
        alert.showAndWait();
        
    }
    
    
    
    @FXML
    private void hitungKeuntungan(ActionEvent event){
        int angka1, angka2;
            int hasil = 0;
            angka1 = Integer.parseInt(tfPenjualan.getText());//hasilnya adalah string walau variabelnya inetegr
            angka2 = Integer.parseInt(tfhargaPokok.getText());
            if (tfPenjualan.getText().equals(null)||tfhargaPokok.getText().equals(null)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog!");
                alert.setHeaderText(null);
                alert.setContentText("Masukkan nominal penjualan dan harga pokok!");
                alert.showAndWait();
            }else{
                if(angka1 >= 0 ){
                    hasil = angka1 - angka2;
                    keuntungan.setText("RP."+Integer.toString(hasil)+",-");
                }else if (angka1 < 0){
                    hasil = angka2 - angka1;
                    keuntungan.setText("Kerugian RP."+Integer.toString(hasil)+",-");
                }
            }
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        kategori.getItems().addAll("Transportasi","Makanan","Minuman","Gaji",
                                   "Pulsa","Kredit","Sedekah","SPP","lainnya");
        kategori.setValue("Sedekah");
        dpTglTransaksi.setValue(LocalDate.now());
        
    
    }    

    
    
}
