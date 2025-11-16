package com.javaprojectoop.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LogoutController {

    @FXML
    private Button logoutButton;

    @FXML
    private void handleLogout() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/javaprojectoop/demo/login-view.fxml"));
            Parent root = loader.load();

            for (javafx.stage.Window window : javafx.stage.Stage.getWindows()) {
                if (window instanceof Stage) {
                    ((Stage) window).close();
                }
            }

            Stage loginStage = new Stage();
            loginStage.setResizable(false);
            loginStage.setScene(new Scene(root));
            loginStage.setTitle("Login");
            loginStage.show();

            Stage currentStage = (Stage) logoutButton.getScene().getWindow();
            currentStage.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCancel() {
        // Close only the logout confirmation window
        Stage currentStage = (Stage) logoutButton.getScene().getWindow();
        currentStage.close();
    }
}
