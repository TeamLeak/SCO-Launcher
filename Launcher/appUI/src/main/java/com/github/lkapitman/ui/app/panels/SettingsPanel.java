package com.github.lkapitman.ui.app.panels;

import com.github.lkapitman.ui.app.PanelManager;
import com.github.lkapitman.ui.app.panel.Panel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SettingsPanel extends Panel {

    @Override
    public void init(PanelManager panelManager) {
        Stage stage = panelManager.stage;

        AnchorPane main = new AnchorPane();
        main.setPrefSize(281, 434);
        main.setStyle("-fx-background-color: linear-gradient( to right top,#facd68, #fc76b3);");

        main.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        main.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        AnchorPane header = new AnchorPane();
        header.setPrefSize(281,43);
        header.setStyle("-fx-background-color: #725a7a;");

        Label title = new Label("SCO - Настройки");
        title.setTranslateX(83);
        title.setTranslateY(13);
        title.setFont(new Font("Consolas Bold", 14));

        ImageView close = new ImageView();
        close.setImage(new Image("/png/close.png"));
        close.setFitHeight(30);
        close.setFitWidth(30);
        close.setTranslateX(244);
        close.setTranslateY(7);

        JFXButton closeButton = new JFXButton("");
        closeButton.setTranslateX(244);
        closeButton.setTranslateY(7);
        closeButton.setPrefSize(30, 30);
        closeButton.setOnMouseClicked(e -> System.exit(0));

        JFXButton saveButton = new JFXButton("Сохранить");
        saveButton.setTranslateX(181);
        saveButton.setTranslateY(391);
        saveButton.setPrefSize(86, 30);
        saveButton.setStyle("-fx-background-color: #ffffff;");
        saveButton.setFont(new Font("Consolas Bold", 13));

        JFXButton loadButton = new JFXButton("Загрузить");
        saveButton.setTranslateX(17);
        saveButton.setTranslateY(391);
        saveButton.setPrefSize(86, 30);
        saveButton.setStyle("-fx-background-color: #ffffff;");
        saveButton.setFont(new Font("Consolas Bold", 13));

        JFXSlider omSlider = new JFXSlider();
        omSlider.setTranslateX(113);
        omSlider.setTranslateY(69);
        omSlider.setMax(32768);
        omSlider.setMin(2048);
        omSlider.setPrefSize(107, 14);
        omSlider.setValue(8000);

        Label selectOM = new Label("Количество ОЗУ:");
        selectOM.setPrefSize(107, 14);
        selectOM.setTranslateX(7);
        selectOM.setTranslateY(69);
        selectOM.setFont(new Font("Consolas", 12));

        JFXTextField givedOM = new JFXTextField();
        givedOM.setText("8000");
        givedOM.setTranslateY(63);
        givedOM.setTranslateX(224);
        givedOM.setPrefSize(51, 26);
        givedOM.setFont(new Font("Consolas Bold", 13));

        Label resizeScreen = new Label("Разрешение экрана:");
        resizeScreen.setTranslateY(104);
        resizeScreen.setTranslateX(7);
        resizeScreen.setPrefSize(122,14);
        resizeScreen.setFont(new Font("Consolas", 12));

        JFXTextField width = new JFXTextField();
        width.setTranslateX(129);
        width.setTranslateY(98);
        width.setPrefSize(46, 26);
        width.setText("1920");
        width.setFont(new Font("Consolas Bold", 13));

        JFXTextField height = new JFXTextField();
        width.setTranslateX(190);
        width.setTranslateY(98);
        width.setPrefSize(46, 26);
        width.setText("1080");
        width.setFont(new Font("Consolas Bold", 13));

        ImageView xResize = new ImageView();
        xResize.setImage(new Image("/png/close.png"));
        xResize.setFitWidth(17);
        xResize.setFitHeight(14);
        xResize.setTranslateY(104);
        xResize.setTranslateX(173);

        Label arguments = new Label("Доп. Аргументы:");
        arguments.setTranslateX(7);
        arguments.setTranslateY(139);
        arguments.setPrefSize(107, 14);
        arguments.setFont(new Font("Consolas", 12));

        JFXTextField argumentsField = new JFXTextField();
        argumentsField.setTranslateX(116);
        arguments.setTranslateY(134);



        header.getChildren().addAll(title, close, closeButton);
        main.getChildren().addAll(header,
                saveButton, loadButton,
                omSlider, selectOM, givedOM,
                resizeScreen, height, width, xResize,
                arguments, argumentsField
                );
        Scene scene = new Scene(main);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
}
