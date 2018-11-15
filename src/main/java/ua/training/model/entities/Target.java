package ua.training.model.entities;

import java.util.ResourceBundle;

public enum Target {
    ANY ("any"), MORTGAGE("mortgage"), CAR("car"), STUDY("study"), RENOVATION("renovation");
    private String resourceCode;

    Target(String message) {
        this.resourceCode = message;
    }

    public String getMessage() {
        ResourceBundle bundle = ResourceBundle.getBundle("labels");
        return bundle.getString(resourceCode);
    }
}
