/*
 BukuKas 
 */
package bukukas1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 *  @author DIMAS ZAECA WARDANA (20523003)
 */
public class conBantuan implements Initializable {
    
    @FXML
    private TextField tfMasalah;
    
    @FXML
    private Label lbTerimakasih1;
    @FXML
    private Label lbTerimakasih2;
    
    @FXML   
    private void batal(ActionEvent event) {
        if(tfMasalah.getText().equals("")||tfMasalah.getText().equals("Ketik permasalahan Anda...")){
            tfMasalah.setText("");
        }else{
            tfMasalah.setText("");
        }

    }
    
    @FXML   
    private void kirim(ActionEvent event) {
        if (tfMasalah.getText().equals("")||tfMasalah.getText().equals("Ketik permasalahan Anda...")){
            lbTerimakasih2.setText("Kolom masih kosong, silahkan ketik permasalahan Anda.");
            lbTerimakasih1.setText("");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Permasalahan Anda segera diproses.");

                alert.showAndWait();
            
            lbTerimakasih2.setText("");
            tfMasalah.setText("");
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
