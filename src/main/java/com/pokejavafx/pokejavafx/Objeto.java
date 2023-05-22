package com.pokejavafx.pokejavafx;

public class Objeto {
    int id;
    String nombre;
    String descripcion;
    int precio;
    int tipo;// 1 aumento velocidad, 2 aumento de probabilidades de conseguir pokeon
    int duracion;
    int potencia;

    public Objeto(int id, String nombre, String descripcion, int precio, int tipo, int duracion, int potencia) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
        this.duracion = duracion;
        this.potencia = potencia;
    }
}
