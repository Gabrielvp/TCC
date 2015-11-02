package dao;

import entity.CPagar;
import entity.CReceber;
import entity.Pessoa;
import java.sql.Connection;
import java.sql.Date;
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
public class CPagarDAO extends MySQL {

    SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");

    public boolean insert(CPagar cpagar) {

        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO cpagar (fatura, total, data, vencimento, parcelas, idPessoa, formPagamento, aVista)"
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, cpagar.getFatura());
            ps.setDouble(2, cpagar.getTotal());
            ps.setString(3, sdfD.format(cpagar.getData()));
            ps.setString(4, sdfD.format(cpagar.getVencimento()));
            ps.setInt(5, cpagar.getParcelas());
            ps.setInt(6, cpagar.getIdPessoa());
            ps.setString(7, cpagar.getFormPagamento());
            ps.setBoolean(8, cpagar.isaVista());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int resultado = rs.getInt(1);
            cpagar.setIdCPagar(resultado);
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
    
    public boolean updateParcela(CPagar cpagar) {

        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("UPDATE CPagar SET parcelas = ? WHERE fatura = ?");
                           
            ps.setInt(1, cpagar.getParcelas());
            ps.setString(2, cpagar.getFatura());
            

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
    
    public List<CPagar> listarCPagar(int id) {
        List<CPagar> listarCPagar = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select formPagamento, fatura, total, data, vencimento, parcelas from cPagar where idPessoa = ?");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CPagar cp = new CPagar();
                cp.setFormPagamento("formPagamento");
                cp.setFatura(rs.getString("fatura"));
                cp.setTotal(rs.getDouble("Total"));
                cp.setData(rs.getDate("Data"));
                cp.setVencimento(rs.getDate("Vencimento"));    
                cp.setParcelas(rs.getInt("parcelas"));
                listarCPagar.add(cp);
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
        return listarCPagar;
    }   
    
    public List<CPagar> listarCPagarString(String fat) {
        List<CPagar> listarCPagar = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select formPagamento, fatura, total, data, vencimento, parcelas from cPagar where fatura = ?");
            ps.setString(1, fat);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CPagar cp = new CPagar();
                cp.setFormPagamento(rs.getString("formPagamento"));
                cp.setFatura(rs.getString("fatura"));
                cp.setTotal(rs.getDouble("Total"));
                cp.setData(rs.getDate("Data"));
                cp.setVencimento(rs.getDate("Vencimento"));     
                cp.setParcelas(rs.getInt("Parcelas"));     
                listarCPagar.add(cp);
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
        return listarCPagar;
    }   

    public void delete(int id, String fat) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM cpagar where idPessoa = ? and fatura = ? ");
                  
            ps.setInt(1, id);
            ps.setString(2, fat);

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
    
    public List<CPagar> listarCPagarAVista(Date data) {
        List<CPagar> listarCPagar = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select formPagamento, fatura, total, data, vencimento, parcelas, pessoa.nome, cpagar.idpessoa"
                    + " from cpagar inner join pessoa on cpagar.idpessoa = pessoa.idpessoa where aVista = 1 and data = ?");
            ps.setDate(1, data);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CPagar cp = new CPagar();
                Pessoa p = new Pessoa();
                cp.setFormPagamento(rs.getString("formPagamento"));
                cp.setFatura(rs.getString("fatura"));
                cp.setTotal(rs.getDouble("Total"));
                cp.setData(rs.getDate("Data"));
                cp.setVencimento(rs.getDate("Vencimento"));
                cp.setParcelas(rs.getInt("parcelas"));
                cp.setIdPessoa(rs.getInt("idPessoa"));
                p.setNome(rs.getString("Nome"));
                p.setIdPessoa(rs.getInt("idPessoa"));
                cp.setP(p);
                listarCPagar.add(cp);
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
        return listarCPagar;
    }  
    
    public List<CPagar> listarCPagarPrazo(Date data) {
        List<CPagar> listarCPagar = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select formPagamento, fatura, total, data, vencimento, parcelas, pessoa.nome, cpagar.idpessoa"
                    + " from cpagar inner join pessoa on cpagar.idpessoa = pessoa.idpessoa where aVista = 0 and data = ?");
            ps.setDate(1, data);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CPagar cp = new CPagar();
                Pessoa p = new Pessoa();
                cp.setFormPagamento(rs.getString("formPagamento"));
                cp.setFatura(rs.getString("fatura"));
                cp.setTotal(rs.getDouble("Total"));
                cp.setData(rs.getDate("Data"));
                cp.setVencimento(rs.getDate("Vencimento"));
                cp.setParcelas(rs.getInt("parcelas"));
                cp.setIdPessoa(rs.getInt("idPessoa"));
                p.setNome(rs.getString("Nome"));
                p.setIdPessoa(rs.getInt("idPessoa"));
                cp.setP(p);
                listarCPagar.add(cp);
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
        return listarCPagar;
    }  
    
     public List<CPagar> listarCPagarPrazoPeriodo(Date data, Date fim) {
        List<CPagar> listarCPagar = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select formPagamento, fatura, total, data, vencimento, parcelas, pessoa.nome, cpagar.idpessoa"
                    + " from cpagar inner join pessoa on cpagar.idpessoa = pessoa.idpessoa where aVista = 0 and data between ? and ?");
            ps.setDate(1, data);
            ps.setDate(2, fim);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CPagar cp = new CPagar();
                Pessoa p = new Pessoa();
                cp.setFormPagamento(rs.getString("formPagamento"));
                cp.setFatura(rs.getString("fatura"));
                cp.setTotal(rs.getDouble("Total"));
                cp.setData(rs.getDate("Data"));
                cp.setVencimento(rs.getDate("Vencimento"));
                cp.setParcelas(rs.getInt("parcelas"));
                cp.setIdPessoa(rs.getInt("idPessoa"));
                p.setNome(rs.getString("Nome"));
                p.setIdPessoa(rs.getInt("idPessoa"));
                cp.setP(p);
                listarCPagar.add(cp);
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
        return listarCPagar;
    }
     
     public List<CPagar> listarCPagarVistaPeriodo(Date data, Date fim) {
        List<CPagar> listarCPagar = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select formPagamento, fatura, total, data, vencimento, parcelas, pessoa.nome, cpagar.idpessoa"
                    + " from cPagar inner join pessoa on cpagar.idpessoa = pessoa.idpessoa where aVista = 1 and data between ? and ?");
            ps.setDate(1, data);
            ps.setDate(2, fim);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CPagar cp = new CPagar();
                Pessoa p = new Pessoa();
                cp.setFormPagamento(rs.getString("formPagamento"));
                cp.setFatura(rs.getString("fatura"));
                cp.setTotal(rs.getDouble("Total"));
                cp.setData(rs.getDate("Data"));
                cp.setVencimento(rs.getDate("Vencimento"));
                cp.setParcelas(rs.getInt("parcelas"));
                cp.setIdPessoa(rs.getInt("idPessoa"));
                p.setNome(rs.getString("Nome"));
                p.setIdPessoa(rs.getInt("idPessoa"));
                cp.setP(p);
                listarCPagar.add(cp);
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
        return listarCPagar;
    }
}