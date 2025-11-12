package com.javaprojectoop.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;

public class ProfileManagementController {

    @FXML private Label lblOwnerName, lblOwnerID;
    @FXML private Label lblFirstName, lblLastName, lblPhone, lblEmail, lblAge, lblAddress;
    @FXML private ImageView profileImage;

    @FXML private TableView<Pet> tblPets;
    @FXML private TableColumn<Pet, String> colPetName, colPetType, colPetBreed, colPetAge;
    @FXML private Button btnAddPet;

    private final ObservableList<Pet> petList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        colPetName.setCellValueFactory(data -> data.getValue().nameProperty());
        colPetType.setCellValueFactory(data -> data.getValue().typeProperty());
        colPetBreed.setCellValueFactory(data -> data.getValue().breedProperty());
        colPetAge.setCellValueFactory(data -> data.getValue().ageProperty());

        petList.addAll(
                new Pet("Buddy", "Dog", "Border Collie", "3"),
                new Pet("Milo", "Cat", "Persian", "2")
        );
        tblPets.setItems(petList);
    }

    @FXML
    private void openAddPet() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addPet-view.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Add Pet");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

