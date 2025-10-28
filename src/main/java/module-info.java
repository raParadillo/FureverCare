module com.javaprojectoop.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javaprojectoop.demo to javafx.fxml;
    exports com.javaprojectoop.demo;
}