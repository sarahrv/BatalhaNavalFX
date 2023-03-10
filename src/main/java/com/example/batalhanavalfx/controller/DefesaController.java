package com.example.batalhanavalfx.controller;

import com.example.batalhanavalfx.model.Celula;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class DefesaController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView barcoUm;

    @FXML
    private GridPane gridDefesa;

    private Stage stage;
    private Scene scene;

    @FXML
    private Button proximoBomba;

    public void handleProximoBomba(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/batalhanavalfx/view/bomba-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void handleProximoDois(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/defesa-dois-view.fxml"));
        Parent root = loader.load();
        DefesaController controller = loader.getController();
        controller.initialize(false);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void initialize(boolean isPlayerUm) {
        ArrayList<Celula> celulaPlayerUm = new ArrayList<>();
        ArrayList<Celula> celulaPlayerDois = new ArrayList<>();
        for (Node node : gridDefesa.getChildren()) {
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
                        ImageView droppedImageView = new ImageView(db.getImage());
                        stackPane.getChildren().add(droppedImageView);
                        int rowIndex = GridPane.getRowIndex(stackPane);
                        int colIndex = GridPane.getColumnIndex(stackPane);

                        if (isPlayerUm) {
                            celulaPlayerUm.add(new Celula(rowIndex, colIndex));
                            //teste
                            System.out.println("player um row " + rowIndex + " column " + colIndex);
                        } else {
                            celulaPlayerDois.add(new Celula(rowIndex, colIndex));
                            //teste
                            System.out.println("player dois row " + rowIndex + " column " + colIndex);
                        }
                        //lembrar de fazer null == valor real
                    }
                    event.setDropCompleted(success);
                    event.consume();
                });
            }
        }

        for (Node node : anchorPane.getChildren()) {
            if (node instanceof ImageView) {
                ImageView imageView = (ImageView) node;

                imageView.setOnDragDetected(event -> {
                    Dragboard db = imageView.startDragAndDrop(TransferMode.MOVE);
                    ClipboardContent content = new ClipboardContent();
                    content.putImage(imageView.getImage());
                    db.setContent(content);
                    event.consume();
                });

                imageView.setOnDragDone(event -> {
                    if (event.getTransferMode() == TransferMode.MOVE) {
                        //remove()
                    }
                    event.consume();
                });
            }
        }
    }

}
