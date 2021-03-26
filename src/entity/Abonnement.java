/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Amine
 */
public class Abonnement {
    
    private SimpleIntegerProperty id;
    private SimpleStringProperty Anom;
    private SimpleIntegerProperty idU;
    private SimpleIntegerProperty idA;

    public Abonnement() {
    }

    public Abonnement(SimpleIntegerProperty id, SimpleStringProperty Anom, SimpleIntegerProperty idU, SimpleIntegerProperty idA) {
        this.id = id;
        this.Anom = Anom;
        this.idU = idU;
        this.idA = idA;
    }

    public Abonnement(String Anom, int idU, int idA) {
        this.Anom = new SimpleStringProperty(Anom);
        this.idU =new SimpleIntegerProperty(idU);
        this.idA = new SimpleIntegerProperty(idA );
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getAnom() {
        return Anom.get();
    }

    public void setAnom(String Anom) {
        this.Anom = new SimpleStringProperty(Anom);
    }

    public int getIdU() {
        return idU.get();
    }

    public void setIdU(int idU) {
        this.idU = new SimpleIntegerProperty(idU);
    }

    public int getIdA() {
        return idA.get();
    }

    public void setIdA(int idA) {
        this.idA = new SimpleIntegerProperty(idA);
    }


public SimpleIntegerProperty getIdUProperty() {
        return idU;
    }

public SimpleIntegerProperty getIdAProperty() {
        return idA;
    }

public SimpleStringProperty getAnomProperty() {
        return Anom;
    }

public SimpleIntegerProperty getIdProperty() {
        return id;
    }


























}

