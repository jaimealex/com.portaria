/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.view;

import com.portaria.dao.IDAO;
import com.portaria.dao.PessoaDAO;
import com.portaria.entity.Pessoa;
import com.portaria.exception.BusinessException;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author visitante
 */
public class ManutencaoPessoaView extends JPanel {

    private Pessoa p;
    private boolean searchBt;
    private List<Pessoa> list = Collections.emptyList();
    private Long iKey;
    

    public ManutencaoPessoaView() {
        initComponents();
        myInitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        cpfLabel = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();
        rgLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        nomeField = new javax.swing.JTextField();
        modButton = new javax.swing.JButton();
        srchButton = new javax.swing.JButton();
        cpfField = new javax.swing.JFormattedTextField();
        rgField = new javax.swing.JFormattedTextField();

        FormListener formListener = new FormListener();

        masterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        masterTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        masterTable.setFocusable(false);
        masterTable.addMouseListener(formListener);
        masterTable.addKeyListener(formListener);
        masterScrollPane.setViewportView(masterTable);

        cpfLabel.setText("Cpf:");

        nomeLabel.setText("Nome:");

        rgLabel.setText("Rg:");

        saveButton.setText("Salva");
        saveButton.addActionListener(formListener);

        refreshButton.setText("Atualiza");
        refreshButton.addActionListener(formListener);

        newButton.setText("Novo");
        newButton.addActionListener(formListener);

        deleteButton.setText("Apaga");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        nomeField.setEditable(false);
        nomeField.setEnabled(false);
        nomeField.addActionListener(formListener);
        nomeField.addKeyListener(formListener);

        modButton.setText("Modifica");
        modButton.addActionListener(formListener);

        srchButton.setText("Pesquisa");
        srchButton.setActionCommand("srchButton");
        srchButton.addActionListener(formListener);

        cpfField.setEditable(false);
        try {
            cpfField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpfField.setEnabled(false);
        cpfField.addActionListener(formListener);
        cpfField.addKeyListener(formListener);

        rgField.setEditable(false);
        try {
            rgField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        rgField.setEnabled(false);
        rgField.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(srchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeLabel)
                                    .addComponent(rgLabel)
                                    .addComponent(cpfLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rgField)
                                    .addComponent(nomeField)
                                    .addComponent(cpfField)))
                            .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton, refreshButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfLabel)
                    .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rgLabel)
                    .addComponent(rgField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(refreshButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton)
                    .addComponent(modButton)
                    .addComponent(srchButton))
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.KeyListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                ManutencaoPessoaView.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                ManutencaoPessoaView.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                ManutencaoPessoaView.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                ManutencaoPessoaView.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == nomeField) {
                ManutencaoPessoaView.this.nomeFieldActionPerformed(evt);
            }
            else if (evt.getSource() == modButton) {
                ManutencaoPessoaView.this.modButtonActionPerformed(evt);
            }
            else if (evt.getSource() == srchButton) {
                ManutencaoPessoaView.this.srchButtonActionPerformed(evt);
            }
            else if (evt.getSource() == cpfField) {
                ManutencaoPessoaView.this.cpfFieldActionPerformed(evt);
            }
            else if (evt.getSource() == rgField) {
                ManutencaoPessoaView.this.rgFieldActionPerformed(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == masterTable) {
                ManutencaoPessoaView.this.masterTableKeyPressed(evt);
            }
            else if (evt.getSource() == nomeField) {
                ManutencaoPessoaView.this.nomeFieldKeyPressed(evt);
            }
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == masterTable) {
                ManutencaoPessoaView.this.masterTableKeyReleased(evt);
            }
            else if (evt.getSource() == nomeField) {
                ManutencaoPessoaView.this.nomeFieldKeyReleased(evt);
            }
            else if (evt.getSource() == cpfField) {
                ManutencaoPessoaView.this.cpfFieldKeyReleased(evt);
            }
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                ManutencaoPessoaView.this.masterTableMouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                ManutencaoPessoaView.this.masterTableMousePressed(evt);
            }
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        PessoaDAO dao = new PessoaDAO();
        list.clear();
        list.addAll(dao.findAll());
        cpfField.setEnabled(false);
        nomeField.setEnabled(false);
        rgField.setEnabled(false);
        rgField.setEditable(false);
        cpfField.setEditable(false);
        nomeField.setEditable(false);
        nomeField.setText("");
        rgField.setText("");
        cpfField.setText("");
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void enableForm(boolean b) {
        cpfField.setEditable(b);
        cpfField.setEnabled(b);
        nomeField.setEditable(b);
        nomeField.setEnabled(b);
        rgField.setEditable(b);
        rgField.setEnabled(b);
    }

    private void myInitComponents() {
        bindingGroup = new BindingGroup();
        modButton.setEnabled(false);
        saveButton.setEnabled(false);
        
        PessoaDAO dao = new PessoaDAO();
        list = ObservableCollections.observableList(dao.findAll());
        masterTable.setModel(new PessoaTableModel(list));

        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
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

    private void showSelected() {
        int[] selected = masterTable.getSelectedRows();
        if (selected.length > 0) {
            this.p = list.get(masterTable.convertRowIndexToModel(selected[0]));
            cpfField.setText(p.getCpf());
            nomeField.setText(p.getNome());
            rgField.setText(p.getRg());
            iKey = p.getIdpessoa();
        }
        this.enableForm(false);
        searchBt = false;
    }

    private class PessoaTableModel extends AbstractTableModel {

        private List<Pessoa> pessoas;
        private final int COLUMN_COUNT = 3;
        private final String[] columnNames = {"CPF", "Nome", "RG"};

        public PessoaTableModel() {
            pessoas = new ArrayList();
        }

        public PessoaTableModel(List<Pessoa> pessoaList) {
            this();
            this.pessoas.addAll(pessoas);
        }

        @Override
        public int getRowCount() {
            return pessoas.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMN_COUNT;
        }

        @Override
        public String getColumnName(int i) {
            return columnNames[i];
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro selecionado?", "Confirmação", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.OK_OPTION) {
            Thread t = new Thread(() -> {
                try{ 
                    int selected = masterTable.getSelectedRow();
                    Pessoa p = list.get(selected);
                    IDAO dao = new PessoaDAO();
                    dao.remove(p);
                    list.remove(selected);
                }catch (BusinessException ex){
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
                } 
            });
            t.start();
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada!", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
        modButton.setEnabled(false);
        nomeField.setText("");
        cpfField.setText("");
        rgField.setText("");
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        cpfField.setText("");
        nomeField.setText("");
        rgField.setText("");
        iKey = 0L;
        this.enableForm(true);
        masterTable.clearSelection();
        saveButton.setEnabled(true);
        PessoaDAO dao = new PessoaDAO();
        list.addAll(dao.findAll());
    }//GEN-LAST:event_newButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

            
        Pessoa altP = new Pessoa();
        PessoaDAO dao = new PessoaDAO();
        altP.setIdpessoa(iKey);
        altP.setCpf(cpfField.getText());
        altP.setNome(nomeField.getText());
        altP.setRg(rgField.getText());
        try {
            altP = dao.save(altP);
        } catch (BusinessException ex) {
            Logger.getLogger(ManutencaoPessoaView.class.getName()).log(Level.SEVERE, null, ex);
        }


        if (iKey == 0) {
            list.add(altP);
            int row = list.size() - 1;
            masterTable.setRowSelectionInterval(row, row);
            masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
        } else {
            int row = masterTable.getSelectedRow();
            System.out.println(row);
            if (row < 0) row = 0;
            
            list.remove(row);
            list.add(row, altP);

        }
        this.showSelected();
        this.enableForm(false);
        JOptionPane.showMessageDialog(null, "Operação executada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);               

    }//GEN-LAST:event_saveButtonActionPerformed

    private void masterTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyPressed

        //System.out.println("masterTableKeyPressed");

    }//GEN-LAST:event_masterTableKeyPressed

    private void masterTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMousePressed
        this.showSelected();
        refreshButton.setEnabled(true);
        modButton.setEnabled(true);
    }//GEN-LAST:event_masterTableMousePressed

    private void nomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFieldActionPerformed

    private void modButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modButtonActionPerformed
        this.showSelected();
        this.enableForm(true);
    }//GEN-LAST:event_modButtonActionPerformed

    private void srchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchButtonActionPerformed
        PessoaDAO dao = new PessoaDAO();
        if (searchBt == false) {
            cpfField.setEditable(true);
            cpfField.setEnabled(true);
            cpfField.setText("");
            nomeField.setEditable(true);
            nomeField.setEnabled(true);
            nomeField.setText("");
            searchBt = true;
            modButton.setEnabled(false);
            deleteButton.setEnabled(false);
            rgField.setText("");
            //cpfField.setFormatterFactory(null);            

        } else {
            cpfField.setEditable(false);
            cpfField.setEnabled(false);
            cpfField.setText("");
            nomeField.setEditable(false);
            nomeField.setEnabled(false);
            nomeField.setText("");                        
            list.clear();
            list.addAll(dao.findAll());
            searchBt = false;
        }
    }//GEN-LAST:event_srchButtonActionPerformed

    private void nomeFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeFieldKeyReleased
        
        if (searchBt == true) {
            cpfField.setText("");
            PessoaDAO dao = new PessoaDAO();
            list.clear();
            if (nomeField.getText() == ""){
                list.addAll(dao.findAll());
            }
            else {                
                list.addAll(dao.findByNome(nomeField.getText()));
            }
        }
        
    }//GEN-LAST:event_nomeFieldKeyReleased

    private void cpfFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpfFieldKeyReleased
        if (searchBt == true) {
            nomeField.setText("");
            PessoaDAO dao = new PessoaDAO();
            list.clear();
            if (cpfField.getText() == "..-"){
                list.addAll(dao.findAll());
            }
            else {                
                list.addAll(dao.findByCpf(cpfField.getText()));
            }
        }
    }//GEN-LAST:event_cpfFieldKeyReleased

    private void cpfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfFieldActionPerformed

    private void rgFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rgFieldActionPerformed

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
        this.showSelected();
    }//GEN-LAST:event_masterTableKeyReleased

    private void nomeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeFieldKeyPressed

    }//GEN-LAST:event_nomeFieldKeyPressed

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        
    }//GEN-LAST:event_masterTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField cpfField;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton modButton;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JFormattedTextField rgField;
    private javax.swing.JLabel rgLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton srchButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
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
            java.util.logging.Logger.getLogger(ManutencaoPessoaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManutencaoPessoaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManutencaoPessoaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManutencaoPessoaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setContentPane(new ManutencaoPessoaView());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        });
    }

}
