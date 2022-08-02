module appUI {

    requires javafx.controls;
    requires javafx.swing;
    requires javafx.fxml;
    requires javafx.web;

    requires com.jfoenix;
    requires java.desktop;

    requires query;
    requires fileManager;

    requires java.sql;
    requires com.google.common;

    exports com.github.lkapitman.ui.app;
}
