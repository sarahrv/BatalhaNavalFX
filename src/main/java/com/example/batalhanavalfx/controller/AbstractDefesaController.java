package com.example.batalhanavalfx.controller;

import com.example.batalhanavalfx.model.Player;
import com.example.batalhanavalfx.model.Tabuleiro;
import javafx.animation.RotateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public abstract class AbstractDefesaController {
    //colocar todos os botoes

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView barcoUmCano;
    @FXML
    private ImageView barcoDoisCanos;
    @FXML
    private ImageView barcoTresCanos;
    @FXML
    private ImageView barcoQuatroCanos;
    @FXML
    private GridPane gridDefesa;

    private int contaBarcos = 0;

    private BooleanProperty isFlippedBarcoUmCano = new SimpleBooleanProperty(false);
    private BooleanProperty isFlippedBarcoDoisCanos = new SimpleBooleanProperty(false);
    private BooleanProperty isFlippedBarcoTresCanos = new SimpleBooleanProperty(false);

    public abstract void setPlayer(Player playerUm, Player playerDois);
    public void flipImage(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String id = btn.getId();
        if(id.equals("verticalUm")){
            RotateTransition rt = new RotateTransition(Duration.millis(500), barcoUmCano);
            rt.setByAngle(90);
            rt.play();
            isFlippedBarcoUmCano.set(!isFlippedBarcoUmCano.get());
        }
        else if (id.equals("verticalDois")){
            RotateTransition rt = new RotateTransition(Duration.millis(500), barcoDoisCanos);
            rt.setByAngle(90);
            rt.play();
            isFlippedBarcoDoisCanos.set(!isFlippedBarcoDoisCanos.get());
        } else if (id.equals("verticalTres")) {
            RotateTransition rt = new RotateTransition(Duration.millis(500), barcoTresCanos);
            rt.setByAngle(90);
            rt.play();
            isFlippedBarcoTresCanos.set(!isFlippedBarcoTresCanos.get());
        }


    }
    public void initialize(Player player) throws NullPointerException {

        Image resizedImage = new Image(barcoUmCano.getImage().getUrl(), 50, 50, true, false);
        barcoUmCano.setImage(resizedImage);
        Image resizedImageDois = new Image(barcoDoisCanos.getImage().getUrl(), 100, 50, true, false);
        barcoDoisCanos.setImage(resizedImageDois);
        Image resizedImageTres = new Image(barcoTresCanos.getImage().getUrl(), 150, 50, true, false);
        barcoTresCanos.setImage(resizedImageTres);
        for (Node node : gridDefesa.getChildren()) {
            if (node instanceof StackPane) {


                StackPane stackPane = (StackPane) node;
                stackPane.setOnDragOver(event -> {

                    if (event.getGestureSource() != stackPane && event.getDragboard().hasImage()) {
                        int rowIndex = GridPane.getRowIndex(stackPane);
                        int colIndex = GridPane.getColumnIndex(stackPane);
                        String tipoBarco = ((Node) event.getGestureSource()).getId();
                        int controleTamanho = 0;
                        if ("barcoUmCano".equals(tipoBarco)) {
                            controleTamanho = 1;
                        }if ("barcoDoisCanos".equals(tipoBarco)) {
                            controleTamanho = 2;
                        }if ("barcoTresCanos".equals(tipoBarco)) {
                            controleTamanho = 3;
                        }
                        if(isFlippedBarcoDoisCanos.get()||isFlippedBarcoTresCanos.get()){
                            if (rowIndex + controleTamanho - 1 <= 9 && colIndex <= 9){
                                if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0) {
                                event.acceptTransferModes(TransferMode.MOVE);}
                        }}else{
                            if (colIndex + controleTamanho - 1 <= 9 && rowIndex <= 9){
                                if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0) {
                                    event.acceptTransferModes(TransferMode.MOVE);}
                            }
                        }


                    }
                    event.consume();
                });

                stackPane.setOnDragDropped(event -> {
                    Dragboard db = event.getDragboard();
                    boolean success = false;
                    if (db.hasImage()) {
                        ImageView droppedImageView = new ImageView(db.getImage());
                        int rowIndex = GridPane.getRowIndex(stackPane);
                        int colIndex = GridPane.getColumnIndex(stackPane);
                        String tipoBarco = ((Node) event.getGestureSource()).getId();
                        if ("barcoUmCano".equals(tipoBarco)) {
                            droppedImageView.setRotate(isFlippedBarcoUmCano.get() ? 90 : 0);
                            player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].setValorCelula(1);
                            contaBarcos ++;
                            player.setNumBarcos(contaBarcos);
                            System.out.println(player.getNome());
                        } else if ("barcoDoisCanos".equals(tipoBarco)) {
                            droppedImageView.setRotate(isFlippedBarcoDoisCanos.get() ? 90 : 0);
                            if (isFlippedBarcoDoisCanos.get()) {
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex + 1][colIndex].setValorCelula(1);
                            } else {
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 1].setValorCelula(1);
                            }
                            contaBarcos ++;
                            player.setNumBarcos(contaBarcos);

                        } else if ("barcoTresCanos".equals(tipoBarco)) {
                            droppedImageView.setRotate(isFlippedBarcoTresCanos.get() ? 90 : 0);
                            player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].setValorCelula(1);
                            player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 1].setValorCelula(1);
                            player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 2].setValorCelula(1);
                            contaBarcos ++;
                            player.setNumBarcos(contaBarcos);

                        }stackPane.getChildren().add(droppedImageView);

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
        //fazer uma função pra passar pro setondragdone que remova os barcos dependendo do modo que o player ta

}}