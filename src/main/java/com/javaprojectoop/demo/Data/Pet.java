package com.javaprojectoop.demo.Data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pet {
    private final StringProperty name;
    private final StringProperty type;
    private final StringProperty breed;
    private final StringProperty age;

    public Pet(String name, String type, String breed, String age) {
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.breed = new SimpleStringProperty(breed);
        this.age = new SimpleStringProperty(age);
    }

    public StringProperty nameProperty() { return name; }
    public StringProperty typeProperty() { return type; }
    public StringProperty breedProperty() { return breed; }
    public StringProperty ageProperty() { return age; }


}
