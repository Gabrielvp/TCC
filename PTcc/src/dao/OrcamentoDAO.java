package dao;

import entity.Orcamento;
import entity.Produto;
import entity.ProdutoOrcamento;
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
public class OrcamentoDAO extends MySQL {

    SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");

    public boolean insert(Orcamento orcamento) {

        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO orcamento (data, cliente, total, desconto, idPessoa, aprovado)"
                            + "VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, sdfD.format(orcamento.getData()));
            ps.setString(2, orcamento.getNome());
            ps.setDouble(3, orcamento.getTotal());
            ps.setDouble(4, orcamento.getDesconto());
            ps.setInt(5, orcamento.getIdPessoa());
            ps.setBoolean(6, orcamento.isAprovado());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int resultado = rs.getInt(1);
            orcamento.setIdOrcamento(resultado);
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

    public void update(int id) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE orcamento SET aprovado = true WHERE idOrcamento = ? ");
            Orcamento orcamento = new Orcamento();
            ps.setInt(1, id);

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

    public void updateOrcameto(Orcamento orcamento) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE orcamento SET cliente = ?, total = ?, desconto = ?, idPessoa = ? WHERE idOrcamento = ? ");

            ps.setString(1, orcamento.getNome());
            ps.setDouble(2, orcamento.getTotal());
            ps.setDouble(3, orcamento.getDesconto());
            ps.setInt(4, orcamento.getIdPessoa());
            ps.setInt(5, orcamento.getIdOrcamento());

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

    public void delete(int id) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM orcamento "
                    + "WHERE idOrcamento = ?");

            ps.setInt(1, id);

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

    public List<Orcamento> listarOrcamentos() {
        List<Orcamento> listarOrcamentos = new ArrayList<Orcamento>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select orcamento.data, orcamento.idOrcamento, orcamento.cliente, orcamento.total, orcamento.aprovado from orcamento");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orcamento orcamento = new Orcamento();
                Produto produto = new Produto();
                ProdutoOrcamento pOrcamento = new ProdutoOrcamento();

                orcamento.setData(rs.getDate("Data"));
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setNome(rs.getString("Cliente"));
                orcamento.setTotal(rs.getDouble("Total"));
                orcamento.setAprovado(rs.getBoolean("Aprovado"));
                listarOrcamentos.add(orcamento);
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
        return listarOrcamentos;
    }

    public List<Orcamento> listarOrcamentosPessoa(int id) {
        List<Orcamento> listarOrcamentos = new ArrayList<Orcamento>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select orcamento.data, orcamento.idOrcamento, orcamento.cliente, orcamento.total, orcamento.aprovado from orcamento where idPessoa = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orcamento orcamento = new Orcamento();
                orcamento.setData(rs.getDate("Data"));
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setNome(rs.getString("Cliente"));
                orcamento.setTotal(rs.getDouble("Total"));
                orcamento.setAprovado(rs.getBoolean("Aprovado"));
                listarOrcamentos.add(orcamento);
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
        return listarOrcamentos;
    }

    public List<Orcamento> listaOrcamentoId(int id) {
        List<Orcamento> listaOrcamentoId = new ArrayList<>();
        Connection c = this.getConnection();
        Orcamento orcamento = new Orcamento();

        try {
            PreparedStatement ps = c.prepareStatement("select orcamento.data, orcamento.idOrcamento, orcamento.cliente, orcamento.total, orcamento.aprovado from orcamento WHERE idOrcamento = ?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setData(rs.getDate("Data"));
                orcamento.setNome(rs.getString("Cliente"));
                orcamento.setAprovado(rs.getBoolean("Aprovado"));
                orcamento.setTotal(rs.getDouble("Total"));

                listaOrcamentoId.add(orcamento);
            }
            rs.close();
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
        return listaOrcamentoId;
    }

    public Orcamento getOrcamentoId(int id) {
        Connection c = this.getConnection();

        Orcamento orcamento = new Orcamento();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT orcamento.idOrcamento, orcamento.data, orcamento.idPessoa, orcamento.cliente,"
                    + "orcamento.total, orcamento.aprovado FROM orcamento WHERE idOrcamento = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setData(rs.getDate("Data"));
                orcamento.setNome(rs.getString("Cliente"));
                orcamento.setIdPessoa(rs.getInt("idPessoa"));
                orcamento.setTotal(rs.getDouble("Total"));
                orcamento.setAprovado(rs.getBoolean("Aprovado"));
            }
            rs.close();
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
        return orcamento;
    }

