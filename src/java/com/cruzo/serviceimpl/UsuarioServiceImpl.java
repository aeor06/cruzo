/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruzo.serviceimpl;




import com.cruzo.entitys.Usuario;
import com.cruzo.service.IUsuarioService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author docente
 */
@Stateless
public class UsuarioServiceImpl implements IUsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuario login(Usuario usuario) {
        System.out.println("login en EJB");
//        if (usuario.getUser().trim().equalsIgnoreCase("admin") && usuario.getPass().equals("12345")) {
//            usuario.setApellidos("Apellidos");
//            usuario.setNombres("Nombres");
//            
//            return usuario;
//        }
//
//        return null;
        
        String jpql = "SELECT u FROM Usuario u WHERE u.user = :userName AND u.pass = :pass";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        query.setParameter("userName", usuario.getUser());
        query.setParameter("pass", usuario.getPass());
        
        try{
            return query.getSingleResult();
        }catch(javax.persistence.NoResultException e) {
            return null;
        }

    }

    
    @Override
    public void insert(Usuario usuario) {
        entityManager.persist(usuario);
        
        
//        entityManager.find(Usuario.class, 1);
//        entityManager.merge(usuario);
//        entityManager.remove(usuario);
    }

    @Override
    public List<Usuario> listAll() {
        List<Usuario> list = null;
        
        String jpql = "SELECT u FROM Usuario u";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        list = query.getResultList();
        
        return list;
    }

    @Override
    public void modify(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void remove(Usuario usuario) {
       usuario = entityManager.find(Usuario.class, usuario.getId());
        entityManager.remove(usuario); 
    }
   
    }

