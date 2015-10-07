/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.control;


import com.portaria.dao.PessoaDAO;
import com.portaria.dao.UsuarioDAO;
import com.portaria.dao.VeiculoDAO;
import com.portaria.model.EntradaModel;

/**
 *
 * @author winston
 */
public class EntradaController implements IController {

    private PessoaDAO pessoaDAO;
    private UsuarioDAO usuarioDAO;
    private VeiculoDAO veiculoDAO;
    private final EntradaModel model;

    /**
     *
     * @param model
     */
    public EntradaController(EntradaModel model) {
        this.model = model;
    }
}
