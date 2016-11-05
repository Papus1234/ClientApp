package com.example.james.customer1.Resou;


/**
 * Created by James on 3/11/2016.
 */

public class Platillo {
    String nombre;
    Ingredientes ingredientes;
    String informacion_nutricional;
    int precio;
    int tiempo_de_preparacion;
    Receta receta ;


    public Platillo(String nombre, Ingredientes ingredientes, String informacion_nutricional, int precio,
                    int tiempo_de_preparacion, Receta receta) {

        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.informacion_nutricional = informacion_nutricional;
        this.precio = precio;
        this.tiempo_de_preparacion = tiempo_de_preparacion;
        this.receta = receta;
    }
    public Platillo(){

    }
    public Receta getReceta() {
        return receta;
    }


    public void setReceta(Receta receta) {
        this.receta = receta;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Ingredientes getIngredientes() {
        return ingredientes;
    }


    public void setIngredientes(Ingredientes ingredientes) {
        this.ingredientes = ingredientes;
    }


    public String getInformacion_nutricional() {
        return informacion_nutricional;
    }


    public void setInformacion_nutricional(String informacion_nutricional) {
        this.informacion_nutricional = informacion_nutricional;
    }


    public int getPrecio() {
        return precio;
    }


    public void setPrecio(int precio) {
        this.precio = precio;
    }


    public int getTiempo_de_preparacion() {
        return tiempo_de_preparacion;
    }


    public void setTiempo_de_preparacion(int tiempo_de_preparacion) {
        this.tiempo_de_preparacion = tiempo_de_preparacion;
    }


}


