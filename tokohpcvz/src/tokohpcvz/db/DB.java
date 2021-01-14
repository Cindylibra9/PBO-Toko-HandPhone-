/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokohpcvz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DB = "toko_hp";
    private static final String MYCONN = "jdbc:mysql://localhost/" + DB;
    private static final String SQCONN = "jdbc:sqlite:C:\\Users\\acer\\Downloads\\java hiya hiyaa\\sqliteDB\\toko_hp.sqlite";
    

public static Connection getConnection(String driver) throws SQLException {
        Connection conn = null;
        switch (driver) {
            case "SQLITE": {
                try {
                    Class.forName("org.sqlite.JDBC");
                    conn = DriverManager.getConnection(SQCONN);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Library tidak ada");
                    Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "MYSQL": {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(MYCONN, USER, PASSWORD);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Library tidak ada");
                    Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }

        return conn;
    }
}

