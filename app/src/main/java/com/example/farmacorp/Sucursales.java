package com.example.farmacorp;

public class Sucursales {
    private Integer id;
    private String sucursal;
    private String usuarioCustom;
    public String elegido;

    public Sucursales() {
    }

    public Sucursales(Integer id, String sucursal) {
        this.id = id;
        this.sucursal = sucursal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        this.usuarioCustom = this.usuarioCustom = sucursal;
        return usuarioCustom;
    }
}
