package com.sainoxsa.loginapp.metodos;

public class Usuario {

    private String nombre;
    private String direccion;
    private String correo;
    private String id;

    public Usuario(String nombre, String direccion, String correo,  String id) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.id = id;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
