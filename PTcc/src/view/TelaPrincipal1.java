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
import entity.Pessoa;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel1
 */
public final class TelaPrincipal1 extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal1() {
        initComponents();
        setLocationRelativeTo(null);
        ajustaTela();
        dataTela();
        configuracao();
        tabelaPrincipal();
        atualizaTabela();
        atualizaDiaSemanaTela();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        tblPrincipal.setShowHorizontalLines(true);
        tblPrincipal.setShowVerticalLines(true);        
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
    DefaultTableCellRenderer direita = new DefaultTableCellRenderer();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
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
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jPanel5 = new javax.swing.JPanel();
        lblProduto = new javax.swing.JLabel();
        lblOrcamento = new javax.swing.JLabel();
        lblPessoa = new javax.swing.JLabel();
        lblCaixa = new javax.swing.JLabel();
        lblConfiguracao = new javax.swing.JLabel();
        lblFinanceiro = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal - Agenda Financeira");
        setBackground(new java.awt.Color(153, 153, 153));
        setForeground(new java.awt.Color(153, 153, 153));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 153)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
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
                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 1106, Short.MAX_VALUE)
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

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1280, 130));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Data");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

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
        jPanel2.add(txtHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 50, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Horário");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 170, -1, -1));

        tblPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 51, 153)));
        tblPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Horário", "ID", "Cliente", "Serviço", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            tblPrincipal.getColumnModel().getColumn(0).setPreferredWidth(6);
            tblPrincipal.getColumnModel().getColumn(1).setResizable(false);
            tblPrincipal.getColumnModel().getColumn(1).setPreferredWidth(5);
            tblPrincipal.getColumnModel().getColumn(2).setResizable(false);
            tblPrincipal.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblPrincipal.getColumnModel().getColumn(3).setPreferredWidth(630);
            tblPrincipal.getColumnModel().getColumn(4).setResizable(false);
            tblPrincipal.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1290, 370));

        lblDiaSemana.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDiaSemana.setForeground(new java.awt.Color(255, 51, 51));
        lblDiaSemana.setText("diaSemana");
        jPanel2.add(lblDiaSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        btnProximoHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N
        btnProximoHorario.setText("Próximo Horário");
        btnProximoHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoHorarioActionPerformed(evt);
            }
        });
        jPanel2.add(btnProximoHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, -1, 46));

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back.png"))); // NOI18N
        btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAnteriorMousePressed(evt);
            }
        });
        jPanel2.add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Forward.png"))); // NOI18N
        btnProximo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnProximoMousePressed(evt);
            }
        });
        jPanel2.add(btnProximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        btnDataDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh.png"))); // NOI18N
        btnDataDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDataDiaMousePressed(evt);
            }
        });
        jPanel2.add(btnDataDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));
        jPanel2.add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 130, -1));
        jPanel2.add(filler2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, -1, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/estoque2.png"))); // NOI18N
        lblProduto.setToolTipText("Cadastro de Produtos");
        lblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProdutoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblProdutoMouseExited(evt);
            }
        });
        jPanel5.add(lblProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, -1, -1));

        lblOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/orcamento2.png"))); // NOI18N
        lblOrcamento.setToolTipText("Orçamento");
        lblOrcamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrcamentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOrcamentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOrcamentoMouseExited(evt);
            }
        });
        jPanel5.add(lblOrcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, -1));

        lblPessoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_add2.png"))); // NOI18N
        lblPessoa.setToolTipText("Cadastro de Pessoas");
        lblPessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPessoaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPessoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPessoaMouseExited(evt);
            }
        });
        jPanel5.add(lblPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Financeiro 162.png"))); // NOI18N
        lblCaixa.setToolTipText("Fluxo de Caixa");
        lblCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaixaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCaixaMouseExited(evt);
            }
        });
        jPanel5.add(lblCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, -1));

        lblConfiguracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/configuração2.png"))); // NOI18N
        lblConfiguracao.setToolTipText("Configurações");
        lblConfiguracao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConfiguracaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblConfiguracaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblConfiguracaoMouseExited(evt);
            }
        });
        jPanel5.add(lblConfiguracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, -1));

        lblFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/financeiro2.png"))); // NOI18N
        lblFinanceiro.setToolTipText("Contas a Receber");
        lblFinanceiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFinanceiroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFinanceiroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblFinanceiroMouseExited(evt);
            }
        });
        jPanel5.add(lblFinanceiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, -1));

        jMenu1.setText("Cadastros");

        jMenuItem3.setText("Forma de Pagamento");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Financeiro");

        jMenuItem2.setText("Contas a Pagar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);
        jMenu2.add(jSeparator1);

        jMenuItem1.setText("Contas a Receber");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);
        jMenu2.add(jSeparator2);

        jMenu3.setText("Baixa");

        jMenuItem4.setText("Baixa Contas a Pagar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Baixa Contas a Receber");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void tblPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrincipalMousePressed
        DataHora dt = new DataHora();
        DefaultTableModel mode = (DefaultTableModel) tblPrincipal.getModel();
        SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
        Agenda a = new Agenda();
        Pessoa p = new Pessoa();
        int linha = tblPrincipal.getSelectedRow();

        if (evt.getClickCount() == 2) {
            dt.setData(txtData.getDate());
            try {
                dt.setHorario(sdfH.parse(tblPrincipal.getValueAt(linha, 0).toString()));
            } catch (ParseException ex) {
                Logger.getLogger(TelaPrincipal1.class.getName()).log(Level.SEVERE, null, ex);
            }
            dt.setDia(lblDiaSemana.getText());

            if (tblPrincipal.getValueAt(linha, 1).toString().equals("")) {
                novo = true;
                TelaAgendamento tela = new TelaAgendamento(this, rootPaneCheckingEnabled, dt, novo, null);
                tela.setVisible(true);
            } else {
                novo = false;
                p.setIdPessoa(Integer.parseInt(tblPrincipal.getValueAt(linha, 1).toString()));
                p.setNome(tblPrincipal.getValueAt(linha, 2).toString());
                p.setTelCelular(tblPrincipal.getValueAt(linha, 4).toString());
                a.setDescricao(tblPrincipal.getValueAt(linha, 3).toString());
                a.setPessoa(p);
                TelaAgendamento tela = new TelaAgendamento(this, rootPaneCheckingEnabled, dt, novo, a);
                tela.setVisible(true);
            }
        }
        limparTabela();
        atualizaTabela();
        atualizaDiaSemanaTela();

    }//GEN-LAST:event_tblPrincipalMousePressed

    private void btnProximoHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoHorarioActionPerformed
        String diaS = lblDiaSemana.getText();
        if (txtHorario.getText().equals("  :  ")) {
            Date data = txtData.getDate();
            TelaProximoHorario tela = new TelaProximoHorario(this, rootPaneCheckingEnabled, data, "  :  ", diaS);
            tela.setVisible(true);
            limparTela();
        } else {
            Date data = txtData.getDate();
            String hora = txtHorario.getText();
            if (cDt.verificaHorario(hora)) {
                TelaProximoHorario tela = new TelaProximoHorario(this, rootPaneCheckingEnabled, data, hora, diaS);
                tela.setVisible(true);
                limparTela();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Horário Inválido!");
            }
        }
    }//GEN-LAST:event_btnProximoHorarioActionPerformed

    private void btnAnteriorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMousePressed
        DefaultTableModel model = (DefaultTableModel) tblPrincipal.getModel();
        model.setNumRows(0);
        GregorianCalendar calInicio = new GregorianCalendar();
        cont -= 1;
        Date dt = txtData.getDate();
        calInicio.add(GregorianCalendar.DAY_OF_MONTH, cont);
        dt = calInicio.getTime();
        txtData.setDate(dt);
        configuracao2();
    }//GEN-LAST:event_btnAnteriorMousePressed

    private void btnProximoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProximoMousePressed
        DefaultTableModel model = (DefaultTableModel) tblPrincipal.getModel();
        model.setNumRows(0);
        GregorianCalendar calInicio = new GregorianCalendar();
        cont++;
        Date dt = txtData.getDate();
        calInicio.add(GregorianCalendar.DAY_OF_MONTH, cont);
        dt = calInicio.getTime();
        txtData.setDate(dt);
        configuracao2();
    }//GEN-LAST:event_btnProximoMousePressed

    private void btnDataDiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDataDiaMousePressed
        DefaultTableModel model = (DefaultTableModel) tblPrincipal.getModel();
        model.setNumRows(0);
        limparTabela();
        dataTela();
        configuracao2();
        cont = 0;
    }//GEN-LAST:event_btnDataDiaMousePressed

    private void lblPessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPessoaMouseClicked
        TelaCadastroPessoa Cp = new TelaCadastroPessoa(this, rootPaneCheckingEnabled);
        Cp.setVisible(true);
    }//GEN-LAST:event_lblPessoaMouseClicked

    private void lblFinanceiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFinanceiroMouseClicked
        TelaContasAReceber f = new TelaContasAReceber(this, rootPaneCheckingEnabled, null);
        f.setVisible(true);
    }//GEN-LAST:event_lblFinanceiroMouseClicked

    private void lblOrcamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrcamentoMouseClicked
        TelaOrcamento o = new TelaOrcamento(this, rootPaneCheckingEnabled, null);
        o.setVisible(true);
    }//GEN-LAST:event_lblOrcamentoMouseClicked

    private void lblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProdutoMouseClicked
        TelaProdutos p = new TelaProdutos(this, rootPaneCheckingEnabled);
        p.setVisible(true);
    }//GEN-LAST:event_lblProdutoMouseClicked

    private void lblCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaixaMouseClicked
        TelaCaixa c = new TelaCaixa(this, rootPaneCheckingEnabled);
        c.setVisible(true);
    }//GEN-LAST:event_lblCaixaMouseClicked

    private void lblConfiguracaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConfiguracaoMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblPrincipal.getModel();
        TelaConfiguracoes c = new TelaConfiguracoes(this, rootPaneCheckingEnabled);
        c.setVisible(true);
        configuracao();
        model.setNumRows(0);
        Calendar cl = Calendar.getInstance();
        int dia = cl.get(Calendar.DAY_OF_WEEK);
        List<Configuracao> lista = cDAO.listarConfiguracaoDia(dia);
        if (!lista.isEmpty()) {
            tabelaPrincipal();
            atualizaTabela();
        }
    }//GEN-LAST:event_lblConfiguracaoMouseClicked

    private void lblPessoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPessoaMouseEntered
        lblPessoa.setBorder(BorderFactory.createBevelBorder(1));
    }//GEN-LAST:event_lblPessoaMouseEntered

    private void lblProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProdutoMouseEntered
        lblProduto.setBorder(BorderFactory.createBevelBorder(1));
    }//GEN-LAST:event_lblProdutoMouseEntered

    private void lblOrcamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrcamentoMouseEntered
        lblOrcamento.setBorder(BorderFactory.createBevelBorder(1));
    }//GEN-LAST:event_lblOrcamentoMouseEntered

    private void lblFinanceiroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFinanceiroMouseEntered
        lblFinanceiro.setBorder(BorderFactory.createBevelBorder(1));
    }//GEN-LAST:event_lblFinanceiroMouseEntered

    private void lblCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaixaMouseEntered
        lblCaixa.setBorder(BorderFactory.createBevelBorder(1));
    }//GEN-LAST:event_lblCaixaMouseEntered

    private void lblConfiguracaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConfiguracaoMouseEntered
        lblConfiguracao.setBorder(BorderFactory.createBevelBorder(1));
    }//GEN-LAST:event_lblConfiguracaoMouseEntered

    private void lblPessoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPessoaMouseExited
        lblPessoa.setBorder(null);
    }//GEN-LAST:event_lblPessoaMouseExited

    private void lblProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProdutoMouseExited
        lblProduto.setBorder(null);
    }//GEN-LAST:event_lblProdutoMouseExited

    private void lblOrcamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrcamentoMouseExited
        lblOrcamento.setBorder(null);
    }//GEN-LAST:event_lblOrcamentoMouseExited

    private void lblFinanceiroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFinanceiroMouseExited
        lblFinanceiro.setBorder(null);
    }//GEN-LAST:event_lblFinanceiroMouseExited

    private void lblCaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaixaMouseExited
        lblCaixa.setBorder(null);
    }//GEN-LAST:event_lblCaixaMouseExited

    private void lblConfiguracaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConfiguracaoMouseExited
        lblConfiguracao.setBorder(null);
    }//GEN-LAST:event_lblConfiguracaoMouseExited

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        TelaBaixaContasAPagar tela = new TelaBaixaContasAPagar(this, novo);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        TelaBaixaContasAReceber tela = new TelaBaixaContasAReceber(this, novo, null);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    String inicio;
    String fim;
    int intervalo;
    int in;
    int f;

    public void ajustaTela() {
        int largura = Toolkit.getDefaultToolkit().getScreenResolution();
        int altura = Toolkit.getDefaultToolkit().getScreenSize().height;       

        JFrame quadro = new JFrame();
        quadro.setSize(largura, altura);
        quadro.pack();
    }

    public void configuracao() {
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DAY_OF_WEEK);
        List<Configuracao> lista = cDAO.listarConfiguracaoDia(dia);
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "             DIA NÃO CONFIGURADO!\n\n Acesse o menu configurações para configurar\n o dia de trabalho");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                inicio = sdfH.format(lista.get(i).getHoraInicial());
                fim = sdfH.format(lista.get(i).getHoraFinal().getTime());
                intervalo = lista.get(i).getIntervalo();
                in = Integer.parseInt(inicio.substring(0, 2));
                f = Integer.parseInt(fim.substring(0, 2));
            }
        }
    }

    public void configuracao2() {
        SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");

        Date data = new Date(txtData.getDate().getTime());
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        int dia = c.get(c.DAY_OF_WEEK);
        diaDaSemana(dia);

        List<Configuracao> lista = cDAO.listarConfiguracaoDia(dia);
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "             DIA NÃO CONFIGURADO!\n\n Acesse o menu configurações para configurar\n o dia de trabalho");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                inicio = sdfH.format(lista.get(i).getHoraInicial());
                fim = sdfH.format(lista.get(i).getHoraFinal().getTime());
                intervalo = lista.get(i).getIntervalo();
                in = Integer.parseInt(inicio.substring(0, 2));
                f = Integer.parseInt(fim.substring(0, 2));
            }
            tabelaPrincipal();
            limparTabela();
            atualizaTabela();
            atualizaDiaSemanaTela();
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
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        tblPrincipal.getColumnModel().getColumn(0).setCellRenderer(direita);
        tblPrincipal.getColumnModel().getColumn(1).setCellRenderer(direita);
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
                    model.setValueAt(listaAgendamentos.get(i), j, 3);
                    model.setValueAt(listaAgendamentos.get(i).getPessoa().getIdPessoa(), j, 1);
                    model.setValueAt(listaAgendamentos.get(i).getPessoa().getNome(), j, 2);
                    model.setValueAt(listaAgendamentos.get(i).getPessoa().getTelCelular(), j, 4);
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
            model.setValueAt(text, i, 3);
            model.setValueAt(text, i, 4);
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
            java.util.logging.Logger.getLogger(TelaPrincipal1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal1.class
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnDataDia;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisaHoraMarcada;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnProximoHorario;
    private javax.swing.JCheckBox ckbConsultasRealizadas;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lblCaixa;
    private javax.swing.JLabel lblConfiguracao;
    private javax.swing.JLabel lblDiaSemana;
    private javax.swing.JLabel lblFinanceiro;
    private javax.swing.JLabel lblOrcamento;
    private javax.swing.JLabel lblPessoa;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JTable tblPrincipal;
    private com.toedter.calendar.JDateChooser txtData;
    private javax.swing.JFormattedTextField txtHorario;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
