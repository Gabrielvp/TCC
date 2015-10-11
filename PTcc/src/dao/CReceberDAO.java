package dao;

import entity.CReceber;
import entity.Orcamento;
import entity.Produto;
import entity.ProdutoOrcamento;
import java.sql.Connection;
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
            creceber.setIdCPagar(resultado);
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
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
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
            PreparedStatement ps = c.prepareStatement("select orcamento.idorcamento, orcamento.data, orcamento.cliente, orcamento.idpessoa, orcamento.total, produto_orcamento.idproduto,\n"
                    + "produto_orcamento.produto, produto_orcamento.valor, produto_orcamento.qtd, produto_orcamento.total from\n"
                    + "orcamento inner join produto_orcamento on orcamento.idorcamento = produto_orcamento.idOrcamento");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setData(rs.getDate("Data"));
                orcamento.setNome(rs.getString("Cliente"));
                orcamento.setIdPessoa(rs.getInt("idPessoa"));
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
}
