/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import entity.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Amine
 */
public class ListUser<User> {
        private ObservableList<User> user = FXCollections.observableArrayList();

    public ListUser()  {
        UserDao pdao;
            try {
                pdao = UserDao.getInstance();
                user = (ObservableList<User>) pdao.displayAll();
        System.out.println(user);
            } catch (SQLException ex) {
                Logger.getLogger(ListUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    public ObservableList<User> getUser() {
        return user;
    }
    
}
