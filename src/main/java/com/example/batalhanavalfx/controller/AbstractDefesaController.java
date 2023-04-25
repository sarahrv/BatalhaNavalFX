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
import javafx.scene.layout.*;
import javafx.util.Duration;


import java.util.Objects;
public abstract class AbstractDefesaController implements IControllerTabuleiros {
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
    protected int contaPortaAviao = 0;
    protected int contaBarcos = 0;


    private BooleanProperty isFlippedBarcoUmCano = new SimpleBooleanProperty(false);
    private BooleanProperty isFlippedBarcoDoisCanos = new SimpleBooleanProperty(false);
    private BooleanProperty isFlippedBarcoTresCanos = new SimpleBooleanProperty(false);

    private BooleanProperty isFlippedBarcoQuatroCanos = new SimpleBooleanProperty(false);
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

        } else if (id.equals("verticalQuatroCanos")) {
            double newAngle = isFlippedBarcoQuatroCanos.get() ? 0 : 90;
            RotateTransition rt = new RotateTransition(Duration.millis(500), barcoQuatroCanos);
            rt.setToAngle(newAngle);
            rt.play();
            isFlippedBarcoQuatroCanos.set(!isFlippedBarcoQuatroCanos.get());
        }
    }
    public void initialize(Player player) throws NullPointerException, IndexOutOfBoundsException {


        Image resizedImage = new Image(barcoUmCano.getImage().getUrl(), 70, 90, false, false);
        barcoUmCano.setImage(resizedImage);
        Image resizedImageDois = new Image(barcoDoisCanos.getImage().getUrl(), 120, 92, false, false);
        barcoDoisCanos.setImage(resizedImageDois);
        Image resizedImageTres = new Image(barcoTresCanos.getImage().getUrl(), 195, 92, false, false);
        barcoTresCanos.setImage(resizedImageTres);
        Image resizedImageQuatro = new Image(barcoQuatroCanos.getImage().getUrl(), 296, 75, false, false);
        barcoQuatroCanos.setImage(resizedImageQuatro);
        Image resizedImagePortaAviao = new Image(portaAviao.getImage().getUrl(), 200, 115, false, false);

        portaAviao.setImage(resizedImagePortaAviao);
        for (Node node : gridDefesa.getChildren()) {
            if (node instanceof StackPane) {


                StackPane stackPane = (StackPane) node;
                stackPane.setOnDragOver(event -> {

                    if (event.getGestureSource() != stackPane && event.getDragboard().hasImage()) {
                        ImageView image = (ImageView) event.getGestureSource();
                        int rowIndex = GridPane.getRowIndex(stackPane);
                        int colIndex = GridPane.getColumnIndex(stackPane);

                        if (image.getId().equals(barcoDoisCanos.getId()) && isFlippedBarcoDoisCanos.get() && rowIndex + 1 <= 9 && colIndex <= 9) {
                            if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0 && player.getTabuleiro().getMatrizBarcos()[rowIndex + 1][colIndex].getValorCelula()==0) {
                                event.acceptTransferModes(TransferMode.MOVE);
                            }
                        }
                        else if (image.getId().equals(barcoTresCanos.getId()) && isFlippedBarcoTresCanos.get() && rowIndex + 2 <= 9 && colIndex <= 9) {
                            if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0 && player.getTabuleiro().getMatrizBarcos()[rowIndex + 1][colIndex].getValorCelula()==0 && player.getTabuleiro().getMatrizBarcos()[rowIndex + 2][colIndex].getValorCelula()==0) {
                                        event.acceptTransferModes(TransferMode.MOVE);
                            }
                        }
                        else if(image.getId().equals(portaAviao.getId()) && isFlippedPortaAviao.get()  && rowIndex + 1 <= 9 && rowIndex - 1 >= 0) {
                            if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0 && player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 1].getValorCelula() == 0 && player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 2].getValorCelula() == 0 && player.getTabuleiro().getMatrizBarcos()[rowIndex - 1][colIndex + 2].getValorCelula() == 0 && player.getTabuleiro().getMatrizBarcos()[rowIndex + 1][colIndex + 2].getValorCelula() == 0) {
                                event.acceptTransferModes(TransferMode.MOVE);
                            }

                        }

                        else if(image.getId().equals(barcoDoisCanos.getId()) && !isFlippedBarcoDoisCanos.get() && colIndex + 1 <= 9 && rowIndex <= 9) {
                                if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0 && player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 1].getValorCelula()==0) {
                                    event.acceptTransferModes(TransferMode.MOVE);
                                }
                            }
                        else if(image.getId().equals(barcoTresCanos.getId()) && !isFlippedBarcoTresCanos.get() && colIndex + 2 <= 9 && rowIndex <= 9) {
                            if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0 && player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 1].getValorCelula()==0 && player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 2].getValorCelula()==0) {
                                event.acceptTransferModes(TransferMode.MOVE);
                            }
                        }

                        else if(image.getId().equals(barcoUmCano.getId()) && player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0){
                                event.acceptTransferModes(TransferMode.MOVE);
                        }
                        else if(image.getId().equals(portaAviao.getId()) && !isFlippedPortaAviao.get() && colIndex + 1 <= 9  && rowIndex + 2 <= 9) {
                            if (player.getTabuleiro().getMatrizBarcos()[rowIndex - 1][colIndex].getValorCelula() == 0 && player.getTabuleiro().getMatrizBarcos()[rowIndex-1][colIndex+1].getValorCelula() == 0 && player.getTabuleiro().getMatrizBarcos()[rowIndex-1][colIndex+2].getValorCelula() == 0 && player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex+1].getValorCelula() == 0 && player.getTabuleiro().getMatrizBarcos()[rowIndex+1][colIndex+1].getValorCelula() == 0) {
                                event.acceptTransferModes(TransferMode.MOVE);
                            }

                        }
                        else if(image.getId().equals(barcoQuatroCanos.getId()) && !isFlippedBarcoQuatroCanos.get() && colIndex + 3 <= 9 && rowIndex <= 9){
                            if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0 && player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 1].getValorCelula()==0 && player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 2].getValorCelula()==0 && player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 3].getValorCelula()==0) {
                                event.acceptTransferModes(TransferMode.MOVE);
                            }
                        }
                        else if (image.getId().equals(barcoQuatroCanos.getId()) && isFlippedBarcoQuatroCanos.get() && rowIndex + 3 <= 9 && colIndex <= 9) {
                            if (player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].getValorCelula() == 0 && player.getTabuleiro().getMatrizBarcos()[rowIndex + 1][colIndex].getValorCelula()==0 && player.getTabuleiro().getMatrizBarcos()[rowIndex + 2][colIndex].getValorCelula()==0 && player.getTabuleiro().getMatrizBarcos()[rowIndex + 3][colIndex].getValorCelula()==0) {
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
                            contaUmCano ++;
                            contaBarcos ++;
                        } else if ("barcoDoisCanos".equals(tipoBarco)) {
                            droppedImageView.setRotate(isFlippedBarcoDoisCanos.get() ? 90 : 0);
                            if (isFlippedBarcoDoisCanos.get()) {
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex + 1][colIndex].setValorCelula(1);
                            } else {
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 1].setValorCelula(1);
                            }contaDoisCanos ++;
                            contaBarcos++;


                        } else if ("barcoQuatroCanos".equals(tipoBarco)) {
                            droppedImageView.setRotate(isFlippedBarcoQuatroCanos.get() ? 90 : 0);
                            if (isFlippedBarcoQuatroCanos.get()) {
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex + 1][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex + 2][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex + 3][colIndex].setValorCelula(1);

                            } else {
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 1].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 2].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 3].setValorCelula(1);
                            }
                            contaQuatroCanos++;
                            contaBarcos ++;
                        }else if ("barcoTresCanos".equals(tipoBarco)) {
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
                            contaTresCanos++;
                            contaBarcos ++;
                        }else if ("portaAviao".equals(tipoBarco)) {
                            droppedImageView.setRotate(isFlippedPortaAviao.get() ? 90 : 0);
                            if(isFlippedPortaAviao.get()){
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 1].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex ][colIndex + 2].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex - 1][colIndex + 2].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex + 1][colIndex + 2].setValorCelula(1);

                            }else {
                                player.getTabuleiro().getMatrizBarcos()[rowIndex - 1][colIndex].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex - 1][colIndex + 1].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex - 1][colIndex + 2].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex][colIndex + 1].setValorCelula(1);
                                player.getTabuleiro().getMatrizBarcos()[rowIndex + 1][colIndex + 1].setValorCelula(1);
                            }

                            contaPortaAviao ++;
                            contaBarcos ++;
                            contaPortaAviao ++;


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

                    }
                    event.consume();
                });
            }
        }

}}
