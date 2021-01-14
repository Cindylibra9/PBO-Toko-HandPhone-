package tokohpcvz;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class FormPembeliController implements Initializable {

    @FXML
    private TextField tfIDPembeli;

    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfAlamat;

    @FXML
    private TextField tfJenisHP;

    @FXML
    private TextField tfHargaHP;

    @FXML
    private DatePicker dpTanggal;

    @FXML
    private Button btnTambahkan;

    @FXML
    private Button btnMuatUlang;

    @FXML
    private Button btnHapus;

    @FXML
    private TableView<Tunai> tblPembeli;

    @FXML
    private TableColumn<Tunai, Integer> colIDPembeli;

    @FXML
    private TableColumn<Tunai, String> colNama;

    @FXML
    private TableColumn<Tunai, String> colAlamat;

    @FXML
    private TableColumn<Tunai, String> colTanggal;

    @FXML
    private TableView<Detail> tblDetail;

    @FXML
    private TableColumn<Detail, String> colJenisHP;

    @FXML
    private TableColumn<Detail, Double> colHargaHP;

    @FXML
    private TextField tfNewJenisHP;

    @FXML
    private TextField tfNewHargaHP;

    @FXML
    private Button btnNewTambahkan;

    @FXML
    private TextField tfNewIDPembeli;

    @FXML
    private Label lblDBStatus;

    @FXML
    private Label lblSaveStatus;
    private Tokohpdatamodel ahdm;
    
    @FXML
   void handleTambahkanButton(ActionEvent event) {
     try {
            Detail acc =  new Detail (tfJenisHP.getText(),(Double.parseDouble(tfNewHargaHP.getText())));      
            ahdm.addDetail(Integer.parseInt(tfNewIDPembeli.getText()),acc);      
            viewDataDetail(Integer.parseInt(tfNewIDPembeli.getText()));
            btnMuatUlang.fire();
            tfNewHargaHP.setText("");
            
        } catch (SQLException ex) {
            Logger.getLogger(FormPembeliController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @FXML
    void handleTambahkanDataButton(ActionEvent event) {
        LocalDate ld = dpTanggal.getValue();
        String tanggal = String.format("%d-%02d-%02d", ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
        Tunai Pembeli = new Tunai(Integer.parseInt(tfIDPembeli.getText()),
                tfNama.getText(),
                tfAlamat.getText(),
                tanggal,
                new Detail(tfJenisHP.getText(),(Double.parseDouble(tfNewHargaHP.getText()))));
        try {
            ahdm.addPembeli (Pembeli);
            lblSaveStatus.setText("Detail berhasil dibuat");
            btnMuatUlang.fire();
            btnHapus.fire();
            lblSaveStatus.setText("Detail gagal dibuat");
    }   catch (SQLException ex) {
            Logger.getLogger(FormPembeliController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void handleHapusButton(ActionEvent event) {
        try {
            tfIDPembeli.setText("" + ahdm.nextIDPembeli());
            tfJenisHP.setText(tfIDPembeli.getText() + "01");
            tfNama.setText("");
            tfAlamat.setText("");
            tfHargaHP.setText("");
            dpTanggal.setValue(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()));
        } catch (SQLException ex) {
            Logger.getLogger(FormPembeliController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
 @FXML
    void handleMuatUlangButton(ActionEvent event) {
        ObservableList<Tunai> data = ahdm.getTunaiPembeli();
        colIDPembeli.setCellValueFactory(new PropertyValueFactory<>("idpembeli"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        colJenisHP.setCellValueFactory(new PropertyValueFactory<>("jenishp"));
        tblPembeli.setItems(null);
        tblPembeli.setItems(data);
        btnTambahkan.setDisable(true);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       try {
            ahdm = new Tokohpdatamodel("MYSQL");
            lblDBStatus.setText(ahdm.conn == null ? "Not Connected" : "Connected");
            btnHapus.fire();
            btnMuatUlang.fire();
        } catch (SQLException ex) {
            Logger.getLogger(FormPembeliController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tblPembeli.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if (tblPembeli.getSelectionModel().getSelectedItem()!=null){
                Pembeli pembeli =  tblPembeli.getSelectionModel().getSelectedItem();
                viewDataDetail(pembeli.getIDpembeli());
                btnTambahkan.setDisable(false);
                tfNewIDPembeli.setText(""+pembeli.getIDpembeli());
                try {
                    tfNewJenisHP.setText(""+ahdm.nextJenisHP(pembeli.getIDpembeli()));
                } catch (SQLException ex) {
                    Logger.getLogger(FormPembeliController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
    

        public void viewDataDetail(int IDPembeli) {
        ObservableList<Detail> data = ahdm.getDetail(IDPembeli);
        colJenisHP.setCellValueFactory(new PropertyValueFactory<>("JenisHP"));
        colHargaHP.setCellValueFactory(new PropertyValueFactory<>("HargaHP"));
        tblPembeli.setItems(null);
        tblDetail.setItems(data);
        }
    }



