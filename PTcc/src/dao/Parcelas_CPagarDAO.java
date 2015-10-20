package dao;

import entity.Parcelas_CPagar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
                    = c.prepareStatement("INSERT INTO parcelas_cpagar (fatura, parcela, valor, entrada, vencimento, intervalo, idCPagar)"
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

    public List<Parcelas_CPagar> listarParcelasString(String fat) {
        List<Parcelas_CPagar> listarParcelas = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select parcela, valor, vencimento, intervalo, entrada from Parcelas_cpagar where fatura = ?");
            ps.setString(1, fat);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Parcelas_CPagar cp = new Parcelas_CPagar();
                cp.setParcelas(rs.getString("parcelas"));
                cp.setValor(rs.getDouble("valor"));
                cp.setVencimento(rs.getDate("Vencimento"));
                cp.setIntervalo(rs.getInt("Intervalo"));
                cp.setEntrada(rs.getDate("Entrada"));
                listarParcelas.add(cp);
            }

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listarParcelas;
    }

    public void delete(String fat) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM parcelas_cpagar where fatura = ?");                    

            ps.setString(1, fat);

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
