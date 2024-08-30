/*
 BukuKas 
 */
package bukukas1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 *
 * @author MAYLA AYYUNI SONYA (20523241)
 */
public class FXMLDocumentController extends OpenScene implements Initializable {
    
    @FXML
    private BorderPane mainPane;
    //untuk daftar
    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfGmail;
    
   
    //xml login
    modelLogin modellogin;
    XStream lg = new XStream(new StaxDriver());
    
    
    @FXML   
    private void notifikasi(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman = object.getPane("FXMLNotifikasi");
        mainPane.setCenter(halaman);
    }
    
     @FXML   
    private void bantuan(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman = object.getPane("FXMLBantuan");
        mainPane.setCenter(halaman);
    }
    
    @FXML   
    private void addBarang(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman = object.getPane("FXMLaddBarang");
        mainPane.setCenter(halaman);
    }
    @FXML
    private void beranda(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman = object.getPane("FXMLHome");
        mainPane.setCenter(halaman);
    }
    @FXML
    private void addTransaksi(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman = object.getPane("FXMLTransaksi");
        mainPane.setCenter(halaman);
    }
    @FXML
    private void daftar(ActionEvent event) {
        OpenScene object=new OpenScene();
        Pane halaman = object.getPane("FXMLDaftar");
        mainPane.setCenter(halaman);
    }
    
    
    @FXML
    private void masuk(ActionEvent event) {
        
        //save data diri ke xml
        modellogin = new modelLogin(tfUsername.getText(), tfGmail.getText());
        String xml = lg.toXML(modellogin);
        FileOutputStream save = null;
        try {
            save = new FileOutputStream("profile.xml");
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
        //buka scene profile
        OpenScene object=new OpenScene();
        Pane halaman = object.getPane("FXMLProfile");
        mainPane.setCenter(halaman);
 
       
    }
    @FXML
    private void invoice(ActionEvent event){
        OpenScene object=new OpenScene();
        Pane halaman = object.getPane("FXMLInvoice");
        mainPane.setCenter(halaman);        
        }
       
    @FXML
    private void laporan(ActionEvent event){
        OpenScene object=new OpenScene();
        Pane halaman = object.getPane("FXMLLaporan");
        mainPane.setCenter(halaman);
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
