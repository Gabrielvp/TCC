/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.FormaPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class FormaPagamentoDAO extends MySQL {

    public boolean insert(FormaPagamento fPagamento) {

        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO forma_pagamento "
                            + "(descricao, parcela, intervalo, aVista)  "
                            + "VALUES ( ?, ?, ?, ?)");
            ps.setString(1, fPagamento.getDescricao());
            ps.setInt(2, fPagamento.getParcela());
            ps.setInt(3, fPagamento.getIntervalo());
            ps.setBoolean(4, fPagamento.isaVista());

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
        JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        }
        return false;
    }
    
    public void update(FormaPagamento fp, String d, int p, int i) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("UPDATE forma_pagamento set descricao = ?, parcela = ?, intervalo = ?, aVista = ?"
                    + " WHERE descricao = ? and parcela = ? and intervalo = ?");            
            ps.setString(1, fp.getDescricao());
            ps.setInt(2, fp.getParcela());
            ps.setInt(3, fp.getIntervalo());
            ps.setBoolean(4, fp.isaVista());
            ps.setString(5, d);
            ps.setInt(6, p);
            ps.setInt(7, i);

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
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
        }
    }

    public List<FormaPagamento> lista() {
        List<FormaPagamento> lista = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement(" SELECT descricao, parcela, intervalo, aVista FROM forma_pagamento");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FormaPagamento fp = new FormaPagamento();
                fp.setDescricao(rs.getString("Descricao"));
                fp.setParcela(rs.getInt("Parcela"));
                fp.setIntervalo(rs.getInt("Intervalo"));
                fp.setaVista(rs.getBoolean("aVista"));

                lista.add(fp);

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
        return lista;
    }
    
    public List<FormaPagamento> listaDesc(String desc) {
        List<FormaPagamento> lista = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement(" SELECT descricao, parcela, intervalo, aVista FROM forma_pagamento WHERE descricao = ?");
            ps.setString(1, desc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FormaPagamento fp = new FormaPagamento();
                fp.setDescricao(rs.getString("Descricao"));
                fp.setParcela(rs.getInt("Parcela"));
                fp.setIntervalo(rs.getInt("Intervalo"));
                fp.setaVista(rs.getBoolean("aVista"));

                lista.add(fp);

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
        return lista;
    }

    public void delete(String desc) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM forma_pagamento "
                    + "WHERE descricao = ?");
            ps.setString(1, desc);

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
            JOptionPane.showMessageDialog(null, "Excluído!");
        }
    }
}
