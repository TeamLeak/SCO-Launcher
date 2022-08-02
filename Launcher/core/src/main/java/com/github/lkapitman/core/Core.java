package com.github.lkapitman.core;

import com.github.lkapitman.ui.app.PanelManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The type Core.
 */
public class Core extends Application {

  @Override
  public void start(Stage primaryStage) {
    PanelManager panelManager = new PanelManager(primaryStage);
    panelManager.init();
  }

  /**
   * Launch app.
   *
   * @param args the args
   */
  public static void launchApp(String[] args) {
    launch(args);
  }
}
