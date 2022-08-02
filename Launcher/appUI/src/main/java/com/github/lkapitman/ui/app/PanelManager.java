package com.github.lkapitman.ui.app;

import com.github.lkapitman.filemanager.files.FileManager;
import com.github.lkapitman.minecraft.utils.QueryAPI;
import com.github.lkapitman.ui.app.database.DatabaseManager;
import com.github.lkapitman.ui.app.panel.IPanel;
import com.github.lkapitman.ui.app.panels.StartupPanel;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * The type Panel manager.
 */
public class PanelManager {

  /**
   * The Stage.
   */
  public final Stage stage;
  /**
   * The Manager.
   */
  public final DatabaseManager manager = new DatabaseManager(Constants.DATABASE_USERNAME, Constants.DATABASE_PASSWORD, Constants.DATABASE_HOST, Constants.TABLE_NAME, this, false);
  /**
   * The Query api.
   */
  public final QueryAPI queryAPI = new QueryAPI(Constants.SERVER_IP, Constants.SERVER_PORT);
  /**
   * The File manager.
   */
  public final FileManager fileManager = new FileManager(Constants.DIR_NAME);

  /**
   * Instantiates a new Panel manager.
   *
   * @param stage the stage
   */
  public PanelManager(Stage stage) {
    this.stage = stage;
  }

  /**
   * Init.
   */
  public void init() {
    fileManager.initGameFolder();

    stage.setTitle(Constants.APP_NAME + " " + Constants.APP_VERSION);
    stage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));
    this.stage.setResizable(false);
    stage.initStyle(StageStyle.TRANSPARENT);

    TrayManager tray = new TrayManager(stage);
    tray.init();

    showPanel(new StartupPanel());

    this.stage.centerOnScreen();
  }

  /**
   * Show panel.
   *
   * @param panel the panel
   */
  public void showPanel(IPanel panel) {
    panel.init(this);
  }

}
