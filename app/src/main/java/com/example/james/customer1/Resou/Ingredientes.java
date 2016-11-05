package com.example.james.customer1.Resou;

/**
 * Created by James on 3/11/2016.
 */

import java.util.List;


public class Ingredientes {
    List <Ingrediente> frutas,vegetales,granos,lacteos,carnes;
    List<Ingrediente>todos;


    public List<Ingrediente> getTodos() {
        return todos;
    }
    public void setTodos(List<Ingrediente> todos) {
        this.todos = todos;
    }
    public Ingredientes(List<Ingrediente> frutas, List<Ingrediente> vegetales, List<Ingrediente> granos,
                        List<Ingrediente> lacteos, List<Ingrediente> carnes) {
        super();
        this.frutas = frutas;
        this.vegetales = vegetales;
        this.granos = granos;
        this.lacteos = lacteos;
        this.carnes = carnes;
    }
    public Ingredientes(List<Ingrediente>todos){
        this.todos=todos;

    }

    public Ingredientes(){

    }

    public List<Ingrediente> getFrutas() {
        return frutas;
    }

    public void setFrutas(List<Ingrediente> frutas) {
        this.frutas = frutas;
    }

    public List<Ingrediente> getVegetales() {
        return vegetales;
    }

    public void setVegetales(List<Ingrediente> vegetales) {
        this.vegetales = vegetales;
    }

    public List<Ingrediente> getGranos() {
        return granos;
    }

    public void setGranos(List<Ingrediente> granos) {
        this.granos = granos;
    }

    public List<Ingrediente> getLacteos() {
        return lacteos;
    }

    public void setLacteos(List<Ingrediente> lacteos) {
        this.lacteos = lacteos;
    }

    public List<Ingrediente> getCarnes() {
        return carnes;
    }

    public void setCarnes(List<Ingrediente> carnes) {
        this.carnes = carnes;
    }


    public void Registrar(String ingrediente, String categoria){
        if (categoria=="frutas"){
            Ingrediente n= new Ingrediente(ingrediente);
            frutas.add(n);
        }
        else if(categoria=="granos"){
            Ingrediente n= new Ingrediente(ingrediente);
            granos.add(n);
        }
        else if(categoria=="vegetales"){
            Ingrediente n= new Ingrediente(ingrediente);
            vegetales.add(n);
        }
        else if(categoria=="lacteos"){
            Ingrediente n= new Ingrediente(ingrediente);
            lacteos.add(n);
        }
        else if(categoria=="carnes"){
            Ingrediente n= new Ingrediente(ingrediente);
            carnes.add(n);
        }
        else{
            System.err.print("Categor�a no v�lida");
        }
    }
}