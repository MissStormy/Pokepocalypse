package com.pokejavafx.pokejavafx;

import java.sql.*;

public class DBConection {
    private Connection con;
    private String ultimoError="Ninguno";



    public  DBConection(String a,String s, String d) {
        System.out.println("Conectando con la base de datos...");
        try {
            this.con = DriverManager.getConnection(a,s,d);
            System.out.println("Conectado con exito.");
        }catch (
                SQLException e){
            this.ultimoError=e.toString();
            System.out.println("Conexion fallida.");
        }
    }

    public boolean cerrar(){
        System.out.println("Desconectando base de datos...");
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokejava?serverTimezone=UTC","root","verysecret");
            System.out.println("Desconectado con exito.");
            return true;
        }catch (
                SQLException e){
            this.ultimoError=e.toString();
            System.out.println("No se ha podido desconectar de la base de datos.");
            return false;
        }
    }
}
