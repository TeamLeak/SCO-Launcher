package com.github.lkapitman.filemanager.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/**
 * The type Utils.
 */
public class Utils {

    /**
     * Close silently.
     *
     * @param closeable the closeable
     */
    public static void closeSilently(final Closeable closeable) {
        if (closeable != null)
            try {
                closeable.close();
            }
            catch(final IOException ignored) {}
    }

    /**
     * Gets md 5.
     *
     * @param file the file
     * @return the md 5
     */
    public static String getMD5(final File file) {
        DigestInputStream stream = null;
        try {
            stream = new DigestInputStream(new FileInputStream(file), MessageDigest.getInstance("MD5"));
            final byte[] buffer = new byte[65536];

            int read = stream.read(buffer);
            while(read >= 1)
                read = stream.read(buffer);
        }
        catch (final Exception ignored) {
            return null;
        }
        finally {
            closeSilently(stream);
        }

        return String.format("%1$032x", new BigInteger(1, stream.getMessageDigest().digest()));
    }

}
