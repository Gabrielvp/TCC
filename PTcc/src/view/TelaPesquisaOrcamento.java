/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.OrcamentoDAO;
import entity.Orcamento;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
    SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat df = new DecimalFormat("#,###.00");
    DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
    List<Orcamento> lista;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrcamento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblOrcamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrcamentoMousePressed
        if (evt.MOUSE_CLICKED == 2) {
            int linha = tblOrcamento.getSelectedRow();
            String coluna = tblOrcamento.getValueAt(linha, 1).toString();
            int id = Integer.parseInt(coluna);
            lista = oDAO.listaId(id);
        }
    }//GEN-LAST:event_tblOrcamentoMousePressed

    private void preencheTabela(int codigo) {
        esquerda.setHorizontalAlignment(SwingConstants.RIGHT);
        tblOrcamento.getColumnModel().getColumn(3).setCellRenderer(esquerda);
        DefaultTableModel model = (DefaultTableModel) tblOrcamento.getModel();
        if (codigo == 0) {
            List<Orcamento> orcamento = oDAO.listarOrcamentos();
            for (int i = 0; i < orcamento.size(); i++) {
                model.addRow(new Object[]{});
                tblOrcamento.setValueAt(sdfD.format(orcamento.get(i).getData()), i, 0);
                tblOrcamento.setValueAt(orcamento.get(i).getIdOrcamento(), i, 1);
                tblOrcamento.setValueAt(orcamento.get(i).getNome(), i, 2);
                tblOrcamento.setValueAt(df.format(orcamento.get(i).getTotal()), i, 3);
            }
        } else {
            List<Orcamento> orcamento = oDAO.listaOrcamentoId(codigo);
            for (int i = 0; i < orcamento.size(); i++) {
                model.addRow(new Object[]{});
                tblOrcamento.setValueAt(sdfD.format(orcamento.get(i).getData()), i, 0);
                tblOrcamento.setValueAt(orcamento.get(i).getIdOrcamento(), i, 1);
                tblOrcamento.setValueAt(orcamento.get(i).getNome(), i, 2);
                tblOrcamento.setValueAt(df.format(orcamento.get(i).getTotal()), i, 3);
            }
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrcamento;
    // End of variables declaration//GEN-END:variables
}
