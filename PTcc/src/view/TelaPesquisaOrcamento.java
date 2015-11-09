/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CadastroClienteDAO;
import dao.OrcamentoDAO;
import dao.ProdutoOrcamentoDAO;
import entity.Orcamento;
import entity.Pessoa;
import entity.ProdutoOrcamento;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felipe.cunha
 */
public class TelaPesquisaOrcamento extends javax.swing.JDialog {

    /**
     * Creates new form TelaPesquisaOrcamento
     */
    public TelaPesquisaOrcamento(java.awt.Frame parent, boolean modal, int cd) {
        super(parent, modal);
        initComponents();
        this.codigo = cd;
        preencheTabela(codigo);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    int codigo;
    OrcamentoDAO oDAO = new OrcamentoDAO();
    Orcamento o = new Orcamento();
    ProdutoOrcamentoDAO pdDAO = new ProdutoOrcamentoDAO();
    SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat df = new DecimalFormat("#,###.00");
    DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
    List<Orcamento> lista;
    List<ProdutoOrcamento> listaPOrcamento;
    boolean alterar;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrcamento = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrc = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDataFim = new javax.swing.JFormattedTextField();
        btnPesquisar = new javax.swing.JButton();
        txtDataInicio = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();

        tblOrcamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Codigo", "Nome", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrcamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblOrcamentoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrcamento);
        if (tblOrcamento.getColumnModel().getColumnCount() > 0) {
            tblOrcamento.getColumnModel().getColumn(0).setResizable(false);
            tblOrcamento.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblOrcamento.getColumnModel().getColumn(1).setResizable(false);
            tblOrcamento.getColumnModel().getColumn(1).setPreferredWidth(20);
            tblOrcamento.getColumnModel().getColumn(2).setResizable(false);
            tblOrcamento.getColumnModel().getColumn(2).setPreferredWidth(180);
            tblOrcamento.getColumnModel().getColumn(3).setResizable(false);
            tblOrcamento.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        jLabel1.setText("Nome");

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        jLabel2.setText("Período");

        jFormattedTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jFormattedTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa Orçamento - Agenda Financeira");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        tblOrc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Orçamento", "Nome", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrcMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblOrcMousePressed(evt);
            }
        });
        tblOrc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblOrcKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblOrc);
        if (tblOrc.getColumnModel().getColumnCount() > 0) {
            tblOrc.getColumnModel().getColumn(0).setResizable(false);
            tblOrc.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblOrc.getColumnModel().getColumn(1).setResizable(false);
            tblOrc.getColumnModel().getColumn(1).setPreferredWidth(20);
            tblOrc.getColumnModel().getColumn(2).setResizable(false);
            tblOrc.getColumnModel().getColumn(2).setPreferredWidth(180);
            tblOrc.getColumnModel().getColumn(3).setResizable(false);
            tblOrc.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        jLabel3.setText("Nome");

        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        jLabel4.setText("Período");

        txtDataFim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataFim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDataFimFocusGained(evt);
            }
        });
        txtDataFim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDataFimMouseClicked(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        btnPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPesquisarKeyPressed(evt);
            }
        });

        txtDataInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDataInicioFocusGained(evt);
            }
        });
        txtDataInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDataInicioMouseClicked(evt);
            }
        });

        jLabel5.setText("Código");

        txtCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(245, 245, 245))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtDataInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5))
                    .addComponent(jLabel4))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisar)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblOrcamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrcamentoMousePressed
        if (evt.getClickCount() == 2) {
            int linha = tblOrc.getSelectedRow();
            String coluna = tblOrc.getValueAt(linha, 1).toString();
            int id = Integer.parseInt(coluna);
            o = oDAO.getOrcamentoId(id);
            listaPOrcamento = pdDAO.getProdutoOrcamentoId(id);
            alterar = true;
            this.dispose();
        }
    }//GEN-LAST:event_tblOrcamentoMousePressed

    private void tblOrcMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrcMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblOrcMousePressed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (txtCodigo.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Digite um código");
            } else {
                CadastroClienteDAO cDAO = new CadastroClienteDAO();
                int cd = Integer.parseInt(txtCodigo.getText());
                List<Pessoa> lista = cDAO.buscarNomeId(cd);
                if (lista.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Código inexistente");
                    txtCodigo.setText("");
                    txtNome.setText("");
                } else {
                    for (int i = 0; i < lista.size(); i++) {
                        txtCodigo.setText(lista.get(i).getIdPessoa() + "");
                        txtNome.setText(lista.get(i).getNome());
                    }
                    btnPesquisar.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void tblOrcKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblOrcKeyPressed

    }//GEN-LAST:event_tblOrcKeyPressed

    private void tblOrcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrcMouseClicked
        if (evt.getClickCount() == 2) {
            int linha = tblOrc.getSelectedRow();
            String coluna = tblOrc.getValueAt(linha, 1).toString();
            int id = Integer.parseInt(coluna);
            o = oDAO.getOrcamentoId(id);
            listaPOrcamento = pdDAO.getProdutoOrcamentoId(id);
            alterar = true;
            this.dispose();
        }
    }//GEN-LAST:event_tblOrcMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblOrc.getModel();
        if (!txtCodigo.getText().equals("") && !txtNome.getText().equals("") && txtDataInicio.getText().equals("  /  /    ")
                && txtDataFim.getText().equals("  /  /    ")) {
            int cd = Integer.parseInt(txtCodigo.getText());
            List<Orcamento> lista = oDAO.listaOrcamentoIdPessoa(cd);
            model.setNumRows(0);
            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[]{});
                tblOrc.setValueAt(sdfD.format(lista.get(i).getData()), i, 0);
                tblOrc.setValueAt(lista.get(i).getIdOrcamento(), i, 1);
                tblOrc.setValueAt(lista.get(i).getNome(), i, 2);
                tblOrc.setValueAt(df.format(lista.get(i).getTotal()), i, 3);
            }
            txtCodigo.setText("");
            txtNome.setText("");
        } else if (!txtDataInicio.getText().equals("  /  /    ") && !txtDataFim.getText().equals("  /  /    ")
                && txtCodigo.getText().equals("") && txtNome.getText().equals("")) {
            try {
                Date dtIni;
                dtIni = sdfD.parse(txtDataInicio.getText());
                Date dtFim;
                dtFim = sdfD.parse(txtDataFim.getText());
                java.sql.Date dataIni;
                java.sql.Date dataFIm;
                dataIni = new java.sql.Date(dtIni.getTime());
                dataFIm = new java.sql.Date(dtFim.getTime());
                List<Orcamento> lista = oDAO.listaOrcamentoPeriodo(dataIni, dataFIm);
                model.setNumRows(0);
                for (int i = 0; i < lista.size(); i++) {
                    model.addRow(new Object[]{});
                    tblOrc.setValueAt(sdfD.format(lista.get(i).getData()), i, 0);
                    tblOrc.setValueAt(lista.get(i).getIdOrcamento(), i, 1);
                    tblOrc.setValueAt(lista.get(i).getNome(), i, 2);
                    tblOrc.setValueAt(df.format(lista.get(i).getTotal()), i, 3);
                }
            } catch (ParseException ex) {
                Logger.getLogger(TelaPesquisaOrcamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (!txtCodigo.getText().equals("") && !txtNome.getText().equals("") && !txtDataInicio.getText().equals("  /  /    ")
                && !txtDataFim.getText().equals("  /  /    ")) {
            try {
                int cd = Integer.parseInt(txtCodigo.getText());
                Date dtIni;
                dtIni = sdfD.parse(txtDataInicio.getText());
                Date dtFim;
                dtFim = sdfD.parse(txtDataFim.getText());
                java.sql.Date dataIni;
                java.sql.Date dataFIm;
                dataIni = new java.sql.Date(dtIni.getTime());
                dataFIm = new java.sql.Date(dtFim.getTime());
                List<Orcamento> lista = oDAO.listaOrcamentoPeriodoPessoa(dataIni, dataFIm, cd);
                model.setNumRows(0);
                for (int i = 0; i < lista.size(); i++) {
                    model.addRow(new Object[]{});
                    tblOrc.setValueAt(sdfD.format(lista.get(i).getData()), i, 0);
                    tblOrc.setValueAt(lista.get(i).getIdOrcamento(), i, 1);
                    tblOrc.setValueAt(lista.get(i).getNome(), i, 2);
                    tblOrc.setValueAt(df.format(lista.get(i).getTotal()), i, 3);
                }
            } catch (ParseException ex) {
                Logger.getLogger(TelaPesquisaOrcamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        txtCodigo.setText("");
        txtNome.setText("");
        txtDataFim.setText("");
        txtDataInicio.setText("");
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPesquisarKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            if (!txtCodigo.getText().equals("") && !txtNome.getText().equals("")) {
                DefaultTableModel model = (DefaultTableModel) tblOrc.getModel();
                int cd = Integer.parseInt(txtCodigo.getText());
                List<Orcamento> lista = oDAO.listaOrcamentoIdPessoa(cd);
                model.setNumRows(0);
                for (int i = 0; i < lista.size(); i++) {
                    model.addRow(new Object[]{});
                    tblOrc.setValueAt(sdfD.format(lista.get(i).getData()), i, 0);
                    tblOrc.setValueAt(lista.get(i).getIdOrcamento(), i, 1);
                    tblOrc.setValueAt(lista.get(i).getNome(), i, 2);
                    tblOrc.setValueAt(df.format(lista.get(i).getTotal()), i, 3);
                }
                txtCodigo.setText("");
                txtNome.setText("");
            }
        }
    }//GEN-LAST:event_btnPesquisarKeyPressed

    private void txtDataInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDataInicioMouseClicked
        txtDataInicio.setSelectionStart(0);
        txtDataInicio.setSelectionEnd(10);
    }//GEN-LAST:event_txtDataInicioMouseClicked

    private void txtDataFimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDataFimMouseClicked
       txtDataInicio.setSelectionStart(0);
        txtDataInicio.setSelectionEnd(10);
    }//GEN-LAST:event_txtDataFimMouseClicked

    private void txtDataInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataInicioFocusGained
       txtDataInicio.setSelectionStart(0);
        txtDataInicio.setSelectionEnd(10);
    }//GEN-LAST:event_txtDataInicioFocusGained

    private void txtDataFimFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataFimFocusGained
        txtDataInicio.setSelectionStart(0);
        txtDataInicio.setSelectionEnd(10);
    }//GEN-LAST:event_txtDataFimFocusGained

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
      
    }//GEN-LAST:event_txtNomeKeyPressed

    private void preencheTabela(int codigo) {
        esquerda.setHorizontalAlignment(SwingConstants.RIGHT);
        tblOrc.getColumnModel().getColumn(3).setCellRenderer(esquerda);
        DefaultTableModel model = (DefaultTableModel) tblOrc.getModel();
        if (codigo == 0) {
            List<Orcamento> orcamento = oDAO.listarOrcamentos();
            model.setNumRows(0);
            for (int i = 0; i < orcamento.size(); i++) {
                model.addRow(new Object[]{});
                tblOrc.setValueAt(sdfD.format(orcamento.get(i).getData()), i, 0);
                tblOrc.setValueAt(orcamento.get(i).getIdOrcamento(), i, 1);
                tblOrc.setValueAt(orcamento.get(i).getNome(), i, 2);
                tblOrc.setValueAt(df.format(orcamento.get(i).getTotal()), i, 3);
            }
        } else {
            List<Orcamento> orcamento = oDAO.listaOrcamentoId(codigo);
            for (int i = 0; i < orcamento.size(); i++) {
                model.addRow(new Object[]{});
                tblOrc.setValueAt(sdfD.format(orcamento.get(i).getData()), i, 0);
                tblOrc.setValueAt(orcamento.get(i).getIdOrcamento(), i, 1);
                tblOrc.setValueAt(orcamento.get(i).getNome(), i, 2);
                tblOrc.setValueAt(df.format(orcamento.get(i).getTotal()), i, 3);
            }
        }
    }

    private void preencheTabelaNome(String nome) {
        esquerda.setHorizontalAlignment(SwingConstants.RIGHT);
        tblOrc.getColumnModel().getColumn(3).setCellRenderer(esquerda);
        DefaultTableModel model = (DefaultTableModel) tblOrc.getModel();
        List<Orcamento> lista = oDAO.getOrcamentoNome(nome);
        model.setNumRows(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{});
            tblOrc.setValueAt(sdfD.format(lista.get(i).getData()), i, 0);
            tblOrc.setValueAt(lista.get(i).getIdOrcamento(), i, 1);
            tblOrc.setValueAt(lista.get(i).getNome(), i, 2);
            tblOrc.setValueAt(df.format(lista.get(i).getTotal()), i, 3);
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
            java.util.logging.Logger.getLogger(TelaPesquisaOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPesquisaOrcamento dialog = new TelaPesquisaOrcamento(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblOrc;
    private javax.swing.JTable tblOrcamento;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtDataFim;
    private javax.swing.JFormattedTextField txtDataInicio;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
