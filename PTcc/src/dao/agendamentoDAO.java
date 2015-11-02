package dao;

import entity.Agenda;
import entity.Pessoa;
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
public class agendamentoDAO extends MySQL {

    SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
    java.util.Date d = new java.util.Date();
    java.sql.Date dt = new java.sql.Date(d.getTime());

    public boolean insert(Agenda agenda) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO agendamento "
                            + "(data, hora, descricao, idPessoa, dia)  "
                            + "VALUES ( ?, ?, ?, ?, ? )");
            ps.setString(1, sdfD.format(agenda.getData()));
            ps.setString(2, sdfH.format(agenda.getHora()));
            ps.setString(3, agenda.getDescricao());
            ps.setInt(4, agenda.getIdPessoa());
            ps.setString(5, agenda.getDia());

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

    public boolean delete(String hora, Date data) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("DELETE FROM agendamento "
                            + "WHERE hora = ? and data = ?");
            ps.setString(1, hora);
            ps.setDate(2, data);

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

    public void deletePessoa(int id){
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM agendamento "
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

    public List<Agenda> listarAgendamentos(Date data) {
        List<Agenda> lista = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT agendamento.hora, agendamento.descricao, agendamento.data, pessoa.nome, pessoa.idPessoa, pessoa.telCelular"
                            + " FROM agendamento INNER JOIN pessoa on"
                            + " pessoa.idPessoa = agendamento.idPessoa WHERE data = ? ORDER BY hora ASC");
            ps.setDate(1, data);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Agenda agenda = new Agenda();
                Pessoa pessoa = new Pessoa();
                agenda.setDescricao(rs.getString("Descricao"));
                agenda.setHora(rs.getTime("Hora"));
                agenda.setData(rs.getDate("Data"));
                pessoa.setNome(rs.getString("Nome"));
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setTelCelular(rs.getString("telCelular"));

                agenda.setPessoa(pessoa);
                lista.add(agenda);

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

    public List<Agenda> listarAgendamentosHorario(Date data, String hora) {
        List<Agenda> lista = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT agendamento.hora, agendamento.descricao, pessoa.nome"
                            + " FROM agendamento INNER JOIN pessoa on"
                            + " pessoa.idPessoa = agendamento.idPessoa WHERE data = ? AND hora = ? ORDER BY hora ASC");
            ps.setDate(1, data);
            ps.setString(2, hora);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Agenda agenda = new Agenda();
                Pessoa pessoa = new Pessoa();
                agenda.setDescricao(rs.getString("Descricao"));
                agenda.setHora(rs.getTime("Hora"));
                pessoa.setNome(rs.getString("Nome"));

                agenda.setPessoa(pessoa);
                lista.add(agenda);

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

    public List<Agenda> listarAgendamentosPessoa(String nome) {
        List<Agenda> lista = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT pessoa.nome, agendamento.data, agendamento.hora, agendamento.dia"
                            + " FROM pessoa INNER JOIN agendamento on"
                            + " pessoa.idPessoa = agendamento.idPessoa WHERE nome like ? and data >= current_date ORDER BY data asc");
            ps.setString(1, nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Agenda agenda = new Agenda();
                Pessoa pessoa = new Pessoa();
                agenda.setData(rs.getDate("Data"));
                agenda.setHora(rs.getTime("Hora"));
                agenda.setDia(rs.getString("Dia"));
                pessoa.setNome(rs.getString("Nome"));

                agenda.setPessoa(pessoa);
                lista.add(agenda);

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

    public List<Agenda> listarAgendamentosPessoaRealizadas(String nome) {
        List<Agenda> lista = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT pessoa.nome, agendamento.data, agendamento.hora, agendamento.dia"
                            + " FROM pessoa INNER JOIN agendamento on"
                            + " pessoa.idPessoa = agendamento.idPessoa WHERE nome like ? "
                            + "and data < current_date order by data desc LIMIT 10 ");
            ps.setString(1, nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Agenda agenda = new Agenda();
                Pessoa pessoa = new Pessoa();
                agenda.setData(rs.getDate("Data"));
                agenda.setHora(rs.getTime("Hora"));
                agenda.setDia(rs.getString("Dia"));
                pessoa.setNome(rs.getString("Nome"));

                agenda.setPessoa(pessoa);
                lista.add(agenda);

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
