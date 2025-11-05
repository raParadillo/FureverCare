package com.javaprojectoop.demo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class AddPetController {

    @FXML private TextField nameField, typeField, breedField, ageField;

    @FXML
    private void handleAddPet(ActionEvent event) {

        String name = nameField.getText();
        String type = typeField.getText();
        String breed = breedField.getText();
        String age = ageField.getText();

    }
}
