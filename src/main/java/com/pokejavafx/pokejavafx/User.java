/**
 * @author Lara Rodriguez
 */
package com.pokejavafx.pokejavafx;

public class User {
    private String username;
    private String lore;
    private String image;

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

    public void setLore(String password) {
        this.lore = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
