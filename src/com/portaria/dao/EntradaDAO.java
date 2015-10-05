/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.dao;

import com.portaria.entity.Entrada;
import com.portaria.exception.BusinessException;
import com.portaria.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import org.jboss.logging.Logger;

public class EntradaDAO implements IDAO<Entrada> {

    private final EntityManager entityManager;

    public EntradaDAO() {
        entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public void remove(Entrada entrada) throws BusinessException {
        try {
            entityManager.getTransaction().begin();
            entrada = entityManager.merge(entrada);
            entityManager.remove(entrada);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            throw new BusinessException("Erro ao remover o registro: " + entrada, ex);
        }
        JPAUtil.closeEntityManager(entityManager);
    }

    @Override
    public Entrada findById(Long codigo) {
        return entityManager.find(Entrada.class, codigo);
    }

    public List<Entrada> findByCpf(String cpf) {
        System.out.println(cpf);
        TypedQuery<Entrada> query = entityManager.createNamedQuery("Entrada.findByCpf", Entrada.class)
                .setParameter("cpf", "%" + cpf + "%");
        List<Entrada> entradas = query.getResultList();
        JPAUtil.closeEntityManager(entityManager);
        return entradas;
    }

    public List<Entrada> findByNome(String nome) {
        System.out.println(nome);
        TypedQuery<Entrada> query = entityManager.createNamedQuery("Entrada.findByNome", Entrada.class)
                .setParameter("nome", "%" + nome + "%");
        List<Entrada> entradas = query.getResultList();
        JPAUtil.closeEntityManager(entityManager);
        return entradas;
    }

    @Override
    public List<Entrada> findAll() {
        TypedQuery<Entrada> query = entityManager.createNamedQuery("Entrada.findAll", Entrada.class);
        List<Entrada> entradas = query.getResultList();
        JPAUtil.closeEntityManager(entityManager);
        return entradas;
    }

    @Override
    public Entrada save(Entrada entrada) throws BusinessException {
        Entrada merged = null;
        try {
            entityManager.getTransaction().begin();
            merged = entityManager.merge(entrada);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            Logger.getLogger(EntradaDAO.class.getName(), null).log(Logger.Level.ERROR, ex);
            try {
                entityManager.getTransaction().rollback();
            } catch (PersistenceException pex) {
                Logger.getLogger(EntradaDAO.class.getName(), null).log(Logger.Level.ERROR, pex);
            }
            throw new BusinessException("Erro ao salvar o usuario " + entrada, ex);
        }

        JPAUtil.closeEntityManager(entityManager);

        return merged;
    }

}
