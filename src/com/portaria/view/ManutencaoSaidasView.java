/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.view;

import com.portaria.model.SaidaModel;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author visitante
 */
public class ManutencaoSaidasView extends javax.swing.JPanel {
    private BindingGroup bindingGroup;
    private final SaidaModel model = new SaidaModel();
    //private final EntradaController controller = new EntradaController(model);
    //List<Pessoa> list;
    /**
     * Creates new form ManutencaoEntradasView2
     * @param args
     */
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(ManutencaoVeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManutencaoVeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManutencaoVeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManutencaoVeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setContentPane(new ManutencaoSaidasView());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        });
    }

    

    public ManutencaoSaidasView() {
        initComponents();
        doBindingsMasterTableSelected();
        doBindingsMasterTableAll();
        model.setPessoas();
        model.setVeiculos();
    }

    private void doBindingsMasterTableSelected() {


        bindingGroup = new BindingGroup();
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, 
                model.getVeiculos(), masterTableVeiculos);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${placa}"));
        columnBinding.setColumnName("Placa");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${modelo}"));
        columnBinding.setColumnName("Modelo");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${cor}"));
        columnBinding.setColumnName("Cor");
        columnBinding.setColumnClass(String.class);
        
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${entrada}"));
        columnBinding.setColumnName("Entrada");
        columnBinding.setColumnClass(String.class);
        
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();        
        
    }
    private void doBindingsMasterTableAll() {
        bindingGroup = new BindingGroup();
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, 
                model.getPessoas(), masterTablePessoas);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${cpf}"));
        columnBinding.setColumnName("CPF");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${rg}"));
        columnBinding.setColumnName("RG");
        columnBinding.setColumnClass(String.class);
        
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${entrada}"));
        columnBinding.setColumnName("Entrada");
        columnBinding.setColumnClass(String.class);        
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        masterTableVeiculos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        masterTablePessoas = new javax.swing.JTable();
        saiButton = new javax.swing.JButton();

        masterTableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(masterTableVeiculos);

        masterTablePessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        masterTablePessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                masterTablePessoasMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(masterTablePessoas);

        saiButton.setText("Registra Saida");
        saiButton.setEnabled(false);
        saiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saiButton)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents
  
 
    private void saiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saiButtonActionPerformed
        int opcao = JOptionPane.showConfirmDialog(null, "Confirma a saida dos itens selecionados?", "Confirmação", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.OK_OPTION) {
            model.setPessoasSelecionadas(masterTablePessoas.getSelectedRows());
            model.setVeiculosSelecionados(masterTableVeiculos.getSelectedRows());        
            model.salvaSaida();        
        }
    }//GEN-LAST:event_saiButtonActionPerformed

    private void masterTablePessoasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTablePessoasMouseReleased
        if (masterTablePessoas.getSelectedRowCount() == 0) {
            saiButton.setEnabled(false);
        }
        else {
            saiButton.setEnabled(true);
        }
            
    }//GEN-LAST:event_masterTablePessoasMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable masterTablePessoas;
    private javax.swing.JTable masterTableVeiculos;
    private javax.swing.JButton saiButton;
    // End of variables declaration//GEN-END:variables

   
}
