package com.github.lkapitman.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lombok.SneakyThrows;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    public static final JFXTextField OZU_GIVE = new JFXTextField();
    public AnchorPane mainPane;
    public AnchorPane headerPane;
    public Label headerTitle;
    public ImageView closeIcon;
    public JFXButton closeButton;
    public JFXButton saveButton;
    public JFXButton load;
    public JFXSlider OZU_slider;
    public TextField width;
    public JFXTextField height;
    public JFXTextField customArgs;
    public JFXButton open1;
    public JFXButton open2;
    public JFXButton open3;
    public ImageView Xtag;
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
        closeButton.setText("");
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @SneakyThrows
    public void close(MouseEvent mouseEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root = loader.load();
        MainController controller = loader.getController();
        Scene scene = new Scene(root);

        scene.setFill(Color.TRANSPARENT);

        stage.setScene(scene);

        controller.setStage(stage);
        stage.show();
    }

    public void save(MouseEvent mouseEvent) {
        //TODO
    }

    public void load(MouseEvent mouseEvent) {
        //TODO:
    }

    public void ozuDragged(MouseEvent mouseEvent) {
        //TODO:
    }

    public void ozuDone(DragEvent dragEvent) {
        //TODO:
    }

    public void openDiscord(MouseEvent mouseEvent) {
        //TODO https://discord.gg/VqwpVEpqAZ
    }

    public void openLolipop(MouseEvent mouseEvent) {
        //TODO https://lollipopmc.net/forum/index.php?threads/9760/
    }

    public void openJVM(MouseEvent mouseEvent) {
        //TODO http://www.duct-tape-architect.ru/?p=711
    }
}
