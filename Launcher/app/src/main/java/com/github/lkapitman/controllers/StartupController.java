package com.github.lkapitman.controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartupController implements Initializable {

    public AnchorPane mainPane;
    public AnchorPane headerPane;
    public AnchorPane downPane;
    public WebView screenshots;
    private double x = 0,y = 0;
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainPane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        mainPane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        screenshots.getEngine().load("https://teamleak.github.io/SCO-Launcher-news/screenshots.html");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(38), ev -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Controller controller = loader.getController();
            Scene scene = new Scene(root);

            scene.setFill(Color.TRANSPARENT);

            stage.setScene(scene);

            controller.setStage(stage);
            stage.show();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
