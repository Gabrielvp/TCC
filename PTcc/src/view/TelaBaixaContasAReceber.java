/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CReceberDAO;
import dao.CadastroClienteDAO;
import dao.FormaPagamentoDAO;
import dao.Parcelas_CReceberDAO;
import entity.CReceber;
import entity.FormaPagamento;
import entity.Orcamento;
import entity.Parcelas_CReceber;
import entity.Pessoa;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel1
 */
public class TelaBaixaContasAReceber extends javax.swing.JDialog {

    /**
     * Creates new form Financeiro
     */
    public TelaBaixaContasAReceber(java.awt.Frame parent, boolean modal, Orcamento o) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        combo();
        lblDescjuros.setVisible(false);
    }

    boolean alterar = false;
    Orcamento orc;
    SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat df = new DecimalFormat("####.00");
    DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
    Pessoa p = new Pessoa();
    CReceberDAO crDAO = new CReceberDAO();
    Parcelas_CReceberDAO pcrDAO = new Parcelas_CReceberDAO();
    String fatUpdate;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFatura = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtVencimento = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDataPgto = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnPesquisaCliente = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cbFormaPagamento = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtCodigoPessoa = new javax.swing.JTextField();
        btnPesquisaOrcamento1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtValorPago = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtParcela = new javax.swing.JTextField();
        lblDescJur = new javax.swing.JLabel();
        txtDescJuros = new javax.swing.JTextField();
        lblDescjuros = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contas a Receber - Agenda Financeira");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 51, 153)));
        jPanel1.setPreferredSize(new java.awt.Dimension(599, 334));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Apply.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)), "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 10), new java.awt.Color(0, 51, 153))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel3.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 69, 397, 25));

        jLabel1.setText("Nome:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 73, -1, -1));

        txtFatura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel3.add(txtFatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 112, 96, 25));

        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel3.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 201, 126, 25));

        jLabel6.setText("Total R$");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 205, -1, -1));

        txtVencimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(txtVencimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 158, 106, 25));

        jLabel5.setText("Vencimento:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 162, -1, -1));

        txtDataPgto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtDataPgto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(txtDataPgto, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 244, 106, 25));

        jLabel4.setText("Data Pagamento:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 248, -1, -1));

        jLabel3.setText("Fatura:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 116, -1, -1));

        btnPesquisaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N
        btnPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaClienteActionPerformed(evt);
            }
        });
        jPanel3.add(btnPesquisaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 66, -1, -1));

        jLabel12.setText("Forma Pagamento:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 116, -1, -1));

        cbFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFormaPagamentoActionPerformed(evt);
            }
        });
        jPanel3.add(cbFormaPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 112, 225, 25));

        jLabel13.setText("Código:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 73, -1, -1));

        txtCodigoPessoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        txtCodigoPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoPessoaKeyPressed(evt);
            }
        });
        jPanel3.add(txtCodigoPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 69, 97, 25));

        btnPesquisaOrcamento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N
        btnPesquisaOrcamento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaOrcamento1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnPesquisaOrcamento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 112, -1, -1));

        jLabel14.setText("Valor Pago R$");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 205, -1, -1));

        txtValorPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        txtValorPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorPagoKeyPressed(evt);
            }
        });
        jPanel3.add(txtValorPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 201, 106, 25));

        jLabel15.setText("Parcela:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 162, -1, -1));

        txtParcela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel3.add(txtParcela, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 158, 127, 25));

        lblDescJur.setText("Desc / Juros");
        jPanel3.add(lblDescJur, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 248, -1, -1));

        txtDescJuros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel3.add(txtDescJuros, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 244, 108, 25));

        lblDescjuros.setText("Desc / Juros");
        jPanel3.add(lblDescjuros, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 248, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 700, 330));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Baixa Contas a Receber");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pincel.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaClienteActionPerformed
        String nome = txtNome.getText();
        if (nome.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite uma letra para pesquisa");
        } else {
            TelaPesquisaPessoa tela = new TelaPesquisaPessoa(null, rootPaneCheckingEnabled, nome, 0);
            tela.setVisible(true);
            txtNome.setText(tela.p.getNome());
            txtCodigoPessoa.setText(tela.p.getIdPessoa() + "");
        }
    }//GEN-LAST:event_btnPesquisaClienteActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisaOrcamento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaOrcamento1ActionPerformed
        if (txtCodigoPessoa.getText().equals("") || txtNome.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Insira uma pessoa para pesquisa");
        } else {
            int id = Integer.parseInt(txtCodigoPessoa.getText());
            p.setIdPessoa(Integer.parseInt(txtCodigoPessoa.getText()));
            p.setNome(txtNome.getText());
            TelaPesquisaFatura tela = new TelaPesquisaFatura(null, rootPaneCheckingEnabled, id, p, 1);
            tela.setVisible(true);
            String fatura = tela.coluna;
            fatUpdate = txtFatura.getText();

            List<CReceber> lista = crDAO.listarCReceberString(fatura);
            List<Parcelas_CReceber> listaParcelas = pcrDAO.listarParcelasString(fatura);
            for (int i = 0; i < lista.size(); i++) {
                txtFatura.setText(lista.get(i).getFatura());
                txtTotal.setText(df.format(lista.get(i).getTotal()) + "");
                txtVencimento.setText(sdfD.format(lista.get(i).getVencimento()));
                cbFormaPagamento.setSelectedItem(lista.get(i).getFormPagamento().toString());
                txtParcela.setText(lista.get(i).getParcelas() + "");
            }
            txtValorPago.requestFocus();
        }
    }//GEN-LAST:event_btnPesquisaOrcamento1ActionPerformed

    private void cbFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFormaPagamentoActionPerformed

    }//GEN-LAST:event_cbFormaPagamentoActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtCodigoPessoa.setText("");
        txtNome.setText("");
        txtFatura.setText("");
        txtDataPgto.setText("");
        txtParcela.setText("");
        txtTotal.setText("");
        txtValorPago.setText("");
        txtVencimento.setText("");
        txtDescJuros.setText("");
        cbFormaPagamento.setSelectedIndex(0);
        lblDescJur.setText("Desc / Juros");
        lblDescjuros.setVisible(false);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtCodigoPessoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPessoaKeyPressed
        CadastroClienteDAO cDAO = new CadastroClienteDAO();
        Pessoa p = new Pessoa();
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (txtCodigoPessoa.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Digite um código para pesquisa");
            } else {
                int id = Integer.parseInt(txtCodigoPessoa.getText());
                if (!txtCodigoPessoa.getText().equals("")) {
                    p = cDAO.getPessoaById(id);
                    if (p.getIdPessoa() == 0 || p.getNome().equals(null)) {
                        JOptionPane.showMessageDialog(rootPane, "Pessoa não encontrada");
                        txtCodigoPessoa.setText("");
                        txtNome.setText("");
                    } else {
                        txtCodigoPessoa.setText(p.getIdPessoa() + "");
                        txtNome.setText(p.getNome());
                        if (txtCodigoPessoa.getText().equals("0")) {
                            limparPessoa();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_txtCodigoPessoaKeyPressed

    private void txtValorPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorPagoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            Double total = Double.parseDouble(txtTotal.getText().replace(",", "."));
            Double pago = Double.parseDouble(txtValorPago.getText().replace(",", "."));
            Double resultado;
            Double juros;
            if (pago > total) {
                resultado = pago - total;
                txtDescJuros.setText(df.format(resultado) + "");
                lblDescJur.setText("Juros R$");
                Double jurosDesc = Double.parseDouble(txtDescJuros.getText().replace(",", "."));
                juros = jurosDesc * 100 / total;
                txtValorPago.setText(df.format(pago));
                lblDescjuros.setVisible(true);
                lblDescjuros.setText(df.format(juros) + "%");
                txtDataPgto.requestFocus();
                if (juros < 1) {
                    String dJ = lblDescjuros.getText();
                    lblDescjuros.setText("0" + dJ);
                }
            } else if (total > pago) {
                resultado = total - pago;
                txtDescJuros.setText(df.format(resultado) + "");
                lblDescJur.setText("Desconto R$");
                Double jurosDesc = Double.parseDouble(txtDescJuros.getText().replace(",", "."));
                juros = jurosDesc * 100 / total;
                txtValorPago.setText(df.format(pago));
                lblDescjuros.setVisible(true);
                lblDescjuros.setText(df.format(juros) + "%");
                txtDataPgto.requestFocus();
                if (juros < 1) {
                    String dJ = lblDescjuros.getText();
                    lblDescjuros.setText("0" + dJ);
                }
            } else  {
                lblDescJur.setText("Desc / Juros");
                txtDescJuros.setText("");
                lblDescjuros.setVisible(false);
                txtValorPago.setText(df.format(pago));
                txtDataPgto.requestFocus();
            }
            txtDataPgto.requestFocus();
        }
    }//GEN-LAST:event_txtValorPagoKeyPressed

    public void combo() {
        cbFormaPagamento.removeAll();
        cbFormaPagamento.removeAllItems();
        cbFormaPagamento.addItem("Selecione a Forma de Pagamento");
        FormaPagamentoDAO fpDAO = new FormaPagamentoDAO();
        List<FormaPagamento> lista = fpDAO.lista();
        for (FormaPagamento fp : lista) {
            cbFormaPagamento.addItem(fp.getDescricao());
        }
    }

    public void limparPessoa() {
        txtCodigoPessoa.setText("");
        txtNome.setText("");
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaBaixaContasAReceber.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBaixaContasAReceber.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBaixaContasAReceber.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBaixaContasAReceber.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaBaixaContasAReceber dialog = new TelaBaixaContasAReceber(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisaCliente;
    private javax.swing.JButton btnPesquisaOrcamento1;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbFormaPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblDescJur;
    private javax.swing.JLabel lblDescjuros;
    private javax.swing.JTextField txtCodigoPessoa;
    private javax.swing.JFormattedTextField txtDataPgto;
    private javax.swing.JTextField txtDescJuros;
    private javax.swing.JTextField txtFatura;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtParcela;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValorPago;
    private javax.swing.JFormattedTextField txtVencimento;
    // End of variables declaration//GEN-END:variables
}
