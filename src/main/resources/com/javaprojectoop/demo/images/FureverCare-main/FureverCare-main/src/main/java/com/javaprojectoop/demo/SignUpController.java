package com.javaprojectoop.demo;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {

    @FXML
    private ImageView imageView;

    @FXML
    public void initialize() {
        // Round the corners of the image
        Rectangle clip = new Rectangle(
                imageView.getFitWidth(),
                imageView.getFitHeight()
        );
        clip.setArcWidth(20);  // adjust for more or less roundness
        clip.setArcHeight(20);
        imageView.setClip(clip);
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void handleBackToLogin(ActionEvent event) throws IOException {
        // Load the signup page
        root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField visiblePasswordField;

    @FXML
    private void togglePasswordVisibility() {
        if (visiblePasswordField.isVisible()) {
            // Hide password again
            passwordField.setText(visiblePasswordField.getText());
            visiblePasswordField.setVisible(false);
            visiblePasswordField.setManaged(false);
            passwordField.setVisible(true);
            passwordField.setManaged(true);
        } else {
            // Show password as text
            visiblePasswordField.setText(passwordField.getText());
            visiblePasswordField.setVisible(true);
            visiblePasswordField.setManaged(true);
            passwordField.setVisible(false);
            passwordField.setManaged(false);
        }
    }

}