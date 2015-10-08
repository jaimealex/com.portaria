/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.view;

import com.portaria.control.EntradaController;
import com.portaria.model.EntradaModel;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
public class ManutencaoEntradasView extends javax.swing.JPanel {
    private BindingGroup bindingGroup;
    private final EntradaModel model = new EntradaModel();
    private final EntradaController controller = new EntradaController(model);
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
            frame.setContentPane(new ManutencaoEntradasView());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        });
    }

    

    public ManutencaoEntradasView() {
        initComponents();
        doBindingsMasterTableSelected();
        doBindingsMasterTableAll();
    }

    private void doBindingsMasterTableSelected() {
        bindingGroup = new BindingGroup();
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, 
                model.getPessoasSelecionadas(), masterTableSelected);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${cpf}"));
        columnBinding.setColumnName("CPF");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${rg}"));
        columnBinding.setColumnName("RG");
        columnBinding.setColumnClass(String.class);

        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
    }
    private void doBindingsMasterTableAll() {
        bindingGroup = new BindingGroup();
        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, 
                model.getPessoas(), masterTableAll);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${cpf}"));
        columnBinding.setColumnName("CPF");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);

        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${rg}"));
        columnBinding.setColumnName("RG");
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
        masterTableSelected = new javax.swing.JTable();
        nomeField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cpfField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        masterTableAll = new javax.swing.JTable();
        selButtonClient = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        placaField = new javax.swing.JTextField();
        modeloField = new javax.swing.JTextField();
        corField = new javax.swing.JTextField();
        addButtonClient = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addButtonVeh = new javax.swing.JButton();
        entradaButton = new javax.swing.JButton();

        masterTableSelected.setModel(new javax.swing.table.DefaultTableModel(
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
        masterTableSelected.setFocusable(false);
        jScrollPane1.setViewportView(masterTableSelected);

        nomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFieldActionPerformed(evt);
            }
        });
        nomeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeFieldKeyReleased(evt);
            }
        });

        jLabel1.setText("Nome:");

        cpfField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfFieldActionPerformed(evt);
            }
        });
        cpfField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cpfFieldKeyReleased(evt);
            }
        });

        jLabel2.setText("CPF");

        masterTableAll.setModel(new javax.swing.table.DefaultTableModel(
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
        masterTableAll.setFocusable(false);
        masterTableAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                masterTableAllMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(masterTableAll);

        selButtonClient.setText("Selecionar");
        selButtonClient.setEnabled(false);
        selButtonClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selButtonClientActionPerformed(evt);
            }
        });

        jLabel3.setText("Placa:");

        placaField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                placaFieldFocusLost(evt);
            }
        });
        placaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placaFieldActionPerformed(evt);
            }
        });
        placaField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                placaFieldKeyReleased(evt);
            }
        });

        modeloField.setText(" ");
        modeloField.setEnabled(false);

        corField.setText(" ");
        corField.setEnabled(false);
        corField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corFieldActionPerformed(evt);
            }
        });

        addButtonClient.setText("Adicionar Pessoa");
        addButtonClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonClientActionPerformed(evt);
            }
        });

        jLabel4.setText("Modelo:");

        jLabel5.setText("Cor:");

        addButtonVeh.setText("Adicionar Veiculo");
        addButtonVeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonVehActionPerformed(evt);
            }
        });

        entradaButton.setText("Efetuar Entrada");
        entradaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaButtonActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(placaField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modeloField)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(corField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)
                                .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(selButtonClient)
                                .addGap(36, 36, 36)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(addButtonClient, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(addButtonVeh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(entradaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(selButtonClient))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(placaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modeloField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButtonClient)
                    .addComponent(addButtonVeh)
                    .addComponent(entradaButton))
                .addGap(0, 9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selButtonClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selButtonClientActionPerformed
        int row = masterTableAll.getSelectedRow();
        if (row >= 0) {            
            model.movePessoa(row);
        }
    }//GEN-LAST:event_selButtonClientActionPerformed

    private void cpfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfFieldActionPerformed

    private void nomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFieldActionPerformed

    private void nomeFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeFieldKeyReleased
        if(nomeField.getText().length() > 3) { //mudar valor minimo para um valor maior
            model.setFiltroPessoaByNome(nomeField.getText());
            
        }
        if(nomeField.getText().length() == 0) {
            model.setFiltroPessoaByNome(null);            
        }        
    }//GEN-LAST:event_nomeFieldKeyReleased

    private void placaFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_placaFieldKeyReleased
        boolean lOk = false;
        if(placaField.getText().length() > 1) { //mudar valor minimo para um valor maior
            model.setFiltroVeiculoByPlaca(placaField.getText());
            
        }
        if(placaField.getText().length() == 0) {
            model.setFiltroVeiculoByPlaca(null);            
        }
        showVeiculo();
    }//GEN-LAST:event_placaFieldKeyReleased
 
    private void placaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placaFieldActionPerformed

    private void corFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_corFieldActionPerformed

    private void refreshTable(){
        model.setFiltroPessoaByNome(null);
    }
    
    private void addButtonClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonClientActionPerformed
        EventQueue.invokeLater(() -> {
            ManutencaoPessoaView.main(null);
        });
            
    }//GEN-LAST:event_addButtonClientActionPerformed

    private void addButtonVehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonVehActionPerformed
        EventQueue.invokeLater(() -> {
            ManutencaoVeiculoView.main(null);
        });
    }//GEN-LAST:event_addButtonVehActionPerformed

    private void placaFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_placaFieldFocusLost
         if (model.getVeiculo().getIdveiculo() != null) {
            placaField.setText(model.getVeiculo().getPlaca());
        }
    }//GEN-LAST:event_placaFieldFocusLost

    private void cpfFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpfFieldKeyReleased
        if(cpfField.getText().length() > 3) { //mudar valor minimo para um valor maior
            model.setFiltroPessoaByCpf(cpfField.getText());

        }
        if(cpfField.getText().length() == 0) {
            model.setFiltroPessoaByNome(null);
        }
    }//GEN-LAST:event_cpfFieldKeyReleased

    private void entradaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaButtonActionPerformed
        int opcao = JOptionPane.showConfirmDialog(null, "Confirma a entrada dos itens selecionados?", "Confirmação", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.OK_OPTION) {
            model.salvaEntrada();
            placaField.setText("");
            modeloField.setText("");
            corField.setText("");
        }
    }//GEN-LAST:event_entradaButtonActionPerformed

    private void masterTableAllMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableAllMouseReleased
        selButtonClient.setEnabled(true);
    }//GEN-LAST:event_masterTableAllMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButtonClient;
    private javax.swing.JButton addButtonVeh;
    private javax.swing.JTextField corField;
    private javax.swing.JTextField cpfField;
    private javax.swing.JButton entradaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable masterTableAll;
    private javax.swing.JTable masterTableSelected;
    private javax.swing.JTextField modeloField;
    private javax.swing.JTextField nomeField;
    private javax.swing.JTextField placaField;
    private javax.swing.JButton selButtonClient;
    // End of variables declaration//GEN-END:variables

    private void showVeiculo() {
        modeloField.setText(model.getVeiculo().getModelo());
        corField.setText(model.getVeiculo().getCor());
        /*if (model.getVeiculo().getIdveiculo()!= null){
            placaField.setText(model.getVeiculo().getPlaca());
        }*/
    }

}
