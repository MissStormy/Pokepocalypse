package com.pokejavafx.pokejavafx;

public class Ataque {
    String nombre;
    int id;
    String descripcion;
    boolean especial;
    int potencia;
    String tipo;

    public Ataque(String nombre, int id, String descripcion, boolean especial, int potencia, String tipo) {
        this.nombre = nombre;
        this.id = id;
        this.descripcion = descripcion;
        this.especial = especial;
        this.potencia = potencia;
        this.tipo = tipo;
    }
}
