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

    public Ataque getAtaque1() {
        return ataque1;
    }

    public void setAtaque1(Ataque ataque1) {
        this.ataque1 = ataque1;
    }

    public Ataque getAtaque2() {
        return ataque2;
    }

    public void setAtaque2(Ataque ataque2) {
        this.ataque2 = ataque2;
    }

    public Ataque getAtaque3() {
        return ataque3;
    }

    public void setAtaque3(Ataque ataque3) {
        this.ataque3 = ataque3;
    }

    public Ataque getAtaque4() {
        return ataque4;
    }

    public void setAtaque4(Ataque ataque4) {
        this.ataque4 = ataque4;
    }

    Ataque ataque3;
    Ataque ataque4;

    public Pokimon(String nombre, int id, int atq, int def, int peso, String tipo, String descripcion, int evolucion, int preevolucion) {
        this.nombre = nombre;
        this.id = id;
        this.atq = atq;
        this.def = def;
        this.peso = peso;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.evolucion = evolucion;
        this.preevolucion = preevolucion;
    }
}
