/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.dao;

import com.portaria.entity.Veiculo;
import java.util.List;

/**
 *
 * @author visitante
 */
public interface VeiculoDAO<veiculo> {
    
    Veiculo save(Veiculo veiculo);

    Veiculo refresh(Veiculo veiculo);
    
    void remove(Veiculo veiculo);

    Veiculo findByID(Integer codigo);
    
    List<Veiculo> findAll();
    
}
