/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.control;

import com.portaria.dao.VeiculoDAO;
import com.portaria.entity.Veiculo;
import com.portaria.exception.BusinessException;
import com.portaria.model.VeiculoModel;

import java.util.List;

/**
 *
 * @author winston.sonnesen
 */
public class VeiculoController implements IController {
    private VeiculoDAO veiculoDAO;
    private final VeiculoModel model;

    /**
     *
     * @param model
     */
    public VeiculoController(VeiculoModel model) {
        this.model = model;
    }

    /**
     * Efetua carga a partir dos registros da tabela inscricao
     */
    public void carregarVeiculos() {
        veiculoDAO = new VeiculoDAO();
        List<Veiculo> veiculos = veiculoDAO.findAll();
        model.setVeiculos(veiculos);
    }

    /**
     *
     * @param veiculo
     * @throws BusinessException
     */
    public void remove(Veiculo veiculo) throws BusinessException {
        veiculoDAO = new VeiculoDAO();
        veiculoDAO.remove(veiculo);
        model.removeVeiculo(veiculo);
    }

    /**
     *
     * @param veiculo
     * @throws BusinessException
     */
    public void save(Veiculo veiculo) throws BusinessException {
        veiculoDAO = new VeiculoDAO();
        veiculo = veiculoDAO.save(veiculo);
        Veiculo d = new Veiculo(veiculo.getIdveiculo(), veiculo.getPlaca(), veiculo.getModelo(), veiculo.getCor());
        model.removeVeiculo(veiculo);
        model.addVeiculo(d);
    }

    public VeiculoModel getModel() {
        return model;
    }

}
