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
    
    public List<Configuracao> listarConfiguracaoDia(int dia) {
        List<Configuracao> listaConfiguracoes = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT horaInicial, horaFinal, intervalo, dia FROM configuracoes WHERE dia = ?");
            ps.setInt(1, dia);
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
}
