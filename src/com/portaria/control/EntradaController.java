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
import java.util.List;

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

    /**
     * Efetua carga a partir dos registros da tabela pessoa
     */
    public void carregarPessoas() {
        //pessoaDAO = new PessoaDAO();
        //model.setPessoaList(pessoaDAO.findAll());
    }

    /**
     * Efetua carga a partir dos registros da tabela inscricao
     */
    public void carregarUsuarios() {
//        inscricaoDAO = new InscricaoDAO();
//        List<Inscricao> inscricoes = inscricaoDAO.findAll();
//        model.setInscricaoList(inscricoes);
//        model.setInscricaoMap(inscricoes);
    }

    /**
     * Efetua carga a partir dos registros da tabela oficina
     */
    public void carregarVeiculos() {
//        oficinaDAO = new OficinaDAO();
//        model.setOficinaList(oficinaDAO.findAll());
    }

    /**
     *
     * @param inscricao
     * @throws BusinessException
     */
//    public void remove(Inscricao inscricao) throws BusinessException {
//        inscricaoDAO = new InscricaoDAO();
//        inscricaoDAO.remove(inscricao);
//        model.removeInscricao(inscricao);
//    }

    /**
     *
     * @param inscricao
     * @throws BusinessException
     */
//    public void save(Inscricao inscricao) throws BusinessException {
//        inscricaoDAO = new InscricaoDAO();
//        inscricao = inscricaoDAO.save(inscricao);
//        model.addInscricao(inscricao);        
//    }

 
    
}
