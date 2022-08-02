package com.github.lkapitman.filemanager.files;

import java.io.File;
import java.io.IOException;

/**
 * The type File manager.
 */
public class FileManager {

    private String serverName;
    private final String fileSeparator = File.separator;

    /**
     * Instantiates a new File manager.
     *
     * @param serverName the server name
     */
    public FileManager(String serverName) {
        this.serverName = serverName;
    }

    /**
     * Create test file.
     */
    public void createTestFile() {
        try {
            new File(createGameDir(), "init.txt").createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create game dir file.
     *
     * @return the file
     */
    public File createGameDir() {
        final String userHome = System.getProperty("user.home");

        switch (OperatingSystem.getCurrentlyPlatform()) {
            case WINDOWS:
                return new File(userHome + fileSeparator + "AppData" + fileSeparator + "Roaming" + fileSeparator + this.serverName);
            case MACOS:
                return new File(userHome + fileSeparator + "Library" + fileSeparator + "Application Support" + fileSeparator + this.serverName);
            default:
                return new File(userHome + fileSeparator + this.serverName);
        }

    }

    /**
     * Init game folder.
     */
    public void initGameFolder() {
        createGameDir().mkdir();
        createTestFile();
    }

    public File bedWarsFolder() {
        new File(createGameDir(), "bedWars").mkdir();
        return new File(createGameDir(), "bedWars");
    }

    public File skyBlockFolder() {
        new File(createGameDir(), "skyBlock").mkdir();
        return new File(createGameDir(), "skyBlock");
    }
}
