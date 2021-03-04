package dao;

import entity.photo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.DataSource;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YACINE
 */
public class PhotoServiceDao implements Idao<photo> {
    
    private static PhotoServiceDao instance;
    private Statement st;
    private ResultSet rs;

    public PhotoServiceDao() {
        DataSource ds = DataSource.getInstance();
        try {
            st=ds.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PhotoServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static PhotoServiceDao getInstance(){
        if(instance==null) 
            instance=new PhotoServiceDao();
        return instance;
    }

    @Override
    public void insert(photo o) {
        String req="insert into photo (url,titre,theme,date_ajout,couleur,localisation) values ('"+o.geturl()+"','"+o.gettitre()+"','"+o.gettheme()+"','"+o.getdate_ajout()+"','"+o.getcouleur()+"','"+o.getlocalisation()+"')";
        try {
            st.executeUpdate(req);
            System.out.println("photo inseré");
        } catch (SQLException ex) {
            Logger.getLogger(PhotoServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(photo o) {
       String req="delete from photo where id_photo="+o.getid_photo();
        photo p=displayById(o.getid_photo());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(PhotoServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
    }

    
    
    @Override
    public List<photo> displayAll() {
        String req="select * from photo";
        List<photo> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                photo p=new photo();
                p.setid_photo(rs.getInt(1));
                p.seturl(rs.getString(2));
                p.settitre(rs.getString(3));
                p.settheme(rs.getString(4));
                p.setdate_ajout(rs.getString(5));
                p.setcouleur(rs.getString(6));
                p.setlocalisation(rs.getString(7));
               
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PhotoServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public photo displayById(int id_photo) {
        String req="select * from photo where id_photo ="+id_photo;
           photo p=new photo();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                 p.setid_photo(rs.getInt(1));
                p.seturl(rs.getString(2));
                p.settitre(rs.getString(3));
                p.settheme(rs.getString(4));
                p.setdate_ajout(rs.getString(5));
                p.setcouleur(rs.getString(6));
                p.setlocalisation(rs.getString(7));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(PhotoServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }

    @Override
    public boolean update(photo os) {
       String qry = "UPDATE photo SET url = '"+os.geturl()+"', titre = '"+os.gettitre()+"' WHERE id = "+os.getid_photo();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PhotoServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
