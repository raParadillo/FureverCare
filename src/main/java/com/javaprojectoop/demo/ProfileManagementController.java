package com.javaprojectoop.demo;

import com.javaprojectoop.demo.Data.Pet;
import com.javaprojectoop.demo.Data.Pets;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static com.javaprojectoop.demo.Users.currentUserProfile;

public class ProfileManagementController {

    @FXML private Label lblFirstName, lblLastName, lblPhone, lblEmail, lblAge, lblAddress;
    @FXML private ImageView profileImage;

    @FXML private TableView<Pet> tblPets;
    @FXML private TableColumn<Pet, String> colPetName, colPetType, colPetBreed, colPetAge;
    @FXML private Button btnAddPet;

    @FXML
    public void initialize() {
        colPetName.setCellValueFactory(data -> data.getValue().nameProperty());
        colPetType.setCellValueFactory(data -> data.getValue().typeProperty());
        colPetBreed.setCellValueFactory(data -> data.getValue().breedProperty());
        colPetAge.setCellValueFactory(data -> data.getValue().ageProperty());

        // Use the shared static list
        tblPets.setItems(Pets.petList);

        tblPets.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    private void HandlePayment1(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/javaprojectoop/demo/Payment1-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

    @FXML
    private void handleEditProfile(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/javaprojectoop/demo/EditUser-view.fxml"));
            Parent root = loader.load();

            EditUserController controller = loader.getController();
            controller.setUserData(currentUserProfile);

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

    @FXML
    private void handleLogoutClick(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("logout-view.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Logout");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    private void HandleServiceClick(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/javaprojectoop/demo/serviceGrooming-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void HandleDashBoardClick(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/javaprojectoop/demo/Dashboard-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void HandleBookingHistory(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/javaprojectoop/demo/booking-history-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void HandleNotifcation(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/javaprojectoop/demo/notifications-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
