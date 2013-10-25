/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruzo.beans;

import com.cruzo.entitys.Usuario;
import com.cruzo.service.IUsuarioService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{
    
     private Usuario usuario;
    @EJB private IUsuarioService usuarioService;
     private List<Usuario> listUsuario;
     
     
       public UsuarioBean() {
        usuario = new Usuario();
    }

    @PostConstruct
    private void init() {
        listUsuario = usuarioService.listAll();
    }
    
    public void registrar() {
        usuarioService.insert(usuario);
        usuario = new Usuario();
        
        
       listUsuario = usuarioService.listAll();
    }
    
    
    public void editar(ActionEvent ae) {
        usuario = (Usuario) ae.getComponent().getAttributes().get("tipo");              
        System.out.println(usuario);
    }
    
    public void eliminar(ActionEvent ae) {
        usuario = (Usuario) ae.getComponent().getAttributes().get("tipo"); 
        usuarioService.remove(usuario);        
        usuario.setNombres("");
        usuario.setApellidos("");
        usuario.setIdentificacion("");        
        usuario.setUser("");
        usuario.setPass("");       
        listUsuario = usuarioService.listAll();
    }

    
    
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }
    
}
