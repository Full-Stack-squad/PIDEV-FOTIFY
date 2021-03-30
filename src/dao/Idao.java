/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author YACINE
 */
public interface Idao<T> {

    public void insert(T o);

    public void delete(T o);

    public List<T> displayAll();

    public T displayById(int id);

    public boolean update(T os);

    void ajouter(T t) throws SQLException;

    boolean delete(int id) throws SQLException;

    boolean chercher(int id) throws SQLException;

    boolean chercher_ajout(T t) throws SQLException;

    boolean update(T t, int id) throws SQLException;

    List<T> readAll() throws SQLException;
}
