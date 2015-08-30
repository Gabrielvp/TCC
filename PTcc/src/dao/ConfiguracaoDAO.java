package dao;

import entity.Configuracao;
import entity.EnumDiaSemana;
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
public class ConfiguracaoDAO extends MySQL {

    SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
    java.util.Date d = new java.util.Date();
    java.sql.Date dt = new java.sql.Date(d.getTime());

    public boolean insert(Configuracao configuracao) {

        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO configuracoes "
                            + "(horaInicial, horaFinal, intervalo, dia)  "
                            + "VALUES ( ?, ?, ?, ?)");
            ps.setString(1, sdfH.format(configuracao.getHoraInicial()));
            ps.setString(2, sdfH.format(configuracao.getHoraFinal()));
            ps.setInt(3, configuracao.getIntervalo());
            ps.setInt(4, configuracao.getDia().getCodigo());

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

    public boolean insertAlmoco(Configuracao configuracao) {

        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO configuracoes "
                            + "(almocoInicio, almocoFim)  "
                            + "VALUES ( ?, ?)");
            ps.setString(1, sdfH.format(configuracao.getAlmocoInicio()));
            ps.setString(2, sdfH.format(configuracao.getAlmocoFim()));

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

    public void delete(int dia) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM configuracoes "
                    + "WHERE dia = ?");
            ps.setInt(1, dia);

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

    public List<Configuracao> listarConfiguracao() {
        List<Configuracao> listaConfiguracoes = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT horaInicial, horaFinal, intervalo, dia FROM configuracoes ORDER BY dia asc");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Configuracao configuracao = new Configuracao();
                configuracao.setHoraInicial(rs.getTime("HoraInicial"));
                configuracao.setHoraFinal(rs.getTime("HoraFinal"));
                configuracao.setIntervalo(rs.getInt("Intervalo"));
                configuracao.setDia(EnumDiaSemana.DOMINGO.getEnumDiaPorCodigo(rs.getInt("Dia")));

                listaConfiguracoes.add(configuracao);

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
        return listaConfiguracoes;
    }

    public List<Configuracao> listarConfiguracaoTela(String dia) {
        List<Configuracao> listaConfiguracoes = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT horaInicial, horaFinal, intervalo, dia FROM configuracoes WHERE dia = ?");
            ps.setString(1, dia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Configuracao configuracao = new Configuracao();
                configuracao.setHoraInicial(rs.getTime("HoraInicial"));
                configuracao.setHoraFinal(rs.getTime("HoraFinal"));
                configuracao.setIntervalo(rs.getInt("Intervalo"));
                configuracao.setDia(EnumDiaSemana.DOMINGO.getEnumDiaPorCodigo(rs.getInt("Dia")));

                listaConfiguracoes.add(configuracao);

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
        return listaConfiguracoes;
    }

    /* public List<Pessoa> buscarNome(String nome) {
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
     PreparedStatement ps = c.prepareStatement("SELECT pessoa.idPessoa, pessoa.nome, pessoa.email, documento.cpf, documento.rg, telefone.numero"
     + " FROM pessoa LEFT JOIN documento ON pessoa.idpessoa = documento.idpessoa"
     + " LEFT JOIN telefone ON pessoa.idpessoa = telefone.idpessoa");

     ResultSet rs = ps.executeQuery();
     while (rs.next()) {

     Pessoa pessoa = new Pessoa();
     Documento documento = new Documento();
     Telefone telefone = new Telefone();

     pessoa.setIdPessoa(rs.getInt("idPessoa"));
     pessoa.setNome(rs.getString("Nome"));
     documento.setCpf(rs.getString("CPF"));
     documento.setRg(rs.getString("Rg"));
     pessoa.setEmail(rs.getString("email"));
     telefone.setNumero(rs.getString("numero"));

     pessoa.setDocumento(documento);
     pessoa.setTelefone(telefone);

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
     }


     /*public boolean update(FContratado funcionario) {
     Connection c = this.getConnection();
     try {
     PreparedStatement ps = c.prepareStatement("UPDATE funcionario "
     + " SET matricula = ?, nome = ?, rua = ?, numero = ?, bairro = ?, cep = ?, uf = ?, "
     + " fone_residencial = ?, fone_celular = ?, salario = ?, funcao = ?, setor = ? "
     + " WHERE id_funcionario = ?");
     ps.setInt(1, funcionario.getMatricula());
     ps.setString(2, funcionario.getNome());
     ps.setString(3, funcionario.getRua());
     ps.setInt(4, funcionario.getNumero());
     ps.setString(5, funcionario.getBairro());
     ps.setString(6, funcionario.getCep());
     ps.setString(7, funcionario.getUf());
     ps.setString(8, funcionario.getResidencial());
     ps.setString(9, funcionario.getCelular());
     ps.setDouble(10, funcionario.getSalario());
     ps.setInt(11, funcionario.getFuncao().getCodigo());
     ps.setInt(12, funcionario.getSetor().getCodigo());
     ps.setInt(13, funcionario.getId_funcionario());

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

     public boolean delete(int id) {
     Connection c = this.getConnection();
     try {
     PreparedStatement ps
     = c.prepareStatement("DELETE FROM funcionario "
     + "WHERE id_funcionario = ?");
     ps.setInt(1, id);

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

     public List<Funcionario> listarFuncionarios() {
     List<Funcionario> lista = new ArrayList<Funcionario>();
     Connection c = this.getConnection();
     try {
     PreparedStatement ps
     = c.prepareStatement("SELECT id_funcionario, matricula, nome, rua, numero, bairro,"
     + " cep, uf, fone_residencial, fone_celular, salario, setor, funcao "
     + "FROM funcionario WHERE tipo = 1");
     ResultSet rs = ps.executeQuery();
     while (rs.next()) {

     FContratado funcionario = new FContratado();
     funcionario.setId_funcionario(rs.getInt("id_funcionario"));
     funcionario.setMatricula(rs.getInt("Matricula"));
     funcionario.setNome(rs.getString("Nome"));
     funcionario.setRua(rs.getString("Rua"));
     funcionario.setNumero(rs.getInt("Numero"));
     funcionario.setBairro(rs.getString("Bairro"));
     funcionario.setCep(rs.getString("Cep"));
     funcionario.setUf(rs.getString("Uf"));
     funcionario.setResidencial(rs.getString("fone_residencial"));
     funcionario.setCelular(rs.getString("fone_celular"));
     funcionario.setSalario(rs.getDouble("salario"));
     funcionario.setSetor(EnumSetor.ADMINISTRATIVO.getEnumSetorPorCodigo(rs.getInt("setor")));
     funcionario.setFuncao(EnumFuncao.ANALISTA.getEnumPorCodigo(rs.getInt("funcao")));

     lista.add(funcionario);
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
     */
}
