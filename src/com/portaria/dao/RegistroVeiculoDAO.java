/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.dao;

import com.portaria.entity.RegistroVeiculo;

import com.portaria.exception.BusinessException;
import com.portaria.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import org.jboss.logging.Logger;

public class RegistroVeiculoDAO implements IDAO<RegistroVeiculo> {

    private final EntityManager entityManager;

    public RegistroVeiculoDAO() {
        entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public void remove(RegistroVeiculo registroVeiculo) throws BusinessException {
        try {
            entityManager.getTransaction().begin();
            registroVeiculo = entityManager.merge(registroVeiculo);
            entityManager.remove(registroVeiculo);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            throw new BusinessException("Erro ao remover o registro: " + registroVeiculo, ex);
        }
        JPAUtil.closeEntityManager(entityManager);
    }

    @Override
    public RegistroVeiculo findById(Long codigo) {
        return entityManager.find(RegistroVeiculo.class, codigo);
    }
    
    public List<RegistroVeiculo> findBySaidaNull() {
        TypedQuery<RegistroVeiculo> query = entityManager.createNamedQuery("RegistroVeiculo.findBySaidaNull", RegistroVeiculo.class);
                
        List<RegistroVeiculo> registroVeiculo = query.getResultList();
        JPAUtil.closeEntityManager(entityManager);
        return registroVeiculo;
    }
    
    @Override
    public List<RegistroVeiculo> findAll() {
        TypedQuery<RegistroVeiculo> query = entityManager.createNamedQuery("RegistroVeiculo.findAll", RegistroVeiculo.class);
        List<RegistroVeiculo> registroVeiculos = query.getResultList();
        JPAUtil.closeEntityManager(entityManager);
        return registroVeiculos;
    }

    @Override
    public RegistroVeiculo save(RegistroVeiculo registroVeiculo) throws BusinessException {
        RegistroVeiculo merged = null;
        try {
            entityManager.getTransaction().begin();
            merged = entityManager.merge(registroVeiculo);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            Logger.getLogger(RegistroVeiculoDAO.class.getName(), null).log(Logger.Level.ERROR, ex);
            try {
                entityManager.getTransaction().rollback();
            } catch (PersistenceException pex) {
                Logger.getLogger(RegistroVeiculoDAO.class.getName(), null).log(Logger.Level.ERROR, pex);
            }
            throw new BusinessException("Erro ao salvar o registro " + registroVeiculo, ex);
        }

        //JPAUtil.closeEntityManager(entityManager);

        return merged;
    }

}
