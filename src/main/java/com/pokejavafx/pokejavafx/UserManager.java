/**
 * @author Lara Rodriguez
 */
package com.pokejavafx.pokejavafx;

import java.util.*;

public class UserManager {
    private ArrayList<User> users;
    User Stormy = new User("Stormy", "1234", "../img/laraPerfil.png");
    User Lokka = new User("Lokka", "4321", "../img/pfpVera.png");


    public UserManager() {
        users = new ArrayList<>();
        users.add(Stormy);
        users.add(Lokka);
    }

    public void addUser(User user) {
        users.add(user);

    }

    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // Otros métodos para gestionar y manipular los usuarios
}
