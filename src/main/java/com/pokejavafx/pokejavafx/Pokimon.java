package com.pokejavafx.pokejavafx;

import javafx.scene.image.Image;

import java.awt.*;

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
    Image img;

    public Ataque getAtaque1() {
        return ataque1;
    }

    public void setAtaque1(Ataque ataque1) {
        this.ataque1 = ataque1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAtq() {
        return atq;
    }

    public void setAtq(int atq) {
        this.atq = atq;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEvolucion() {
        return evolucion;
    }

    public void setEvolucion(int evolucion) {
        this.evolucion = evolucion;
    }

    public int getPreevolucion() {
        return preevolucion;
    }

    public void setPreevolucion(int preevolucion) {
        this.preevolucion = preevolucion;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
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

    public Pokimon(String nombre, int id, int atq, int def, int peso, String tipo, String descripcion, int evolucion, int preevolucion, String img) {
        this.nombre = nombre;
        this.id = id;
        this.atq = atq;
        this.def = def;
        this.peso = peso;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.evolucion = evolucion;
        this.preevolucion = preevolucion;
        this.img=new Image("file:src/main/resources/img/Pokemon/"+img);
    }
}
