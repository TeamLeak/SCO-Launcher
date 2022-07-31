package com.github.lkapitman.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public AnchorPane top;
    public Label title;
    public ImageView exit;
    public JFXButton install;
    public ImageView folder;
    public ImageView settings;
    public ProgressBar progress;
    public ImageView website;
    public ImageView discord;
    public WebView news;
    public WebView trailer;
    public Label trailerLabel;
    public Label online;
    public TextArea onlineForm;
    public AnchorPane main;
    public JFXButton exitButton;
    public JFXButton discordButton;
    public JFXButton websiteButton;
    public JFXButton folderButton;
    public JFXButton settingsButton;
    private Stage stage;

    private double x = 0,y = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        main.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        main.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        trailer.getEngine().load("https://teamleak.github.io/SCO-Launcher-news/trailer.mp4");
        news.getEngine().load("https://teamleak.github.io/SCO-Launcher-news/index.html");
    }

    @FXML
    void installAction(ActionEvent event) {
        //TODO
    }

    public void openSettings(MouseEvent mouseEvent) {
        //TODO
    }

    public void openFolder(MouseEvent mouseEvent) {
        //TODO
    }

    public void openWebsite(MouseEvent mouseEvent) {
        //TODO
    }

    public void openDiscord(MouseEvent mouseEvent) {
        //TODO
    }

    public void exitClicked(MouseEvent mouseEvent) {
        System.exit(0);
    }

}
