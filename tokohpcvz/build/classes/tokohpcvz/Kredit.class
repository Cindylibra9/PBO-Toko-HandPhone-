/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokohpcvz;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Kredit extends Pembeli{
    StringProperty kontak;

    public Kredit(Integer IDpembeli, String nama, String alamat, String kontak, ArrayList<Detail> details) {
        super(IDpembeli, nama, alamat, details);
        this.kontak=new SimpleStringProperty(kontak);
    }

    public Kredit(Integer IDpembeli, String nama, String alamat, String kontak, Detail detail) {
        super(IDpembeli, nama, alamat, detail);
        this.kontak.set(kontak);
    }

    public String getKontak() {
        return kontak.get();
    }

    public void setKontak(String kontak) {
        this.kontak.set(kontak);
    }
    public StringProperty kontakProperty() {
        return kontak;
    }
}

