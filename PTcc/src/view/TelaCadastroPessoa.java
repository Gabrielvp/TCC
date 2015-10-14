/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CadastroClienteDAO;
import dao.agendamentoDAO;
import entity.Pessoa;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel1
 */
public class TelaCadastroPessoa extends javax.swing.JDialog {

    /**
     * Creates new form TelaCadastroPessoa
     */
    public TelaCadastroPessoa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    CadastroClienteDAO pDAO = new CadastroClienteDAO();
    Pessoa p = new Pessoa();
    boolean alterar = false;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        txtRg = new javax.swing.JTextField();
        txtCep = new javax.swing.JFormattedTextField();
        txtBairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtFoneResidencial = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        txtFoneCelular = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        txtFoneComercial = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtObservacoes = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPessoa = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        ckbCadastroIncompleto = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Pessoas - Agenda Financeira");

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)), "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 10), new java.awt.Color(0, 51, 153))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nome");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 16, -1, -1));

        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 35, 554, 20));

        jLabel2.setText("Rua");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 105, -1, -1));

        txtRua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel1.add(txtRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 125, 439, 20));

        jLabel3.setText("Número");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 105, -1, -1));

        txtNumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel1.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 125, 109, 20));

        jLabel6.setText("UF");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 151, -1, -1));

        txtEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel1.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 171, 58, 20));

        jLabel5.setText("Cidade");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 151, -1, -1));

        txtCidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel1.add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 171, 173, 20));

        jLabel4.setText("Bairro");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 151, -1, -1));

        jLabel7.setText("CEP");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 151, -1, -1));

        jLabel8.setText("CPF");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 59, -1, -1));

        txtCpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 79, 117, 20));

        txtRg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel1.add(txtRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 79, 188, 20));

        txtCep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 171, 117, 20));

        txtBairro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel1.add(txtBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 171, 186, 20));

        jLabel9.setText("RG");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 59, -1, -1));

        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 79, 237, 20));

        jLabel11.setText("e-mail");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 59, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)), "Telefones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 10), new java.awt.Color(0, 51, 153))); // NOI18N

        jLabel10.setText("Residencial");

        txtFoneResidencial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtFoneResidencial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel13.setText("Celular");

        txtFoneCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtFoneCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel14.setText("Comercial");

        txtFoneComercial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtFoneComercial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFoneResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFoneCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFoneComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, 0)
                        .addComponent(txtFoneComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, 0)
                        .addComponent(txtFoneCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, 0)
                        .addComponent(txtFoneResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTxtObservacoes.setColumns(20);
        jTxtObservacoes.setRows(5);
        jTxtObservacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)), "Observações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 0, 10), new java.awt.Color(0, 51, 153))); // NOI18N
        jScrollPane1.setViewportView(jTxtObservacoes);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Apply.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir)
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tblPessoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        tblPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "E-mail", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPessoaMousePressed(evt);
            }
        });
        tblPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPessoaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblPessoa);
        if (tblPessoa.getColumnModel().getColumnCount() > 0) {
            tblPessoa.getColumnModel().getColumn(0).setResizable(false);
            tblPessoa.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblPessoa.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblPessoa.getColumnModel().getColumn(2).setPreferredWidth(20);
            tblPessoa.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPessoa.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        ckbCadastroIncompleto.setText("Cadastro Incompleto");
        ckbCadastroIncompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbCadastroIncompletoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ckbCadastroIncompleto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(ckbCadastroIncompleto)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (verificaCadastroCompleto()) {
            p.setNome(txtNome.getText());
            p.setBairro(txtBairro.getText());
            p.setCep(txtCep.getText());
            p.setCidade(txtCidade.getText());
            p.setCompleto(true);
            p.setCpf(txtCpf.getText());
            p.setEmail(txtEmail.getText());
            p.setEstado(txtEstado.getText());
            p.setNumero(Integer.parseInt(txtNumero.getText()));
            p.setRg(txtRg.getText());
            p.setRua(txtRua.getText());
            p.setTelCelular(txtFoneCelular.getText());
            p.setTelComercial(txtFoneComercial.getText());
            p.setTelResidencial(txtFoneResidencial.getText());
            p.setObservacoes(jTxtObservacoes.getText());

            if (alterar == false) {
                pDAO.insert(p);
                limparCampos();

            } else {
                pDAO.update(p);
                limparCampos();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Cadastro incompleto, por favor preencha todos os dados");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void ckbCadastroIncompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbCadastroIncompletoActionPerformed
        txtNome.setText("");
        DefaultTableModel tbl = (DefaultTableModel) this.tblPessoa.getModel();
        tbl.setNumRows(0);
        txtNome.requestFocus();
    }//GEN-LAST:event_ckbCadastroIncompletoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        agendamentoDAO aDAO = new agendamentoDAO();
        int sel = tblPessoa.getSelectedRow();
        int linha = tblPessoa.getSelectedRow();
        if (sel == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um cadastro a ser excluído");
        } else {
            String tbl = tblPessoa.getValueAt(linha, 1).toString();
            if ((tbl.equals(""))) {
                JOptionPane.showMessageDialog(this, "Selecione um cadastro para exclusão");
            } else {
                int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja Excluir o Cadastro?", "Exclusão", 0, 0);
                if (confirmacao == 0) {
                    int id = (int) tblPessoa.getValueAt(linha, 0);
                    aDAO.deletePessoa(id);
                    pDAO.delete(id);
                }
            }
        }
        limparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed


    private void tblPessoaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPessoaMousePressed
        alterar();
    }//GEN-LAST:event_tblPessoaMousePressed

    private void tblPessoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPessoaKeyReleased
        if (evt.getKeyCode() == evt.VK_UP) {
            alterar();
        } else if (evt.getKeyCode() == evt.VK_DOWN) {
            alterar();
        }
    }//GEN-LAST:event_tblPessoaKeyReleased

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        String nome = txtNome.getText();
        atualizaTabelaPessoa(nome);
    }//GEN-LAST:event_txtNomeKeyPressed
    public boolean verificaCadastroCompleto() {
        if (txtNome.getText().equals("")) {           
            return false;
        } else if (txtCpf.getText().equals("")) {           
            return false;
        } else if (txtRg.getText().equals("")) {           
            return false;
        } else if (txtEmail.getText().equals("")) {           
            return false;
        } else if (txtRua.getText().equals("")) {          
            return false;
        } else if (txtNumero.getText().equals("")) {           
            return false;
        } else if (txtCep.getText().equals("")) {           
            return false;
        } else if (txtBairro.getText().equals("")) {           
            return false;
        } else if (txtCidade.getText().equals("")) {           
            return false;
        } else if (txtEstado.getText().equals("")) {          
            return false;
        }
        return true;
    }

    public void limparCampos() {
        txtEmail.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        txtNome.setText("");
        txtEstado.setText("");
        txtBairro.setText("");
        txtCep.setText("");
        txtFoneCelular.setText("");
        txtFoneComercial.setText("");
        txtFoneResidencial.setText("");
        txtCidade.setText("");
        txtNumero.setText("");
        txtRua.setText("");
        jTxtObservacoes.setText("");

    }

    public void atualizaTabelaPessoa(String nome) {
        CadastroClienteDAO cDAO = new CadastroClienteDAO();
        if (ckbCadastroIncompleto.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) this.tblPessoa.getModel();
            List<Pessoa> listaPessoaIncompleto = cDAO.listarPessoasIncompletos(nome);
            model.setNumRows(0);
            for (int i = 0; i < listaPessoaIncompleto.size(); i++) {
                if (txtNome.getText().isEmpty()) {
                    model.setNumRows(0);
                } else {
                    model.addRow(new Object[]{});
                    model.setValueAt(listaPessoaIncompleto.get(i).getIdPessoa(), i, 0);
                    model.setValueAt(listaPessoaIncompleto.get(i).getNome(), i, 1);
                }
            }
        } else {
            List<Pessoa> listaPessoaCompleto = cDAO.buscarNomeCompleto(nome);
            DefaultTableModel model = (DefaultTableModel) this.tblPessoa.getModel();
            model.setNumRows(0);
            for (int i = 0; i < listaPessoaCompleto.size(); i++) {
                model.addRow(new Object[]{});
                if (txtNome.getText().isEmpty()) {
                    model.setNumRows(0);
                } else {
                    model.setValueAt(listaPessoaCompleto.get(i).getIdPessoa(), i, 0);
                    model.setValueAt(listaPessoaCompleto.get(i).getNome(), i, 1);
                    model.setValueAt(listaPessoaCompleto.get(i).getCpf(), i, 2);
                    model.setValueAt(listaPessoaCompleto.get(i).getEmail(), i, 3);
                    model.setValueAt(listaPessoaCompleto.get(i).getTelCelular(), i, 4);

                }
            }
        }
    }

    public void alterar() {
        alterar = true;
        int linha = tblPessoa.getSelectedRow();
        int id = (int) tblPessoa.getValueAt(linha, 0);
        p = pDAO.getPessoaById(id);

        txtNome.setText(p.getNome());
        txtBairro.setText(p.getBairro());
        txtCep.setText(p.getCep());
        txtCidade.setText(p.getCidade());
        txtCpf.setText(p.getCpf());
        txtEmail.setText(p.getEmail());
        txtEstado.setText(p.getEstado());
        txtFoneCelular.setText(p.getTelCelular());
        txtFoneComercial.setText(p.getTelComercial());
        txtFoneResidencial.setText(p.getTelResidencial());
        txtNumero.setText(p.getNumero() + "");
        txtRg.setText(p.getRg());
        txtRua.setText(p.getRua());
        jTxtObservacoes.setText(p.getObservacoes());
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
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroPessoa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroPessoa dialog = new TelaCadastroPessoa(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox ckbCadastroIncompleto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTxtObservacoes;
    private javax.swing.JTable tblPessoa;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JFormattedTextField txtFoneCelular;
    private javax.swing.JFormattedTextField txtFoneComercial;
    private javax.swing.JFormattedTextField txtFoneResidencial;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables
}
