package dao;

import entity.EnumUnidade;
import entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public Produto getProdutoById(int id) {
        Connection c = this.getConnection();
        Produto produto = new Produto();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT produto.idproduto, produto.descricao, produto.cod_barras, produto.quantidade, "
                            + " produto.valor_venda, produto.valor_compra, produto.unidade, produto.marca, produto.modelo, produto.fornecedor, produto.referencia, produto.ativo"
                            + " FROM produto where idproduto = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                produto.setIdProduto(rs.getInt("Idproduto"));
                produto.setDescricao(rs.getString("Descricao"));
                produto.setCodBarras(rs.getString("Cod_barras"));
                produto.setQtd(rs.getDouble("Quantidade"));
                produto.setValorVenda(rs.getDouble("Valor_venda"));
                produto.setValorCompra(rs.getDouble("Valor_compra"));
                produto.setUnidade(EnumUnidade.LITRO.getEnumUnidade(rs.getInt("Unidade")));
                produto.setMarca(rs.getString("Marca"));
                produto.setModelo(rs.getString("Modelo"));
                produto.setFornecedor(rs.getString("Fornecedor"));
                produto.setReferencia(rs.getString("Referencia"));
                produto.setAtivo(rs.getBoolean("Ativo"));
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
        return produto;
    }
    
    public List<Produto> buscarProduto(String produto) {
        List<Produto> listaBuscaProduto = new ArrayList<Produto>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT produto.idproduto, produto.descricao, produto.cod_barras, produto.quantidade, "
                            + " produto.valor_venda, produto.valor_compra, produto.unidade, produto.marca, produto.modelo, produto.fornecedor, produto.referencia"
                            + " FROM produto where descricao LIKE ?");
            ps.setString(1, produto + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Produto p = new Produto();
                p.setIdProduto(rs.getInt("Idproduto"));
                p.setDescricao(rs.getString("Descricao"));
                p.setCodBarras(rs.getString("Cod_barras"));
                p.setQtd(rs.getDouble("Quantidade"));
                p.setValorVenda(rs.getDouble("Valor_venda"));
                p.setValorCompra(rs.getDouble("Valor_compra"));
                p.setUnidade(EnumUnidade.LITRO.getEnumUnidade(rs.getInt("Unidade")));
                p.setMarca(rs.getString("Marca"));
                p.setModelo(rs.getString("Modelo"));
                p.setFornecedor(rs.getString("Fornecedor"));
                p.setReferencia(rs.getString("Referencia"));

                listaBuscaProduto.add(p);

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
        return listaBuscaProduto;
    }

    public void delete(int id) {
     Connection c = this.getConnection();
     try {
     PreparedStatement ps = c.prepareStatement("DELETE FROM produto "
     + "WHERE idProduto = ?");
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
    
    public void update(Produto produto, int id) {

        Connection c = this.getConnection();

        try {

            PreparedStatement ps = c.prepareStatement("UPDATE produto "
                    + "Set descricao = ?, cod_barras = ? , quantidade = ?, valor_venda = ?, valor_compra = ?, unidade = ?, "
                    + "marca = ?, modelo = ?, fornecedor = ?, referencia = ?, ativo = ?  "
                    + "WHERE idproduto = ? ");

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
            ps.setInt(12, id);

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
