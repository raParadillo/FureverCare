package com.javaprojectoop.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class ServiceController {

    @FXML
    private Button btnBookNow;

    @FXML
    private VBox servicesSubMenu;

    @FXML
    private Button servicesArrow;

    private boolean isOpen = false;

    @FXML
    private void toggleServicesMenu() {
        System.out.println("Arrow clicked!");
        if (isOpen) {
            servicesSubMenu.setVisible(false);
            servicesSubMenu.setManaged(false);
            servicesArrow.setText(">");
        } else {
            servicesSubMenu.setVisible(true);
            servicesSubMenu.setManaged(true);
            servicesArrow.setText("v");
        }
        isOpen = !isOpen;
    }

    @FXML
    private void goToPetWalk(ActionEvent event) throws IOException {
        loadScene("/com/javaprojectoop/demo/servicePetWalk-view.fxml", event);
    }

    @FXML
    private void goToPetGrooming(ActionEvent event) throws IOException {
        loadScene("/com/javaprojectoop/demo/serviceGrooming-view.fxml", event);
    }

    @FXML
    private void goToPetSitting(ActionEvent event) throws IOException {
        loadScene("/com/javaprojectoop/demo/servicePetSitting-view.fxml", event);
    }

    @FXML
    private void goToProfile(ActionEvent event) throws IOException {
        loadScene("/com/javaprojectoop/demo/profileManagement-view.fxml", event);
    }

    private void loadScene(String fxmlPath, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
