package tokohpcvz;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Detail {
    private final StringProperty jenisHp;
    private final DoubleProperty hargaHp;

    public Detail(String jenisHp, double hargaHp) {
        this.jenisHp=new SimpleStringProperty(jenisHp);
        this.hargaHp=new SimpleDoubleProperty(hargaHp);
    }

    public Double getHargaHp() {
        return hargaHp.get();
    }

    public void setHargaHp(double hargaHp) {
        this.hargaHp.set(hargaHp);
    }

    public String getJenisHp() {
        return jenisHp.get();
    }

    public void setJenisHp(String jenisHp) {
        this.jenisHp.set(jenisHp);
    }
    
    public StringProperty jenisHpProperty(){
        return jenisHp;
    }
    public DoubleProperty hargaHpProperty(){
        return hargaHp;
    }
}
