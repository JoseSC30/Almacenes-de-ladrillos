package com.example.farmacorp;

public class Usuario {

    private Integer id;
    private String almacen;
    private String usuarioCustom;

    public Usuario() {
    }

    public Usuario(Integer id, String almacen) {
        this.id = id;
        this.almacen = almacen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    @Override
    public String toString() {
        this.usuarioCustom = this.usuarioCustom = almacen;
        return usuarioCustom;
    }
}
