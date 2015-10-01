/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.dao;

import com.portaria.exception.BusinessException;
import java.util.List;

/**
 *
 * @author visitante
 * @param <E>
 */
public interface IDAO<E> {

    E findById(Long id);

    List<E> findAll();

    E save(E entity) throws BusinessException;

    void remove(E entity) throws BusinessException;

}
