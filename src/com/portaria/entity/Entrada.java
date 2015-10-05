/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.entity;

import com.portaria.entity.Pessoa;
import com.portaria.entity.Usuario;
import com.portaria.entity.Veiculo;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author visitante
 */
public class Entrada {
    private List<Pessoa> pessoaList = Collections.emptyList();
    private Veiculo veiculo = new Veiculo();
    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public void pessoaAdd(Pessoa pessoa) {
        this.pessoaList.add(pessoa);
    }
    
    public boolean pessoaRemove(Pessoa pessoa) {        
        return this.pessoaList.remove(pessoa);
    }    
    
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public boolean Commit() {
        //to do 
        return true;
    }
    
    
    
    
}
