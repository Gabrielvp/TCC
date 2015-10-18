package dao;

import entity.CReceber;
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
public class CReceberDAO extends MySQL {

    SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");

    public boolean insert(CReceber creceber) {

        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO creceber (formPagamento, fatura, total, data, vencimento, parcelas, idPessoa, pessoa)"
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, creceber.getFormPagamento());
            ps.setString(2, creceber.getFatura());
            ps.setDouble(3, creceber.getTotal());
            ps.setString(4, sdfD.format(creceber.getData()));
            ps.setString(5, sdfD.format(creceber.getVencimento()));
            ps.setInt(6, creceber.getParcelas());
            ps.setInt(7, creceber.getIdPessoa());
            ps.setString(8, creceber.getPessoa());
           

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int resultado = rs.getInt(1);
            creceber.setIdCReceber(resultado);
            rs.close();

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
    
    public boolean updateParcela(CReceber creceber) {

        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("UPDATE CReceber SET parcelas = ? WHERE fatura = ?");
                           
            ps.setInt(1, creceber.getParcelas());
            ps.setString(2, creceber.getFatura());
            

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
    
    public List<CReceber> listarCReceberString(String fat) {
        List<CReceber> listarCReceber = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select formPagamento, fatura, total, data, vencimento, parcelas from cReceber where fatura = ?");
            ps.setString(1, fat);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CReceber cr = new CReceber();
                cr.setFormPagamento(rs.getString("formPagamento"));
                cr.setFatura(rs.getString("fatura"));
                cr.setTotal(rs.getDouble("Total"));
                cr.setData(rs.getDate("Data"));
                cr.setVencimento(rs.getDate("Vencimento"));     
                cr.setParcelas(rs.getInt("Parcelas"));     
                listarCReceber.add(cr);
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
        return listarCReceber;
    }    
    
    public List<CReceber> listarCReceber(int id) {
        List<CReceber> listarCReceber = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select formPagamento, fatura, total, data, vencimento, parcelas from cReceber where idPessoa = ?");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CReceber cr = new CReceber();
                cr.setFormPagamento("formPagamento");
                cr.setFatura(rs.getString("fatura"));
                cr.setTotal(rs.getDouble("Total"));
                cr.setData(rs.getDate("Data"));
                cr.setVencimento(rs.getDate("Vencimento"));    
                cr.setParcelas(rs.getInt("parcelas"));
                listarCReceber.add(cr);
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
        return listarCReceber;
    }   
}
