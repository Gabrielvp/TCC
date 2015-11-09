package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ricardo.nene
 */
public class MySQL {

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String nomeServidor = "localhost";
            String database = "db_tcc";
            String url = "jdbc:mysql://" + "127.0.0.1" + "/" + "db_tcc";
            String username = "root";
            String password = "";

            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar com o banco de dados");
            e.printStackTrace();
            return null;
        }
    }
}
