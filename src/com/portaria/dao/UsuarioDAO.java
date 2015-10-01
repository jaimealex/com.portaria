/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.dao;

import com.portaria.entity.Usuario;
import com.portaria.exception.BusinessException;
import com.portaria.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import org.jboss.logging.Logger;

/**
 *
 * @author winston.sonnesen
 */
public class UsuarioDAO implements IDAO<Usuario> {

    private final EntityManager entityManager;

    public UsuarioDAO() {
        entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public Usuario save(Usuario usuario) throws BusinessException{
        Usuario merged = null;
        try{
           entityManager.getTransaction().begin();
           merged = entityManager.merge(usuario);
           entityManager.getTransaction().commit();
       } catch (PersistenceException ex){
            Logger.getLogger(UsuarioDAO.class.getName(), null).log(Logger.Level.ERROR, ex);
           try{
               entityManager.getTransaction().rollback();
           }catch (PersistenceException pex) {
               Logger.getLogger(UsuarioDAO.class.getName(), null).log(Logger.Level.ERROR, pex);
           }
            throw new BusinessException("Erro ao salvar Usuario " + usuario, ex);
       
       }
        JPAUtil.closeEntityManager(entityManager);
        
       return merged; 
    }
    
    public Usuario refresh(Usuario usuario) {
        entityManager.getTransaction().begin();
        Usuario u = entityManager.merge(usuario);
        entityManager.refresh(u);
        entityManager.getTransaction().commit();
        entityManager.close();
        return u;
    }
    
    @Override
    public void remove(Usuario usuario) {
        entityManager.getTransaction().begin();
        Usuario u = entityManager.merge(usuario);
        entityManager.remove(u);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Usuario findById(Long codigo) {
        return entityManager.find(Usuario.class, codigo);
    }

    public Usuario findByLoginSenha(String login, String senha) {
        TypedQuery<Usuario> query = entityManager.createQuery("Usuario.findByLoginSenha", Usuario.class)
                .setParameter("login", login)
                .setParameter("senha", senha);
        Usuario usuario = query.getSingleResult();
        JPAUtil.closeEntityManager(entityManager);
        return usuario;        
    }

    @Override
    public List<Usuario> findAll() {
        TypedQuery<Usuario> query = entityManager.createNamedQuery("Usuario.findAll", Usuario.class);
        List<Usuario> usuarios = query.getResultList();
        JPAUtil.closeEntityManager(entityManager);
        return usuarios;
    }

}
