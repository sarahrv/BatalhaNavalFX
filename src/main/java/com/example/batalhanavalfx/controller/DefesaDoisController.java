package com.example.batalhanavalfx.controller;

import com.example.batalhanavalfx.model.Barcos;
import com.example.batalhanavalfx.model.Celula;
import com.example.batalhanavalfx.model.Player;
import com.example.batalhanavalfx.model.Tabuleiro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class DefesaDoisController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView barcoUm;
    @FXML
    private GridPane gridDefesa;
    private Stage stage;
    private Scene scene;

    private Player playerUm;
    private Player playerDois;
    @FXML
    private Button proximoBomba;

    @FXML
    private ImageView barcoUmCano;
    @FXML
    private ImageView barcoDoisCanos;
    @FXML
    private ImageView barcoTresCanos;
    @FXML
    private ImageView barcoQuatroCanos;

    public void setPlayer(Player playerUm, Player playerDois){
        this.playerUm = playerUm;
        this.playerDois = playerDois;
    }
    public void handleProximoBomba(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/bomba-view.fxml"));
        Parent root = loader.load();
        BombasController controller = loader.getController();
        controller.setPlayer(playerUm, playerDois);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize() {
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

                            Tabuleiro tabuleiro = playerDois.getTabuleiro();
                            if ("barcoUmCano".equals(tipoBarco)) {
                                Barcos barco = new Barcos(1);
                                Celula celula = new Celula(rowIndex,colIndex, 1);
                                barco.getCelulaOcupada().add(celula);
                                tabuleiro.colocaBracosNaMatriz(barco);
                                System.out.println("1cano p1");
                            } else if ("barcoDoisCanos".equals(tipoBarco)) {
                                System.out.println("2canos p1");
                                Barcos barco = new Barcos(2);
                                Celula celula = new Celula(rowIndex,colIndex, 1);
                                Celula celulaDois = new Celula(rowIndex + 1,colIndex, 1);
                                barco.getCelulaOcupada().add(celula);
                                barco.getCelulaOcupada().add(celulaDois);
                                tabuleiro.colocaBracosNaMatriz(barco);

                            } else if ("barcoTresCanos".equals(tipoBarco)) {
                                Barcos barco = new Barcos(3);
                                Celula celula = new Celula(rowIndex,colIndex, 1);
                                Celula celulaDois = new Celula(rowIndex + 1,colIndex, 1);
                                Celula celulaTres = new Celula(rowIndex + 2,colIndex, 1);
                                barco.getCelulaOcupada().add(celula);
                                barco.getCelulaOcupada().add(celulaDois);
                                barco.getCelulaOcupada().add(celulaTres);
                                tabuleiro.colocaBracosNaMatriz(barco);
                                System.out.println("3canos player um");
                            }
                        System.out.println(Arrays.deepToString(playerUm.getTabuleiro().getMatrizCelulas()));
                            System.out.println("player um row " + rowIndex + " column " + colIndex);

                    }

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
}
