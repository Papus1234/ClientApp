package com.example.james.customer1.Resou;

/**
 * Created by James on 4/11/2016.
 */

public class Ingrediente {
    String nombre;


    int cantidad;
    String tipo ;

    public Ingrediente(String tipo,String nombre){
        this.tipo=tipo;
        this.nombre=nombre;


    }
    public Ingrediente(String nombre,int cantidad){
        this.nombre=nombre;
        this.cantidad=cantidad;
    }
    public Ingrediente(){

    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Ingrediente(String n){
        cantidad=1;
        nombre=n;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
