/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import application.Main;
import gui.util.Alerts;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author julio
 */
public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemSellerAction() {
        System.out.println("onMenuItemSellerAction");
    }

    @FXML
    public void onMenuItemDepartmentAction() {
        loadView("/gui/DepartmentList.fxml");
    }

    @FXML
    public void onMenuItemAboutAction() {
        loadView("/gui/About.fxml");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    // Carrega a view - o synchronized garante que o carregamento não será interrompido no meio
    private synchronized void loadView(String absoluteName) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();
            // Carrega o Scene Principal
            Scene mainScene = Main.getMainScene();
            // Pega o VBox da classe principal onde será inserido os node
            VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            // Guarda o node da barra de menu
            Node mainMenu = mainVbox.getChildren().get(0);
            mainVbox.getChildren().clear(); //limpa o VBox da Main
            mainVbox.getChildren().add(mainMenu); // Adiciona o node da Barra de Menu
            mainVbox.getChildren().addAll(newVBox.getChildren()); // Adiciona os node da tela about

        } catch (Exception e) {
            Alerts.showAlert("IO Exeption", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }

    }

}
