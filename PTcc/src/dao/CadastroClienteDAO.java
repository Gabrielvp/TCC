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
                            + "(Nome,email, completo, rua, numero, cep, bairro, cidade, estado, cpf, rg, "
                            + "telResidencial, telCelular,telComercial, observacoes )  "
                            + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
                    + "Set nome = ?, email = ? , completo = ?, rua = ?, numero = ?, cep = ?, "
                    + "bairro = ?, cidade = ?, estado = ?, cpf = ?, rg = ?  "
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
            ps.setInt(15, id);

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
