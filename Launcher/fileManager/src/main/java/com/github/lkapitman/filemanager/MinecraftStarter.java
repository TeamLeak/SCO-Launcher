package com.github.lkapitman.filemanager;

import java.io.*;

public class MinecraftStarter {

    private final File directory;
    private final String username;
    private final String IP;

    public MinecraftStarter(File directory, String username, String IP) {
        this.directory = directory;
        this.username = username;
        this.IP = IP;
    }

    private void replace(String replace, String replaced) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(directory  + "\\" + "start.bat")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                sb.append(strLine.replace(replace, replaced)).append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(directory  + "\\" + "start.bat")) {
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        replace("%CD%", directory.getAbsolutePath());
        replace("{username}", username);
        replace("{server_ip}", IP);

        try {
            Runtime.getRuntime().exec("cmd /c start \"\" " + directory.getAbsolutePath() + "/start.bat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
