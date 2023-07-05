package com.example.gdmdr;

public class Boleta {
    private int id;
    private String contenido;
    private double precioTotal;
    private String usuario;

    public Boleta(String contenido, double precioTotal, String usuario) {
        this.contenido = contenido;
        this.precioTotal = precioTotal;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
