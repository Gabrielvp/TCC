/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.agendamentoDAO;
import entity.Agenda;
import entity.DataHora;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel1
 */
public class TelaProximoHorario extends javax.swing.JDialog {

    /**
     * Creates new form TelaProximoHorario
     */
    public TelaProximoHorario(java.awt.Frame parent, boolean modal, Date data, String hora) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.h = hora;
        tabelaHorarioLivre();
        this.dt = data;
        removeLinha();

    }

    Date dt;
    String h;
    List<Agenda> listaAgendamentos;
    SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
    boolean novo = true;
    int cont = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHorarioLivre = new javax.swing.JTable();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Próximo Horário - Agenda Financeira");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true));

        tblHorarioLivre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblHorarioLivre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Data", "Horário"
            }
        ));
        tblHorarioLivre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblHorarioLivreMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblHorarioLivre);
        if (tblHorarioLivre.getColumnModel().getColumnCount() > 0) {
            tblHorarioLivre.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblHorarioLivre.getColumnModel().getColumn(1).setPreferredWidth(20);
            tblHorarioLivre.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back.png"))); // NOI18N

        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Forward.png"))); // NOI18N
        btnProximo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnProximoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addComponent(btnProximo))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnterior)
                    .addComponent(btnProximo))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHorarioLivreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHorarioLivreMousePressed
        DataHora d = new DataHora();
        if (evt.getClickCount() == 2) {
            int linha = tblHorarioLivre.getSelectedRow();
            d.setDia(tblHorarioLivre.getValueAt(linha, 0).toString());
            String tblData = tblHorarioLivre.getValueAt(linha, 1).toString();
            String tblHora = tblHorarioLivre.getValueAt(linha, 2).toString();
            try {
                d.setData(sdfD.parse(tblData));
            } catch (ParseException ex) {
                Logger.getLogger(TelaProximoHorario.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                d.setHorario(sdfH.parse(tblHora));
            } catch (ParseException ex) {
                Logger.getLogger(TelaProximoHorario.class.getName()).log(Level.SEVERE, null, ex);
            }
            TelaAgendamento a = new TelaAgendamento(null, rootPaneCheckingEnabled, d, novo);
            a.setVisible(true);
            // this.dispose();
            removeLinha();
        }
    }//GEN-LAST:event_tblHorarioLivreMousePressed

    private void btnProximoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProximoMousePressed
        
    }//GEN-LAST:event_btnProximoMousePressed

    private void tabelaHorarioLivre() {

        agendamentoDAO aDAO = new agendamentoDAO();
        ArrayList<String> listaPeriodo = new ArrayList<>();

        if (h.equals("  :  ")) {
            Calendar inicial = Calendar.getInstance();
            inicial.set(Calendar.HOUR_OF_DAY, 8);
            inicial.set(Calendar.MINUTE, 0);

            Calendar Final = Calendar.getInstance();
            Final.set(Calendar.HOUR_OF_DAY, 18);
            Final.set(Calendar.MINUTE, 0);

            int minute = 30;

            int diaInicial = inicial.get(Calendar.DAY_OF_MONTH);
            int diaFinal = Final.get(Calendar.DAY_OF_MONTH);

            while (inicial.before(Final)) {
                listaPeriodo.add(String.format("%02d",
                        inicial.get(Calendar.HOUR_OF_DAY)) + ":" + String.format("%02d", inicial.get(Calendar.MINUTE)));
                inicial.add(Calendar.MINUTE, minute);
            }

            GregorianCalendar calInicio = new GregorianCalendar();
            calInicio.add(GregorianCalendar.DAY_OF_MONTH, 1);
            dt = calInicio.getTime();
            java.sql.Date dia;
            dia = new java.sql.Date(dt.getTime());
            Calendar c = Calendar.getInstance();
            int diaSemanaInt = calInicio.get(calInicio.DAY_OF_WEEK);
            System.out.println(calInicio);
            String diaDaSemana[] = {" ", "Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado"};
            //pega o modelo da Tabela e coloca na variavel "model"
            DefaultTableModel model
                    = (DefaultTableModel) this.tblHorarioLivre.getModel();

            for (int i = 0; i < listaPeriodo.size(); i++) {
                model.addRow(new Object[]{});
                model.setValueAt(diaDaSemana[diaSemanaInt], i, 0);
                model.setValueAt(sdfD.format(dia), i, 1);
                model.setValueAt(listaPeriodo.get(i), i, 2);
            }
        } else {
            int hora = Integer.parseInt(h.substring(0, 2));
            int minuto = Integer.parseInt(h.substring(3, 5));
            Calendar inicial = Calendar.getInstance();
            inicial.set(Calendar.HOUR_OF_DAY, hora);
            inicial.set(Calendar.MINUTE, minuto);
            int diaInicial = inicial.get(Calendar.DAY_OF_MONTH);

            GregorianCalendar calInicio = new GregorianCalendar();
            calInicio.add(GregorianCalendar.DAY_OF_MONTH, 1);
            dt = calInicio.getTime();
            java.sql.Date dia;
            dia = new java.sql.Date(dt.getTime());
            Calendar c = Calendar.getInstance();
            int diaSemanaInt = calInicio.get(calInicio.DAY_OF_WEEK);
            String diaDaSemana[] = {" ","Domingo", "Segunda-Feira", "Terça-Feira",
                "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado"};

            listaPeriodo.add(String.format("%02d",
                    inicial.get(Calendar.HOUR_OF_DAY)) + ":" + String.format("%02d", inicial.get(Calendar.MINUTE)));
            //pega o modelo da Tabela e coloca na variavel "model"
            DefaultTableModel model
                    = (DefaultTableModel) this.tblHorarioLivre.getModel();
            for (int i = 0; i < 15; i++) {
                model.addRow(new Object[]{});
                model.setValueAt(diaDaSemana[diaSemanaInt], i, 0);
                model.setValueAt(sdfD.format(dia), i, 1);
                model.setValueAt(listaPeriodo.get(i), i, 2);
                calInicio.add(GregorianCalendar.DAY_OF_MONTH, 1);
                dt = calInicio.getTime();
                dia = new java.sql.Date(dt.getTime());
                listaPeriodo.add(String.format("%02d",
                        inicial.get(Calendar.HOUR_OF_DAY)) + ":" + String.format("%02d", inicial.get(Calendar.MINUTE)));
                if (diaSemanaInt < 7) {
                    diaSemanaInt++;
                } else {
                    diaSemanaInt = 1;
                }
            }
        }
    }

    public void removeLinha() {
        DefaultTableModel model
                = (DefaultTableModel) this.tblHorarioLivre.getModel();
        agendamentoDAO aDAO = new agendamentoDAO();
        int linha = tblHorarioLivre.getRowCount() - 1;
        String tb = tblHorarioLivre.getValueAt(linha, 1).toString();

        String verificaHora;
        String verificaData;
        GregorianCalendar calInicio = new GregorianCalendar();
        calInicio.add(GregorianCalendar.DAY_OF_MONTH, 1);
        dt = calInicio.getTime();
        java.sql.Date data;
        data = new java.sql.Date(dt.getTime());
        for (int j = 0; j < tblHorarioLivre.getRowCount(); j++) {
            calInicio.add(GregorianCalendar.DAY_OF_MONTH, 1);
            dt = calInicio.getTime();
            data = new java.sql.Date(dt.getTime());
            listaAgendamentos = aDAO.listarAgendamentos(data);
            for (int i = 0; i < listaAgendamentos.size(); i++) {
                verificaData = tblHorarioLivre.getValueAt(j, 1).toString();
                verificaHora = tblHorarioLivre.getValueAt(j, 2).toString() + ":00";
                if (listaAgendamentos.get(i).getHora().toString().equals(verificaHora)
                        && sdfD.format(listaAgendamentos.get(i).getData()).toString().equals(verificaData)) {
                    model.removeRow(j);
                }
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
            java.util.logging.Logger.getLogger(TelaProximoHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProximoHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProximoHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProximoHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaProximoHorario dialog = new TelaProximoHorario(new javax.swing.JFrame(), true, null, null);
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
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnProximo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHorarioLivre;
    // End of variables declaration//GEN-END:variables
}
