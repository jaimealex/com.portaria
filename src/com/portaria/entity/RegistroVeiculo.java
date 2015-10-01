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
@Table(name = "registro_veiculo", catalog = "portaria", schema = "")
@NamedQueries({
    @NamedQuery(name = "RegistroVeiculo.findAll", query = "SELECT r FROM RegistroVeiculo r"),
    @NamedQuery(name = "RegistroVeiculo.findByIdregistro", query = "SELECT r FROM RegistroVeiculo r WHERE r.idregistro = :idregistro"),
    @NamedQuery(name = "RegistroVeiculo.findByEntrada", query = "SELECT r FROM RegistroVeiculo r WHERE r.entrada = :entrada"),
    @NamedQuery(name = "RegistroVeiculo.findBySaida", query = "SELECT r FROM RegistroVeiculo r WHERE r.saida = :saida"),
    @NamedQuery(name = "RegistroVeiculo.findByIdusuario", query = "SELECT r FROM RegistroVeiculo r WHERE r.idusuario = :idusuario"),
    @NamedQuery(name = "RegistroVeiculo.findByIdveiculo", query = "SELECT r FROM RegistroVeiculo r WHERE r.idveiculo = :idveiculo")})
public class RegistroVeiculo implements Serializable {

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
    @Column(name = "idveiculo")
    private Long idveiculo;

    public RegistroVeiculo() {
    }

    public RegistroVeiculo(Long idregistro) {
        this.idregistro = idregistro;
    }

    public RegistroVeiculo(Long idregistro, Date entrada, int idusuario) {
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

    public Long getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(Long idveiculo) {
        this.idveiculo = idveiculo;
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
        if (!(object instanceof RegistroVeiculo)) {
            return false;
        }
        RegistroVeiculo other = (RegistroVeiculo) object;
        if ((this.idregistro == null && other.idregistro != null) || (this.idregistro != null && !this.idregistro.equals(other.idregistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.portaria.view.RegistroVeiculo[ idregistro=" + idregistro + " ]";
    }
}
