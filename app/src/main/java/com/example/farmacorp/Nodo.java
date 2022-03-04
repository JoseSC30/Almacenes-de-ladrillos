package com.example.farmacorp;

/**
 * Write a description of class Nodo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Nodo
{
    private String vertice;
    private int costo;

    public Nodo(String ver, int costo){
        this.vertice=ver;
        this.costo=costo;
    }
    public String getVertice(){
        return vertice;
    }
    public int getCosto(){
        return costo;
    }

}
