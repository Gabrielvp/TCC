package dao;

import entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ricardonene
 */
public class ProdutoDAO extends MySQL {

    public boolean insert(Produto produto) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO produto "
                            + "(descricao, cod_barras, quantidade, valor_venda, valor_compra, unidade, marca, modelo, fornecedor, referencia, ativo)  "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");

            ps.setString(1, produto.getDescricao());
            ps.setString(2, produto.getCodBarras());
            ps.setDouble(3, produto.getQtd());
            ps.setDouble(4, produto.getValorVenda());
            ps.setDouble(5, produto.getValorCompra());
            ps.setInt(6, produto.getUnidade().getCodigo());
            ps.setString(7, produto.getMarca());
            ps.setString(8, produto.getModelo());
            ps.setString(9, produto.getFornecedor());
            ps.setString(10, produto.getReferencia());
            ps.setBoolean(11, produto.isAtivo());
           
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

    /*public List<Endereco> listarEndereco(int id) {
        List<Endereco> listaEndereco = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT endereco.rua, endereco.numero, endereco.cep, endereco.cidade, "
                            + " endereco.bairro, endereco.uf, endereco.ponto_referencia"
                            + " FROM endereco where idpessoa = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Endereco endereco = new Endereco();
                endereco.setRua(rs.getString("Rua"));
                endereco.setNumero(rs.getInt("Numero"));
                endereco.setCep(rs.getString("Cep"));
                endereco.setCidade(rs.getString("Cidade"));
                endereco.setBairro(rs.getString("Bairro"));
                endereco.setUf(rs.getString("UF"));
                endereco.setpReferencia(rs.getString("Ponto_referencia"));

                listaEndereco.add(endereco);
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
        return listaEndereco;
    }
    
        public void delete(int id) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM endereco "
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


    public FContratado getFuncionarioById(int id) {
     Connection c = this.getConnection();
     FContratado funcionario = null;
     try {
     PreparedStatement ps = c.prepareStatement("SELECT id_funcionario, "
     + "matricula, nome "
     + "FROM funcionario WHERE id_funcionario = ?");
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     while (rs.next()) {

     funcionario = new FContratado();
     funcionario.setId_funcionario(rs.getInt("id_funcionario"));
     funcionario.setMatricula(rs.getInt("matricula"));
     funcionario.setNome(rs.getString("nome"));
     funcionario.setRua(rs.getString("rua"));
     funcionario.setNumero(rs.getInt("numero"));

     }
     rs.close();
     ps.close();
     return funcionario;
     } catch (SQLException ex) {
     ex.printStackTrace();
     } finally {
     try {
     c.close();
     } catch (SQLException ex) {
     ex.printStackTrace();
     }
     }
     return null;
     }
     */
}
