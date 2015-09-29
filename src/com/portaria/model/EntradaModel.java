/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.model;


import com.portaria.entity.Pessoa;
import com.portaria.entity.Usuario;
import com.portaria.entity.Veiculo;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Classe utilizada como modelo de dados para a tela de manutenção de inscrições
 * 
 * @author winston
 */
public class EntradaModel extends BindableModel {

    private Usuario usuario;
    private Veiculo veiculo;
    private List<Pessoa> pessoas;
    private Pessoa pessoaSelecionada ;
    //private NavigableMap<Long, Inscricao> inscricaoNavigableMap;

    /**
     * Construtor da classe
     */
    public EntradaModel() {
        usuario = new Usuario();
        veiculo = new Veiculo();
        
        pessoas = ObservableCollections.observableList(new ArrayList());        
        /*teste*/
        pessoaSelecionada = new Pessoa();
        pessoaSelecionada.setIdpessoa(1);
        pessoaSelecionada.setCpf("1234");
        pessoaSelecionada.setNome("1234");
        pessoaSelecionada.setRg("1234");        
        pessoas.add(pessoaSelecionada);
        
        pessoaSelecionada = new Pessoa();
        pessoaSelecionada.setIdpessoa(2);
        pessoaSelecionada.setCpf("2221234");
        pessoaSelecionada.setNome("2221234");
        pessoaSelecionada.setRg("221234");
        pessoas.add(pessoaSelecionada);        
        /*teste*/
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

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        firePropertyChange("pessoas", this.pessoas, pessoas);
        this.pessoas = pessoas;
    }

    public void addPessoa(Pessoa pessoa) {
        this.pessoas.add(pessoa);
        //this.pessoaNavigableMap.put(pessoa.getIdpessoa() pessoa);
        setPessoaSelecionada(pessoa);
        //firePropertyChange("inscricaoList", null, Collections.unmodifiableList(inscricaoList));
        //firePropertyChange("inscricaoNavigableMap", null, Collections.unmodifiableNavigableMap(inscricaoNavigableMap));
    }    

    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }
    
    public void setPessoaSelecionada(Pessoa pessoa) {
        //firePropertyChange("pessoaSelecionada", this.pessoaSelecionada, pessoa);
        this.pessoaSelecionada = pessoa;
        
    }    
    
