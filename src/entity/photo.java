/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author YACINE
 */
public class photo {
    private SimpleIntegerProperty id_photo;
    private SimpleStringProperty url;
    private SimpleStringProperty titre;
    private SimpleStringProperty theme;
    private SimpleStringProperty date_ajout;
    private SimpleStringProperty couleur;
    private SimpleStringProperty localisation; 
    private SimpleIntegerProperty Id_membre;

    public photo() {
    }

    public photo(int id_photo,String url, String titre, String theme, String date_ajout, String couleur, String localisation) {
        this.id_photo = new SimpleIntegerProperty(id_photo);
        this.url = new SimpleStringProperty(url);
        this.titre = new SimpleStringProperty(titre);
        this.theme = new SimpleStringProperty(theme);
        this.date_ajout = new SimpleStringProperty(date_ajout);
        this.couleur = new SimpleStringProperty(couleur);
        this.localisation = new SimpleStringProperty(localisation);
    }
    public photo(int id_photo,String url, String titre, String theme, String date_ajout, String couleur, String localisation, int Id_membre) {
        this.id_photo = new SimpleIntegerProperty(id_photo);
        this.url = new SimpleStringProperty(url);
        this.titre = new SimpleStringProperty(titre);
        this.theme = new SimpleStringProperty(theme);
        this.date_ajout = new SimpleStringProperty(date_ajout);
        this.couleur = new SimpleStringProperty(couleur);
        this.localisation = new SimpleStringProperty(localisation);
        this.Id_membre = new SimpleIntegerProperty(Id_membre);
    }
    public photo(String url, String titre, String theme, String date_ajout, String couleur, String localisation,int Id_membre) {
        this.url = new SimpleStringProperty(url);
        this.titre = new SimpleStringProperty(titre);
        this.theme = new SimpleStringProperty(theme);
        this.date_ajout = new SimpleStringProperty(date_ajout);
        this.couleur = new SimpleStringProperty(couleur);
        this.localisation = new SimpleStringProperty(localisation);
        this.Id_membre = new SimpleIntegerProperty(Id_membre);
    }
    public photo( int id_photo,String titre, String theme,String couleur, String localisation) {
      this.id_photo = new SimpleIntegerProperty(id_photo);
        this.titre = new SimpleStringProperty(titre);
        this.theme = new SimpleStringProperty(theme);
        this.couleur = new SimpleStringProperty(couleur);
        this.localisation = new SimpleStringProperty(localisation);
    }
    
    public int getid_membre() {
        return Id_membre.get();
    }
    public void setid_membre(int Id_membre) {
        this.Id_membre = new SimpleIntegerProperty(Id_membre);
    }
     public int getid_photo() {
        return id_photo.get();
    }
    public void setid_photo(int id_photo) {
        this.id_photo = new SimpleIntegerProperty(id_photo);
    }
    
    public String geturl() {
        return url.get();
    }
    public void seturl(String url) {
        this.url = new SimpleStringProperty(url);
    }

    public String gettitre() {
        return titre.get();
    }
    public void settitre(String titre) {
        this.titre = new SimpleStringProperty(titre);
    }
    
    public String gettheme() {
        return theme.get();
    }
    public void settheme(String theme) {
        this.theme = new SimpleStringProperty(theme);
    }
    
    public String getdate_ajout() {
        return date_ajout.get();
    }
    public void setdate_ajout(String date_ajout) {
        this.date_ajout = new SimpleStringProperty(date_ajout);
    }
    
    public String getcouleur() {
        return couleur.get();
    }
    public void setcouleur(String couleur) {
        this.couleur = new SimpleStringProperty(couleur);
    }
    
     public String getlocalisation() {
        return localisation.get();
    }
    public void setlocalisation(String localisation) {
        this.localisation = new SimpleStringProperty(localisation);
    }



@Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id_photo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final photo other = (photo) obj;
        if (!Objects.equals(this.id_photo, other.id_photo)) {
            return false;
        }
        return true;
    }









}

