package com.example.batalhanavalfx.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class DefesaController {

    @FXML
    private ImageView barcoUm;
    @FXML
    private GridPane gridDefesa;

    public void initialize() {
        for (Node node : gridDefesa.getChildrenUnmodifiable()) {
            if (node instanceof StackPane) {
                StackPane stackPane = (StackPane) node;
                stackPane.setOnDragOver(event -> {
                    if (event.getGestureSource() != stackPane && event.getDragboard().hasImage()) {
                        event.acceptTransferModes(TransferMode.MOVE);
                    }
                    event.consume();
                });

                stackPane.setOnDragDropped(event -> {
                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasImage()) {
                        ImageView droppedBarcoUm = new ImageView(db.getImage());
                        stackPane.getChildren().add(droppedBarcoUm);
                        int rowIndex = GridPane.getRowIndex(stackPane);
                        int colIndex = GridPane.getColumnIndex(stackPane);
                        //teste:
                        System.out.println("row" + rowIndex + "column " + colIndex);
                        success = true;
                    }
                    event.setDropCompleted(success);
                    event.consume();
                });
            }
        }

        barcoUm.setOnDragDetected(event -> {
            Dragboard db = barcoUm.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putImage(barcoUm.getImage());
            db.setContent(content);
            event.consume();
        });

        barcoUm.setOnDragDone(event -> {
            if (event.getTransferMode() == TransferMode.MOVE) {
                ((ImageView) event.getSource()).getParent().getChildrenUnmodifiable().remove(barcoUm);

            }
            event.consume();
        });
    }

    }

