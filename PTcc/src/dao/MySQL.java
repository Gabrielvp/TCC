package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ricardo.nene
 */
public class MySQL {

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String nomeServidor = "localhost";
            String database = "bd_tcc";
            String url = "jdbc:mysql://" + "127.0.0.1" + "/" + "bd_tcc";
            String username = "root";
            String password = "";

            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }
}