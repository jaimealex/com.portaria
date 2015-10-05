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
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

/**
 *
 * @author winston.sonnesen
 */
public class VeiculoDAO implements IDAO<Veiculo> {

    private final EntityManager manager;
    

    /**
     * Construtor da classe
     */
    public VeiculoDAO() {
        manager = JPAUtil.getEntityManager();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Veiculo> findAll() {
        List<Veiculo> veiculos = manager.createNamedQuery("Veiculo.findAll", Veiculo.class).getResultList();
        manager.close();
        return veiculos;
    }

    /**
     *
     * @param veiculo
     * @throws BusinessException
     */
    @Override
    public Veiculo save(Veiculo veiculo) throws BusinessException {
        try {
            manager.getTransaction().begin();
            if (!manager.contains(veiculo)) {
                veiculo = manager.merge(veiculo);
            }
            manager.persist(veiculo);
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao salvar registro: " + veiculo, e);
        } finally {
            manager.close();
        }
        return veiculo;
    }

    @Override
    public void remove(Veiculo veiculo) throws BusinessException {
        try {
            manager.getTransaction().begin();
            manager.remove(manager.merge(veiculo));
            manager.getTransaction().commit();
        } catch (RollbackException e) {
            throw new BusinessException("Erro ao remover registro: " + veiculo, e);
        } finally {
            manager.close();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Veiculo findById(Long id) {
        Veiculo veiculo = manager.find(Veiculo.class, id);
        manager.close();
        return veiculo;
    }    
    public List<Veiculo> findByPlaca(String placa) {
        System.out.println("placa= " + placa);
        TypedQuery<Veiculo> query = manager.createNamedQuery("Veiculo.findByPlaca", Veiculo.class)
                .setParameter("placa", "%" + placa + "%");
        List<Veiculo> veiculos = query.getResultList();
        JPAUtil.closeEntityManager(manager);
        return veiculos;
    }
}
