package dao;

import entity.Pessoa;
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
public class CadastroClienteDAO extends MySQL {

    public boolean insert(Pessoa pessoa) {

        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO pessoa "
                            + "(Nome,email, completo )  "
                            + "VALUES ( ?, ?, ?)");
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getEmail());
            ps.setBoolean(3, pessoa.isCompleto());

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
    
    public void update(Pessoa pessoa, int id) {

        Connection c = this.getConnection();

        try {

            PreparedStatement ps = c.prepareStatement("UPDATE pessoa "
                    + "Set nome = ?, email = ? "
                    + "WHERE idpessoa = ? ");

            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getEmail());
            ps.setInt(3, id);

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
            PreparedStatement ps = c.prepareStatement("SELECT pessoa.idPessoa, pessoa.nome, pessoa.email FROM pessoa");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Pessoa pessoa = new Pessoa();
               
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setNome(rs.getString("Nome"));
                pessoa.setEmail(rs.getString("email"));
                
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
            PreparedStatement ps = c.prepareStatement("SELECT pessoa.idPessoa, pessoa.nome, pessoa.email "
                    + "FROM Pessoa WHERE idPessoa = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                objPessoa.setIdPessoa(rs.getInt("idPessoa"));
                objPessoa.setNome(rs.getString("nome"));
                objPessoa.setEmail(rs.getString("email"));

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
