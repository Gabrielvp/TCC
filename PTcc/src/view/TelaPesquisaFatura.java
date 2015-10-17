/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CPagarDAO;
import dao.OrcamentoDAO;
import dao.ProdutoOrcamentoDAO;
import entity.CPagar;
import entity.Orcamento;
import entity.Pessoa;
import entity.ProdutoOrcamento;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felipe.cunha
 */
public class TelaPesquisaFatura extends javax.swing.JDialog {

    /**
     * Creates new form TelaPesquisaOrcamento
     */
    public TelaPesquisaFatura(java.awt.Frame parent, boolean modal, int cd, Pessoa p) {
        super(parent, modal);
        initComponents();
        this.codigo = cd;
        preencheTabela(codigo);
        setLocationRelativeTo(null);
        setResizable(false);
        lblCodigo.setText(p.getIdPessoa()+"");
        lblNome.setText(p.getNome());
    }

    int codigo;
    CPagarDAO cpDAO = new CPagarDAO();
    SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat df = new DecimalFormat("#,###.00");
    DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
    List<Orcamento> lista;
    List<ProdutoOrcamento> listaPOrcamento;
    boolean alterar;
    String coluna;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblFatura = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa Orçamento - Agenda Financeira");

        tblFatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vencimento", "Parcela", "Valor", "Fatura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFatura.setShowHorizontalLines(true);
        tblFatura.setShowVerticalLines(true);
        tblFatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblFaturaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblFatura);
        if (tblFatura.getColumnModel().getColumnCount() > 0) {
            tblFatura.getColumnModel().getColumn(0).setResizable(false);
            tblFatura.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblFatura.getColumnModel().getColumn(1).setResizable(false);
            tblFatura.getColumnModel().getColumn(1).setPreferredWidth(20);
            tblFatura.getColumnModel().getColumn(2).setResizable(false);
            tblFatura.getColumnModel().getColumn(2).setPreferredWidth(20);
            tblFatura.getColumnModel().getColumn(3).setResizable(false);
            tblFatura.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        lblCodigo.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblCodigo.setText("Codigo");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("-");

        lblNome.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblNome.setText("nome");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodigo)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblNome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(jLabel2)
                    .addComponent(lblNome))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFaturaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFaturaMousePressed
        if (evt.getClickCount() == 2) {
            int linha = tblFatura.getSelectedRow();
            coluna = tblFatura.getValueAt(linha, 3).toString();          
            alterar = true;
            this.dispose();
        }
    }//GEN-LAST:event_tblFaturaMousePressed

    private void preencheTabela(int codigo) {
        esquerda.setHorizontalAlignment(SwingConstants.RIGHT);
        tblFatura.getColumnModel().getColumn(3).setCellRenderer(esquerda);
        DefaultTableModel model = (DefaultTableModel) tblFatura.getModel();        
            List<CPagar> lista = cpDAO.listarCPagar(codigo);
            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[]{});
                tblFatura.setValueAt(sdfD.format(lista.get(i).getVencimento()), i, 0);
                tblFatura.setValueAt(lista.get(i).getParcelas(), i, 1);
                tblFatura.setValueAt(df.format(lista.get(i).getTotal()), i, 2);
                tblFatura.setValueAt(lista.get(i).getFatura(), i, 3);
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
            java.util.logging.Logger.getLogger(TelaPesquisaFatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaFatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaFatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaFatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPesquisaFatura dialog = new TelaPesquisaFatura(new javax.swing.JFrame(), true, 0, null);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tblFatura;
    // End of variables declaration//GEN-END:variables
}
