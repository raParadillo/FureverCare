package com.javaprojectoop.demo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class EditUserController {

    @FXML private TextField firstNameField, lastNameField, emailField, phoneField, ageField, addressField;

    private UserProfile userProfile;

    public void setUserData(UserProfile profile) {
        this.userProfile = profile;
        firstNameField.setText(profile.getFirstName());
        lastNameField.setText(profile.getLastName());
        emailField.setText(profile.getEmail());
        phoneField.setText(profile.getPhone());
        ageField.setText(profile.getAge());
        addressField.setText(profile.getAddress());
    }

    @FXML
    private void handleSaveProfile(ActionEvent event) {
        if(userProfile != null) {
            userProfile.setFirstName(firstNameField.getText());
            userProfile.setLastName(lastNameField.getText());
            userProfile.setEmail(emailField.getText());
            userProfile.setPhone(phoneField.getText());
            userProfile.setAge(ageField.getText());
            userProfile.setAddress(addressField.getText());

            System.out.println("Profile Updated: " + userProfile.getFirstName() + " " + userProfile.getLastName());
        }

        Stage stage = (Stage) firstNameField.getScene().getWindow();
        stage.close();
    }
}
