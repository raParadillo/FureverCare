package com.javaprojectoop.demo;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class LoginController {

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
}
