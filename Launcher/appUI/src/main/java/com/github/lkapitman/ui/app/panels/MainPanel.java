package com.github.lkapitman.ui.app.panels;

import com.github.lkapitman.ui.app.PanelManager;
import com.github.lkapitman.ui.app.panel.Panel;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * The type Main panel.
 */
public class MainPanel extends Panel {

    @Override
    public void init(PanelManager panelManager) {
        Stage stage = panelManager.stage;

        AnchorPane core = new AnchorPane();
        core.setMinSize(886, 584);
        core.setMaxSize(886, 584);

        core.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });

        core.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });


        //core.getChildren().addAll(main);
        Scene scene = new Scene(core);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
}
