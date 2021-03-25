/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class ResendController implements Initializable {

    @FXML
    private TextField txtemail;
    @FXML
    private PasswordField txtcode;
    @FXML
    private Button send;
    @FXML
    private Button verify;
    
    int randomCode ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         send.setOnMouseClicked(event -> {
        try {
        
        Random rand = new Random();
        randomCode= rand.nextInt(999999);
        String host = "smtp.gmail.com";
        String user = "aminechibeni46@gmail.com";
        String pass = "medamine26208729";
        String to = txtemail.getText();
        String subject = "Reseting Code";
        String message = "Your reset code is" +randomCode;
        boolean sessionDebug = false ;
        Properties pros = System.getProperties();
        pros.put("mail.smtp.starttls.enable", "true");
        pros.put("mail.smtp.host", "host");
        pros.put("mail.smtp.port", "587");
        pros.put("mail.smtp.auth", "true");
        pros.put("mail.smtp.starttls.required", "true");
        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Session mailSession = Session.getDefaultInstance(pros,null);
        mailSession.setDebug(sessionDebug);
        Message msg = new MimeMessage(mailSession);
        msg.setFrom(new InternetAddress(user));
        InternetAddress  address = new InternetAddress(to); 
        msg.setRecipient(Message.RecipientType.TO, address);
        msg.setSubject(subject);
        msg.setText(message);
            try (Transport transport = mailSession.getTransport("smtp")) {
                transport.connect(host, user, pass);
                transport.sendMessage(msg, msg.getAllRecipients());
            }
        JOptionPane.showMessageDialog(null, "code has been sent to the email");
        
    }   
     catch (HeadlessException | MessagingException ex) {
       JOptionPane.showMessageDialog(null, ex);
    }
        });
         
         
         verify.setOnMouseClicked(event -> {
          if (Integer.valueOf(txtcode.getText()) == randomCode) {
               try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/reset.fxml"));
                Region root = (Region) loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                ResetController rpc = loader.getController();
                rpc.setIdd(txtemail.getText());//envoie de l'ID de la photo   
                stage.setScene(scene);
                stage.show();}
    catch (IOException ex) {
                Logger.getLogger(ResendController.class.getName()).log(Level.SEVERE, null, ex);
            }
             
             // Reset rs = new Reset(txtemail.getText());
             
              
          } else {
              JOptionPane.showMessageDialog(null, "Please enter correct code");
          }
        });
        
        
        
        
        
        
        
        
        
        
        
}
    
    
    
    
    
    
    
    
    
    
    
    
    
}