package dao;

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
import javax.swing.JOptionPane;

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
                    = c.prepareStatement("INSERT INTO creceber (formPagamento, fatura, total, data, vencimento, parcelas, idPessoa, pessoa, aVista)"
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, creceber.getFormPagamento());
            ps.setString(2, creceber.getFatura());
            ps.setDouble(3, creceber.getTotal());
            ps.setString(4, sdfD.format(creceber.getData()));
            ps.setString(5, sdfD.format(creceber.getVencimento()));
            ps.setInt(6, creceber.getParcelas());
            ps.setInt(7, creceber.getIdPessoa());
            ps.setString(8, creceber.getPessoa());
            ps.setBoolean(9, creceber.isaVista());

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

    public void delete(int id, String fat) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM creceber where idPessoa = ? and fatura = ? ");

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
    
    public void update(CReceber creceber, String fatura) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE CReceber SET formPagamento = ?, fatura = ?, total = ?, data = ?, vencimento = ?, parcelas = ?"
                    + " idPessoa = ?, pessoa = ? aVista = ? WHERE fatura = ? ");

            ps.setString(1, creceber.getFormPagamento());
            ps.setString(2, creceber.getFatura());
            ps.setDouble(3, creceber.getTotal());
            ps.setString(4, sdfD.format(creceber.getData()));
            ps.setString(5, sdfD.format(creceber.getVencimento()));
            ps.setInt(6, creceber.getParcelas());
            ps.setInt(7, creceber.getIdPessoa());
            ps.setString(8, creceber.getPessoa());
            ps.setBoolean(9, creceber.isaVista());
            ps.setString(10, fatura);

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
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
        }
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

    public List<CReceber> listarCReceberAVista(Date data) {
        List<CReceber> listarCReceber = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select formPagamento, fatura, total, data, vencimento, parcelas, pessoa.nome, creceber.idpessoa"
                    + " from cReceber inner join pessoa on creceber.idpessoa = pessoa.idpessoa where aVista = 1 and data = ?");
            ps.setDate(1, data);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CReceber cr = new CReceber();
                Pessoa p = new Pessoa();
                cr.setFormPagamento(rs.getString("formPagamento"));
                cr.setFatura(rs.getString("fatura"));
                cr.setTotal(rs.getDouble("Total"));
                cr.setData(rs.getDate("Data"));
                cr.setVencimento(rs.getDate("Vencimento"));
                cr.setParcelas(rs.getInt("parcelas"));
                cr.setIdPessoa(rs.getInt("idPessoa"));
                p.setNome(rs.getString("Nome"));
                p.setIdPessoa(rs.getInt("idPessoa"));
                cr.setP(p);
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
    
    public List<CReceber> listarCReceberPrazo(Date data) {
        List<CReceber> listarCReceber = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select formPagamento, fatura, total, data, vencimento, parcelas, pessoa.nome, creceber.idpessoa"
                    + " from cReceber inner join pessoa on creceber.idpessoa = pessoa.idpessoa where aVista = 0 and data = ?");
            ps.setDate(1, data);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CReceber cr = new CReceber();
                Pessoa p = new Pessoa();
                cr.setFormPagamento(rs.getString("formPagamento"));
                cr.setFatura(rs.getString("fatura"));
                cr.setTotal(rs.getDouble("Total"));
                cr.setData(rs.getDate("Data"));
                cr.setVencimento(rs.getDate("Vencimento"));
                cr.setParcelas(rs.getInt("parcelas"));
                cr.setIdPessoa(rs.getInt("idPessoa"));
                p.setNome(rs.getString("Nome"));
                p.setIdPessoa(rs.getInt("idPessoa"));
                cr.setP(p);
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
    
    public List<CReceber> listarCReceberVistaPeriodo(Date data, Date fim) {
        List<CReceber> listarCReceber = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select formPagamento, fatura, total, data, vencimento, parcelas, pessoa.nome, creceber.idpessoa"
                    + " from cReceber inner join pessoa on creceber.idpessoa = pessoa.idpessoa where aVista = 1 and data between ? and ?");
            ps.setDate(1, data);
            ps.setDate(2, fim);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CReceber cr = new CReceber();
                Pessoa p = new Pessoa();
                cr.setFormPagamento(rs.getString("formPagamento"));
                cr.setFatura(rs.getString("fatura"));
                cr.setTotal(rs.getDouble("Total"));
                cr.setData(rs.getDate("Data"));
                cr.setVencimento(rs.getDate("Vencimento"));
                cr.setParcelas(rs.getInt("parcelas"));
                cr.setIdPessoa(rs.getInt("idPessoa"));
                p.setNome(rs.getString("Nome"));
                p.setIdPessoa(rs.getInt("idPessoa"));
                cr.setP(p);
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
    
    public List<CReceber> listarCReceberPrazoPeriodo(Date data, Date fim) {
        List<CReceber> listarCReceber = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select formPagamento, fatura, total, data, vencimento, parcelas, pessoa.nome, creceber.idpessoa"
                    + " from cReceber inner join pessoa on creceber.idpessoa = pessoa.idpessoa where aVista = 0 and data between ? and ?");
            ps.setDate(1, data);
            ps.setDate(2, fim);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CReceber cr = new CReceber();
                Pessoa p = new Pessoa();
                cr.setFormPagamento(rs.getString("formPagamento"));
                cr.setFatura(rs.getString("fatura"));
                cr.setTotal(rs.getDouble("Total"));
                cr.setData(rs.getDate("Data"));
                cr.setVencimento(rs.getDate("Vencimento"));
                cr.setParcelas(rs.getInt("parcelas"));
                cr.setIdPessoa(rs.getInt("idPessoa"));
                p.setNome(rs.getString("Nome"));
                p.setIdPessoa(rs.getInt("idPessoa"));
                cr.setP(p);
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
