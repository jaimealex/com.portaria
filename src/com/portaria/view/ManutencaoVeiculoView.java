/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.view;

import com.portaria.dao.IDAO;
import com.portaria.dao.VeiculoDAO;
import com.portaria.entity.Veiculo;
import com.portaria.exception.BusinessException;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author visitante
 */
public class ManutencaoVeiculoView extends JPanel {
    
    private int iKey = 0;
    private String modOption;
    private List<Veiculo> list;
    private List<Veiculo> veiculoList = Collections.emptyList();
    private Veiculo veiculoSelecionado;
    private static final String UPDATE = "update";
    private static final String INSERT = "insert";
    
    public ManutencaoVeiculoView() {
        initComponents();
        myInitComponents();
    }
    private void myInitComponents() {
        
        placaField.setEnabled(true);
        placaField.setEditable(true);
        updateButton.setEnabled(false);
        bindingGroup = new BindingGroup();
        cancelButton.setEnabled(false);
        
        IDAO dao = new VeiculoDAO();
        veiculoList = ObservableCollections.observableList(dao.findAll());
        masterTable.setModel(new ManutencaoVeiculoView.VeiculoTableModel(veiculoList));
        masterTable.setRowSelectionAllowed(true);

        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, veiculoList, masterTable);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${placa}"));
        columnBinding.setColumnName("Placa");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${modelo}"));
        columnBinding.setColumnName("Modelo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${cor}"));
        columnBinding.setColumnName("Cor");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        
        
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        
        Binding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, masterTable, ELProperty.create("${selectedElement.placa}"), placaField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, masterTable, ELProperty.create("${selectedElement != null}"), placaField, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, masterTable, ELProperty.create("${selectedElement.modelo}"), modeloField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, masterTable, ELProperty.create("${selectedElement != null}"), modeloField, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, masterTable, ELProperty.create("${selectedElement.cor}"), corField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, masterTable, ELProperty.create("${selectedElement != null}"), corField, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, masterTable, ELProperty.create("${selectedElement != null}"), deleteButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);
        
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, masterTable, ELProperty.create("${selectedElement != null}"), updateButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        bindingGroup.bind();

    }
    
    private void disableText() {
        placaField.setEnabled(false);
        modeloField.setEnabled(false);
        corField.setEnabled(false);
    }
    
    private void resetText() {
        placaField.setText("");
        modeloField.setText("");
        corField.setText("");
    }
    
    private void ableText(){
        placaField.setEnabled(true);
        placaField.setEditable(true);
        placaField.setFocusable(true);
        modeloField.setEnabled(true);
        modeloField.setEditable(true);
        modeloField.setFocusable(true);
        corField.setEnabled(true);
        corField.setEditable(true);
        corField.setFocusable(true);
    }
    
    private class VeiculoTableModel extends AbstractTableModel {

        private final int modOption = 0;
        private List<Veiculo> veiculos;
        private final int COLUMN_COUNT = 3;
        private final String[] columnNames = {"Placa", "Modelo", "Cor"};

        public VeiculoTableModel() {
            veiculos = new ArrayList();
        }

        public VeiculoTableModel(List<Veiculo> veiculos) {
            this();
            this.veiculos.addAll(veiculos);
        }

        @Override
        public int getRowCount() {
            return veiculos.size();
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
            Veiculo veiculo = veiculos.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return veiculo.getPlaca();
                case 1:
                    return veiculo.getModelo();
                case 2:
                    return veiculo.getCor();
                default:
                    return "";
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Veiculo veiculo = veiculos.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    veiculo.setPlaca(aValue.toString());
                    break;
                case 1:
                    veiculo.setModelo(aValue.toString());
                    break;
                case 2:
                    veiculo.setCor(aValue.toString());
                    break;
            }
            fireTableDataChanged();
        }
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

        placaLabel = new javax.swing.JLabel();
        modeloLabel = new javax.swing.JLabel();
        corLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        placaField = new javax.swing.JTextField();
        modeloField = new javax.swing.JTextField();
        corField = new javax.swing.JTextField();

        FormListener formListener = new FormListener();

        placaLabel.setText("Placa:");

        modeloLabel.setText("Modelo:");

        corLabel.setText("Cor:");

        saveButton.setText("Salvar");
        saveButton.addActionListener(formListener);

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(formListener);

        newButton.setText("Novo");
        newButton.addActionListener(formListener);

        deleteButton.setText("Deletar");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, new javax.swing.JTable(), org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        updateButton.setText("Modificar");
        updateButton.addActionListener(formListener);

        masterTable.setModel(new VeiculoTableModel());
        masterTable.setFocusable(false);
        masterTable.addMouseListener(formListener);
        jScrollPane1.setViewportView(masterTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(newButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(placaLabel)
                        .addGap(18, 18, 18)
                        .addComponent(placaField))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modeloLabel)
                            .addComponent(corLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modeloField)
                            .addComponent(corField))))
                .addGap(19, 19, 19))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, deleteButton, newButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placaLabel)
                    .addComponent(placaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modeloLabel)
                    .addComponent(modeloField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(corLabel)
                    .addComponent(corField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton)
                    .addComponent(updateButton))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(122, Short.MAX_VALUE)))
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                ManutencaoVeiculoView.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == cancelButton) {
                ManutencaoVeiculoView.this.cancelButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                ManutencaoVeiculoView.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                ManutencaoVeiculoView.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == updateButton) {
                ManutencaoVeiculoView.this.updateButtonActionPerformed(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                ManutencaoVeiculoView.this.masterTableMouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                ManutencaoVeiculoView.this.masterTableMousePressed(evt);
            }
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    

    @SuppressWarnings("unchecked")
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        updateButton.setEnabled(false);
        cancelButton.setEnabled(false);
        saveButton.setEnabled(false);
        newButton.setEnabled(true);
        resetText();
        disableText();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro selecionado?", "Confirmação", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.OK_OPTION) {
            Thread t = new Thread(() -> {
                try{ 
                    int selected = masterTable.getSelectedRow();
                    Veiculo v = veiculoList.get(selected);
                    IDAO dao = new VeiculoDAO();
                    dao.remove(v);
                    veiculoList.remove(selected);
                    resetText();
                }catch (BusinessException ex){
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
                } 
            });
            t.start();
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada!", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }                                            
        updateButton.setEnabled(false);
        cancelButton.setEnabled(false);
        masterTable.setRowSelectionAllowed(true);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        Veiculo veiculo = new Veiculo();
        veiculoList.add(veiculo);
        int row = veiculoList.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
        ableText();
        saveButton.setEnabled(true);
        masterTable.setRowSelectionAllowed(false);
        masterTable.setCellSelectionEnabled(false);
        masterTable.setColumnSelectionAllowed(false);
        deleteButton.setEnabled(false);
        updateButton.setEnabled(false);
        cancelButton.setEnabled(true);
        placaField.setEnabled(true);
        placaField.setEditable(true);
    }//GEN-LAST:event_newButtonActionPerformed
    
    private boolean doFormValidation() {
        if ((placaField.getText().toString().isEmpty()) || (modeloField.getText().toString().isEmpty())){
            JOptionPane.showMessageDialog(null, "Preencha Placa ou Modelo", "Erro", JOptionPane.OK_OPTION);
            return false;
        } else
            return true;
    }
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Thread t = new Thread(() -> {
            if (doFormValidation()) {
                try{
                    IDAO dao = new VeiculoDAO();
                    Veiculo v = new Veiculo();
                    v.setIdveiculo((veiculoSelecionado == null) ? null : veiculoSelecionado.getIdveiculo());
                    v.setPlaca(placaField.getText());
                    v.setModelo(modeloField.getText());
                    v.setCor(corField.getText());
                    v = (Veiculo) dao.save(v);
                    veiculoList.add(v);
                    JOptionPane.showMessageDialog(null, "Operação executada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }catch (BusinessException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.OK_OPTION);
                }
            }
        });
        t.start();
        disableText();
        resetText();
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        updateButton.setEnabled(false);
        masterTable.setRowSelectionAllowed(true);
        int row = masterTable.getSelectedRow();
        veiculoList.remove(row);
        newButton.setEnabled(true);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        saveButton.setEnabled(true);
        this.showSelected();
        this.enableForm(true);
        masterTable.setColumnSelectionAllowed(false);
        modOption = UPDATE;
        newButton.setEnabled(false);
        deleteButton.setEnabled(false);
        cancelButton.setEnabled(true);
        ableText();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void masterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseClicked
        disableText();
        cancelButton.setEnabled(true);
        updateButton.setEnabled(true);
    }//GEN-LAST:event_masterTableMouseClicked

    private void masterTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMousePressed
        disableText();
        cancelButton.setEnabled(true);
        updateButton.setEnabled(true);
    }//GEN-LAST:event_masterTableMousePressed

    private void enableForm(boolean b) {
        placaField.setEditable(true);
        placaField.setEnabled(true);
        modeloField.setEditable(true);
        modeloField.setEnabled(true);
        corField.setEditable(true);
        corField.setEnabled(true);
    }

    private void showSelected() {
        int[] selected = masterTable.getSelectedRows();
        if (selected.length > 0) {
            Veiculo v = veiculoList.get(masterTable.convertRowIndexToModel(selected[0]));
            placaField.setText(v.getPlaca());
            modeloField.setText(v.getModelo());
            corField.setText(v.getCor());
        }
        this.enableForm(false);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField corField;
    private javax.swing.JLabel corLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField modeloField;
    private javax.swing.JLabel modeloLabel;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField placaField;
    private javax.swing.JLabel placaLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton updateButton;
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
            frame.setContentPane(new ManutencaoVeiculoView());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
    
    private class VeiculoMasterTableListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            int row = masterTable.getSelectedRow();
            if (row >= 0) {
                Veiculo v = veiculoList.get(row);
                veiculoSelecionado = new Veiculo(v.getIdveiculo(), v.getPlaca(), v.getModelo(), v.getCor());
            }
        }
    }
}
