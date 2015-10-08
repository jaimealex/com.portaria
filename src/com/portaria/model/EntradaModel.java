/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.model;

import com.portaria.dao.RegistroPessoaDAO;
import com.portaria.dao.PessoaDAO;
import com.portaria.dao.RegistroVeiculoDAO;
import com.portaria.dao.VeiculoDAO;
import com.portaria.entity.Pessoa;
import com.portaria.entity.RegistroPessoa;
import com.portaria.entity.RegistroVeiculo;
import com.portaria.entity.Usuario;
import com.portaria.entity.Veiculo;
import com.portaria.exception.BusinessException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Classe utilizada como modelo de dados para a tela de manutenção de inscrições
 *
 * @author winston
 */
public class EntradaModel extends BindableModel {

    private Usuario usuario;
    private Veiculo veiculo;
    private Pessoa pessoa;
    
    private List<Pessoa> pessoas;
    private List<Pessoa> pessoasSelecionadas;

    public List<Pessoa> getPessoasSelecionadas() {
        return pessoasSelecionadas;
    }

    public void setPessoasSelecionadas(List<Pessoa> pessoasSelecionadas) {
        this.pessoasSelecionadas = pessoasSelecionadas;
    }



    //private NavigableMap<Long, Inscricao> inscricaoNavigableMap;
    /**
     * Construtor da classe
     */
    public EntradaModel() {
        usuario = new Usuario();
        veiculo = new Veiculo();
        pessoasSelecionadas = ObservableCollections.observableList(new ArrayList());
        pessoas = ObservableCollections.observableList(new ArrayList());
 
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        firePropertyChange("usuario", this.usuario, usuario);
        this.usuario = usuario;

    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        firePropertyChange("veiculo", this.veiculo, veiculo);
        this.veiculo = veiculo;
    }

    public void movePessoa(int i) {        
        Pessoa p = this.pessoas.get(i);
        if (! this.pessoasSelecionadas.contains(p)) {
            this.pessoasSelecionadas.add(p);
        }
   }
    
    public List<Pessoa> getPessoas() {
        PessoaDAO dao = new PessoaDAO();
        pessoas.clear();
        pessoas.addAll(dao.findAll());
        return pessoas;
    }
    public boolean setFiltroPessoaByNome(String s) {        
        PessoaDAO dao = new PessoaDAO();
        pessoas.clear();
        if (s == null){
            pessoas.addAll(dao.findAll());            
        }
        else {
            pessoas.addAll(dao.findByNome(s));
        }
            
        
        if (pessoas.size() > 0) {
            return true;
        } else {
            return false;
        }

    }
    public boolean setFiltroPessoaByCpf(String s) {        
        PessoaDAO dao = new PessoaDAO();
        pessoas.clear();
        if (s == null){
            pessoas.addAll(dao.findAll());
            
        }
        else {
            pessoas.addAll(dao.findByCpf(s));
        }
            
        
        if (pessoas.size() > 0) {
            return true;
        } else {
            return false;
        }

    }
    public boolean setFiltroVeiculoByPlaca(String s) {
        VeiculoDAO dao = new VeiculoDAO();
        if (s == null){
            return false;
        }
        List<Veiculo> veiculos = dao.findByPlaca(s);
        
        if(veiculos.size() == 1){
            veiculo = veiculos.get(0);
            return true;
        }
        
        return false;
        
    }

 
    public void salvaEntrada() {
        
        Date dt = new Date();        
        for(Pessoa p: pessoasSelecionadas) {
            RegistroPessoaDAO dao = new RegistroPessoaDAO();
            RegistroPessoa rp = new RegistroPessoa();
            rp.setIdpessoa(p.getIdpessoa());
            rp.setEntrada(dt);
            rp.setIdusuario(1); //to do remover usr fixo
            try {
                dao.save(rp);
            } catch (BusinessException ex) {
                Logger.getLogger(EntradaModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if (veiculo.getIdveiculo() > 0){
            RegistroVeiculoDAO vDao = new RegistroVeiculoDAO();
            RegistroVeiculo rv = new RegistroVeiculo();
            rv.setIdveiculo(veiculo.getIdveiculo());
            rv.setIdusuario(1); //to do remover usr fixo
            rv.setEntrada(dt);
            
            try {
                vDao.save(rv);
            } catch (BusinessException ex) {
                Logger.getLogger(EntradaModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    pessoasSelecionadas.clear();
    veiculo = new Veiculo();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
