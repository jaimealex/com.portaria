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
import com.portaria.entity.SaidaPessoa;
import com.portaria.entity.SaidaVeiculo;
import com.portaria.entity.Usuario;
import com.portaria.entity.Veiculo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Classe utilizada como modelo de dados para a tela de manutenção de inscrições
 *
 * @author winston
 */
public class SaidaModel extends BindableModel {

    private Usuario usuario;
    private Veiculo veiculo;
    private SaidaPessoa pessoa;
    
    private List<SaidaPessoa> pessoas;
    private List<Veiculo> veiculos;

    //private NavigableMap<Long, Inscricao> inscricaoNavigableMap;
    /**
     * Construtor da classe
     */
    public SaidaModel() {
        usuario = new Usuario();
        veiculo = new Veiculo();
        pessoa  = new SaidaPessoa();

        veiculos = ObservableCollections.observableList(new ArrayList());
        pessoas = ObservableCollections.observableList(new ArrayList());
 
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public SaidaPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(SaidaPessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<SaidaPessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas() {
        RegistroPessoaDAO rpDAO = new RegistroPessoaDAO();
        List<RegistroPessoa> rps = rpDAO.findBySaidaNull();
        PessoaDAO pDAO = new PessoaDAO();
        
        pessoas.clear();
        for (RegistroPessoa rp: rps){
            Pessoa p = pDAO.findById(rp.getIdpessoa());  
            SaidaPessoa sp = new SaidaPessoa();
            sp.setNome(p.getNome());
            sp.setCpf(p.getCpf());
            sp.setRg(p.getRg());
            sp.setEntrada(rp.getEntrada());
            sp.setIdEntrada(rp.getIdregistro());            
            pessoas.add(sp);
            
        }
        
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos() {
        
        RegistroVeiculoDAO rvDAO = new RegistroVeiculoDAO();
        List<RegistroVeiculo> rvs = rvDAO.findBySaidaNull();
        VeiculoDAO pDAO = new VeiculoDAO();
        
        pessoas.clear();
        for (RegistroVeiculo rv: rvs){
            Veiculo v = pDAO.findById(rv.getIdveiculo());  
            
            SaidaVeiculo sv = new SaidaVeiculo();
            sv.setCor(v.getCor());
            sv.setPlaca(v.getPlaca());            
            sv.setModelo(v.getModelo());
            sv.setEntrada(rv.getEntrada());
            sv.setIdEntrada(rv.getIdregistro());            
            veiculos.add(sv);
            
        }
        
    }


  
  
   
    public void salvaSaida() {
        
        Date dt = new Date();        
        
//        for(Pessoa p: pessoasSelecionadas) {
//            RegistroPessoaDAO dao = new RegistroPessoaDAO();
//            RegistroPessoa rp = new RegistroPessoa();
//            rp.setIdpessoa(p.getIdpessoa());
//            rp.setEntrada(dt);
//            rp.setIdusuario(1); //to do remover usr fixo
//            try {
//                dao.save(rp);
//            } catch (BusinessException ex) {
//                Logger.getLogger(SaidaModel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        }
        
        
        
    }

}
