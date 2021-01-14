/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokohpcvz;

import tokohpcvz.db.DB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FormPembeli.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Toko Handphone CVZ");
        stage.setScene(scene);
        stage.show();
    }
    
 public static void main(String[] args) {
 /*       try {
            Tokohpdatamodel ahdm = new Tokohpdatamodel("MYSQL");
            Tunai ih = new Tunai(6, "Vadella", "Pesawaran", "2020-09-09", new Detail("Samsung A5", 40000000.00));
            ahdm.addPembeli(ih);
            System.out.println("Sukses ditambahkan");*/
            launch(args);
/*       } catch (SQLException ex) {
            System.out.println("Gagal ditambahkan");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}