/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author visitante
 */
@Entity
@Table(name = "registro_pessoa", catalog = "portaria", schema = "")
@NamedQueries({
    @NamedQuery(name = "RegistroPessoa.findAll", query = "SELECT r FROM RegistroPessoa r"),
    @NamedQuery(name = "RegistroPessoa.findByIdregistro", query = "SELECT r FROM RegistroPessoa r WHERE r.idregistro = :idregistro"),
    @NamedQuery(name = "RegistroPessoa.findByEntrada", query = "SELECT r FROM RegistroPessoa r WHERE r.entrada = :entrada"),
    @NamedQuery(name = "RegistroPessoa.findBySaida", query = "SELECT r FROM RegistroPessoa r WHERE r.saida = :saida"),
    @NamedQuery(name = "RegistroPessoa.findByIdusuario", query = "SELECT r FROM RegistroPessoa r WHERE r.idusuario = :idusuario"),
    @NamedQuery(name = "RegistroPessoa.findByIdpessoa", query = "SELECT r FROM RegistroPessoa r WHERE r.idpessoa = :idpessoa")})
public class RegistroPessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregistro")
    private Long idregistro;
    @Basic(optional = false)
    @Column(name = "entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entrada;
    @Column(name = "saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date saida;
    @Basic(optional = false)
    @Column(name = "idusuario")
    private int idusuario;
    @Column(name = "idpessoa")
    private Long idpessoa;

    public RegistroPessoa() {
    }

    public RegistroPessoa(Long idregistro) {
        this.idregistro = idregistro;
    }

    public RegistroPessoa(Long idregistro, Date entrada, int idusuario) {
        this.idregistro = idregistro;
        this.entrada = entrada;
        this.idusuario = idusuario;
    }

    public Long getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(Long idregistro) {
        this.idregistro = idregistro;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Long getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Long idpessoa) {
        this.idpessoa = idpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregistro != null ? idregistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroPessoa)) {
            return false;
        }
        RegistroPessoa other = (RegistroPessoa) object;
        if ((this.idregistro == null && other.idregistro != null) || (this.idregistro != null && !this.idregistro.equals(other.idregistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.portaria.view.RegistroPessoa[ idregistro=" + idregistro + " ]";
    }

}
