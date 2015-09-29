/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.dao;
import com.portaria.entity.Pessoa;
import java.util.Collection;
import java.util.List;

/**
 *
 * @param <Pessoa>
 */
public interface PessoaDAO<Pessoa> {

    Pessoa save(Pessoa pessoa);

    void remove(Pessoa pessoa);

    Pessoa findByID(Integer codigo);

    List<Pessoa> findAll();

    List<Pessoa> findByName(String nome);
    List<Pessoa> findByCpf(String cpf);
}
