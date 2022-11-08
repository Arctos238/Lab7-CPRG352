/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sa.sait.services;

import ca.sait.dataaccess.UserDB;
import ca.sait.models.User;
import java.util.*;

/**
 *
 * @author J.Pointer
 */
public class UserService {

    private ArrayList<User> users;

    public UserService() {

    }

    public List<User> getAll() {
        UserDB userDb = new UserDB();

        return userDb.getAll();
    }

    public void updateUser(User user) {
        if (user != null) {
            UserDB uDb = new UserDB();

            uDb.updateUser(user);
        }
    }

    public void deleteUser(User user) {
        if (user != null) {
            UserDB udb = new UserDB();

            udb.deleteUser(user);
        }
    }

    public boolean createUser(User user) {
        if (user != null) {
            UserDB udb = new UserDB();

            return udb.createUser(user);
        }

        return false;
    }
}
