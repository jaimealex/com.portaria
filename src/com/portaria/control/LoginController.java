/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portaria.control;

import com.portaria.dao.UsuarioDAO;
import com.portaria.entity.Usuario;
import com.portaria.exception.BusinessException;
import com.portaria.model.LoginModel;
import com.portaria.session.SessionManager;
import javax.swing.JOptionPane;

/**
 *
 * @author visitante
 */
public class LoginController {

    private final LoginModel model;

    public LoginController(LoginModel model) {
        this.model = model;
    }

    public void doLogin(Usuario usuario) throws BusinessException {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuarioLogado = dao.findByLoginSenha(usuario.getLogin(), usuario.getSenha());
        if (usuarioLogado == null) {           
            JOptionPane.showMessageDialog(null, "Operação executada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
        SessionManager.setUsuarioLogado(usuarioLogado);
    }
}
