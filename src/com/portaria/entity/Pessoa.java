/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author visitante
 */
@Entity
@Table(name = "pessoa", catalog = "portaria", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.findByIdpessoa", query = "SELECT p FROM Pessoa p WHERE p.idpessoa = :idpessoa"),
    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome LIKE :nome"),
    @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf LIKE :cpf"),
    @NamedQuery(name = "Pessoa.findByRg", query = "SELECT p FROM Pessoa p WHERE p.rg = :rg")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpessoa")
    private Long idpessoa;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "RG")
    private String rg;

    public Pessoa() {
    }

    public Pessoa(Long idpessoa) {
        this.idpessoa = idpessoa;
    }

    public Pessoa(Long idpessoa, String nome, String cpf) {
        this.idpessoa = idpessoa;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Long getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Long idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpessoa != null ? idpessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.idpessoa == null && other.idpessoa != null) || (this.idpessoa != null && !this.idpessoa.equals(other.idpessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.portaria.view.Pessoa[ idpessoa=" + idpessoa + " ]";
    }

}
