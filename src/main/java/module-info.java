module com.example.batalhanavalfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.batalhanavalfx to javafx.fxml;
    exports com.example.batalhanavalfx;
    exports com.example.batalhanavalfx.controller;
    opens com.example.batalhanavalfx.controller to javafx.fxml;
    exports com.example.batalhanavalfx.model;
    opens com.example.batalhanavalfx.model to javafx.fxml;
    exports com.example.batalhanavalfx.exception;
    opens com.example.batalhanavalfx.exception to javafx.fxml;
}