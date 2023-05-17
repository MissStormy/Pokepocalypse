package com.pokejavafx.pokejavafx;

public class Pokimon {
    String nombre;
    int id;
    int atq;
    int def;
    int peso;
    String tipo;
    String descripcion;
    int evolucion;
    int preevolucion;
    Ataque ataque1;
    Ataque ataque2;
    Ataque ataque3;
    Ataque ataque4;

    public Pokimon(String nombre, int id, int atq, int def, int peso, String tipo, String descripcion, int evolucion, int preevolucion, Ataque ataque1, Ataque ataque2, Ataque ataque3, Ataque ataque4) {
        this.nombre = nombre;
        this.id = id;
        this.atq = atq;
        this.def = def;
        this.peso = peso;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.evolucion = evolucion;
        this.preevolucion = preevolucion;
        this.ataque1 = ataque1;
        this.ataque2 = ataque2;
        this.ataque3 = ataque3;
        this.ataque4 = ataque4;
    }
}
