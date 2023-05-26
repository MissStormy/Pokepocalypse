package com.pokejavafx.pokejavafx;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;

import java.sql.*;

public class DBConection {
    private Connection con;
    private String ultimoError="Ninguno";

    public Connection getCon() {
        return con;
    }

    public  DBConection(String database, String user, String password) {
        System.out.println("Conectando con la base de datos...");
        try {
            this.con = DriverManager.getConnection(database,user,password);
            System.out.println("Conectado con exito.");
        }catch (
                SQLException e){
            this.ultimoError=e.toString();
            System.out.println("Conexion fallida.");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error de conexion");
            alert.setContentText("No se ha podido conectar a la base de datos");
            alert.showAndWait();
            this.con=null;
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
    public Pokimon cargarPokimon(int id){
        try {
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery("select * from pokedex where id ='"+id+"'");
            if (rs.next()){
                return new Pokimon(rs.getString("Nombre"),rs.getInt("ID"),rs.getInt("Atq"),rs.getInt("Def"),rs.getInt("Peso"),rs.getString("Tipo"),rs.getString("Descripcion"),rs.getInt("evolucion"),rs.getInt("preevolucion"),rs.getString("Img"));
            }else return new Pokimon ("Error",0,0,0,0,"null","Este pokimon no existe",0,0,"error.png");
        }catch (
                SQLException e){
            this.ultimoError=e.toString();
            System.out.println("Error al conectar a la base de datos.");
            return null;
        }

    }

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
    public Pokimon[] getPokedex(){
        try {
            Statement st = this.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from pokedex");
            int size = 0;
            if(rs != null){ //Comprobar cuantos pokemon tenemos
                rs.last();
                size=rs.getRow();
                rs.beforeFirst();
            }
            Pokimon[] pokedex = new Pokimon[size];
            while (rs.next()){
                pokedex[rs.getRow()-1] = new Pokimon(rs.getString("Nombre"),rs.getInt("ID"),rs.getInt("Atq"),rs.getInt("Def"),rs.getInt("Peso"),rs.getString("Tipo"),rs.getString("Descripcion"),rs.getInt("evolucion"),rs.getInt("preevolucion"),rs.getString("Img"));
            }
            return pokedex;
        }catch (SQLException e){
            this.ultimoError=e.toString();
            System.out.println("Error al conectar con la base de datos: "+e);
            return null;
        }
    }
    public Objeto[] getListaObjetos(){
        try {
            Statement st = this.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from objetos");
            int size = 0;
            if(rs != null){ //Comprobar cuantos pokemon tenemos
                rs.last();
                size=rs.getRow();
                rs.beforeFirst();
            }
            Objeto[] objs = new Objeto[size];
            while (rs.next()){
                objs[rs.getRow()-1] = new Objeto(rs.getInt("ID"),rs.getString("Nombre"),rs.getString("Descripcion"),rs.getInt("Precio"),rs.getInt("Tipo"),rs.getInt("Duracion"),rs.getInt("Potencia"));

            }
            return objs;
        }catch (SQLException e){
            this.ultimoError=e.toString();
            System.out.println("Error al conectar con la base de datos: "+e);
            return null;
        }
    }
}
