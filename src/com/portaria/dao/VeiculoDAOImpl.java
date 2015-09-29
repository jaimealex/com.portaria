/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.dao;

import com.portaria.entity.Veiculo;
import com.portaria.util.JPAUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


public class VeiculoDAOImpl implements VeiculoDAO<Veiculo> {

    private final EntityManager entityManager;

    public VeiculoDAOImpl() {
        entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public Veiculo save(Veiculo veiculo) {
        entityManager.getTransaction().begin();
        Veiculo merged = entityManager.merge(veiculo);
        entityManager.getTransaction().commit();
        entityManager.close();
        return merged;
    }
    
    @Override
    public void remove(Veiculo veiculo) {
        entityManager.getTransaction().begin();
        Veiculo v = entityManager.merge(veiculo);
        entityManager.remove(v);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Veiculo findByID(Integer codigo) {
        return entityManager.find(Veiculo.class, codigo);
    }

    @Override
    public List<Veiculo> findAll() {
        TypedQuery<Veiculo> query = entityManager.createQuery("from Veiculo", Veiculo.class);
        List<Veiculo> veiculos = query.getResultList();
        return veiculos;
    }

    @Override
    public Veiculo refresh(Veiculo veiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
