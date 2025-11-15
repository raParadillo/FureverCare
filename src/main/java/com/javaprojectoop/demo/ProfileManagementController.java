package com.javaprojectoop.demo;

import javafx.event.ActionEvent;
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

    @FXML private Label lblServices;

    private UserProfile currentUserProfile = new UserProfile(
            "Alice", "Smith", "alicesmith123@gmail.com", "09171234567", "25", "Carmen Cagayan de Oro"
    );

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

        lblServices.setOnMouseClicked(event -> openServices());
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

    private void openServices() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/javaprojectoop/demo/servicePetWalk-view.fxml"));
            Parent serviceRoot = loader.load();

            Stage stage = (Stage) lblServices.getScene().getWindow();
            stage.getScene().setRoot(serviceRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToPetWalk(javafx.scene.input.MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("servicePetWalk-view.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Pet Walk Service");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleEditProfile(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/javaprojectoop/demo/EditUser-view.fxml"));
            Parent root = loader.load();

            EditUserController controller = loader.getController();
            controller.setUserProfile(currentUserProfile);

            Stage stage = new Stage();
            stage.setTitle("Edit Profile");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

            updateProfileDisplay();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProfileDisplay() {
        lblFirstName.setText(currentUserProfile.getFirstName());
        lblLastName.setText(currentUserProfile.getLastName());
        lblEmail.setText(currentUserProfile.getEmail());
        lblPhone.setText(currentUserProfile.getPhone());
        lblAge.setText(currentUserProfile.getAge());
        lblAddress.setText(currentUserProfile.getAddress());
    }


}
