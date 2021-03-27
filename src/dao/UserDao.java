/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Cours;
import entity.Feedback;
import entity.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static sun.security.x509.CertificateAlgorithmId.ALGORITHM;

/**
 *
 * @author hp
 */

public class UserDao implements IUserDao<User> {

    private static UserDao instance;
    private final Connection cnx;
    private final Statement ste;
    public static User connectedUser;
      private static final String ALGORITHM = "md5";
    private static final String DIGEST_STRING = "HG58YZ3CR9";
    private static final String CHARSET_UTF_8 = "utf-8";
    private static final String SECRET_KEY_ALGORITHM = "DESede";
    private static final String TRANSFORMATION_PADDING = "DESede/CBC/PKCS5Padding";
    private ResultSet rs;
    public  String pwd;

     public String encrypt(String message) throws Exception
    {
        String passwordToHash = message;
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);
 
        return generatedPassword;
    }
    
    public UserDao() throws SQLException {
        cnx = Connexion.getInstance().getConnection();
        ste = cnx.createStatement();
    }

    public static UserDao getInstance() throws SQLException {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    @Override
    public Object SignIn(String email, String password) {
        try {
            pwd=encrypt(password);
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        String req = "select * from userr where email = '" + email + "' and password ='" + pwd + "'";
        User u = new User();
        try {
            ResultSet rs = ste.executeQuery(req);
            if (rs.next()) {
                u.setUserId(rs.getInt("idU"));
                u.setUserNom(rs.getString("nom"));
                u.setUserPrenom(rs.getString("prenom"));
                u.setUserBio(rs.getString("BIO"));
                u.setUserAge(rs.getInt("Age"));
                u.setUserTel(rs.getInt("tel"));
                u.setUserEmail(rs.getString("email"));
                u.setUserPassword(rs.getString("password"));
                u.setUserType(rs.getString("type"));

            } else {
                u = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    @Override
    public void SignUp(User o) {
        String req = "insert into userr (nom,prenom,BIO,Age,tel,email, password,type) values (?,?,?,?,?,?,?,?)";
        System.out.println(o.getUserNom() + "  " + o.getUserPrenom() + "   " + o.getUserBio() + "   " + o.getUserAge() + "   " + o.getUserTel() + "   " + o.getUserEmail() + "   " + o.getUserPassword() + "   " + o.getUserType());
        PreparedStatement statement;
        try {
            statement = cnx.prepareStatement(req);

            statement.setString(1, o.getUserNom());
            statement.setString(2, o.getUserPrenom());
            statement.setString(3, o.getUserBio());
            statement.setInt(4, o.getUserAge());
            statement.setInt(5, o.getUserTel());
            statement.setString(6, o.getUserEmail());
            statement.setString(7, o.getUserPassword());
            statement.setString(8, o.getUserType());

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    @Override
    public void delete(Membre o) {
    String req="delete from personne where id="+o.getIdM();
        //Membre p=displayById(o.getIdM());
        
          if(o!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(MembreDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");


    }

    @Override
    public List<Membre> displayAll() {

String req="select * from membre";
        List<Membre> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Membre M=new Membre();
                //M.setIdM(rs.getInt());
                M.setNom(rs.getString("nom"));
                M.setPrenom(rs.getString(3));
                list.add(M);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MembreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    @Override
    public Membre displayByIdM(int idM) {
String req="select * from membre where id ="+idM;
           Membre m=new Membre();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                //m.setIdM(rs.getInt("id"));
                m.setNom(rs.getString("nom"));
                m.setPrenom(rs.getString("prenom"));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(MembreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return m;    }*/
    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
     public ObservableList<User> displayAlll() {
         String s= "Membre";
        String req="select * from userr where type= '"+s+"'and idU<>  "+ UserDao.connectedUser.getUserId();
        ObservableList<User> list=FXCollections.observableArrayList();       
        
        try {
            rs=ste.executeQuery(req);
            while(rs.next()){
               User p=new User();
                p.setUserId(rs.getInt(1));
                p.setUserNom(rs.getString(2));
                p.setUserPrenom(rs.getString(3));
                p.setUserBio(rs.getString(4));
              
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public User displayByIdM(int idM) {
       String req="select * from userr where idU ="+idM;
           User p=new User();
        try {
            rs=ste.executeQuery(req);
           // while(rs.next()){
            rs.next();
            p.setUserId(rs.getInt(1));
                 p.setUserNom(rs.getString(2));
                p.setUserPrenom(rs.getString(3));
                p.setUserBio(rs.getString(4));
                 p.setUserAge(rs.getInt(5));
                p.setUserTel(rs.getInt(6));
                p.setUserEmail(rs.getString(7));
                p.setUserPassword(rs.getString(8));
                p.setUserType(rs.getString(9));
                
            //}  
            
        } catch (SQLException ex) {
            Logger.getLogger(PhotoServiceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }
   

    public Integer starsCount(int nb) {
        String req = "select count(*) as total from feedback where id_membre = " + UserDao.connectedUser.getUserId() + " AND rating = " + nb;
        int i = 0;
        try {
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                i = rs.getInt("total");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    
    public Integer feedbackCount() {
        String req = "select count(*) as total from feedback where id_membre = " + UserDao.connectedUser.getUserId();
        int i = 0;
        try {
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                i = rs.getInt("total");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    
    public Integer imageCount() {
        String req = "select count(*) as total from photo where idU = " + UserDao.connectedUser.getUserId();
        int i = 0;
        try {
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                i = rs.getInt("total");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    
    public Integer verify() {
        String req = "select count(*) as total from feedback where id_membre = " + UserDao.connectedUser.getUserId() + " AND id_abonne = " + 2;
        int i = 0;
        try {
            ResultSet rs = ste.executeQuery(req);
            while (rs.next()) {
                i = rs.getInt("total");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    @Override
    public ObservableList<User> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
