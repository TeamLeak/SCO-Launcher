package com.github.lkapitman.ui.app.panels;

import com.github.lkapitman.ui.app.PanelManager;
import com.github.lkapitman.ui.app.panel.Panel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * The type Login panel.
 */
public class LoginPanel extends Panel {

    private static String usernameM;

    @Override
    public void init(PanelManager panelManager) {
        Stage stage = panelManager.stage;

        AnchorPane main = new AnchorPane();
        main.setPrefSize(600, 400);
        main.setStyle("-fx-background-color: transparent;");

        main.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        main.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        AnchorPane right = new AnchorPane();
        right.setTranslateY(76);
        right.setTranslateX(224);
        right.setPrefSize(310, 249);
        right.setStyle("-fx-background-radius: 25; -fx-background-color: white;");

        JFXTextField login = new JFXTextField("Введите логин");
        login.setTranslateX(72);
        login.setTranslateY(53);
        login.setPrefSize(174, 25);
        login.setFont(new Font("Consolas Bold", 13));

        JFXTextField password = new JFXTextField("Введите пароль");
        password.setTranslateX(72);
        password.setTranslateY(109);
        password.setPrefSize(174, 25);
        password.setFont(new Font("Consolas Bold", 13));

        JFXButton loginButton = new JFXButton("Войти");
        loginButton.setButtonType(JFXButton.ButtonType.RAISED);
        loginButton.setTranslateX(112);
        loginButton.setTranslateY(176);
        loginButton.setPrefSize(87, 41);
        loginButton.setStyle("-fx-background-color: linear-gradient( to right top,#facd68, #fc76b3);");
        password.setFont(new Font("Consolas Bold", 13));

        loginButton.setOnMouseClicked(e -> {
            //TODO:
            panelManager.showPanel(new MainPanel());
        });
        AnchorPane left = new AnchorPane();
        left.setStyle("-fx-background-color: linear-gradient( to right top,#facd68, #fc76b3); -fx-background-radius: 25;");
        left.setTranslateX(31);
        left.setTranslateY(53);
        left.setPrefSize(220, 295);

        JFXButton close = new JFXButton("X");
        close.setTranslateX(182);
        close.setTranslateY(14);

        close.setOnMouseClicked(e -> System.exit(0));

        Label copyright = new Label(" Copyright © 2022.  Все права защищены");
        copyright.setTranslateX(16);
        copyright.setTranslateY(273);
        copyright.setFont(new Font("System Italic", 10));

        left.getChildren().addAll(close, copyright);
        right.getChildren().addAll(login, password, loginButton);
        main.getChildren().addAll(left, right);

        Scene scene = new Scene(main);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

}
