
package tokohpcvz;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tunai extends Pembeli {
    StringProperty tgl_bayar;

    public Tunai(Integer IDpembeli, String nama,
        String alamat, String tgl_pembayaran, ArrayList<Detail> details) {
        super(IDpembeli, nama, alamat, details);
        this.tgl_bayar = new SimpleStringProperty(tgl_pembayaran);
    }
    public Tunai(Integer IDpembeli, String nama, String alamat, String tgl_pembayaran, Detail detail) {
        super(IDpembeli, nama, alamat, detail);
        this.tgl_bayar = new SimpleStringProperty(tgl_pembayaran);
    }
    public String getTgl_bayar() {
        return tgl_bayar.get();
    }
   public void setTgl_bayar(String tgl_pembayaran) {
        this.tgl_bayar = new SimpleStringProperty(tgl_pembayaran);
    }
    public StringProperty tgl_bayarProperty() {
        return tgl_bayar;
    }
}
