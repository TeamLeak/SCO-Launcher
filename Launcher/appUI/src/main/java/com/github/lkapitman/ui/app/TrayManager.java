package com.github.lkapitman.ui.app;

import javafx.application.Platform;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * The type Tray manager.
 */
public class TrayManager {

    private static final String APPLICATION_NAME = Constants.APP_NAME;
    private static final String ICON_STR = "/icon.png";

    private int stateWindow = 1;
    private TrayIcon trayIcon;

    private final Stage stage;

    /**
     * Instantiates a new Tray manager.
     *
     * @param stage the stage
     */
    public TrayManager(Stage stage) {
        this.stage = stage;
    }

    /**
     * Init.
     */
    public void init() {
        setTrayIcon();
    }

    private void setTrayIcon() {

        if (!SystemTray.isSupported()) {
            return;
        }

        final PopupMenu popup = new PopupMenu();
        final MenuItem exit = new MenuItem("Выйти");
        final SystemTray tray = SystemTray.getSystemTray();

        ActionListener menuActionListener = e -> System.exit(0);

        URL imageURL = PanelManager.class.getResource(ICON_STR);
        Image icon = Toolkit.getDefaultToolkit().getImage(imageURL);

        trayIcon = new TrayIcon(icon, APPLICATION_NAME, popup);
        trayIcon.setImageAutoSize(true);

        exit.addActionListener(menuActionListener);
        popup.add(exit);

        trayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if (event.getButton() == MouseEvent.BUTTON1) {
                    Platform.runLater(() -> {
                        if (stateWindow == 1) {
                            stage.hide();
                            stateWindow = 0;
                        } else if (stateWindow == 0) {
                            stage.show();
                            stateWindow = 1;
                        }
                    });
                }
            }
        });

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        Platform.setImplicitExit(false);

        trayIcon.displayMessage(APPLICATION_NAME, "Готов к работе!", TrayIcon.MessageType.INFO);
    }

    /**
     * Display message.
     *
     * @param text the text
     * @param TYPE the type
     */
    public void displayMessage(String text, String TYPE) {
        if (TYPE.equalsIgnoreCase("INFO")) {
            trayIcon.displayMessage(APPLICATION_NAME, text, TrayIcon.MessageType.INFO);
            return;
        }
        if (TYPE.equalsIgnoreCase("ERROR")) {
            trayIcon.displayMessage(APPLICATION_NAME, text, TrayIcon.MessageType.ERROR);
            return;
        }
        if (TYPE.equalsIgnoreCase("WARN")) {
            trayIcon.displayMessage(APPLICATION_NAME, text, TrayIcon.MessageType.WARNING);
        }
    }
}
