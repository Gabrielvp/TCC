/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.ProdutoDAO;
import entity.Produto;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel
 */
public class TelaPesquisaProduto extends javax.swing.JDialog {

    /**
     * Creates new form TelaPesquisaPessoa
     */
    public TelaPesquisaProduto(java.awt.Frame parent, boolean modal, String produto) {
        super(parent, modal);
        initComponents();
        this.pesquisa = produto;
        buscaProduto(produto);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    String pesquisa;
    ProdutoDAO pDAO = new ProdutoDAO();
    Produto p = new Produto();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa Produto - Agenda Financeira");

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProdutoMousePressed(evt);
            }
        });
        tblProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProdutoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduto);
        if (tblProduto.getColumnModel().getColumnCount() > 0) {
            tblProduto.getColumnModel().getColumn(0).setResizable(false);
            tblProduto.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblProduto.getColumnModel().getColumn(1).setResizable(false);
            tblProduto.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblProduto.getColumnModel().getColumn(2).setResizable(false);
            tblProduto.getColumnModel().getColumn(2).setPreferredWidth(15);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMousePressed
        if (evt.getClickCount() == 2) {
            int linha = tblProduto.getSelectedRow();
            String coluna = tblProduto.getValueAt(linha, 0).toString();
            int id = Integer.parseInt(coluna);
            p = pDAO.getProdutoById(id);
            this.dispose();
        }
    }//GEN-LAST:event_tblProdutoMousePressed

    private void tblProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProdutoKeyReleased
        if (evt.getKeyCode() == evt.VK_ENTER) {
            int linha = tblProduto.getSelectedRow();
            String coluna = tblProduto.getValueAt(linha, 0).toString();
            int id = Integer.parseInt(coluna);
            p = pDAO.getProdutoById(id);
            this.dispose();
        }
    }//GEN-LAST:event_tblProdutoKeyReleased

    public void buscaProduto(String produto) {
        List<Produto> listaProduto = pDAO.buscarProduto(produto);
        DefaultTableModel modelo = (DefaultTableModel) tblProduto.getModel();
        for (int i = 0; i < listaProduto.size(); i++) {
            modelo.addRow(new Object[]{});
            modelo.setValueAt(listaProduto.get(i).getIdProduto(), i, 0);
            modelo.setValueAt(listaProduto.get(i).getDescricao(), i, 1);
            modelo.setValueAt(df.format(listaProduto.get(i).getValorVenda()), i, 2);
        }
    }
    DecimalFormat df = new DecimalFormat("#,###.00");

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
            java.util.logging.Logger.getLogger(TelaPesquisaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPesquisaProduto dialog = new TelaPesquisaProduto(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduto;
    // End of variables declaration//GEN-END:variables
}
