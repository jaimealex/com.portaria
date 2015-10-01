/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.session;

import com.portaria.entity.Usuario;

/**
 *
 * @author visitante
 */
public class SessionManager {

    private static Usuario usuarioLogado;

    private SessionManager() {

    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuarioLogado) {
        SessionManager.usuarioLogado = usuarioLogado;
    }

}
