/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CDataHora;
import dao.ConfiguracaoDAO;
import dao.agendamentoDAO;
import entity.Agenda;
import entity.Configuracao;
import entity.DataHora;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel1
 */
public final class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        dataTela();
        configuracao();
        tabelaPrincipal();
        atualizaTabela();
        atualizaDiaSemanaTela();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    agendamentoDAO aDAO = new agendamentoDAO();
    List<Agenda> listaAgendamentos;
    boolean antigas = false;
    Configuracao c = new Configuracao();
    boolean novo;
    SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm:ss");
    int cont = 0;
    CDataHora cDt = new CDataHora();
    ConfiguracaoDAO cDAO = new ConfiguracaoDAO();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnPesquisaHoraMarcada = new javax.swing.JButton();
        ckbConsultasRealizadas = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtHorario = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrincipal = new javax.swing.JTable();
        lblDiaSemana = new javax.swing.JLabel();
        btnProximoHorario = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnDataDia = new javax.swing.JButton();
        txtData = new com.toedter.calendar.JDateChooser();
        btnCadCliente = new javax.swing.JButton();
        btnOrcamento = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnFinanceiro = new javax.swing.JButton();
        btnCaixa = new javax.swing.JButton();
        btnConfiguracao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal - Agenda Financeira");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 51, 153)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 153)), "Consulta Horário Agendado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 51, 153))); // NOI18N

        jLabel3.setText("Nome:");

        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        btnPesquisaHoraMarcada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N
        btnPesquisaHoraMarcada.setText("Nome");
        btnPesquisaHoraMarcada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaHoraMarcadaActionPerformed(evt);
            }
        });

        ckbConsultasRealizadas.setText("Consultas Realizadas");
        ckbConsultasRealizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbConsultasRealizadasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisaHoraMarcada, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ckbConsultasRealizadas)
                .addGap(159, 159, 159))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(ckbConsultasRealizadas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnPesquisaHoraMarcada, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 630, 130));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Data");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtHorario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHorario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtHorarioMousePressed(evt);
            }
        });
        jPanel2.add(txtHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 50, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Horário");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 599, -1, -1));

        tblPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        tblPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Horário", "Cliente", "Serviço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblPrincipalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tblPrincipalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPrincipalMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPrincipal);
        if (tblPrincipal.getColumnModel().getColumnCount() > 0) {
            tblPrincipal.getColumnModel().getColumn(0).setResizable(false);
            tblPrincipal.getColumnModel().getColumn(0).setPreferredWidth(25);
            tblPrincipal.getColumnModel().getColumn(1).setResizable(false);
            tblPrincipal.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblPrincipal.getColumnModel().getColumn(2).setResizable(false);
            tblPrincipal.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 211, 630, 382));

        lblDiaSemana.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDiaSemana.setForeground(new java.awt.Color(255, 51, 51));
        lblDiaSemana.setText("diaSemana");
        jPanel2.add(lblDiaSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        btnProximoHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N
        btnProximoHorario.setText("Próximo Horário");
        btnProximoHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoHorarioActionPerformed(evt);
            }
        });
        jPanel2.add(btnProximoHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 161, -1, 46));

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back.png"))); // NOI18N
        btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAnteriorMousePressed(evt);
            }
        });
        jPanel2.add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Forward.png"))); // NOI18N
        btnProximo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnProximoMousePressed(evt);
            }
        });
        jPanel2.add(btnProximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        btnDataDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh.png"))); // NOI18N
        btnDataDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDataDiaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDataDiaMousePressed(evt);
            }
        });
        btnDataDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataDiaActionPerformed(evt);
            }
        });
        jPanel2.add(btnDataDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));
        jPanel2.add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, -1));

        btnCadCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_add.png"))); // NOI18N
        btnCadCliente.setText("Cad. Pessoa");
        btnCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadClienteActionPerformed(evt);
            }
        });

        btnOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cadastro perguntads.png"))); // NOI18N
        btnOrcamento.setText("Orçamento");
        btnOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrcamentoActionPerformed(evt);
            }
        });

        btnProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/estoque.png"))); // NOI18N
        btnProduto.setText("Produtos");
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        btnFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/financeiro.png"))); // NOI18N
        btnFinanceiro.setText("Financeiro");
        btnFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinanceiroActionPerformed(evt);
            }
        });

        btnCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Financeiro 16.png"))); // NOI18N
        btnCaixa.setText("Caixa");
        btnCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaixaActionPerformed(evt);
            }
        });

        btnConfiguracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/configuração.png"))); // NOI18N
        btnConfiguracao.setText("Configurações");
        btnConfiguracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracaoActionPerformed(evt);
            }
        });

        jMenu1.setText("Cadastros");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Financeiro");

        jMenuItem2.setText("Contas a Pagar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem1.setText("Contas a Receber");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem3.setText("Forma de Pagamento");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOrcamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfiguracao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                    .addComponent(btnFinanceiro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCaixa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnCadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfiguracao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadClienteActionPerformed
        TelaCadastroPessoa Cp = new TelaCadastroPessoa(this, rootPaneCheckingEnabled);
        Cp.setVisible(true);
    }//GEN-LAST:event_btnCadClienteActionPerformed

    private void btnFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinanceiroActionPerformed
        TelaContasAReceber f = new TelaContasAReceber(this, rootPaneCheckingEnabled, null);
        f.setVisible(true);
    }//GEN-LAST:event_btnFinanceiroActionPerformed

    private void btnOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrcamentoActionPerformed
        TelaOrcamento o = new TelaOrcamento(this, rootPaneCheckingEnabled, null);
        o.setVisible(true);
    }//GEN-LAST:event_btnOrcamentoActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        TelaProdutos p = new TelaProdutos(this, rootPaneCheckingEnabled);
        p.setVisible(true);
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void tblPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrincipalMousePressed
        DataHora dt = new DataHora();
        SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
        int linha = tblPrincipal.getSelectedRow();

        if (evt.getClickCount() == 2) {
            dt.setData(txtData.getDate());
            try {
                dt.setHorario(sdfH.parse(tblPrincipal.getValueAt(linha, 0).toString()));
            } catch (ParseException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            dt.setDia(lblDiaSemana.getText());

            if (tblPrincipal.getValueAt(linha, 1).toString().equals("")) {
                novo = true;
                TelaAgendamento a = new TelaAgendamento(this, rootPaneCheckingEnabled, dt, novo);
                a.setVisible(true);
            } else {
                novo = false;
                TelaAgendamento a = new TelaAgendamento(this, rootPaneCheckingEnabled, dt, novo);
                a.setVisible(true);
            }
        }
        limparTabela();
        atualizaTabela();
        atualizaDiaSemanaTela();
    }//GEN-LAST:event_tblPrincipalMousePressed

    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed
        TelaCaixa c = new TelaCaixa(this, rootPaneCheckingEnabled);
        c.setVisible(true);
    }//GEN-LAST:event_btnCaixaActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int sel = tblPrincipal.getSelectedRow();
        if (sel == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o agendamento a ser excluído");
        } else {
            int linha = tblPrincipal.getSelectedRow();
            String tbl = tblPrincipal.getValueAt(linha, 1).toString();
            if ((tbl.equals(""))) {
                JOptionPane.showMessageDialog(this, "Selecione um Agendamento para Exclusão");
            } else {
                int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja Excluir o  Agendamento?", "Exclusão", 0, 0);
                if (confirmacao == 0) {
                    int line = tblPrincipal.getSelectedRow();
                    String hora = tblPrincipal.getValueAt(linha, 0).toString();
                    Date dt = txtData.getDate();
                    java.sql.Date data;
                    data = new java.sql.Date(dt.getTime());
                    agendamentoDAO aDAO = new agendamentoDAO();

                    aDAO.delete(hora, data);
                    this.limparTabela();
                    this.atualizaTabela();
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tblPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrincipalMouseEntered
        limparTabela();
        atualizaTabela();
        atualizaDiaSemanaTela();
    }//GEN-LAST:event_tblPrincipalMouseEntered

    private void tblPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrincipalMouseExited
        limparTabela();
        atualizaTabela();
        atualizaDiaSemanaTela();
    }//GEN-LAST:event_tblPrincipalMouseExited

    private void btnPesquisaHoraMarcadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaHoraMarcadaActionPerformed
        if (txtNome.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Insira um nome ou parte dele para fazer a pesquisa!");
        } else {
            String nome = txtNome.getText();
            TelaPesquisaAgendamento tela = new TelaPesquisaAgendamento(this, rootPaneCheckingEnabled, nome, antigas);
            tela.setVisible(true);
        }
        limparTela();
    }//GEN-LAST:event_btnPesquisaHoraMarcadaActionPerformed

    private void btnProximoHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoHorarioActionPerformed
        if (txtHorario.getText().equals("  :  ")) {
            Date data = txtData.getDate();
            TelaProximoHorario tela = new TelaProximoHorario(this, rootPaneCheckingEnabled, data, "  :  ");
            tela.setVisible(true);
            limparTela();
        } else {
            Date data = txtData.getDate();
            String hora = txtHorario.getText();
            if (cDt.verificaHorario(hora)) {
                TelaProximoHorario tela = new TelaProximoHorario(this, rootPaneCheckingEnabled, data, hora);
                tela.setVisible(true);
                limparTela();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Horário Inválido!");
            }
        }
    }//GEN-LAST:event_btnProximoHorarioActionPerformed

    private void ckbConsultasRealizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbConsultasRealizadasActionPerformed
        if (ckbConsultasRealizadas.isSelected()) {
            antigas = true;
        } else {
            antigas = false;
        }
    }//GEN-LAST:event_ckbConsultasRealizadasActionPerformed

    private void txtHorarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHorarioMousePressed
        txtHorario.setSelectionStart(0);
        txtHorario.setSelectionEnd(5);
    }//GEN-LAST:event_txtHorarioMousePressed

    private void btnProximoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProximoMousePressed
        GregorianCalendar calInicio = new GregorianCalendar();
        cont++;
        Date dt = txtData.getDate();
        calInicio.add(GregorianCalendar.DAY_OF_MONTH, cont);
        dt = calInicio.getTime();
        txtData.setDate(dt);

        limparTabela();
        atualizaTabela();
        atualizaDiaSemanaTela();
    }//GEN-LAST:event_btnProximoMousePressed

    private void btnDataDiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDataDiaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDataDiaMouseClicked

    private void btnDataDiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDataDiaMousePressed
        limparTabela();
        dataTela();
        atualizaTabela();
        atualizaDiaSemanaTela();
        cont = 0;
    }//GEN-LAST:event_btnDataDiaMousePressed

    private void btnDataDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDataDiaActionPerformed

    private void btnAnteriorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMousePressed
        GregorianCalendar calInicio = new GregorianCalendar();
        cont -= 1;
        Date dt = txtData.getDate();
        calInicio.add(GregorianCalendar.DAY_OF_MONTH, cont);
        dt = calInicio.getTime();
        txtData.setDate(dt);

        limparTabela();
        atualizaTabela();
        atualizaDiaSemanaTela();
    }//GEN-LAST:event_btnAnteriorMousePressed

    private void btnConfiguracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracaoActionPerformed
        TelaConfiguracoes c = new TelaConfiguracoes(this, rootPaneCheckingEnabled);
        c.setVisible(true);
        if (tblPrincipal.getRowCount() > 0) {

        } else {
            configuracao();
            tabelaPrincipal();
            atualizaTabela();
        }
        if (c.excluir > 0) {
            configuracao();
            apagarTabela();
        }
    }//GEN-LAST:event_btnConfiguracaoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TelaContasAPagar tela = new TelaContasAPagar(this, rootPaneCheckingEnabled);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TelaContasAReceber tela = new TelaContasAReceber(this, rootPaneCheckingEnabled, null);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        TelaFormaDePagamento tela = new TelaFormaDePagamento(this, novo);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    String inicio;
    String fim;
    int intervalo;
    int in;
    int f;

    public void configuracao() {
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DAY_OF_WEEK);
        List<Configuracao> lista = cDAO.listarConfiguracaoDia(dia);
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Dia não Configurado!\n Acesse o menu configurções para configurar\n o dia de trabalho");
        }
        for (int i = 0; i < lista.size(); i++) {
            inicio = sdfH.format(lista.get(i).getHoraInicial());
            fim = sdfH.format(lista.get(i).getHoraFinal().getTime());
            intervalo = lista.get(i).getIntervalo();
            in = Integer.parseInt(inicio.substring(0, 2));
            f = Integer.parseInt(fim.substring(0, 2));
        }
    }

    public void dataTela() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date data = new Date();
            txtData.setDate(data);
            lblDiaSemana.setText(formatter.format(Calendar.DAY_OF_WEEK));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DAY_OF_WEEK);
        diaDaSemana(dia);
    }

    public void diaDaSemana(int dia) {
        String diaDaSemana[] = {"Domingo", "Segunda-Feira", "Terça-Feira",
            "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado"};
        lblDiaSemana.setText(diaDaSemana[dia - 1]);
    }

    private void tabelaPrincipal() {
        ArrayList<String> listaPeriodo = new ArrayList<>();
        //Seta a hora inicial  
        Calendar inicial = Calendar.getInstance();
        inicial.set(Calendar.HOUR_OF_DAY, in);
        inicial.set(Calendar.MINUTE, 0);

        //Seta hora final
        Calendar Final = Calendar.getInstance();
        Final.set(Calendar.HOUR_OF_DAY, f);
        Final.set(Calendar.MINUTE, 0);

        //Periodo a ser somado  
        int minute = intervalo;

        //Guarda o dia inicial  e final
        int diaInicial = inicial.get(Calendar.DAY_OF_MONTH);
        int diaFinal = Final.get(Calendar.DAY_OF_MONTH);

        //Enquanto o horário inicial for menor que o final add lista
        while (inicial.before(Final)) {
            //Pega a hora e minuto e formata para 00:00  
            listaPeriodo.add(String.format("%02d", inicial.get(Calendar.HOUR_OF_DAY)) + ":" + String.format("%02d", inicial.get(Calendar.MINUTE)));

            //Soma o minuto  
            inicial.add(Calendar.MINUTE, minute);

        }

        //pega o modelo da Tabela e coloca na variavel "model"
        DefaultTableModel model
                = (DefaultTableModel) this.tblPrincipal.getModel();

        //laço para inserir o número de linhas igual ao da lista
        for (int i = 0; i < listaPeriodo.size(); i++) {
            model.addRow(new Object[]{});
            model.setValueAt(listaPeriodo.get(i), i, 0);

        }
    }

    public void atualizaTabela() {
        DefaultTableModel model
                = (DefaultTableModel) this.tblPrincipal.getModel();

        SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");

        String verificaHora;
        Date dt = txtData.getDate();
        java.sql.Date data;
        data = new java.sql.Date(dt.getTime());

        String dataAtual = sdfD.format(new Date());
        String dat = sdfD.format(txtData.getDate());

        if (!dat.equals(dataAtual)) {
            tblPrincipal.setBackground(Color.PINK);

        } else {
            tblPrincipal.setBackground(null);
        }
        listaAgendamentos = aDAO.listarAgendamentos(data);
        for (int j = 0; j < tblPrincipal.getRowCount(); j++) {
            verificaHora = tblPrincipal.getValueAt(j, 0).toString() + ":00";
            for (int i = 0; i < listaAgendamentos.size(); i++) {
                if (listaAgendamentos.get(i).getHora().toString().equals(verificaHora)) {
                    model.setValueAt(listaAgendamentos.get(i), j, 2);
                    model.setValueAt(listaAgendamentos.get(i).getPessoa().getNome(), j, 1);
                }
            }
        }
    }

    public void atualizaDiaSemanaTela() {
        SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
        String diaTela = sdfD.format(txtData.getDate());
        Date data = new Date(txtData.getDate().getTime());
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        int dia = c.get(c.DAY_OF_WEEK);
        diaDaSemana(dia);
    }

    public void limparTela() {
        txtNome.setText("");
        txtHorario.setText("");
        ckbConsultasRealizadas.setSelected(false);
    }

    public void limparTabela() {
        DefaultTableModel model
                = (DefaultTableModel) this.tblPrincipal.getModel();
        String text = "";
        for (int i = 0; i < tblPrincipal.getRowCount(); i++) {
            model.setValueAt(text, i, 2);
            model.setValueAt(text, i, 1);
        }
    }

    public void apagarTabela() {
        DefaultTableModel model = (DefaultTableModel) tblPrincipal.getModel();
        model.setNumRows(0);
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCadCliente;
    private javax.swing.JButton btnCaixa;
    private javax.swing.JButton btnConfiguracao;
    private javax.swing.JButton btnDataDia;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFinanceiro;
    private javax.swing.JButton btnOrcamento;
    private javax.swing.JButton btnPesquisaHoraMarcada;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnProximoHorario;
    private javax.swing.JCheckBox ckbConsultasRealizadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiaSemana;
    private javax.swing.JTable tblPrincipal;
    private com.toedter.calendar.JDateChooser txtData;
    private javax.swing.JFormattedTextField txtHorario;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
