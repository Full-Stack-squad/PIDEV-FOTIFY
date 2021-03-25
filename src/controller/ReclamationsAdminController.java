/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PhotoServiceDao;
import dao.ReclamationDao;
import enums.Etat;

import entity.Reclamation;
import utils.EmailService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author fares
 */
public class ReclamationsAdminController implements Initializable {

    private ObservableList<Reclamation> reclamations;
    private FilteredList<Reclamation> filteredReclamation;

    @FXML
    private TableView<Reclamation> reclamationTV;
    @FXML
    private TableColumn<Reclamation, String> membreTC;
    @FXML
    private TableColumn<Reclamation, ImageView> photoTC;
    @FXML
    private TableColumn<Reclamation, String> sujetTC;
    @FXML
    private TableColumn<Reclamation, String> date_creationTC;
    @FXML
    private TableColumn<Reclamation, Etat> etatTC;
    @FXML
    private TableColumn<Reclamation, Void> actionTC;
    @FXML
    private TextField rechercheTF;
    @FXML
    private ComboBox<String> rechercheCB;
    @FXML
    private Label fotify;
  

    public void getData() {
        ReclamationDao rdao = new ReclamationDao();
          PhotoServiceDao ps1 = new PhotoServiceDao();
        this.reclamations = FXCollections.observableArrayList(rdao.playById());

        sujetTC.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        date_creationTC.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
          etatTC.setCellValueFactory((CellDataFeatures<Reclamation, Etat> param) -> {
            Reclamation reclamation = param.getValue();
            Etat etat = reclamation.getEtat();
            return new SimpleObjectProperty<Etat>(etat);
        });
          
          etatTC.setCellFactory(ComboBoxTableCell.forTableColumn(FXCollections.observableArrayList(Etat.values())));
        membreTC.setCellValueFactory((CellDataFeatures<Reclamation, String> p) -> {
            return new SimpleStringProperty(p.getValue().getDescription());
        });
      
        etatTC.setOnEditCommit((CellEditEvent<Reclamation, Etat> event) -> {
            TablePosition<Reclamation, Etat> pos = event.getTablePosition();
            Etat newEtat = event.getNewValue();
            int row = pos.getRow();
            Reclamation reclamation = event.getTableView().getItems().get(row);
            reclamation.setEtat(newEtat);
            rdao.update(reclamation);
            EmailService.sendMailFunc("jlassi.med.yacine@gmail.com", "Reclamation: " + reclamation.getSujet(), "Votre Reclamation est " + reclamation.getEtat());

        });

        actionTC.setCellFactory((TableColumn<Reclamation, Void> param) -> {
            final TableCell<Reclamation, Void> cell = new TableCell<Reclamation, Void>() {
                private final HBox paddedButton = new HBox();
                private final Button detailbtn = new Button("Details");
                private final Button supprimerbtn = new Button("Supprimer");

                {

                    paddedButton.setSpacing(10);
                    paddedButton.getChildren().add(detailbtn);
                    paddedButton.getChildren().add(supprimerbtn);

                    detailbtn.setOnAction((ActionEvent event) -> {
                        Reclamation reclamation = getTableView().getItems().get(getIndex());

                        try {
                            FXMLLoader loader = new FXMLLoader(
                                    getClass().getResource(
                                            "/view/DetailReclamationAdmin.fxml"
                                    )
                            );
                            loader.load();
                            DetailReclamationAdminController dialogController = loader.getController();
                            System.out.println(dialogController);
                            dialogController.initData(reclamation);
                            rechercheTF.getScene().setRoot(loader.getRoot());

                        } catch (IOException ex) {
                            Logger.getLogger(ReclamationItemController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });

                    supprimerbtn.setOnAction((ActionEvent event) -> {
                        System.out.println(getIndex());
                        getTableView().getSelectionModel().select(getIndex()); 
                        Reclamation reclamation = reclamationTV.getSelectionModel().getSelectedItem();
                        System.out.println(reclamation);
                        
                        if (reclamation != null) {
                            reclamations.remove(reclamation);
                            rdao.delete(reclamation);

                        }

                    });
                }

                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(paddedButton);
                    }
                }
            };
            return cell;
        });

        filteredReclamation = new FilteredList<>(reclamations, p -> true);
        rechercheTF.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredReclamation.setPredicate((rec) -> {
                if (newValue == null || newValue.isEmpty()) {
 
                    return this.checkRechercheCB(rec, rechercheCB.getSelectionModel().getSelectedItem()) &&true;
                }            
String lowerCaseFilter = newValue.toLowerCase();
                 if (rec.getSujet().toLowerCase().contains(lowerCaseFilter)) {
                    return this.checkRechercheCB(rec, rechercheCB.getSelectionModel().getSelectedItem()) &&true;// Filter matches last name.
                } 
                else
                return false; // Does not match.
            });

        });
        rechercheCB.getItems().addAll("Tout", "EN_ATTENTE", "TRAITE", "REFUSE");
        rechercheCB.getSelectionModel().select(0);

        rechercheCB.valueProperty().addListener((observable, oldValue, newValue) -> {

            filteredReclamation.setPredicate((rec) -> {
                String lowerCaseFilter = rechercheTF.getText().toLowerCase();
                if (lowerCaseFilter == null || lowerCaseFilter.isEmpty()) {
                    return this.checkRechercheCB(rec, newValue) && true;
                }

                if (rec.getPhoto().gettitre().toLowerCase().contains(lowerCaseFilter)) {
                    return this.checkRechercheCB(rec, newValue) && true; // Filter matches first name.
                } else if (rec.getSujet().toLowerCase().contains(lowerCaseFilter)) {
                    return this.checkRechercheCB(rec, newValue) && true;// Filter matches last name.
                } else if (rec.getUser().getUserNom().toLowerCase().contains(lowerCaseFilter)) {
                    return this.checkRechercheCB(rec, newValue) && true;// Filter matches last name.
                }
                return false;

            });
        });

        SortedList<Reclamation> sortedData = new SortedList<>(filteredReclamation);

        sortedData.comparatorProperty().bind(reclamationTV.comparatorProperty());

        reclamationTV.setItems(sortedData);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         fotify.setOnMouseClicked(event -> {
            try {

                Parent type = FXMLLoader.load(getClass().getResource("/view/Back.fxml"));
                Scene scene = new Scene(type);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Fotify"); 
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(CoursController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        // TODO

        getData();

        //membreTC.setCellFactory(new TreeItemPropertyValueFactory<Reclamation, String>("membre"));
    }

    private boolean checkRechercheCB(Reclamation rec, String value) {

        if (value == null || value == "Tout") {
            return true;
        }
        if (rec.getEtat().toString() == value) {
            return true; // Filter matches first name.
        } else {
            return false;
        }

    }

}
