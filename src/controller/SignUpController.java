/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import entity.User;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * FXML Controller class
 *
 * @author ayoub
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField TF_nom;
    @FXML
    private TextField TF_presnom;
    @FXML
    private TextField TF_email;
    @FXML
    private PasswordField TF_password;
    @FXML
    private TextField TF_age;
    @FXML
    private Button btn_signup;
    @FXML
    private Button btn_signin_google;
    @FXML
    private TextField TF_tel;
    @FXML
    private RadioButton homme_rb;
    @FXML
    private RadioButton femme_rb;

    private String str = "Homme";
  private static final String ALGORITHM = "md5";
    private static final String DIGEST_STRING = "HG58YZ3CR9";
    private static final String CHARSET_UTF_8 = "utf-8";
    private static final String SECRET_KEY_ALGORITHM = "DESede";
    private static final String TRANSFORMATION_PADDING = "DESede/CBC/PKCS5Padding"; 
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
     public String encrypt(String message) throws Exception
    {
        String passwordToHash = TF_password.getText();
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
        homme_rb.setSelected(true);

        femme_rb.setOnAction((ActionEvent arg0) -> {
            if (femme_rb.isSelected()) {
                str = "Femme";
                homme_rb.setSelected(false);
                System.out.println("asba");
            }
        });

        homme_rb.setOnAction((ActionEvent arg0) -> {
            if (homme_rb.isSelected()) {
                str = "Homme";
                femme_rb.setSelected(false);
            }
        });
        
        btn_signup.setOnAction(
                (ActionEvent event) -> {
                    try {
                        UserDao udao = UserDao.getInstance();
                        String pwd=encrypt(TF_password.getText());
                                udao.SignUp(new User(1,TF_nom.getText(), TF_presnom.getText(), str, Integer.parseInt(TF_age.getText()), Integer.parseInt(TF_tel.getText()), TF_email.getText(),pwd, "Membre"));
                    } catch (SQLException ex) {
                        Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }

                }
        );
    }

}
