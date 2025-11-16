package com.javaprojectoop.demo;

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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;

public class BookinghistoryController {


    @FXML
    private void handleLogoutClick(MouseEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("logout-view.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("logout");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void HandleProfileManagementClick(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/javaprojectoop/demo/profilemanagement-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void HandleDashBoardClick(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/javaprojectoop/demo/Dashboard-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void HandleServiceClick(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/com/javaprojectoop/demo/serviceGrooming-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
