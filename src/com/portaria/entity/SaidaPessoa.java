/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.entity;

import java.util.Date;

/**
 *
 * @author visitante
 */
public class SaidaPessoa extends Pessoa {

    private String entrada;
    private long idEntrada;
    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    

    public long getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(long idEntrada) {
        this.idEntrada = idEntrada;
    }

}
