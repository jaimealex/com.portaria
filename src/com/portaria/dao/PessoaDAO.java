/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.dao;

import com.portaria.entity.Pessoa;
import com.portaria.exception.BusinessException;
import com.portaria.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import org.jboss.logging.Logger;

public class PessoaDAO implements IDAO<Pessoa> {

    private final EntityManager entityManager;

    public PessoaDAO() {
        entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public void remove(Pessoa pessoa) throws BusinessException {
        try {
            entityManager.getTransaction().begin();
            pessoa = entityManager.merge(pessoa);
            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            throw new BusinessException("Erro ao remover o registro: " + pessoa, ex);
        }
    }

    @Override
    public Pessoa findById(Long codigo) {
        return entityManager.find(Pessoa.class, codigo);
    }

    public List<Pessoa> findByCpf(String cpf) {
        System.out.println(cpf);
        TypedQuery<Pessoa> query = entityManager.createNamedQuery("Pessoa.findByCpf", Pessoa.class)
                .setParameter("cpf", "%" + cpf + "%");
        List<Pessoa> pessoas = query.getResultList();
        JPAUtil.closeEntityManager(entityManager);
        return pessoas;
    }

    public List<Pessoa> findByNome(String nome) {
        TypedQuery<Pessoa> query = entityManager.createNamedQuery("Pessoa.findByNome", Pessoa.class)
                .setParameter("nome", "%" + nome + "%");
        List<Pessoa> pessoas = query.getResultList();
        JPAUtil.closeEntityManager(entityManager);
        return pessoas;
    }

    @Override
    public List<Pessoa> findAll() {
        TypedQuery<Pessoa> query = entityManager.createNamedQuery("Pessoa.findAll", Pessoa.class);
        List<Pessoa> pessoas = query.getResultList();
        JPAUtil.closeEntityManager(entityManager);
        return pessoas;
    }

    @Override
    public Pessoa save(Pessoa pessoa) throws BusinessException {
        Pessoa merged = null;
        try {
            entityManager.getTransaction().begin();
            merged = entityManager.merge(pessoa);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            Logger.getLogger(PessoaDAO.class.getName(), null).log(Logger.Level.ERROR, ex);
            try {
                entityManager.getTransaction().rollback();
            } catch (PersistenceException pex) {
                Logger.getLogger(PessoaDAO.class.getName(), null).log(Logger.Level.ERROR, pex);
            }
            throw new BusinessException("Erro ao salvar o usuario " + pessoa, ex);
        }

        JPAUtil.closeEntityManager(entityManager);

        return merged;
    }

}
