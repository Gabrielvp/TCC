/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CReceberDAO;
import dao.FormaPagamentoDAO;
import dao.Parcelas_CReceberDAO;
import entity.CReceber;
import entity.FormaPagamento;
import entity.Orcamento;
import entity.Parcelas_CReceber;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel1
 */
public class TelaContasAReceber extends javax.swing.JDialog {

    /**
     * Creates new form Financeiro
     */
    public TelaContasAReceber(java.awt.Frame parent, boolean modal, Orcamento o) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.orc = o;
        if (orc == null) {
            limparOrc();
        } else {
            txtCodigoPessoa.setText(o.getIdPessoa() + "");
            txtNome.setText(o.getNome());
            txtData.setText(sdfD.format(o.getData()));
            txtFatura.setText(o.getIdOrcamento() + "");
            txtTotal.setText(df.format(o.getTotal()) + "");
            txtOrcamento.setText(o.getIdOrcamento() + "");
            String data = sdfD.format(new Date());
            txtVencimento.setText(data);
        }
        combo();
    }
    Orcamento orc;
    SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat df = new DecimalFormat("####.00");
    DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        txtIntervalo = new javax.swing.JTextField();
        txtValorParcela = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtParcelas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParcelas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtOrcamento = new javax.swing.JTextField();
        btnPesquisaOrcamento = new javax.swing.JButton();
        txtFatura = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtVencimento = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnPesquisaCliente = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cbFormaPagamento = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtCodigoPessoa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

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
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 153)), "Parcelas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 10), new java.awt.Color(0, 51, 153))); // NOI18N

        jLabel10.setText("Entrada");

        txtEntrada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("Intervalo:");

        txtIntervalo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        txtIntervalo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIntervaloKeyPressed(evt);
            }
        });

        txtValorParcela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        jLabel7.setText("Parcelas:");

        txtParcelas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        txtParcelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtParcelasKeyPressed(evt);
            }
        });

        jLabel8.setText("Valor R$:");

        tblParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parcela", "Valor R$", "Vencimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblParcelas.setShowHorizontalLines(true);
        tblParcelas.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tblParcelas);
        if (tblParcelas.getColumnModel().getColumnCount() > 0) {
            tblParcelas.getColumnModel().getColumn(0).setResizable(false);
            tblParcelas.getColumnModel().getColumn(1).setResizable(false);
            tblParcelas.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtParcelas)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtValorParcela, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(txtIntervalo))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtIntervalo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 700, 170));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)), "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 10), new java.awt.Color(0, 51, 153))); // NOI18N

        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        jLabel1.setText("Nome:");

        jLabel9.setText("Orçamento:");

        txtOrcamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        btnPesquisaOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N
        btnPesquisaOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaOrcamentoActionPerformed(evt);
            }
        });

        txtFatura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        jLabel6.setText("Total R$");

        txtVencimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Vencimento:");

        txtData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Data:");

        jLabel3.setText("Fatura:");

        btnPesquisaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N
        btnPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaClienteActionPerformed(evt);
            }
        });

        jLabel12.setText("Forma Pagamento:");

        jLabel13.setText("Código:");

        txtCodigoPessoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(jLabel3))
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPesquisaOrcamento)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFatura)
                                    .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                    .addComponent(txtVencimento)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisaCliente)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtCodigoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPesquisaOrcamento)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtFatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 700, 170));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Contas a Receber");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

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
            TelaPesquisaPessoa tela = new TelaPesquisaPessoa(null, rootPaneCheckingEnabled, nome);
            tela.setVisible(true);
            txtCodigoPessoa.setText(tela.p.getIdPessoa() + "");
            txtNome.setText(tela.p.getNome());
        }
    }//GEN-LAST:event_btnPesquisaClienteActionPerformed

    private void btnPesquisaOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaOrcamentoActionPerformed
        int cdPessoa = Integer.parseInt(txtCodigoPessoa.getText());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        TelaPesquisaOrcamentoNome tela = new TelaPesquisaOrcamentoNome(null, rootPaneCheckingEnabled, cdPessoa);
        tela.setVisible(true);
        if (tela.o.getIdOrcamento() == 0) {
            limparOrc();
        } else {
            txtOrcamento.setText(tela.o.getIdOrcamento() + "");
            txtData.setText(formatter.format(tela.o.getData()));
            txtTotal.setText(df.format(tela.o.getTotal()) + "");
            txtFatura.setText(tela.o.getIdOrcamento() + "");
        }

        String data = formatter.format(new Date());
        txtVencimento.setText(data);
    }//GEN-LAST:event_btnPesquisaOrcamentoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        CReceber cr = new CReceber();
        CReceberDAO crDAO = new CReceberDAO();
        Parcelas_CReceber pCR = new Parcelas_CReceber();
        Parcelas_CReceberDAO pCRDAO = new Parcelas_CReceberDAO();

        String vl = txtTotal.getText().replaceAll(",", ".");
        cr.setIdPessoa(Integer.parseInt(txtCodigoPessoa.getText()));
        cr.setPessoa(txtNome.getText());
        cr.setFormPagamento(cbFormaPagamento.getSelectedItem().toString());
        cr.setFatura(txtFatura.getText());
        cr.setTotal(Double.parseDouble(vl));
        try {
            cr.setData(sdfD.parse(txtData.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(TelaContasAReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cr.setVencimento(sdfD.parse(txtVencimento.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(TelaContasAReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
        crDAO.insert(cr);
        if (!txtParcelas.getText().equals("")) {
            if (txtValorParcela.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Pressione enter no campo parcelas para gerar o valor");
            } else if (txtEntrada.getText().equals("  /  /    ")) {
                JOptionPane.showMessageDialog(rootPane, "Digite a data de entrada");
            } else if (txtIntervalo.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Digite o intervalo");
            } else {
                int linhas = tblParcelas.getRowCount();
                for (int i = 0; i < linhas; i++) {
                    String valor = tblParcelas.getValueAt(i, 1).toString().replaceAll(",", ".");
                    pCR.setFatura(txtFatura.getText());
                    pCR.setParcelas(tblParcelas.getValueAt(i, 0).toString());
                    pCR.setValor(Double.parseDouble(valor));
                    try {
                        pCR.setEntrada(sdfD.parse(txtEntrada.getText()));
                    } catch (ParseException ex) {
                        Logger.getLogger(TelaContasAReceber.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        pCR.setVencimento(sdfD.parse(tblParcelas.getValueAt(i, 2).toString()));
                    } catch (ParseException ex) {
                        Logger.getLogger(TelaContasAReceber.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pCR.setIntervalo(Integer.parseInt(txtIntervalo.getText()));
                    pCR.setIdOrcamento(Integer.parseInt(txtOrcamento.getText()));
                    pCR.setIdCReceber(cr.getIdCReceber());

                    pCRDAO.insert(pCR);
                }
            }
            JOptionPane.showMessageDialog(rootPane, "Salvo com Sucesso!");
            limparTela();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Salvo com Sucesso!");
            limparTela();
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void txtParcelasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParcelasKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            String vl = txtTotal.getText().replaceAll(",", ".");
            double valor = Double.parseDouble(vl);
            int parcelas = Integer.parseInt(txtParcelas.getText());
            double resultado = valor / parcelas;
            txtValorParcela.setText(df.format(resultado) + "");
        }
    }//GEN-LAST:event_txtParcelasKeyPressed

    private void txtIntervaloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIntervaloKeyPressed
        int contador = 0;
        DefaultTableModel model = (DefaultTableModel) tblParcelas.getModel();
        if (evt.getKeyCode() == evt.VK_ENTER) {
            esquerda.setHorizontalAlignment(SwingConstants.RIGHT);
            tblParcelas.getColumnModel().getColumn(1).setCellRenderer(esquerda);
            tblParcelas.getColumnModel().getColumn(2).setCellRenderer(esquerda);
            try {
                int intervalo = Integer.parseInt(txtIntervalo.getText());
                int parcelas = Integer.parseInt(txtParcelas.getText());
                Date data = sdfD.parse(txtEntrada.getText());
                GregorianCalendar calInicio = new GregorianCalendar();
                for (int i = 0; i < parcelas; i++) {
                    contador++;
                    calInicio.add(GregorianCalendar.DAY_OF_MONTH, intervalo);
                    data = calInicio.getTime();
                    model.addRow(new Object[]{txtFatura.getText() + "/" + contador, txtValorParcela.getText(), sdfD.format(data)});
                }
            } catch (ParseException ex) {
                Logger.getLogger(TelaContasAReceber.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtIntervaloKeyPressed

    public void limparOrc() {
        txtOrcamento.setText("");
    }

    public void limparTela() {
        DefaultTableModel model = (DefaultTableModel) tblParcelas.getModel();
        txtCodigoPessoa.setText("");
        txtNome.setText("");
        txtOrcamento.setText("");
        txtFatura.setText("");
        txtTotal.setText("");
        txtData.setText("");
        txtVencimento.setText("");
        txtParcelas.setText("");
        txtValorParcela.setText("");
        txtEntrada.setText("");
        txtIntervalo.setText("");
        model.setNumRows(0);
    }

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
            java.util.logging.Logger.getLogger(TelaContasAReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaContasAReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaContasAReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaContasAReceber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                TelaContasAReceber dialog = new TelaContasAReceber(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton btnPesquisaCliente;
    private javax.swing.JButton btnPesquisaOrcamento;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbFormaPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblParcelas;
    private javax.swing.JTextField txtCodigoPessoa;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtEntrada;
    private javax.swing.JTextField txtFatura;
    private javax.swing.JTextField txtIntervalo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtOrcamento;
    private javax.swing.JTextField txtParcelas;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValorParcela;
    private javax.swing.JFormattedTextField txtVencimento;
    // End of variables declaration//GEN-END:variables
}
