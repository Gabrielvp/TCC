package dao;

import entity.Pessoa;
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
public class ProdutoOrcamentoDAO extends MySQL {

    SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");

    public boolean insert(ProdutoOrcamento produtoOrcamento) {

        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO produto_orcamento (idProduto, idOrcamento, produto, qtd, valor, desconto, total)"
                            + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, produtoOrcamento.getIdProduto());
            ps.setInt(2, produtoOrcamento.getIdOrcamento());
            ps.setString(3, produtoOrcamento.getProduto());
            ps.setDouble(4, produtoOrcamento.getQuantidade());
            ps.setDouble(5, produtoOrcamento.getValor());
            ps.setDouble(6, produtoOrcamento.getDesconto());
            ps.setDouble(7, produtoOrcamento.getTotal());

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

    public List<ProdutoOrcamento> getProdutoOrcamentoId(int id) {
        Connection c = this.getConnection();
        List<ProdutoOrcamento> lista = new ArrayList<>();

        try {
            PreparedStatement ps = c.prepareStatement("SELECT idproduto, produto, qtd, valor, desconto, total from produto_orcamento where idorcamento = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProdutoOrcamento pOrcamento = new ProdutoOrcamento();
                pOrcamento.setIdProduto(rs.getInt("idProduto"));
                pOrcamento.setProduto(rs.getString("Produto"));
                pOrcamento.setQuantidade(rs.getDouble("Qtd"));
                pOrcamento.setValor(rs.getDouble("valor"));
                pOrcamento.setDesconto(rs.getDouble("desconto"));
                pOrcamento.setTotal(rs.getDouble("total"));

                lista.add(pOrcamento);
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
   
    public List<ProdutoOrcamento> verificaOrcamentosProduto(int id) {
        List<ProdutoOrcamento> listarOrcamentos = new ArrayList<ProdutoOrcamento>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("select idProduto, idOrcamento from produto_orcamento where idProduto = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProdutoOrcamento orcamento = new ProdutoOrcamento();
                orcamento.setIdProduto(rs.getInt("idProduto"));
                orcamento.setIdOrcamento(rs.getInt("idOrcamento"));                
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
    
    public void delete(int id) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM produto_orcamento "
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
    
    public void deleteProduto(int idOrcamento, int idProduto) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM produto_orcamento "
                    + "WHERE idOrcamento = ? AND idProduto = ?");

            ps.setInt(1, idOrcamento);
            ps.setInt(2, idProduto);

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

    public List<Pessoa> listarPessoasIncompletos(int completo) {
        List<Pessoa> listaPessoasIncompleto = new ArrayList<Pessoa>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT pessoa.idPessoa, pessoa.nome, pessoa.email FROM pessoa WHERE completo = ?");
            ps.setInt(1, completo);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("Nome"));

                listaPessoasIncompleto.add(pessoa);

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
        return listaPessoasIncompleto;
    }

    public List<Pessoa> buscarNome(String nome) {
        List<Pessoa> listaBuscaNome = new ArrayList<Pessoa>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT pessoa.idPessoa, pessoa.nome FROM pessoa WHERE nome like ?");
            ps.setString(1, nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("Nome"));

                listaBuscaNome.add(pessoa);

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
        return listaBuscaNome;
    }

    public List<Pessoa> listarPessoasCompleto() {
        List<Pessoa> listaPessoasCompleto = new ArrayList<Pessoa>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idPessoa,Nome,email, completo, rua, numero, cep, bairro, cidade, estado, cpf, rg, "
                    + "telResidencial, telCelular,telComercial, observacoes FROM pessoa");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Pessoa pessoa = new Pessoa();

                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("Nome"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setTelCelular(rs.getString("telCelular"));
                pessoa.setTelComercial(rs.getString("telComercial"));
                pessoa.setTelResidencial(rs.getString("telResidencial"));
                pessoa.setCompleto(rs.getBoolean("completo"));
                pessoa.setRua(rs.getString("rua"));
                pessoa.setNumero(rs.getInt("numero"));
                pessoa.setCep(rs.getString("cep"));
                pessoa.setBairro(rs.getString("bairro"));
                pessoa.setCidade(rs.getString("cidade"));
                pessoa.setEstado(rs.getString("estado"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setRg(rs.getString("rg"));
                pessoa.setObservacoes(rs.getString("observacoes"));

                listaPessoasCompleto.add(pessoa);

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
        return listaPessoasCompleto;
    }

    public Pessoa getPessoaById(int id) {
        Connection c = this.getConnection();
        Pessoa objPessoa = new Pessoa();

        try {
            PreparedStatement ps = c.prepareStatement("SELECT idPessoa, nome , email , completo, rua, numero, cep, "
                    + "bairro, cidade, estado,cpf , rg ,telResidencial , telCelular, telComercial "
                    + "FROM Pessoa WHERE idPessoa = ?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                objPessoa.setIdPessoa(rs.getInt("idPessoa"));
                objPessoa.setNome(rs.getString("nome"));
                objPessoa.setEmail(rs.getString("email"));
                objPessoa.setCompleto(rs.getBoolean("completo"));
                objPessoa.setRua(rs.getString("rua"));
                objPessoa.setNumero(rs.getInt("numero"));
                objPessoa.setCep(rs.getString("cep"));
                objPessoa.setBairro(rs.getString("bairro"));
                objPessoa.setCidade(rs.getString("cidade"));
                objPessoa.setEstado(rs.getString("estado"));
                objPessoa.setCpf(rs.getString("cpf"));
                objPessoa.setRg(rs.getString("rg"));
                objPessoa.setTelResidencial(rs.getString("telResidencial"));
                objPessoa.setTelCelular(rs.getString("telCelular"));
                objPessoa.setTelComercial(rs.getString("telComercial"));

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
        return objPessoa;
    }
}
