package com.javaprojectoop.demo;

import com.javaprojectoop.demo.Data.Pet;
import com.javaprojectoop.demo.Data.Pets;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPetController {

    @FXML private TextField nameField;
    @FXML private TextField typeField;
    @FXML private TextField breedField;
    @FXML private TextField ageField;
    @FXML private Button btnSave;

    @FXML
    private void handleAddPet() {
        String name = nameField.getText().trim();
        String type = typeField.getText().trim();
        String breed = breedField.getText().trim();
        String age = ageField.getText().trim();

        if (!name.isEmpty() && !type.isEmpty() && !breed.isEmpty() && !age.isEmpty()) {
            Pet newPet = new Pet(name, type, breed, age);
            Pets.petList.add(newPet);


            Stage stage = (Stage) btnSave.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill all fields.");
            alert.showAndWait();
        }
    }
}
