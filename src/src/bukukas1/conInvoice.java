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
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MAYLA AYYUNI SONYA (20523241)
 */
public class conInvoice implements Initializable {

    @FXML
    private Label lbJudul;
    @FXML
    private Label lbKategori;
    @FXML
    private Label lbCatatan;
    @FXML
    private Label lbPenjualan;
    @FXML
    private Label lbHpokok;
    @FXML
    private Label lbUntung;
    @FXML
    private Label lbWaktu;
    
    
    modelInvoice modelinvoice;
    XStream vc = new XStream(new StaxDriver());
    
    @FXML
    private BorderPane mainPane;
    
    void bukaXML(){
        FileInputStream open = null;
        try {
            open = new FileInputStream("invoice.xml");
            int isi;
            char charnya;
            String stringnya;
            stringnya ="";
            while ((isi = open.read()) != -1) {
                charnya= (char) isi;
                stringnya = stringnya + charnya;
            }    
            modelinvoice = (modelInvoice) vc.fromXML(stringnya);	  
        }
        catch (Exception e){
            System.err.println("test: "+e.getMessage());
        }
        finally{
            if(open != null){
                try{
                    open.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }      
        }
        System.out.println("berhasil load data transaksi dari data base");
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bukaXML();
        lbJudul.setText(modelinvoice.getJudul());
        lbKategori.setText(modelinvoice.getKategori());
        lbCatatan.setText(modelinvoice.getCatatan());
        lbPenjualan.setText(String.valueOf(modelinvoice.getRpjual()));
        lbHpokok.setText(String.valueOf(modelinvoice.getRppokok()));
        lbUntung.setText(String.valueOf(modelinvoice.getUntung()));
        lbWaktu.setText(modelinvoice.getTgltransaksi()); 
        System.out.println("conInvoice.initialize telah dijalankan");
          
    }    
   
}
