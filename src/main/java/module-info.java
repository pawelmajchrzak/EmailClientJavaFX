module TestJavaFX {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires activation;
    requires java.mail;
    requires java.desktop;

    opens com.test;
    opens com.test.view;
    opens com.test.controller;
    opens com.test.model;
}