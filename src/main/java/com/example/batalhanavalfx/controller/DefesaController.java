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

public class DefesaController {

    private Label[][] celulasP1;
    private Label[][] celulasP2;
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

    /*public DefesaController(AnchorPane anchorPane, ImageView barcoUm, GridPane gridDefesa, Stage stage, Scene scene, Button proximoBomba) {
        this.anchorPane = anchorPane;
        this.barcoUm = barcoUm;
        this.gridDefesa = gridDefesa;
        this.stage = stage;
        this.scene = scene;
        this.proximoBomba = proximoBomba;
    }*/

    public void handleProximoBomba(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/bomba-view.fxml"));
        Parent root = loader.load();
        BombasController controller = loader.getController();
        controller.setLabelP1(this.celulasP1);
        controller.setLabelP2(this.celulasP2);
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
        //ArrayList<Celula> celulaPlayerUm = new ArrayList<>();
        //ArrayList<Celula> celulaPlayerDois = new ArrayList<>();
        //Celula celulaPlayerUm = new Celula(0,0);
        //Celula celulaPlayerDois = new Celula(0,0);
        this.celulasP1 = new Label[10][10];
        this.celulasP2 = new Label[10][10];
        Barcos barcos = new Barcos();
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
                        for(int i = 0; i < 10; i++){
                            for(int j = 0; j < 10; j++){
                                celulasP1[i][j] = new Label("0");
                                celulasP2[i][j] = new Label("0");
                            }
                        }
                        if(isPlayerUm){
                            if ("barcoUmCano".equals(tipoBarco)) {
                                celulasP1[rowIndex][colIndex].setText("1");
                                System.out.println("1cano");
                            } else if ("barcoDoisCanos".equals(tipoBarco)) {
                                celulasP1[rowIndex][colIndex].setText("2");
                                celulasP1[rowIndex + 1][colIndex].setText("2");
                                System.out.println("2canos");
                            } else if ("barcoTresCanos".equals(tipoBarco)) {
                                celulasP1[rowIndex][colIndex].setText("3");
                                celulasP1[rowIndex + 1][colIndex].setText("3");
                                celulasP1[rowIndex + 2][colIndex].setText("3");
                                System.out.println("3anos");
                            } else if ("barcoQuatroCanos".equals(tipoBarco)) {
                                celulasP1[rowIndex][colIndex].setText("4");
                                celulasP1[rowIndex + 1][colIndex].setText("4");
                                celulasP1[rowIndex + 2][colIndex].setText("4");
                            }
                            celulasP2[rowIndex][colIndex].setStyle("-fx-text-fill: TRANSPARENT");
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
    // fazer for no método de ataque pra

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
