/**
 * @author Lara Rodriguez
 */
package com.pokejavafx.pokejavafx;

public class User {
    private String username;
    private String lore;
    private String image;
    private Objeto obj1;
    private Objeto obj2;
    private Objeto obj3;

    // Constructor, getters y setters para username, password e image
    public User(String username, String lore, String image){
        this.username = username;
        this.lore = lore;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
