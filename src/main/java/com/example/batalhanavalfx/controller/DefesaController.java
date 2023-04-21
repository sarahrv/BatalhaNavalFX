package com.example.batalhanavalfx.controller;

import com.example.batalhanavalfx.model.Player;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DefesaController extends AbstractDefesaController {
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

    private Button horizontal;

    @FXML
    private ImageView barcoUmCano;
    @FXML
    private ImageView barcoDoisCanos;
    @FXML
    private ImageView barcoTresCanos;
    @FXML
    private ImageView barcoQuatroCanos;

    private int contaBarcos = 0;

    private ImageView imageViewGirada;

    private BooleanProperty isFlipped = new SimpleBooleanProperty(false);



    public void handleProximoDois(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/defesa-dois-view.fxml"));
        Parent root = loader.load();
        DefesaDoisController controller = loader.getController();
        controller.setPlayer(playerUm, playerDois);
        controller.initialize(playerDois);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @Override
    public void setPlayer(Player playerUm, Player playerDois) {
        this.playerUm = playerUm;
        this.playerDois = playerDois;
    }

}
