/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ConfiguracaoDAO;
import entity.Configuracao;
import entity.EnumDiaSemana;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel1
 */
public class TelaConfiguracoes extends javax.swing.JDialog {

    /**
     * Creates new form Configuracoes
     */
    public TelaConfiguracoes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        cbDia.setModel(new DefaultComboBoxModel<>(EnumDiaSemana.values()));
        atualizaTabelaConfiguracao();
    }

    SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
    int dia;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHoraInicio = new javax.swing.JFormattedTextField();
        txtHoraFim = new javax.swing.JFormattedTextField();
        txtIntervalo = new javax.swing.JTextField();
        cbDia = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConfiguracao = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações - Agenda Financeira");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)), "Horas:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 51, 153))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Horário Inicial:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 101, -1, -1));

        jLabel3.setText("Horário Final:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 137, -1, -1));

        jLabel2.setText("Intervalo:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 115, -1, -1));

        txtHoraInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtHoraInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHoraInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtHoraInicioMousePressed(evt);
            }
        });
        jPanel2.add(txtHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 100, 55, -1));

        txtHoraFim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtHoraFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHoraFim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtHoraFimMousePressed(evt);
            }
        });
        jPanel2.add(txtHoraFim, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 136, 55, -1));

        txtIntervalo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        txtIntervalo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIntervaloMousePressed(evt);
            }
        });
        jPanel2.add(txtIntervalo, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 114, 61, -1));

        cbDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDia.setBorder(null);
        jPanel2.add(cbDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 47, 234, -1));

        jLabel6.setText("Dia:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 24, -1, -1));

        jLabel4.setText("minutos");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 115, -1, -1));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Apply.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        tblConfiguracao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        tblConfiguracao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Dia", "Inicio", "Fim", "Intervalo"
            }
        ));
        tblConfiguracao.setShowHorizontalLines(true);
        tblConfiguracao.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tblConfiguracao);
        if (tblConfiguracao.getColumnModel().getColumnCount() > 0) {
            tblConfiguracao.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblConfiguracao.getColumnModel().getColumn(1).setPreferredWidth(20);
            tblConfiguracao.getColumnModel().getColumn(2).setPreferredWidth(20);
            tblConfiguracao.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(btnSalvar)
                .addGap(6, 6, 6)
                .addComponent(btnExcluir))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (txtHoraInicio.getText().equals("  :  ") || txtHoraFim.getText().equals("  :  ") || txtIntervalo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos");
        } else {
            Configuracao c = new Configuracao();
            ConfiguracaoDAO cDAO = new ConfiguracaoDAO();

            try {
                c.setHoraInicial(sdfH.parse(txtHoraInicio.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(TelaConfiguracoes.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                c.setHoraFinal(sdfH.parse(txtHoraFim.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(TelaConfiguracoes.class.getName()).log(Level.SEVERE, null, ex);
            }
            c.setIntervalo(Integer.parseInt(txtIntervalo.getText()));
            c.setDia((EnumDiaSemana) cbDia.getSelectedItem());
            c.setConfigurado(true);

            String dia = cbDia.getSelectedItem().toString();
            cDAO.insert(c);
            atualizaTabelaConfiguracao();
            limparTela();
            JOptionPane.showMessageDialog(this, "Configuração salva com sucesso!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int sel = tblConfiguracao.getSelectedRow();
        if (sel == -1) {
            JOptionPane.showMessageDialog(this, "Selecione a configuração a ser excluída");
        } else {
            int linha = tblConfiguracao.getSelectedRow();
            String tbl = tblConfiguracao.getValueAt(linha, 0).toString();
            if (tbl.equals("")) {
                JOptionPane.showMessageDialog(this, "Configuração vazia");
            } else {
                ConfiguracaoDAO cDAO = new ConfiguracaoDAO();
                int line = tblConfiguracao.getSelectedRow();
                String tb = tblConfiguracao.getValueAt(line, 0).toString();
                diaDaSemana(tb);
                int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja Excluir a configuração?", "Exclusão", 0, 0);
                if (confirmacao == 0) {
                    cDAO.delete(dia);
                    this.limparTabela();
                }
            }
        }

        this.atualizaTabelaConfiguracao();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtHoraInicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHoraInicioMousePressed
        txtHoraInicio.setSelectionStart(0);
        txtHoraInicio.setSelectionEnd(5);
    }//GEN-LAST:event_txtHoraInicioMousePressed

    private void txtHoraFimMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHoraFimMousePressed
        txtHoraFim.setSelectionStart(0);
        txtHoraFim.setSelectionEnd(5);
    }//GEN-LAST:event_txtHoraFimMousePressed

    private void txtIntervaloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIntervaloMousePressed
        txtIntervalo.setSelectionStart(0);
        txtIntervalo.setSelectionEnd(3);
    }//GEN-LAST:event_txtIntervaloMousePressed

    public void limparTabela() {
        DefaultTableModel model
                = (DefaultTableModel) this.tblConfiguracao.getModel();
        String text = "";
        for (int i = 0; i < tblConfiguracao.getRowCount(); i++) {
            model.setValueAt(text, i, 0);
            model.setValueAt(text, i, 1);
            model.setValueAt(text, i, 2);
            model.setValueAt(text, i, 3);
        }
    }

    public void limparTela() {
        txtHoraInicio.setText("");
        txtHoraFim.setText("");
        txtIntervalo.setText("");
    }

    public void atualizaTabelaConfiguracao() {
        ConfiguracaoDAO cDAO = new ConfiguracaoDAO();
        List<Configuracao> listaConfiguracoes = cDAO.listarConfiguracao();
        DefaultTableModel model = (DefaultTableModel) this.tblConfiguracao.getModel();
        for (int i = 0; i < listaConfiguracoes.size(); i++) {
            model.setValueAt(listaConfiguracoes.get(i).getDia(), i, 0);
            model.setValueAt(listaConfiguracoes.get(i).getHoraInicial(), i, 1);
            model.setValueAt(listaConfiguracoes.get(i).getHoraFinal(), i, 2);
            model.setValueAt(listaConfiguracoes.get(i).getIntervalo(), i, 3);
        }
    }

    public void diaDaSemana(String diaSemana) {
        switch (diaSemana) {
            case ("Domingo"):
                dia = 1;
                break;
            case ("Segunda-Feira"):
                dia = 2;
                break;
            case ("Terça-Feira"):
                dia = 3;
                break;
            case ("Quarta-Feira"):
                dia = 4;
                break;
            case ("Quinta-Feira"):
                dia = 5;
                break;
            case ("Sexta-Feira"):
                dia = 6;
                break;
            case ("Sábado"):
                dia = 7;
                break;
        }
    }

    public void verificaConfiguracao(String dia) {
        int linha = tblConfiguracao.getRowHeight();
        String tbl = tblConfiguracao.getValueAt(linha, 0).toString();
        for (int i = 0; i < tblConfiguracao.getRowCount(); i++) {
            if (tbl.equals(dia)) {
                JOptionPane.showMessageDialog(null, "Dia já configurado!"
                        + "Para reconfigurar exclua o dia da tabela e refaça a configuração!");
            }
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaConfiguracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConfiguracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConfiguracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConfiguracoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaConfiguracoes dialog = new TelaConfiguracoes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbDia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblConfiguracao;
    private javax.swing.JFormattedTextField txtHoraFim;
    private javax.swing.JFormattedTextField txtHoraInicio;
    private javax.swing.JTextField txtIntervalo;
    // End of variables declaration//GEN-END:variables
}
