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
  public static void createTable(Connection conn, String driver) throws SQLException {
        String sqlCreate = "";
        switch (driver) {
            case "MYSQL": {
                sqlCreate = "CREATE TABLE IF NOT EXISTS `account_holder` ("
                        + "  `id_pembeli` int(10) NOT NULL,"
                        + "  `nama` varchar(30) DEFAULT NULL,"
                        + "  `alamat` varchar(50) DEFAULT NULL,"
                        + "  PRIMARY KEY (`id_pembeli`)"
                        + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;"
                        + "CREATE TABLE IF NOT EXISTS `detail` ("
                        + "  `jenis_hp` varchar(30) DEFAULT NULL,"
                        + "  `harga` double(16,2) DEFAULT NULL,"
                        + "  `id_pembeli` int(10) DEFAULT NULL,"
                        + "  KEY `id_pembeli` (`id_pembeli`),"
                        + "  FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id_pembeli`) ON UPDATE CASCADE"
                        + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;"
                        + "CREATE TABLE IF NOT EXISTS `kredit` ("
                        + "  `id_pembeli` int(10) NOT NULL,"
                        + "  `kontak` varchar(50) DEFAULT NULL,"
                        + "  PRIMARY KEY (`id_pembeli`),"
                        + "  FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id_pembeli`) ON UPDATE CASCADE"
                        + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;"
                        + "CREATE TABLE IF NOT EXISTS `tunai` ("
                        + "  `id_pembeli` int(10) NOT NULL,"
                        + "  `tgl_bayar` date DEFAULT NULL,"
                        + "  PRIMARY KEY (`id_pembeli`),"
                        + "  FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id_pembeli`) ON UPDATE CASCADE"
                        + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
                break;
            }
            case "SQLITE": {
                sqlCreate = "CREATE TABLE IF NOT EXISTS  account_holder ("
                        + "    id_pembeli INT (10)      PRIMARY KEY,"
                        + "    nama      VARCHAR (30),"
                        + "    alamat   VARCHAR (50) "
                        + ");"
                        + "CREATE TABLE IF NOT EXISTS account ("
                        + "    jenis_hp VARCHAR (30),"
                        + "    harga    DOUBLE (16, 2),"
                        + "    id_pembeli  INT (10)       REFERENCES pembeli (id_pembeli) ON DELETE RESTRICT"
                        + "                                                                    ON UPDATE CASCADE"
                        + ");"
                        + "CREATE TABLE IF NOT EXISTS kredit ("
                        + "    id_pembeli INT (10)      PRIMARY KEY"
                        + "                            REFERENCES pembeli (id_pembeli) ON DELETE RESTRICT"
                        + "                                                                    ON UPDATE CASCADE"
                        + "    kontak   VARCHAR (50) "
                        + ");"
                        + "CREATE TABLE IF NOT EXISTS  tunai ("
                        + "    id_pembeli INT (10)      PRIMARY KEY"
                        + "                            REFERENCES pembeli (id_pembeli) ON DELETE RESTRICT"
                        + "                                                                    ON UPDATE CASCADE"
                        + "    tgl_bayar DATE"
                        + ");";
                break;
            }
        }
        String sqls[] = sqlCreate.split(";");
        for (String sql : sqls) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
        }
    }
}