    public List<Orcamento> listaOrcamentoIdPessoa(int id) {
        Connection c = this.getConnection();
        List<Orcamento> lista = new ArrayList<>();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT orcamento.idOrcamento, orcamento.data, orcamento.idPessoa, orcamento.cliente,"
                    + "orcamento.total, orcamento.aprovado FROM orcamento WHERE idPessoa = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orcamento orcamento = new Orcamento();
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setData(rs.getDate("Data"));
                orcamento.setNome(rs.getString("Cliente"));
                orcamento.setIdPessoa(rs.getInt("idPessoa"));
                orcamento.setTotal(rs.getDouble("Total"));
                orcamento.setAprovado(rs.getBoolean("Aprovado"));
                lista.add(orcamento);
            }
            rs.close();
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
        return lista;
    }
    
    public List<Orcamento> listaOrcamentoPeriodo(Date inicio, Date fim) {
        Connection c = this.getConnection();
        List<Orcamento> lista = new ArrayList<>();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT orcamento.idOrcamento, orcamento.data, orcamento.idPessoa, orcamento.cliente,"
                    + "orcamento.total, orcamento.aprovado FROM orcamento WHERE data between  ? and  ?");
            ps.setDate(1, inicio);
            ps.setDate(2, fim);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orcamento orcamento = new Orcamento();
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setData(rs.getDate("Data"));
                orcamento.setNome(rs.getString("Cliente"));
                orcamento.setIdPessoa(rs.getInt("idPessoa"));
                orcamento.setTotal(rs.getDouble("Total"));
                orcamento.setAprovado(rs.getBoolean("Aprovado"));
                lista.add(orcamento);
            }
            rs.close();
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
        return lista;
    }
    
    public List<Orcamento> listaOrcamentoPeriodoPessoa(Date inicio, Date fim, int id) {
        Connection c = this.getConnection();
        List<Orcamento> lista = new ArrayList<>();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT orcamento.idOrcamento, orcamento.data, orcamento.idPessoa, orcamento.cliente,"
                    + "orcamento.total, orcamento.aprovado FROM orcamento WHERE data between  ? and  ? and idPessoa = ?");
            ps.setDate(1, inicio);
            ps.setDate(2, fim);
            ps.setInt(3, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orcamento orcamento = new Orcamento();
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setData(rs.getDate("Data"));
                orcamento.setNome(rs.getString("Cliente"));
                orcamento.setIdPessoa(rs.getInt("idPessoa"));
                orcamento.setTotal(rs.getDouble("Total"));
                orcamento.setAprovado(rs.getBoolean("Aprovado"));
                lista.add(orcamento);
            }
            rs.close();
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
        return lista;
    }

    public Orcamento getOrcamentoIdPessoa(int id) {
        Connection c = this.getConnection();

        Orcamento orcamento = new Orcamento();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT orcamento.idOrcamento, orcamento.data, orcamento.idPessoa, orcamento.cliente,"
                    + "orcamento.total, orcamento.aprovado FROM orcamento WHERE idPessoa = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setData(rs.getDate("Data"));
                orcamento.setNome(rs.getString("Cliente"));
                orcamento.setIdPessoa(rs.getInt("idPessoa"));
                orcamento.setTotal(rs.getDouble("Total"));
                orcamento.setAprovado(rs.getBoolean("Aprovado"));
            }
            rs.close();
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
        return orcamento;
    }
    
    public Orcamento getOrcamentoIdPO(int id, int cd) {
        Connection c = this.getConnection();

        Orcamento orcamento = new Orcamento();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT orcamento.idOrcamento, orcamento.data, orcamento.idPessoa, orcamento.cliente,"
                    + "orcamento.total, orcamento.aprovado FROM orcamento WHERE idPessoa = ? and idOrcamento = ?");
            ps.setInt(1, id);
            ps.setInt(2, cd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setData(rs.getDate("Data"));
                orcamento.setNome(rs.getString("Cliente"));
                orcamento.setIdPessoa(rs.getInt("idPessoa"));
                orcamento.setTotal(rs.getDouble("Total"));
                orcamento.setAprovado(rs.getBoolean("Aprovado"));
            }
            rs.close();
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
        return orcamento;
    }

    public List<Orcamento> getOrcamentoNome(String nome) {
        Connection c = this.getConnection();
        List<Orcamento> lista = new ArrayList<>();
        Orcamento orcamento = new Orcamento();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT orcamento.idOrcamento, orcamento.data, orcamento.idPessoa, orcamento.cliente,"
                    + "orcamento.total, orcamento.aprovado FROM orcamento WHERE cliente like ?");
            ps.setString(1, nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setData(rs.getDate("Data"));
                orcamento.setNome(rs.getString("Cliente"));
                orcamento.setIdPessoa(rs.getInt("idPessoa"));
                orcamento.setTotal(rs.getDouble("Total"));
                orcamento.setAprovado(rs.getBoolean("Aprovado"));
                lista.add(orcamento);
            }
            rs.close();
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
        return lista;
    }

}
