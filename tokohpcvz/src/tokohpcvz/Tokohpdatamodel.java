package tokohpcvz;

import tokohpcvz.db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Tokohpdatamodel {

    public final Connection conn;

    public Tokohpdatamodel(String driver) throws SQLException {
        this.conn = DB.getConnection(driver);
    }

    public void addPembeli(Tunai pembeli) throws SQLException {
        String insertPembeli = "INSERT INTO pembeli(id_pembeli, nama, alamat)"
                + " VALUES (?,?,?)";
        String insertTunai = "INSERT INTO tunai(id_pembeli, tgl_bayar)"
                + " VALUES (?,?)";
        String insertDetail = "INSERT INTO detail(jenis_hp, harga, id_pembeli)"
                + " VALUES (?,?,?)";
        PreparedStatement stmtPembeli = conn.prepareStatement(insertPembeli);
        stmtPembeli.setInt(1, pembeli.getIDpembeli());
        stmtPembeli.setString(2, pembeli.getNama());
        stmtPembeli.setString(3, pembeli.getAlamat());
        stmtPembeli.execute();

        PreparedStatement stmtTunai = conn.prepareStatement(insertTunai);
        stmtTunai.setInt(1, pembeli.getIDpembeli());
        stmtTunai.setString(2, pembeli.getTgl_bayar());
        stmtTunai.execute();

        PreparedStatement stmtDetail = conn.prepareStatement(insertDetail);
        stmtDetail.setString(1, pembeli.getDetails().get(0).getJenisHp());
        stmtDetail.setDouble(2, pembeli.getDetails().get(0).getHargaHp());
        stmtDetail.setInt(3, pembeli.getIDpembeli());
        stmtDetail.execute();

    }

    public void addPembeli(Kredit pembeli) throws SQLException {
        String insertPembeli = "INSERT INTO pembeli(id_pembeli, nama, alamat)"
                + " VALUES (?,?,?)";
        String insertKredit = "INSERT INTO kredit(id_pembeli, kontak)"
                + " VALUES (?,?)";
        String insertDetail = "INSERT INTO detail(jenis_hp, harga, id_pembeli)"
                + " VALUES (?,?,?)";
        PreparedStatement stmtPembeli = conn.prepareStatement(insertPembeli);
        stmtPembeli.setInt(1, pembeli.getIDpembeli());
        stmtPembeli.setString(2, pembeli.getNama());
        stmtPembeli.setString(3, pembeli.getAlamat());
        stmtPembeli.execute();

        PreparedStatement stmtTunai = conn.prepareStatement(insertKredit);
        stmtTunai.setInt(1, pembeli.getIDpembeli());
        stmtTunai.setString(2, pembeli.getKontak());
        stmtTunai.execute();

        PreparedStatement stmtDetail = conn.prepareStatement(insertDetail);
        stmtDetail.setString(1, pembeli.getDetails().get(0).getJenisHp());
        stmtDetail.setDouble(2, pembeli.getDetails().get(0).getHargaHp());
        stmtDetail.setInt(3, pembeli.getIDpembeli());
        stmtDetail.execute();
    }

    public ObservableList<Tunai> getTunai() {
        ObservableList<Tunai> data = FXCollections.observableArrayList();
        String sql = "SELECT `id_pembeli`, `nama`, `alamat`, `tgl_bayar` "
                + "FROM `pembeli`"
                + "NATURAL JOIN `tunai` ORDER BY nama";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                String sqlDetail = "SELECT jenis_hp, harga "
                        + "FROM Detail WHERE id_pembeli=" + rs.getInt(1);
                ResultSet rsDetail = conn.createStatement().executeQuery(sqlDetail);
                ArrayList<Detail> dataDetail = new ArrayList<>();
                while (rsDetail.next()) {
                    dataDetail.add(new Detail(rsDetail.getString(1), rsDetail.getDouble(2)));
                }
                data.add(new Tunai(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), dataDetail));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Tokohpdatamodel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public ObservableList<Kredit> getKredit() {
        ObservableList<Kredit> data = FXCollections.observableArrayList();
        String sql = "SELECT `id_pembeli`, `nama`, `alamat`, `kontak` "
                + "FROM `pembeli`"
                + " NATURAL JOIN `kredit` ORDER BY nama";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                String sqlDetail = "SELECT jenis_hp, harga "
                        + "FROM Detail WHERE pembeli=" + rs.getInt(1);
                ResultSet rsDetail = conn.createStatement().executeQuery(sqlDetail);
                ArrayList<Detail> dataDetail = new ArrayList<>();
                while (rsDetail.next()) {
                    dataDetail.add(new Detail(rsDetail.getString(1), rsDetail.getDouble(2)));
                }
                data.add(new Kredit(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), dataDetail));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Tokohpdatamodel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public ObservableList<Detail> getDetail(int IDpembeli) {
        ObservableList<Detail> data = FXCollections.observableArrayList();
        String sql = "SELECT `jenis_hp`, `harga`"
                + "FROM `detail`"
                + "WHERE id_pembeli=" + IDpembeli;

        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                data.add(new Detail(rs.getString(1), rs.getDouble(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tokohpdatamodel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

    public int nextIDpembeli() throws SQLException {
        String sql = "SELECT MAX(id_pembeli) from pembeli";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()) {
            return rs.getInt(1) == 0 ? 1000001 : rs.getInt(1) + 1;
        }
        return 1000001;
    }

/*        public int nextJenisHP(int idpembeli) throws SQLException{
        String sql="SELECT MAX(jenis_hp) FROM Detail WHERE id_pembeli="+idpembeli;
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
            return rs.getInt(1)+1;
            }
            return 0;
        }*/
    
     public void addDetail(int IDpembeli, Detail acc) throws SQLException{
        String insertDetail = "INSERT INTO detail (id_pembeli, jenis_hp, harga)"
                + " VALUES (?,?,?)";
  
        PreparedStatement stmtDetail = conn.prepareStatement(insertDetail);
        stmtDetail.setInt(1, IDpembeli);
        stmtDetail.setString(2, acc.getJenisHp());
        stmtDetail.setDouble(3, acc.getHargaHp());
        stmtDetail.execute();
        
    }
    }
