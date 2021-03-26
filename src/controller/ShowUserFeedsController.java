/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FeedbackDAO;
import dao.UserDao;
import entity.Feedback;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class ShowUserFeedsController implements Initializable {

     private ObservableList<Feedback> feedbacks = FXCollections.observableArrayList();
    @FXML
    private Pane pane;
    @FXML
    private Button feedback_window_btn;
    @FXML
    private Button ab51;
    @FXML
    private Button ab3;
    @FXML
    private Button ab4;
    @FXML
    private Button ab2;
    @FXML
    private Button ab;
    @FXML
    private Button ab1;
    @FXML
    private Label fotify;
    @FXML
    private ScrollPane scroll_feedback;
    @FXML
    private VBox vb;
    @FXML
    private ImageView coms;
    @FXML
    private Label feedback_nb;
    @FXML
    private ImageView images;
    @FXML
    private Label images_nb;
    @FXML
    private PieChart feedback_stats;
    @FXML
    private Button add_feedback_btn;
public  String css ="-fx-text-fill:white;\n" ;
public  String ccss ="-fx-text-fill:#fabe2e;\n" ;
public  String cs ="-fx-background-color: #1f1f22;\n" +
                   "-fx-border-insets: 2;\n"+"-fx-font-weight: bold;\n"+
                   "-fx-border-width: 2;\n" +
        "-fx-border-color: #fabe2e;\n" +"-fx-min-height:50;\n"+
                  "-fx-text-fill:#fabe2e;\n" +
                   "-fx-border-radius: 10;\n";
public  String csss ="-fx-text-fill:white;\n" +"-fx-background-color:#1f1f22;\n" +"-fx-font-weight: bold;\n";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
    }

    @FXML
    private void gererFeedback() {
          feedback_window_btn.setOnMouseClicked(event -> {
            System.out.println("hey");
           try {
                Parent type = FXMLLoader.load(getClass().getResource("/view/ListerFeedback.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                System.out.println("hey");
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        });
    }

    @FXML
    private void gererprofile() {
          ab51.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/displayUsers.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @FXML
    private void abonnementt(ActionEvent event) {
    }

    @FXML
    private void gerercours() {
         ab4.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/home.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @FXML
    private void gererevenement() {
         ab2.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/AfficherEvenement.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @FXML
    private void gerergalerie() {
         ab.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/ProfileView.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    @FXML
    private void gererreclamation() {
          ab1.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/MesReclamations.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    void setIdu(Integer userId) {
        fotify.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/firstView.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        Rectangle clip = new Rectangle(
                images.getFitWidth(), images.getFitHeight()
        );
        clip.setArcWidth(60);
        clip.setArcHeight(60);

        images.setClip(clip);

        // snapshot the rounded image.
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        WritableImage img = images.snapshot(parameters, null);

        // remove the rounding clip so that our effect can show through.
        images.setClip(null);

        // apply a shadow effect.
        images.setEffect(new DropShadow(20, Color.WHEAT));

        // store the rounded image in the imageView.
        images.setImage(img);

        Rectangle clipC = new Rectangle(
                coms.getFitWidth(), coms.getFitHeight()
        );
        clipC.setArcWidth(300);
        clipC.setArcHeight(80);

        coms.setClip(clipC);

        // snapshot the rounded image.
        parameters.setFill(Color.TRANSPARENT);
        WritableImage imgC = coms.snapshot(parameters, null);

        // remove the rounding clip so that our effect can show through.
        coms.setClip(null);

        // apply a shadow effect.
        coms.setEffect(new DropShadow(30, Color.BLACK));

        // store the rounded image in the imageView.
        coms.setImage(imgC);

        try {
            UserDao ud = UserDao.getInstance();

            if (ud.verify() == 1) {
                add_feedback_btn.setText("Modifier Commentaire");
            } else {
                add_feedback_btn.setVisible(false);
            }

            feedback_nb.setText("" + ud.feedbackCount() + " commentaires");
            images_nb.setText("" + ud.imageCount() + " images");

            ObservableList<PieChart.Data> pc = FXCollections.observableArrayList(
                    new PieChart.Data("1 star rating", ud.starsCount(1)),
                    new PieChart.Data("2 star rating", ud.starsCount(2)),
                    new PieChart.Data("3 star rating", ud.starsCount(3)),
                    new PieChart.Data("4 star rating", ud.starsCount(4)),
                    new PieChart.Data("5 star rating", ud.starsCount(5))
            );
            feedback_stats.setData(pc);

            feedback_stats.getData().stream().map((data) -> {
                data.nameProperty().set(data.getName() + " : " + (int) data.getPieValue() + " commentaires");
                return data;
            }).forEachOrdered((data) -> {
                data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
                    JOptionPane.showMessageDialog(null, data.getName() + "\nTotal Commentaires --" + (int) data.getPieValue());
                });
            });
        } catch (SQLException ex) {
            Logger.getLogger(ProfileMembreController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Node n;
        try {
            Label title = new Label("User");
            title.setMinWidth(85);
            title.setMaxWidth(85);
            title.setAlignment(Pos.BASELINE_LEFT);
            
            Label title_date = new Label("Date d'ajout");
            title_date.setMinWidth(250);
            title_date.setMaxWidth(250);
            title_date.setAlignment(Pos.CENTER);
            Label title_description = new Label("Description");
            title_description.setMinWidth(300);
            title_description.setMaxWidth(300);
            title_description.setAlignment(Pos.CENTER);
            Label title_rating = new Label("Notation");
            title_rating.setMinWidth(65);
            title_rating.setMaxWidth(65);
 title_rating.setAlignment(Pos.CENTER);
            n = (Node) FXMLLoader.load(getClass().getResource("/view/Item.fxml"));
            ((HBox) n).setFillHeight(true);
            ((HBox) n).setAlignment(Pos.CENTER);
((HBox) n).setStyle(cs);
            //((HBox) n).setStyle("-fx-background-color: #FFFACD;");
            ((HBox) n).getChildren().addAll(title,title_date, title_description, title_rating);
           
            title.setStyle(ccss);
            title_date.setStyle(ccss);
            title_description.setStyle(ccss);
            title_rating.setStyle(ccss);
            
            vb.getChildren().add(n);
            vb.setSpacing(15);
        } catch (IOException ex) {
            Logger.getLogger(ListerFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            FeedbackDAO fb = FeedbackDAO.getInstance();
            feedbacks = fb.feedMembre(userId);
            TextField field = new TextField();
            Node[] nodes = new Node[feedbacks.size()];
            UserDao ud= new UserDao();
            for (int i = 0; i < nodes.length; i++) {
                Label label_user = new Label("" + ud.displayByIdM(feedbacks.get(i).getIdMembre()).getUserNom());
                label_user.setMinWidth(100);
                label_user.setMaxWidth(100);
                label_user.setAlignment(Pos.BASELINE_LEFT);

                Label label_date = new Label("" + feedbacks.get(i).getDateAjoutFeedBack());
                label_date.setMinWidth(250);
                label_date.setMaxWidth(250);
                label_date.setAlignment(Pos.CENTER);
                Label label_description = new Label("" + feedbacks.get(i).getContenuFeedBack());
                label_description.setMinWidth(300);
                label_description.setMaxWidth(300);
                label_description.setAlignment(Pos.CENTER);
                Label label_rating = new Label("" + feedbacks.get(i).getRating());
                label_rating.setMinWidth(25);
                label_rating.setMaxWidth(25);
label_rating.setAlignment(Pos.CENTER);
                Image image = new Image("/utils/star.png");
                ImageView iv = new ImageView();
                iv.setFitWidth(20);
                iv.setPreserveRatio(true);
                iv.setSmooth(true);
                iv.setCache(true);

                iv.setImage(image);
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("/view/Item.fxml"));
                ((HBox) nodes[i]).setFillHeight(true);
                      label_date.setStyle(css);
                      label_user.setStyle(css);
                              label_description.setStyle(css);
                        label_rating.setStyle(csss);
                ((HBox) nodes[i]).setAlignment(Pos.CENTER);
((HBox) nodes[i]).setStyle(cs);

                ((HBox) nodes[i]).getChildren().addAll(label_user,label_date, label_description, label_rating, iv);
                vb.getChildren().add(nodes[i]);
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(ListerFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
