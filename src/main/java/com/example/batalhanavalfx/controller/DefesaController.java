package com.example.batalhanavalfx.controller;

import com.example.batalhanavalfx.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private Button[][] proximoBomba;

    @FXML
    private ImageView barcoUmCano;
    @FXML
    private ImageView barcoDoisCanos;
    @FXML
    private ImageView barcoTresCanos;
    @FXML
    private ImageView barcoQuatroCanos;

    Tabuleiro tabuleiro = new Tabuleiro();

    public void handleProximoBomba(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/bomba-view.fxml"));
        Parent root = loader.load();
        BombasController controller = loader.getController();
        controller.setPlayerUm(true);
        //Parent root = FXMLLoader.load(getClass().getResource("/com/example/batalhanavalfx/view/bomba-view.fxml"));
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
                        String tipoBarco = ((Node) event.getGestureSource()).getId();

                        if(isPlayerUm){
                            if ("barcoUmCano".equals(tipoBarco)) {
                                Barcos barco = new Barcos(1);
                                Celula celula = new Celula(rowIndex,colIndex, 1);
                                barco.getCelulaOcupada().add(celula);
                                tabuleiro.colocaBracosNaMatriz(barco);
                                System.out.println("1cano");
                            } else if ("barcoDoisCanos".equals(tipoBarco)) {
                                System.out.println("2canos");
                                Barcos barco = new Barcos(2);
                                Celula celula = new Celula(rowIndex,colIndex, 2);
                                Celula celulaDois = new Celula(rowIndex + 1,colIndex, 1);
                                barco.getCelulaOcupada().add(celula);
                                barco.getCelulaOcupada().add(celulaDois);
                                tabuleiro.colocaBracosNaMatriz(barco);

                            } else if ("barcoTresCanos".equals(tipoBarco)) {
                                System.out.println("2canos");
                                Barcos barco = new Barcos(3);
                                Celula celula = new Celula(rowIndex,colIndex, 3);
                                Celula celulaDois = new Celula(rowIndex + 1,colIndex, 1);
                                Celula celulaTres = new Celula(rowIndex + 2,colIndex, 1);
                                barco.getCelulaOcupada().add(celula);
                                barco.getCelulaOcupada().add(celulaDois);
                                barco.getCelulaOcupada().add(celulaTres);
                                tabuleiro.colocaBracosNaMatriz(barco);
                                System.out.println("3anos");
                            } else if ("barcoQuatroCanos".equals(tipoBarco)) {

                            }
                            System.out.println("player um row " + rowIndex + " column " + colIndex);
                        }}

                    event.setDropCompleted(success);
                    event.consume();
                });
            }
        }

        for(Node node: anchorPane.getChildren()) {
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

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public ImageView getBarcoUm() {
        return barcoUm;
    }

    public void setBarcoUm(ImageView barcoUm) {
        this.barcoUm = barcoUm;
    }

    public GridPane getGridDefesa() {
        return gridDefesa;
    }

    public void setGridDefesa(GridPane gridDefesa) {
        this.gridDefesa = gridDefesa;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Button[][] getProximoBomba() {
        return proximoBomba;
    }

    public void setProximoBomba (Button[][] proximoBomba) {
        this.proximoBomba = proximoBomba;
    }

}
