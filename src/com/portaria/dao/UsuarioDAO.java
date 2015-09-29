/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.dao;

import java.util.List;

/**
 *
 * @author winston.sonnesen
 * @param <Usuario>
 */
public interface UsuarioDAO<Usuario> {

    Usuario save(Usuario usuario);

    Usuario refresh(Usuario usuario);
    
    void remove(Usuario usuario);

    Usuario findByID(Integer codigo);
    
    Usuario findByLoginSenha(String login, String senha);

    List<Usuario> findAll();
}
