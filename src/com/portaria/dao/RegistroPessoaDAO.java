/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.dao;

import com.portaria.entity.RegistroPessoa;
import com.portaria.entity.Veiculo;
import com.portaria.exception.BusinessException;
import com.portaria.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import org.jboss.logging.Logger;

public class RegistroPessoaDAO implements IDAO<RegistroPessoa> {

    private final EntityManager entityManager;

    public RegistroPessoaDAO() {
        entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public void remove(RegistroPessoa registroPessoa) throws BusinessException {
        try {
            entityManager.getTransaction().begin();
            registroPessoa = entityManager.merge(registroPessoa);
            entityManager.remove(registroPessoa);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            throw new BusinessException("Erro ao remover o registro: " + registroPessoa, ex);
        }
        JPAUtil.closeEntityManager(entityManager);
    }

    @Override
    public RegistroPessoa findById(Long codigo) {
        return entityManager.find(RegistroPessoa.class, codigo);
    }
    
    public List<RegistroPessoa> findBySaidaNull() {
        TypedQuery<RegistroPessoa> query = entityManager.createNamedQuery("RegistroPessoa.findBySaidaNull", RegistroPessoa.class);
                
        List<RegistroPessoa> registroPessoa = query.getResultList();
        JPAUtil.closeEntityManager(entityManager);
        return registroPessoa;
    }
    
    @Override
    public List<RegistroPessoa> findAll() {
        TypedQuery<RegistroPessoa> query = entityManager.createNamedQuery("RegistroPessoa.findAll", RegistroPessoa.class);
        List<RegistroPessoa> registroPessoas = query.getResultList();
        JPAUtil.closeEntityManager(entityManager);
        return registroPessoas;
    }

    @Override
    public RegistroPessoa save(RegistroPessoa registroPessoa) throws BusinessException {
        RegistroPessoa merged = null;
        try {
            entityManager.getTransaction().begin();
            merged = entityManager.merge(registroPessoa);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            Logger.getLogger(RegistroPessoaDAO.class.getName(), null).log(Logger.Level.ERROR, ex);
            try {
                entityManager.getTransaction().rollback();
            } catch (PersistenceException pex) {
                Logger.getLogger(RegistroPessoaDAO.class.getName(), null).log(Logger.Level.ERROR, pex);
            }
            throw new BusinessException("Erro ao salvar o registro " + registroPessoa, ex);
        }

        JPAUtil.closeEntityManager(entityManager);

        return merged;
    }

}
