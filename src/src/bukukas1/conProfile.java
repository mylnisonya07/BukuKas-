/*
 BukuKas 
 */
package bukukas1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pai
 */
public class conProfile implements Initializable {
    
    @FXML
    private Label lbUsername;
    @FXML
    private Label lbGmail;
   
    modelLogin modellogin;
    XStream lg = new XStream(new StaxDriver());
    
    void bukaXML(){
        FileInputStream open = null;
        try {
            open = new FileInputStream("profile.xml");
            int isi;
            char charnya;
            String stringnya;
            stringnya ="";
            while ((isi = open.read()) != -1) {
                charnya= (char) isi;
                stringnya = stringnya + charnya;
            }    
            modellogin = (modelLogin) lg.fromXML(stringnya);	  
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
        lbUsername.setText(modellogin.getLbUsername());
        lbGmail.setText(modellogin.getLbGmail());
        System.out.println("conProfile.initialize telah dijalankan");
        
       
    }    

    
    
}
