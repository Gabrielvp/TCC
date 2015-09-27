package dao;

import entity.Orcamento;
import entity.Pessoa;
import entity.Produto;
import entity.ProdutoOrcamento;
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
        List<Orcamento> listarOrcamentos = new ArrayList<Orcamento>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select\n"
                    + "	produto.idProduto,\n"
                    + "    produto.descricao,\n"
                    + "    produto_orcamento.qtd,\n"
                    + "    produto_orcamento.valor,\n"
                    + "    produto_orcamento.total,\n"
                    + "    orcamento.idOrcamento,\n"
                    + "    orcamento.data,\n"
                    + "    orcamento.total,\n"
                    + "    pessoa.idPessoa,\n"
                    + "    pessoa.nome\n"
                    + "from \n"
                    + "	produto\n"
                    + "inner join \n"
                    + "	produto_orcamento on\n"
                    + "    produto.idProduto = produto_orcamento.idProduto\n"
                    + "inner join\n"
                    + "	orcamento on\n"
                    + "    orcamento.idOrcamento = produto_orcamento.idOrcamento\n"
                    + "inner join\n"
                    + "	pessoa on\n"
                    + "	pessoa.idPessoa = orcamento.idPessoa");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orcamento orcamento = new Orcamento();
                Produto produto = new Produto();
                ProdutoOrcamento pOrcamento = new ProdutoOrcamento();

                orcamento.setData(rs.getDate("Data"));
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setNome(rs.getString("Nome"));
                orcamento.setTotal(rs.getDouble("Total"));
                orcamento.setIdPessoa(rs.getInt("idPessoa"));
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setDescricao(rs.getString("Descricao"));
                pOrcamento.setQuantidade(rs.getDouble("qtd"));
                pOrcamento.setValor(rs.getDouble("Valor"));
                pOrcamento.setTotal(rs.getDouble("Total"));
                orcamento.setProduto(produto);
                orcamento.setpOrcamento(pOrcamento);
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
            PreparedStatement ps = c.prepareStatement("SELECT data, idOrcamento, cliente, total FROM orcamento WHERE idOrcamento = ?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orcamento.setData(rs.getDate("Data"));
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setNome(rs.getString("Cliente"));
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

    public List<Orcamento> listaId(int id) {
        List<Orcamento> listaId = new ArrayList<>();
        Connection c = this.getConnection();

        try {
            PreparedStatement ps = c.prepareStatement("select\n"
                    + "	produto.idProduto,\n"
                    + "    produto.descricao,\n"
                    + "    produto_orcamento.qtd,\n"
                    + "    produto_orcamento.valor,\n"
                    + "    produto_orcamento.total,\n"
                    + "    orcamento.idOrcamento,\n"
                    + "    orcamento.data,\n"
                    + "    orcamento.total,\n"
                    + "    pessoa.idPessoa,\n"
                    + "    pessoa.nome\n"
                    + "from \n"
                    + "	produto\n"
                    + "inner join \n"
                    + "	produto_orcamento on\n"
                    + "    produto.idProduto = produto_orcamento.idProduto\n"
                    + "inner join\n"
                    + "	orcamento on\n"
                    + "    orcamento.idOrcamento = produto_orcamento.idOrcamento\n"
                    + "inner join\n"
                    + "	pessoa on\n"
                    + "	pessoa.idPessoa = orcamento.idPessoa");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orcamento orcamento = new Orcamento();
                Produto produto = new Produto();
                ProdutoOrcamento pOrcamento = new ProdutoOrcamento();

                orcamento.setData(rs.getDate("Data"));
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));
                orcamento.setNome(rs.getString("Nome"));
                orcamento.setTotal(rs.getDouble("Total"));
                orcamento.setIdPessoa(rs.getInt("idPessoa"));
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setDescricao(rs.getString("Descricao"));
                pOrcamento.setQuantidade(rs.getDouble("qtd"));
                pOrcamento.setValor(rs.getDouble("Valor"));
                pOrcamento.setTotal(rs.getDouble("Total"));
                orcamento.setProduto(produto);
                orcamento.setpOrcamento(pOrcamento);
                listaId.add(orcamento);
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
        return listaId;
    }

}
