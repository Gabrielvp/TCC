package dao;

import entity.Parcelas_CPagar;
import entity.Parcelas_CReceber;
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
public class Parcelas_CReceberDAO extends MySQL {

    SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");

    public boolean insert(Parcelas_CReceber pCReceber) {

        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO parcelas_creceber (fatura, parcelas, valor, entrada, vencimento, intervalo, idOrcamento, idCReceber)"
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, pCReceber.getFatura());
            ps.setString(2, pCReceber.getParcelas());
            ps.setDouble(3, pCReceber.getValor());
            ps.setString(4, sdfD.format(pCReceber.getEntrada()));
            ps.setString(5, sdfD.format(pCReceber.getVencimento()));
            ps.setInt(6, pCReceber.getIntervalo());
            ps.setInt(7, pCReceber.getIdOrcamento());
            ps.setInt(8, pCReceber.getIdCReceber());

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
    
    public List<Parcelas_CReceber> listarParcelasString(String fat) {
        List<Parcelas_CReceber> listarParcelas = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select parcelas, valor, vencimento, intervalo, entrada, idOrcamento from Parcelas_creceber where fatura = ?");
            ps.setString(1, fat);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Parcelas_CReceber cr = new Parcelas_CReceber();
                cr.setParcelas(rs.getString("parcelas"));
                cr.setValor(rs.getDouble("valor"));
                cr.setVencimento(rs.getDate("Vencimento"));
                cr.setIntervalo(rs.getInt("Intervalo"));
                cr.setEntrada(rs.getDate("Entrada"));
                cr.setIdOrcamento(rs.getInt("idOrcamento"));
                listarParcelas.add(cr);
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
            PreparedStatement ps = c.prepareStatement("DELETE FROM parcelas_creceber where fatura = ?");                    

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
