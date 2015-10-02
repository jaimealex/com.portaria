/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.dao;

import com.portaria.entity.Veiculo;
import com.portaria.exception.BusinessException;
import com.portaria.util.JPAUtil;
import java.util.List;
import javax.persistence.*;
import org.jboss.logging.Logger;


public class VeiculoDAO implements IDAO<Veiculo> {

    private final EntityManager entityManager;

    public VeiculoDAO() {
        entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public Veiculo save(Veiculo veiculo) throws BusinessException{
        Veiculo merged = null;
        try{
            entityManager.getTransaction().begin();
            merged = entityManager.merge(veiculo);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex){
                Logger.getLogger(VeiculoDAO.class.getName(), null).log(Logger.Level.ERROR, ex);
                
            try{
                entityManager.getTransaction().rollback();
            }catch(PersistenceException pex){
                    Logger.getLogger(VeiculoDAO.class.getName(), null).log(Logger.Level.ERROR, pex);
            }
                throw new BusinessException("Erro ao salvar Veiculo" + veiculo, ex);
        }
        JPAUtil.closeEntityManager(entityManager);
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
    public Veiculo findById(Long codigo) {
        return entityManager.find(Veiculo.class, codigo);
    }

    @Override
    public List<Veiculo> findAll() {
        TypedQuery<Veiculo> query = entityManager.createNamedQuery("Veiculo.findAll", Veiculo.class);
        List<Veiculo> veiculos = query.getResultList();
        return veiculos;
    }

    public Veiculo refresh(Veiculo veiculo) {
        entityManager.getTransaction().begin();
        Veiculo v = entityManager.merge(veiculo);
        entityManager.refresh(v);
        entityManager.getTransaction().commit();
        entityManager.close();
        return v;
    }

}
