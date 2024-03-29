package com.example.batalhanavalfx.controller;

import com.example.batalhanavalfx.exception.NumeroDeBarcosCustomException;
import com.example.batalhanavalfx.exception.NumeroDeBarcosException;
import com.example.batalhanavalfx.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DefesaController extends AbstractDefesaController {
    @FXML
    private Label nomeUmLabel;
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





    public void handleProximoDois(ActionEvent event) throws IOException, NumeroDeBarcosException, NumeroDeBarcosCustomException {
        try {
            if (playerUm.getModo().equals("normal") ) {
                if(contaUmCano < 4 || contaDoisCanos < 3 || contaTresCanos < 2 || contaQuatroCanos < 1 || contaPortaAviao < 1){
                    throw new NumeroDeBarcosException();
                }

            }

            if (playerUm.getModo().equals("custom") && contaBarcos == 0) {
                throw new NumeroDeBarcosCustomException();
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/batalhanavalfx/view/defesa-dois-view.fxml"));
            Parent root = loader.load();
            DefesaDoisController controller = loader.getController();
            controller.setPlayer(playerUm, playerDois);
            controller.initialize(playerDois);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (NumeroDeBarcosException | NumeroDeBarcosCustomException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, e.getMessage());
            alert.showAndWait();
        }
    }

    @Override
    public void setPlayer(Player playerUm, Player playerDois) {
        this.playerUm = playerUm;
        this.playerDois = playerDois;
    }

}
