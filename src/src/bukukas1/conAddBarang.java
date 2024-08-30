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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author DIMAS ZAECA WARDANA (20523003)
 */
public class conAddBarang implements Initializable {
    
    
    //deklarasi untuk objek fxml
    
    
    @FXML
    private TextField textF1;
    
    @FXML
    private TextField textF2;
    
    @FXML
    private TableView tblV;
    
    @FXML
    private TableColumn tcNama;
    
    @FXML
    private TableColumn tcJumlah;
    
    @FXML
    private Label excep;
    
    ArrayList<modelStokBarang> mtal = new ArrayList<>();
    modelStokBarang sb;
    ObservableList data = observableArrayList();
    XStream xs = new XStream(new StaxDriver());

    
    @FXML
    private void tambahBarang(ActionEvent event) {
            String Temp1 = textF1.getText();
            String Temp2 = textF2.getText();
            sb = new modelStokBarang(Temp1, Temp2);
            mtal.add(sb);
            data.add(sb);
            textF1.setText("");
            textF2.setText("");
            String xml = xs.toXML(mtal);
                    FileOutputStream save = null;
                    try {
                        save = new FileOutputStream("dataBarang.xml");
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
    }
    void bukaXML(){
        FileInputStream open = null;
        try {
            open = new FileInputStream("dataBarang.xml");
            int isi;
            char charnya;
            String stringnya;
            stringnya ="";
            while ((isi = open.read()) != -1) {
                charnya= (char) isi;
                stringnya = stringnya + charnya;
            }    
            mtal = (ArrayList<modelStokBarang>) xs.fromXML(stringnya);	  
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
    }
    @FXML
    private void hapusBarang(ActionEvent event) {
        try{
            int slcIndex = tblV.getSelectionModel().getSelectedIndex();
            tblV.getItems().remove(slcIndex); //hapus data di kolom yang dipilih
            mtal.remove(slcIndex); // hapus data arraylist yang di xml dataBarang
            
            String xml = xs.toXML(mtal);
            FileOutputStream output = null;
            try{
                output = new FileOutputStream("dataBarang.xml");
                byte[] bytes = xml.getBytes("UTF-8");
                output.write(bytes);    
            }catch (Exception e) {
            System.err.println("Perhatian: " + e.getMessage());
            } 
            finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Perhatian: "+e.getMessage());
            excep.setText("Anda belum memilih barang yang akan dihapus");
        }
        
        
    }
    
//    @FXML
//    private void editBarang(TableColumn.CellEditEvent<modelStokBarang, String> editbarang) {
////        this.sb =  (modelStokBarang) tblV.getSelectionModel().getSelectedItem();
////        this.sb = sb;
////        sb.setNama(Nama);
////        sb.setJumlah(Jumlah);
////        bukaXML();
//// fersi temen 
//          modelStokBarang barang = (modelStokBarang) tblV.getSelectionModel().getSelectedItem();
//          barang.setNama(editbarang.getNewValue());
//          barang.setJumlah(editbarang.getNewValue());
//        
//    }


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO mengsett column
        tcNama.setCellValueFactory(new PropertyValueFactory<modelStokBarang, String>("Nama"));
        tcJumlah.setCellValueFactory(new PropertyValueFactory<modelStokBarang, String>("Jumlah"));
        //tblV.setItems(data);
        bukaXML();
        for (int i = 0; i < mtal.size(); i++){
            data.add(mtal.get(i));
        }
        tblV.setItems(data);
    }    
    
}