//    /**
//     * 
//     * @return
//     */
//    public Inscricao getInscricaoSelecionada() {
//        return inscricaoSelecionada;
//    }
//
//    /**
//     *
//     * @param inscricao
//     */
//    public void setInscricaoSelecionada(Inscricao inscricao) {
//        this.inscricaoSelecionada = inscricao;
//        firePropertyChange("inscricaoSelecionada", null, inscricao);
//    }
//
//    /**
//     *
//     * @return
//     */
//    public List<Inscricao> getInscricaoList() {
//        return inscricaoList;
//    }
//
//    /**
//     *
//     * @param inscricoes
//     */
//    public void setInscricaoList(List<Inscricao> inscricoes) {
//        this.inscricaoList = new ArrayList();
//        this.inscricaoList.addAll(inscricoes);
//        firePropertyChange("inscricaoList", null, Collections.unmodifiableList(inscricoes));
//    }
//
//    /**
//     *
//     * @return
//     */
//    public List<Pessoa> getPessoaList() {
//        return pessoaList;
//    }
//
//    /**
//     *
//     * @param pessoas
//     */
//    public void setPessoaList(List<Pessoa> pessoas) {
//        this.pessoaList = new ArrayList();
//        this.pessoaList.addAll(pessoas);
//        firePropertyChange("pessoaList", null, Collections.unmodifiableList(pessoas));
//    }
//
//    /**
//     *
//     * @return
//     */
//    public List<Oficina> getOficinaList() {
//        return oficinaList;
//    }
//
//    /**
//     *
//     * @param oficinas
//     */
//    public void setOficinaList(List<Oficina> oficinas) {
//        this.oficinaList = new ArrayList();
//        this.oficinaList.addAll(oficinas);
//        firePropertyChange("oficinaList", null, Collections.unmodifiableList(oficinaList));
//    }
//
//    /**
//     *
//     * @param inscricoes
//     */
//    public void setInscricaoMap(List<Inscricao> inscricoes) {
//        inscricaoNavigableMap = new TreeMap();
//        inscricoes.forEach(inscricao -> {
//            this.inscricaoNavigableMap.put(inscricao.getId(), inscricao);
//        });
//        firePropertyChange("inscricaoNavigableMap", null, Collections.unmodifiableNavigableMap(inscricaoNavigableMap));
//    }
//
//    /**
//     *
//     * @param inscricao
//     */
//    public void removeInscricao(Inscricao inscricao) {
//        this.inscricaoList.remove(inscricao);
//        this.inscricaoNavigableMap.remove(inscricao.getId());
//        Entry<Long, Inscricao> entry = inscricaoNavigableMap.lowerEntry(inscricao.getId());
//        if (entry == null) {
//            entry = inscricaoNavigableMap.higherEntry(inscricao.getId());
//            if (entry == null) {
//                setInscricaoSelecionada(new Inscricao());
//            } else {
//                setInscricaoSelecionada(entry.getValue());
//            }
//        } else {
//            setInscricaoSelecionada(entry.getValue());
//        }
//        firePropertyChange("inscricaoList", null, Collections.unmodifiableList(inscricaoList));
//        firePropertyChange("inscricaoNavigableMap", null, Collections.unmodifiableNavigableMap(inscricaoNavigableMap));
//    }
//
//    /**
//     *
//     * @param inscricao
//     */
//    public void addInscricao(Inscricao inscricao) {
//        this.inscricaoList.add(inscricao);
//        this.inscricaoNavigableMap.put(inscricao.getId(), inscricao);
//        setInscricaoSelecionada(inscricao);
//        firePropertyChange("inscricaoList", null, Collections.unmodifiableList(inscricaoList));
//        firePropertyChange("inscricaoNavigableMap", null, Collections.unmodifiableNavigableMap(inscricaoNavigableMap));
//    }
//
//    /**
//     * Efetua a navegação até o primeiro elemento da coleção
//     */
//    public void navigateToFirstInscricao() {
//        if (inscricaoNavigableMap != null && !inscricaoNavigableMap.isEmpty()) {
//            Entry<Long, Inscricao> entry = inscricaoNavigableMap.firstEntry();
//            if (entry != null) {
//                setInscricaoSelecionada(entry.getValue());
//            }
//        }
//    }
//
//    /**
//     * Efetua a navegação na coleção até o elemento anterior ao atual
//     */
//    public void navigateToPreviousInscricao() {
//        if (inscricaoNavigableMap != null && !inscricaoNavigableMap.isEmpty()) {
//            Entry<Long, Inscricao> entry = inscricaoNavigableMap.lowerEntry(inscricaoSelecionada.getId());
//            if (entry != null) {
//                setInscricaoSelecionada(entry.getValue());
//            }
//        }
//    }
//
//    /**
//     * Efetua a navegação na coleção até o elemento posterior ao atual
//     */
//    public void navigateToNextInscricao() {
//        if (inscricaoNavigableMap != null && !inscricaoNavigableMap.isEmpty()) {
//            Entry<Long, Inscricao> entry = inscricaoNavigableMap.higherEntry(inscricaoSelecionada.getId());
//            if (entry != null) {
//                setInscricaoSelecionada(entry.getValue());
//            }
//        }
//    }
//
//    /**
//     * Efetua a navegação até o último elemento da coleção
//     */
//    public void navigateToLastInstrucao() {
//        if (inscricaoNavigableMap != null && !inscricaoNavigableMap.isEmpty()) {
//            Entry<Long, Inscricao> entry = inscricaoNavigableMap.lastEntry();
//            if (entry != null) {
//                setInscricaoSelecionada(entry.getValue());
//            }
//        }
//    }
//
//    /**
//     *
//     * @return
//     */
//    public Inscricao getInscricaoSelecionadaBackup() {
//        return inscricaoSelecionadaBackup;
//    }
//
//    /**
//     *
//     * @param inscricaoSelecionadaBackup
//     */
//    public void setInscricaoSelecionadaBackup(Inscricao inscricaoSelecionadaBackup) {
//        if (inscricaoSelecionadaBackup == null) {
//            this.inscricaoSelecionadaBackup = null;
//        } else {
//            this.inscricaoSelecionadaBackup = inscricaoSelecionadaBackup;
//        }
//    }
//
//    /**
//     *
//     * @return
//     */
//    public NavigableMap<Long, Inscricao> getInscricaoNavigableMap() {
//        return inscricaoNavigableMap;
//    }
//
//    /**
//     *
//     * @param inscricaoNavigableMap
//     */
//    public void setInscricaoNavigableMap(NavigableMap<Long, Inscricao> inscricaoNavigableMap) {
//        this.inscricaoNavigableMap = inscricaoNavigableMap;
//    }

}
