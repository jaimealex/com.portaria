/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author visitante
 */
public class JPAUtil {

    private static final String PERSISTENCE_UNIT_NAME = "PortariaPU";
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static void closeEntityManager(EntityManager entityManager) {
        try {
            entityManager.close();
        } catch (PersistenceException ex) {
            Logger.getLogger(JPAUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private JPAUtil() {

    }

    /**
     * Obtendo um gerenciador de entidades
     * @return EntityManager
     */
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Fechando as conexões com o banco de dados
     */
    public static void closeEntityManagerFactory() {
        emf.close();
    }
}
