/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.model;

import com.portaria.entity.Veiculo;
import java.util.Comparator;

/**
 *
 * @author winston.sonnesen
 */
public class VeiculoComparator implements Comparator<Veiculo> {

    @Override
    public int compare(Veiculo o1, Veiculo o2) {
        return (o1.getIdveiculo() < o2.getIdveiculo() ? -1 : (o1.getIdveiculo().longValue() == o2.getIdveiculo()) ? 0 : 1);
    }

}
