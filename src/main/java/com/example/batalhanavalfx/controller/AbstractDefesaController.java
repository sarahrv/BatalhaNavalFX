package com.example.batalhanavalfx.controller;

import com.example.batalhanavalfx.model.Player;
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

import java.util.Objects;

public abstract class AbstractDefesaController {
    //colocar barcos quatro canos
    //colocar barcos porta aviao

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

    @FXML ImageView portaAviao;
    @FXML
    private GridPane gridDefesa;

    protected int contaUmCano = 0;
    protected int contaDoisCanos = 0;

    protected int contaTresCanos = 0;

    protected int contaQuatroCanos = 0;

<<<<<<< HEAD
    private int contaBarcos = 0;
    private int contaPortaAvioes;
=======
    protected int contaPortaAviao = 0;

    protected int contaBarcos = 0;
>>>>>>> 01514bd3f95d8785227e12772a3a1c5962daed0c


    private BooleanProperty isFlippedBarcoUmCano = new SimpleBooleanProperty(false);
    private BooleanProperty isFlippedBarcoDoisCanos = new SimpleBooleanProperty(false);
    private BooleanProperty isFlippedBarcoTresCanos = new SimpleBooleanProperty(false);
    private BooleanProperty isFlippedPortaAviao = new SimpleBooleanProperty(false);

