/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.view;

import com.portaria.dao.IDAO;
import com.portaria.dao.UsuarioDAO;
import com.portaria.entity.Usuario;
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
public class ManutencaoUsuarioView extends JPanel {

    private String modOption;
    private List<Usuario> list;
    private List<Usuario> usuarioList = Collections.emptyList();
    private Usuario usuarioSelecionado;
    
    private static final String UPDATE = "update";
    private static final String INSERT = "insert";

    public ManutencaoUsuarioView() {
        initComponents();
        myInitComponents();
    }

    private void myInitComponents() {
        updateButton.setEnabled(false);
        bindingGroup = new BindingGroup();
        cancelButton.setEnabled(false);
        
        IDAO dao = new UsuarioDAO();
        usuarioList = ObservableCollections.observableList(dao.findAll());
        masterTable.setModel(new UsuarioTableModel(usuarioList));
        masterTable.setRowSelectionAllowed(true);

        JTableBinding jTableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, usuarioList, masterTable);
        JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${login}"));
        columnBinding.setColumnName("Login");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        
        columnBinding = jTableBinding.addColumnBinding(ELProperty.create("${senha}"));
        columnBinding.setColumnName("Senha");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        
        
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        
        Binding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, masterTable, ELProperty.create("${selectedElement.login}"), loginField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, masterTable, ELProperty.create("${selectedElement != null}"), loginField, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, masterTable, ELProperty.create("${selectedElement.nome}"), nomeField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, masterTable, ELProperty.create("${selectedElement != null}"), nomeField, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, masterTable, ELProperty.create("${selectedElement.senha}"), senhaField, BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, masterTable, ELProperty.create("${selectedElement != null}"), senhaField, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, masterTable, ELProperty.create("${selectedElement != null}"), deleteButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);
        
        binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ, masterTable, ELProperty.create("${selectedElement != null}"), updateButton, BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        bindingGroup.bind();

    }

    private void resetText() {
        nomeField.setText("");
        loginField.setText("");
        senhaField.setText("");
    }

    private void disableText() {
        nomeField.setEnabled(false);
        loginField.setEnabled(false);
        senhaField.setEnabled(false);
    }
    
    private void ableText(){
        nomeField.setEnabled(true);
        nomeField.setEditable(true);
        nomeField.setFocusable(true);
        loginField.setEnabled(true);
        loginField.setEditable(true);
        loginField.setFocusable(true);
        senhaField.setEnabled(true);
        senhaField.setEditable(true);
        senhaField.setFocusable(true);
    }

    private class UsuarioTableModel extends AbstractTableModel {

        private final int modOption = 0;
        private List<Usuario> usuarios;
        private final int COLUMN_COUNT = 3;
        private final String[] columnNames = {"Nome", "Login", "Senha"};

        public UsuarioTableModel() {
            usuarios = new ArrayList();
        }

        public UsuarioTableModel(List<Usuario> usuarios) {
            this();
            this.usuarios.addAll(usuarios);
        }

        @Override
        public int getRowCount() {
            return usuarios.size();
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
            Usuario usuario = usuarios.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return usuario.getNome();
                case 1:
                    return usuario.getLogin();
                case 2:
                    return usuario.getSenha();
                default:
                    return "";
            }
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Usuario usuario = usuarios.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    usuario.setNome(aValue.toString());
                    break;
                case 1:
                    usuario.setLogin(aValue.toString());
                    break;
                case 2:
                    usuario.setSenha(aValue.toString());
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

        nomeLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        senhaLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        nomeField = new javax.swing.JTextField();
        loginField = new javax.swing.JTextField();
        senhaField = new javax.swing.JTextField();

        FormListener formListener = new FormListener();

        setMaximumSize(new java.awt.Dimension(0, 0));

        nomeLabel.setText("Nome:");

        loginLabel.setText("Login:");

        senhaLabel.setText("Senha:");

        saveButton.setText("Salvar");
        saveButton.setEnabled(false);
        saveButton.addActionListener(formListener);

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(formListener);

        newButton.setText("Novo");
        newButton.addMouseListener(formListener);
        newButton.addActionListener(formListener);

        deleteButton.setText("Excluir");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        updateButton.setText("Modificar");
        updateButton.setEnabled(false);
        updateButton.addActionListener(formListener);

        masterTable.setModel(new UsuarioTableModel());
        masterTable.getSelectionModel().addListSelectionListener(new UsuarioMasterTableListSelectionListener());
        masterTable.setFocusable(false);
        masterTable.addMouseListener(formListener);
        jScrollPane1.setViewportView(masterTable);

        loginField.setEnabled(false);
        loginField.setFocusable(false);

        senhaField.setEnabled(false);
        senhaField.setFocusable(false);
        senhaField.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(updateButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(newButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cancelButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(saveButton))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nomeLabel)
                                        .addComponent(loginLabel))
                                    .addGap(7, 7, 7))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(senhaLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(senhaField)
                                .addComponent(loginField)
                                .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, deleteButton, newButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nomeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton)
                    .addComponent(updateButton))
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                ManutencaoUsuarioView.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == cancelButton) {
                ManutencaoUsuarioView.this.cancelButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                ManutencaoUsuarioView.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                ManutencaoUsuarioView.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == updateButton) {
                ManutencaoUsuarioView.this.updateButtonActionPerformed(evt);
            }
            else if (evt.getSource() == senhaField) {
                ManutencaoUsuarioView.this.senhaFieldActionPerformed(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == newButton) {
                ManutencaoUsuarioView.this.newButtonMouseClicked(evt);
            }
            else if (evt.getSource() == masterTable) {
                ManutencaoUsuarioView.this.masterTableMouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                ManutencaoUsuarioView.this.masterTableMousePressed(evt);
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
        masterTable.clearSelection();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro selecionado?", "Confirmação", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.OK_OPTION) {
            Thread t = new Thread(() -> {
                try{ 
                    int selected = masterTable.getSelectedRow();
                    Usuario u = usuarioList.get(selected);
                    IDAO dao = new UsuarioDAO();
                    dao.remove(u);
                    usuarioList.remove(selected);
                    resetText();
                }catch (BusinessException ex){
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
                } 
            });
            t.start();
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada!", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_deleteButtonActionPerformed
        updateButton.setEnabled(false);
        cancelButton.setEnabled(false);
        masterTable.setRowSelectionAllowed(true);
    }
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        Usuario usuario = new Usuario();
        usuarioList.add(usuario);
        int row = usuarioList.size() - 1;
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
    }//GEN-LAST:event_newButtonActionPerformed

    private boolean doFormValidation() {
        if ((loginField.getText().toString().isEmpty()) || (senhaField.getText().toString().isEmpty())){
            JOptionPane.showMessageDialog(null, "Preencha Login ou Senha", "Erro", JOptionPane.OK_OPTION);
            return false;
        } else
            return true;
    }
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        Thread t = new Thread(() -> {
            if (doFormValidation()) {
                try{
                    IDAO dao = new UsuarioDAO();
                    Usuario u = new Usuario();
                    u.setIdusuario((usuarioSelecionado == null) ? null : usuarioSelecionado.getIdusuario());
                    u.setNome(nomeField.getText());
                    u.setLogin(loginField.getText());
                    u.setSenha(senhaField.getText());
                    u = (Usuario) dao.save(u);
                    usuarioList.add(u);
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
        usuarioList.remove(row);
        newButton.setEnabled(true);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void newButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_newButtonMouseClicked

    private void enableForm(boolean b) {
        loginField.setEditable(true);
        loginField.setEnabled(true);
        nomeField.setEditable(true);
        nomeField.setEnabled(true);
        senhaField.setEditable(true);
        senhaField.setEnabled(true);
    }

    private void showSelected() {
        int[] selected = masterTable.getSelectedRows();
        if (selected.length > 0) {
            com.portaria.entity.Usuario u = usuarioList.get(masterTable.convertRowIndexToModel(selected[0]));
            nomeField.setText(u.getNome());
            loginField.setText(u.getLogin());
            senhaField.setText(u.getSenha());
        }
        this.enableForm(false);
    }

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

    private void senhaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaFieldActionPerformed

    private void masterTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMousePressed
        disableText();
        cancelButton.setEnabled(true);
        updateButton.setEnabled(true);
    }//GEN-LAST:event_masterTableMousePressed

    private javax.persistence.EntityManager entityManager;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField loginField;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField senhaField;
    private javax.swing.JLabel senhaLabel;
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
            java.util.logging.Logger.getLogger(ManutencaoUsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManutencaoUsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManutencaoUsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManutencaoUsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setContentPane(new ManutencaoUsuarioView());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        });
    }

    private class UsuarioMasterTableListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            int row = masterTable.getSelectedRow();
            if (row >= 0) {
                Usuario u = usuarioList.get(row);
                usuarioSelecionado = new Usuario(u.getIdusuario(), u.getLogin(), u.getNome(), u.getSenha());
            }
        }
    }
}
