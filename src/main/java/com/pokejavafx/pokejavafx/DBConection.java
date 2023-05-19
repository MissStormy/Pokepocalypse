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
    /*public Pokimon cargarPokimon(int id){
        try {
            Statement st = this.con.createStatement();
            //todo acabar esto sacando todos los datos y estadisticas de un pokemon de la base de datos
        }catch (
                SQLException e){
            this.ultimoError=e.toString();
            System.out.println("Error al conectar a la base de datos.");
            return null;
        }

    }*/

    public String getUltimoError(){
        return this.ultimoError;
    }
    public User login(String nombre, String contrasenya){
        System.out.println("Intentando autenticar con el usuario "+nombre);
        try {
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery("select * from jugadores where nombre ='"+nombre+"'");
            rs.next();
            if (rs.getString("contrasenya").equals(contrasenya)) {
                System.out.println("Usuario "+nombre+" autenticado con exito.");
                User usuario = new User(nombre,rs.getString("lore"),rs.getString("img"));
                rs.close();
                return usuario;
            } else {
                System.out.println("Fallo al autenticar el usuario contraseña incorrecta");
                st.close();
                return null;
            }
        }catch (SQLException e){
            this.ultimoError=e.toString();
            System.out.println("Error al conectar a la base de datos (¿usuario no existe?): "+e);
            return null;
        }
    }
    public boolean signup(String nombre, String contrasenya, String img){
        try {
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery("select * from jugadores where nombre ='"+nombre+"'");
            if ( !rs.next() && !nombre.equals("") && !contrasenya.equals("") ) {//todo manejar de forma individual, mediante errores, si el nombre o la contraseña estan vacias
                st.execute("INSERT INTO `pokejava`.`jugadores` (`nombre`, `contrasenya`, `img`) VALUES ('"+nombre+"', '"+contrasenya+"', '"+img+"');");
                System.out.println("Usuario "+nombre+" creado correctamente");
                return true;
            } else {
                System.out.println("Fallo crear el usuario, ya existe un usuario con ese nombre, el nombre esta vacio o la contraseña esta vacia");
                st.close();
                return false;
            }
        }catch (SQLException e){
            this.ultimoError=e.toString();
            System.out.println("Error crear usuario: "+e);
            return false;
        }
    }
}
