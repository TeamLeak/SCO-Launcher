package com.github.lkapitman.ui.app.panels;

import com.github.lkapitman.ui.app.PanelManager;
import com.github.lkapitman.ui.app.panel.Panel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StartupPanel extends Panel {

    @Override
    public void init(PanelManager panelManager) {
        Stage stage = panelManager.stage;

        AnchorPane mainPane = new AnchorPane();
        mainPane.setPrefSize(496, 296);
        mainPane.setStyle("-fx-background-color: #725a7a;");

        AnchorPane downPane = new AnchorPane();
        downPane.setPrefSize(496, 22);
        downPane.setTranslateY(274);
        downPane.setStyle("-fx-background-color: linear-gradient(to bottom left, #f78361, #f54b64);");

        Label initTitle = new Label("Инициализация...");
        initTitle.setFont(new Font("Consolas", 12));
        initTitle.setTranslateX(372);
        initTitle.setTranslateY(4);

        Label releaseTitle = new Label("stable");
        releaseTitle.setFont(new Font("Consolas", 12));
        releaseTitle.setTranslateX(7);
        releaseTitle.setTranslateY(4);

        AnchorPane headerPane = new AnchorPane();
        headerPane.setPrefSize(496, 22);
        headerPane.setStyle("-fx-background-color: linear-gradient(to bottom left, #f78361, #f54b64);");

        Label title = new Label("SwordCraftOnline - Launcher");
        title.setFont(new Font("Consolas", 12));
        title.setTranslateX(159);
        title.setTranslateY(4);

        WebView screenshots = new WebView();
        screenshots.setTranslateY(22);
        screenshots.setPrefSize(496, 252);
        screenshots.getEngine().load("https://teamleak.github.io/SCO-Launcher-news/screenshots.html");

        headerPane.getChildren().addAll(title);
        downPane.getChildren().addAll(initTitle, releaseTitle);
        mainPane.getChildren().addAll(downPane, headerPane, screenshots);

        Scene scene = new Scene(mainPane);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(38), ev -> panelManager.showPanel(new LoginPanel())));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
