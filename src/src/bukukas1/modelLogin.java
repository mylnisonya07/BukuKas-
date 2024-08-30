/*
 BukuKas 
 */
package bukukas1;
/**
 *
 * @author AHMAD RIFA'I (20523007)
 */
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class modelLogin {
    
    String lbUsername;
    String lbGmail;

    //buat konstruktor yang isinya ada variable lokal

    public modelLogin(String lbUsername, String lbGmail) {
        this.lbUsername = lbUsername;
        this.lbGmail = lbGmail;
    }
    // method getter and setternya

    public String getLbUsername() {
        return lbUsername;
    }

    public void setLbUsername(String lbUsername) {
        this.lbUsername = lbUsername;
    }

    public String getLbGmail() {
        return lbGmail;
    }

    public void setLbGmail(String lbGmail) {
        this.lbGmail = lbGmail;
    }
    

    
    
    

    
    
    
    
    
    
}