
package com.cruzo.interfaces;


import com.cruzo.entitys.Usuario;
import java.util.List;

public interface IUsuarioService {
    public Usuario login(Usuario usuario, List<Usuario> lista);

    public Usuario login(Usuario usuario);
}
