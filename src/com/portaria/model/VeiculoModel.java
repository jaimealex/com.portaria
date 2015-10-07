/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.model;

import com.portaria.entity.Veiculo;
import java.util.Collections;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Classe utilizada como modelo de dados para a tela de manutenção de doações
 *
 * @author winston.sonnesen
 */
public class VeiculoModel extends BindableModel {
    private Veiculo registroSelecionado;
    private Veiculo backupRegistro;
    private Veiculo registroEditado;
    private List<Veiculo> veiculos;
    private Boolean isEnabled;

    /**
     * Construtor da classe
     */
    public VeiculoModel() {

    }

    /**
     *
     * @return
     */
    public Veiculo getRegistroSelecionado() {
        return registroSelecionado;
    }

    /**
     *
     * @param veiculo
     */
    public void setRegistroSelecionado(Veiculo veiculo) {
        this.registroSelecionado = veiculo;
        firePropertyChange("registroSelecionado", null, veiculo);
    }

    /**
     *
     * @return
     */
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    /**
     *
     * @param veiculos
     */
    public void setVeiculos(List<Veiculo> veiculos) {
        veiculos.sort(new VeiculoComparator());
        this.veiculos = ObservableCollections.observableList(veiculos);
        firePropertyChange("veiculos", null, Collections.unmodifiableList(veiculos));
    }

    /**
     *
     * @param veiculo
     */
    public void removeVeiculo(Veiculo veiculo) {
        this.veiculos.remove(veiculo);
        this.veiculos.sort(new VeiculoComparator());
        firePropertyChange("veiculos", null, Collections.unmodifiableList(veiculos));
    }

    /**
     *
     * @param veiculo
     */
    public void addVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
        this.veiculos.sort(new VeiculoComparator());
        firePropertyChange("veiculos", null, Collections.unmodifiableList(veiculos));
    }

    /**
     *
     * @return
     */
    public Veiculo getBackupRegistro() {
        return backupRegistro;
    }

    /**
     *
     * @param backupRegistro
     */
    public void setBackupRegistro(Veiculo backupRegistro) {
        if (backupRegistro == null) {
            this.backupRegistro = null;
        } else {
            this.backupRegistro = backupRegistro;
        }
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
        firePropertyChange("isEnabled", null, isEnabled);
    }

    public Veiculo getRegistroEditado() {
        return registroEditado;
    }

    public void setRegistroEditado(Veiculo registroEditado) {
        this.registroEditado = registroEditado;
        firePropertyChange("registroEditado", null, registroEditado);
    }

}
