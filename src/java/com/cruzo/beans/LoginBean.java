/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruzo.beans;


import com.cruzo.entitys.Usuario;
import com.cruzo.service.IUsuarioService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author docente
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {    
    private Usuario usuario;
    
    @EJB private IUsuarioService usuarioService;

    /** Creates a new instance of LoginBean */
    public LoginBean() {
        usuario = new Usuario();
    }
    
    public String login() {
        Usuario u = usuarioService.login(usuario);
        
        if(u != null) {
            usuario = u;
            return "inicio";
        }
        
        return null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
