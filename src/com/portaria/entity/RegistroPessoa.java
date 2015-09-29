/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

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
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregistro")
    private Integer idregistro;
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
    private Integer idpessoa;
    

    public RegistroPessoa() {
    }

    public RegistroPessoa(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public RegistroPessoa(Integer idregistro, Date entrada, int idusuario) {
        this.idregistro = idregistro;
        this.entrada = entrada;
        this.idusuario = idusuario;
    }

    public Integer getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(Integer idregistro) {
        Integer oldIdregistro = this.idregistro;
        this.idregistro = idregistro;
        changeSupport.firePropertyChange("idregistro", oldIdregistro, idregistro);
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        Date oldEntrada = this.entrada;
        this.entrada = entrada;
        changeSupport.firePropertyChange("entrada", oldEntrada, entrada);
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        Date oldSaida = this.saida;
        this.saida = saida;
        changeSupport.firePropertyChange("saida", oldSaida, saida);
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        int oldIdusuario = this.idusuario;
        this.idusuario = idusuario;
        changeSupport.firePropertyChange("idusuario", oldIdusuario, idusuario);
    }

    public Integer getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Integer idpessoa) {
        Integer oldIdpessoa = this.idpessoa;
        this.idpessoa = idpessoa;
        changeSupport.firePropertyChange("idpessoa", oldIdpessoa, idpessoa);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
