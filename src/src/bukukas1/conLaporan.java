/*
 BukuKas 
 */
package bukukas1;

import java.net.URL;
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
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LEO AGUS SAPUTRA (20523048)
 */
public class conLaporan implements Initializable {

    
    @FXML 
    private RadioButton rbPdf;
    @FXML 
    private RadioButton rbAxcel;
     @FXML 
    private ChoiceBox cbLaporan;
    
    
    @FXML 
    private void unduh(ActionEvent event){
        if((!rbPdf.isSelected()&&rbAxcel.isSelected())||(rbPdf.isSelected()&&!rbAxcel.isSelected())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informasi");
            alert.setHeaderText(null);
            alert.setContentText("Laporan Anda berhasil diunduh!");    
            alert.showAndWait();
        }else if(rbPdf.isSelected()&& rbAxcel.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Perhatian");
            alert.setHeaderText(null);
            alert.setContentText("Pilih salah satu format file");    
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pehatian");
            alert.setHeaderText("Gagal melakukan Unduh!");
            alert.setContentText("Silahkan pilih format file yang akan diunduh");    
            alert.showAndWait();    
    }
    }
     @FXML 
    private void cetak(ActionEvent event){
        if((!rbPdf.isSelected()&&rbAxcel.isSelected())||(rbPdf.isSelected()&&!rbAxcel.isSelected())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informasi");
            alert.setHeaderText(null);
            alert.setContentText("Laporan Anda sedang dicetak");    
            alert.showAndWait();
        }else if(rbPdf.isSelected()&& rbAxcel.isSelected()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Perhatian");
            alert.setHeaderText(null);
            alert.setContentText("Pilih salah satu format file");    
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Pehatian");
            alert.setHeaderText("Gagal melakukan cetak!");
            alert.setContentText("Silahkan pilih format file yang akan dicetak");    
            alert.showAndWait();
        }    
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbLaporan.getItems().addAll("Laporan Transaksi","Laporan Keuntungan", "Laporan Penjualan", "Laporan Kerugian");
        cbLaporan.setValue("Laporan Transaksi");
    }    

    
    
}
