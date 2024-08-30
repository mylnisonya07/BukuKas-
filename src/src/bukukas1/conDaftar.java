/*
 BukuKas 
 */
package bukukas1;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML 
 *
 * @author AHMAD RIFA'I (20523007)
 */
public class conDaftar implements Initializable {

       
    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPassword;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private ChoiceBox cbDomisili ;
    @FXML
    private DatePicker dpLahir;
    @FXML
    private TextField tfNoHP;
    
    

    @FXML
    private void daftar(ActionEvent event) throws Exception
    {
        Parent homeParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene homeScene = new Scene(homeParent);
        
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.show();
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Info Registrasi");
                alert.setHeaderText(null);
                alert.setContentText("Akun Anda telah terfatar di BukuKas.");

                alert.showAndWait();
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbDomisili.getItems().addAll("Aceh","Sumatera Utara","Sumatera Barat","Riau",
                                   "Kepulauan Riau","Jambi","Sumatera Selatan","Kepulau Bangka Belitug",
                                   "Bengkulu","Lampung","DKI Jakarta","Banten","Jawa Barat",
                                   "Jawa Tengah","DI Yogyakarta","Jawa Timur","Bali",
                                   "Nusa Tenggara Barat","Nusa Tenggara Timur","Kalimantan Barat","Kalimantan Tengah","Provinsi Kalimantan Selatan",
                                   "Kalimantan Timur","Kalimantan Utara","Sulawesi Utara","Gorontalo",
                                   "Sulawesi Tengah","Sulawesi Barat","Provinsi Sulawesi Selatan","Sulawesi Tenggara","Maluku",
                                   "Maluku Utara","Papua Barat","Papua");
        cbDomisili.setValue("tempat tinggal saat ini..");
        dpLahir.setValue(LocalDate.now());
        //tfNoHP.setText("+628");
        
    }    

    
    
}
