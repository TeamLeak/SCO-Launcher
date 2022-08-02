package com.github.lkapitman.ui.app.database;

import com.github.lkapitman.ui.app.PanelManager;
import com.github.lkapitman.ui.app.panels.MainPanel;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.sql.*;

/**
 * The type Database manager.
 */
public class DatabaseManager {

    private final String name;
    private final String password;
    private final String host;
    private final String tableName;
    private final PanelManager panelManager;
    private final boolean enabled;

    private String usernameM = " ";

    /**
     * Instantiates a new Database manager.
     *
     * @param name         the name
     * @param password     the password
     * @param host         the host
     * @param tableName    the table name
     * @param panelManager the panel manager
     * @param enabled      the enabled
     */
    public DatabaseManager(String name, String password, String host, String tableName, PanelManager panelManager, boolean enabled) {
        this.name = name;
        this.password = password;
        this.host = host;
        this.tableName = tableName;
        this.panelManager = panelManager;
        this.enabled = enabled;
    }

    /**
     * Login.
     *
     * @param username the username
     * @param password the password
     */
    public void login(String username, String password) {
        if (!enabled) {
            this.panelManager.showPanel(new MainPanel());
            return;
        }

        String pass = Hashing.sha512().hashString(username, StandardCharsets.UTF_8).toString();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(host, name, password);

            PreparedStatement pstmt = con.prepareStatement("select id,realname,password from " + tableName);

            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                if (rst.getString(2).equals(username) && rst.getString(3).equalsIgnoreCase(pass)) {
                    panelManager.showPanel(new MainPanel());
                    usernameM = username;
                } else {
                    // Todo: показать окно с ошибкой
                    return;
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

    }
}
