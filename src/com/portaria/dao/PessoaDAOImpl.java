/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.dao;

import com.portaria.entity.Pessoa;
import com.portaria.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class PessoaDAOImpl implements PessoaDAO<Pessoa> {

    private final EntityManager entityManager;

    public PessoaDAOImpl() {
        entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public Pessoa save(Pessoa pessoa) {  
  
        entityManager.getTransaction().begin();
        Pessoa merged = entityManager.merge(pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
    
        
        return merged;
    }

    @Override
    public void remove(Pessoa pessoa) {
        entityManager.getTransaction().begin();
        pessoa = entityManager.merge(pessoa); 
        entityManager.remove(pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();        
    }

    @Override
    public Pessoa findByID(Integer codigo) {
        return entityManager.find(Pessoa.class, codigo);
    }
   
    @Override
    public List<Pessoa> findByCpf(String cpf) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT p FROM Pessoa p WHERE ");
        sb.append("p.cpf");

        sb.append(" like :param");            

        TypedQuery<Pessoa> query = entityManager.createQuery(sb.toString(), Pessoa.class);

        query.setParameter("param", "%" + cpf + "%");

        List<Pessoa> pessoas = query.getResultList();
        return pessoas;  
    }

    @Override
    public List<Pessoa> findByName(String nome) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT p FROM Pessoa p WHERE ");
        sb.append("p.nome");

        sb.append(" like :param");            

        TypedQuery<Pessoa> query = entityManager.createQuery(sb.toString(), Pessoa.class);

        query.setParameter("param", "%" + nome + "%");

        List<Pessoa> pessoas = query.getResultList();
        return pessoas;        
    }

    
    @Override
    public List<Pessoa> findAll() {
        TypedQuery<Pessoa> query = entityManager.createQuery("from Pessoa p", Pessoa.class);
        List<Pessoa> pessoas = query.getResultList();
        return pessoas;
    }


}
