package tokohpcvz;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Pembeli {
    private IntegerProperty IDpembeli;
    private StringProperty nama;
    private StringProperty alamat;
    private ArrayList<Detail> details;

    public Pembeli(Integer IDpembeli, String nama, String alamat,
        ArrayList<Detail> details) {
        this.IDpembeli=new SimpleIntegerProperty(IDpembeli);
        this.nama= new SimpleStringProperty(nama);
        this.alamat=new SimpleStringProperty(alamat);
        this.details = details;
    }
public Pembeli(Integer IDpembeli, String nama, String alamat, Detail detail) {
        details = new ArrayList<>();
        this.IDpembeli=new SimpleIntegerProperty(IDpembeli);
        this.nama=new SimpleStringProperty(nama);
        this.alamat=new SimpleStringProperty(alamat);
        this.details.add(detail);
    }

    public Integer getIDpembeli() {
        return IDpembeli.get();
    }

    public void setIDpembeli(Integer IDpembeli) {
        this.IDpembeli.set(IDpembeli);
    }

    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }

    public ArrayList<Detail> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<Detail> details) {
        this.details = details;
    }
    
    public IntegerProperty IDpembeliProperty(){
        return IDpembeli;
    }
    public StringProperty namaProperty(){
        return nama;
    }
    public StringProperty alamatProperty(){
        return alamat;
}
}
