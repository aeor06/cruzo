/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruzo.entitys;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable{
    
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    
    @NotNull 
    @Column(name="NOMBRES", length=15)
    private String nombres;
    
    @NotNull 
    @Column(name="APELLIDOS", length=15)
    private String apellidos;
    
    @NotNull
    @Size(min=5, max=15, message="La identificacion del usuario debe tener entre 5 y 15 caracteres")
    @Column(name="IDENTIDAD", length=10)
    private String identificacion;
    
    @NotNull
    @Size(min=3, max=10, message="El nombre de usuario debe tener entre 3 y 10 caracteres")
    @Column(name="USER_NAME", length=10, nullable=false, unique=true)
    private String user;
    
    @NotNull
    @Size(min=5, max=20, message="la contraseña debe tener entre 5 y 20 caracteres")
    @Column(name="PASS", length=10, nullable=false, unique=true)
    private String pass;
    
    @NotNull
    @Column(name="PERFIL", length=15)
    private String perfil;
    
    private int estado;

    public Usuario() {
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", identificacion=" + identificacion + ", user=" + user + ", pass=" + pass + ", perfil=" + perfil + ", estado=" + estado + '}';
    }
    
    

    
    
}
