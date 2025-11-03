package com.javaprojectoop.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

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
    private void handleAddPet(ActionEvent event) {
        System.out.println("Add Pet button clicked!");
    }
}

