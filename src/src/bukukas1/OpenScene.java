/*
 BukuKas 
 */
package bukukas1;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import bukukas1.BukuKas;
import javafx.stage.Stage;
/**
 *
 * @author 
 */
public class OpenScene {
    private Pane halaman;
   // Stage popupStage = new Stage();
    
    public Pane getPane(String page){
        try{
            URL fileHalaman = BukuKas.class.getResource("/bukukas1/"+page+".fxml");
            
            if(fileHalaman==null){
                throw new java.io.FileNotFoundException("Halaman"+page+ "tidak ditemukan");
            }
            halaman = new FXMLLoader().load(fileHalaman);
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Tidak ditemukan halaman tersebut "+page);
        }
        return halaman;
    }
    
}
