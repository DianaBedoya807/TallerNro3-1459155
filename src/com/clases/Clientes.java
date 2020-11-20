package com.clases;

import java.util.List;

public class Clientes extends Empresas{
    private String nombre;
    private String telefono;
    private String direccion;
    private List<Producto> productos;

    public Clientes() {
    }

    public Clientes(String tipoDoc, String documento) {
        super(tipoDoc, documento);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }


}
