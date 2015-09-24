package dao;

import entity.Orcamento;
import entity.Pessoa;
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

    public void update(Pessoa pessoa) {

        Connection c = this.getConnection();

        try {

            PreparedStatement ps = c.prepareStatement("UPDATE pessoa "
                    + "Set nome = ?, email = ? , completo = ?, rua = ?, numero = ?, cep = ?, "
                    + "bairro = ?, cidade = ?, estado = ?, cpf = ?, rg = ?,  "
                    + "telResidencial = ?, telCelular = ?,telComercial = ?, observacoes = ? "
                    + "WHERE idpessoa = ? ");

            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getEmail());
            ps.setBoolean(3, pessoa.isCompleto());
            ps.setString(4, pessoa.getRua());
            ps.setInt(5, pessoa.getNumero());
            ps.setString(6, pessoa.getCep());
            ps.setString(7, pessoa.getBairro());
            ps.setString(8, pessoa.getCidade());
            ps.setString(9, pessoa.getEstado());
            ps.setString(10, pessoa.getCpf());
            ps.setString(11, pessoa.getRg());
            ps.setString(12, pessoa.getTelResidencial());
            ps.setString(13, pessoa.getTelCelular());
            ps.setString(14, pessoa.getTelComercial());
            ps.setString(15, pessoa.getObservacoes());
            ps.setInt(16, pessoa.getIdPessoa());

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

    public void delete(int id) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM pessoa "
                    + "WHERE idPessoa = ?");

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
        List<Orcamento> listaOrcamentos = new ArrayList<Orcamento>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idOrcamento, data, total From Orcamento");
            

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Orcamento orcamento = new Orcamento();
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setData(rs.getDate("data"));
                orcamento.setTotal(rs.getDouble("valor"));
                

                listaOrcamentos.add(orcamento);

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
        return listaOrcamentos;
    }

    public Orcamento getOrcamentoById(int id) {
        Connection c = this.getConnection();
        Orcamento orcamento = new Orcamento();
        
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idOrcamento, data, valor"
                    + "FROM Orcamento WHERE idOrcamento = ?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setData(rs.getDate("data"));
                orcamento.setTotal(rs.getDouble("valor"));
                
                

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
