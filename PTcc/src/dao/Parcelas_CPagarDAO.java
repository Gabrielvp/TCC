package dao;

import entity.Parcelas_CPagar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author ricardonene
 */
public class Parcelas_CPagarDAO extends MySQL {

    SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");

    public boolean insert(Parcelas_CPagar pCPagar) {

        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO parcelas_cpagar (fatura, parcelas, valor, entrada, vencimento, intervalo, idCPagar)"
                            + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, pCPagar.getFatura());
            ps.setString(2, pCPagar.getParcelas());
            ps.setDouble(3, pCPagar.getValor());
            ps.setString(4, sdfD.format(pCPagar.getEntrada()));
            ps.setString(5, sdfD.format(pCPagar.getVencimento()));
            ps.setInt(6, pCPagar.getIntervalo());
            ps.setInt(7, pCPagar.getIdCPagar());

            ps.execute();
            ps.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}