    public abstract void setPlayer(Player playerUm, Player playerDois);
    public void flipImage(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String id = btn.getId();

        if (id.equals("verticalUm")) {
            double newAngle = isFlippedBarcoUmCano.get() ? 0 : 90;
            RotateTransition rt = new RotateTransition(Duration.millis(500), barcoUmCano);
            rt.setToAngle(newAngle);
            rt.play();
            isFlippedBarcoUmCano.set(!isFlippedBarcoUmCano.get());
        } else if (id.equals("verticalDois")) {
            double newAngle = isFlippedBarcoDoisCanos.get() ? 0 : 90;
            RotateTransition rt = new RotateTransition(Duration.millis(500), barcoDoisCanos);
            rt.setToAngle(newAngle);
            rt.play();
            isFlippedBarcoDoisCanos.set(!isFlippedBarcoDoisCanos.get());
        } else if (id.equals("verticalTres")) {
            double newAngle = isFlippedBarcoTresCanos.get() ? 0 : 90;
            RotateTransition rt = new RotateTransition(Duration.millis(500), barcoTresCanos);
            rt.setToAngle(newAngle);
            rt.play();
            isFlippedBarcoTresCanos.set(!isFlippedBarcoTresCanos.get());
        } else if (id.equals("verticalPortaAviao")) {
            double newAngle = isFlippedPortaAviao.get() ? 0 : 90;
            RotateTransition rt = new RotateTransition(Duration.millis(500), portaAviao);
            rt.setToAngle(newAngle);
            rt.play();
            isFlippedPortaAviao.set(!isFlippedPortaAviao.get());

        }
    }
    public void initialize(Player player) throws NullPointerException {

        //ajeitar porta aviao
        //ajeitar controleTamanho

        Image resizedImage = new Image(barcoUmCano.getImage().getUrl(), 50, 50, true, false);
        barcoUmCano.setImage(resizedImage);
        Image resizedImageDois = new Image(barcoDoisCanos.getImage().getUrl(), 100, 50, true, false);
        barcoDoisCanos.setImage(resizedImageDois);
        Image resizedImageTres = new Image(barcoTresCanos.getImage().getUrl(), 150, 50, true, false);
        barcoTresCanos.setImage(resizedImageTres);
        Image resizedImagePortaAviao = new Image(portaAviao.getImage().getUrl(), 174, 128, false, false);
        portaAviao.setImage(resizedImagePortaAviao);
        for (Node node : gridDefesa.getChildren()) {
            if (node instanceof StackPane) {


                StackPane stackPane = (StackPane) node;
                stackPane.setOnDragOver(event -> {

                    if (event.getGestureSource() != stackPane && event.getDragboard().hasImage()) {
                        ImageView image = (ImageView) event.getGestureSource();
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

                        if (image.getId().equals(barcoDoisCanos.getId()) && isFlippedBarcoDoisCanos.get() && rowIndex + controleTamanho - 1 <= 9 && colIndex <= 9) {
                            if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0) {
                                event.acceptTransferModes(TransferMode.MOVE);
                            }
                        }
                        if (image.getId().equals(barcoTresCanos.getId()) && isFlippedBarcoTresCanos.get() && rowIndex + controleTamanho - 1 <= 9 && colIndex <= 9) {
                            if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0) {
                                        event.acceptTransferModes(TransferMode.MOVE);
                            }
                        }
                        if(image.getId().equals(portaAviao.getId()) && isFlippedPortaAviao.get() && colIndex + 2 <= 9 && rowIndex + 2 <= 9) {
                            if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0) {
                                event.acceptTransferModes(TransferMode.MOVE);
                            }

                        }

                        if(image.getId().equals(barcoDoisCanos.getId()) && !isFlippedBarcoDoisCanos.get() && colIndex + controleTamanho - 1 <= 9 && rowIndex <= 9) {
                                if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0) {
                                    event.acceptTransferModes(TransferMode.MOVE);
                                }
                            }
                        if(image.getId().equals(barcoTresCanos.getId()) && !isFlippedBarcoTresCanos.get() && colIndex + controleTamanho - 1 <= 9 && rowIndex <= 9) {
                            if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0) {
                                event.acceptTransferModes(TransferMode.MOVE);
                            }
                        }
                        if(image.getId().equals(barcoUmCano.getId())){
                            if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0) {
                                event.acceptTransferModes(TransferMode.MOVE);
                            }
                        }if(image.getId().equals(portaAviao.getId()) && !isFlippedPortaAviao.get() && colIndex + 2 <= 9 && rowIndex + 2 <= 9) {
                            if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0) {
                                event.acceptTransferModes(TransferMode.MOVE);
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
                            contaUmCano ++;
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
                            contaDoisCanos ++;
                            player.setNumBarcos(contaBarcos);

                        } else if ("barcoTresCanos".equals(tipoBarco)) {
                            droppedImageView.setRotate(isFlippedBarcoTresCanos.get() ? 90 : 0);
                            if (isFlippedBarcoTresCanos.get()) {
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex + 1][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex + 2][colIndex].setValorCelula(1);

                            } else {
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 1].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 2].setValorCelula(1);
                            }
                            contaBarcos++;
                            contaTresCanos++;
                            player.setNumBarcos(contaBarcos);
                        }else if ("portaAviao".equals(tipoBarco)) {
                            droppedImageView.setRotate(isFlippedPortaAviao.get() ? 90 : 0);
                            if(isFlippedPortaAviao.get()){
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 1].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex ][colIndex + 2].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex - 1][colIndex + 2].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex + 1][colIndex + 2].setValorCelula(1);

                            }else {
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 1].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 2].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex + 1][colIndex+ 1].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex + 2][colIndex + 1].setValorCelula(1);
                            }
                            contaBarcos ++;
<<<<<<< HEAD
                            contaPortaAvioes ++;
=======
                            contaPortaAviao ++;
>>>>>>> 01514bd3f95d8785227e12772a3a1c5962daed0c
                            player.setNumBarcos(contaBarcos);

                        }stackPane.getChildren().add(droppedImageView);



                    }
                    event.setDropCompleted(success);

                    if(player.getModo().equals("normal")){
                        if(contaUmCano == 4){
                            anchorPane.getChildren().remove(barcoUmCano);
                        }
                        if(contaDoisCanos == 3){
                            anchorPane.getChildren().remove(barcoDoisCanos);
                        }
                        if(contaTresCanos == 2){
                            anchorPane.getChildren().remove(barcoTresCanos);
                        }
                        /*if(contaQuatroCanos == 1){
                            anchorPane.getChildren().remove(barcoQuatroCanos);
                        }*/
                        if(contaPortaAvioes == 1){
                            anchorPane.getChildren().remove(portaAviao);
                        }

                    }


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
                        //tentar deixar a imagem vestical enquanto gira

                    }
                    event.consume();
                });
            }
        }

}}
