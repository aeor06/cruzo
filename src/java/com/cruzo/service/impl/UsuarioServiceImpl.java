/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruzo.service.impl;




import com.cruzo.entitys.Usuario;
import com.cruzo.interfaces.IUsuarioService;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author docente
 */
@Stateless
public class UsuarioServiceImpl implements IUsuarioService {

        public Usuario login(Usuario usuario) {
        System.out.println("login en EJB");
        if (usuario.getUser().trim().equalsIgnoreCase("admin") && usuario.getPass().equals("12345")) {
            return usuario;
        }
        return null;
    }

    @Override
    public Usuario login(Usuario usuario, List<Usuario> lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
