package com.github.lkapitman.filemanager.files;

/**
 * The type Os util.
 */
public class OsUtil {
    /**
     * Gets os.
     *
     * @return the os
     */
    public static EnumOS getOs() {
        String os = System.getProperty("os.name").toLowerCase();
        return os.contains("win") ? EnumOS.WINDOWS
                :(os.contains("mac") ? EnumOS.MAC
                :(os.contains("linux") ? EnumOS.LINUX
                :(os.contains("unix") ? EnumOS.MAC : EnumOS.UNKNOWN)));
    }

    /**
     * The enum Enum os.
     */
    public static enum EnumOS {
        /**
         * Linux enum os.
         */
        LINUX("LINUX", 0),
        /**
         * Windows enum os.
         */
        WINDOWS("WINDOWS", 1),
        /**
         * Mac enum os.
         */
        MAC("MAC", 2),
        /**
         * Unknown enum os.
         */
        UNKNOWN("UNKNOWN", 3);

        private EnumOS(String name, int id) {}
    }
}
