
package com.cruzo.service;


import com.cruzo.entitys.Usuario;
import java.util.List;

public interface IUsuarioService {
    
    
    /**
     * Realiza el login del usuario en la base de datos
     * @param usuario
     * @return 
     */
    Usuario login(Usuario usuario);
    
    /**
     * Metodo encargado de registrar un usuario en la base de datos
     * @param usuario 
     */
    public void insert(Usuario usuario);
    
    public List<Usuario> listAll();
    
    public void modify (Usuario usuario);
    
     public void remove(Usuario usuario);
}
