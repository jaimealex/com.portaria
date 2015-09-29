/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
