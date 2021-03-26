/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Abonnement;
import entity.Photo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Amine
 */
public class AbonnementDAO implements Idao<Abonnement>{
    
    
      
    private static AbonnementDAO instance;
    private Statement st;
    private ResultSet rs;

    public AbonnementDAO() {
        DataSource ds = DataSource.getInstance();
        try {
            st=ds.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PhotoServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static AbonnementDAO getInstance(){
        if(instance==null) 
            instance=new AbonnementDAO();
        return instance;
    }

    @Override
    public void insert(Abonnement o) {
       
          String req="insert into abonnement (Anom,idA,idU) values ('"+o.getAnomProperty().get()+"','"+o.getIdA()+"','"+o.getIdU()+"')";
        try {
            st.executeUpdate(req);
            System.out.println("abonnement inseré");
        } catch (SQLException ex) {
            Logger.getLogger(PhotoServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void delete(Abonnement o) {
        
    }

    @Override
    public List<Abonnement> displayAll() {
         String req="select * from abonnement where idU= "+UserDao.connectedUser.getUserId();
        List<Abonnement> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Abonnement p=new Abonnement();
                p.setIdA(rs.getInt(1));
                p.setAnom(rs.getString(2));
                p.setIdU(rs.getInt(3));
               list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PhotoServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;}
public List<Abonnement> dislayAll(int id) {
         String req="select * from abonnement where idU= '"+UserDao.connectedUser.getUserId()+"'and idA = "+id;
        List<Abonnement> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Abonnement p=new Abonnement();
                p.setIdA(rs.getInt(1));
                p.setAnom(rs.getString(2));
                p.setIdU(rs.getInt(3));
               list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PhotoServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;}
public Abonnement dislay(int id) {
         String req="select * from abonnement where idU= '"+UserDao.connectedUser.getUserId()+"'and idA = "+id;
        Abonnement list=new Abonnement();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Abonnement p=new Abonnement();
                p.setIdA(rs.getInt(1));
                p.setAnom(rs.getString(2));
                p.setIdU(rs.getInt(3));
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PhotoServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;}

    @Override
    public Abonnement displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Abonnement os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouter(Abonnement t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id)  {
        return false;
     
    }
    
     public void deletea(int id)  {
     String req="delete from abonnement where idU= '"+UserDao.connectedUser.getUserId()+"'and idA = "+id;
        Abonnement c=dislay(id);
          if(c!=null)
              try {
           
            st.executeUpdate(req);
                  System.out.println("fassa5");
        } catch (SQLException ex) {
            Logger.getLogger(PhotoServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
    }

    @Override
    public boolean chercher(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean chercher_ajout(Abonnement t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Abonnement t, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Abonnement> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
