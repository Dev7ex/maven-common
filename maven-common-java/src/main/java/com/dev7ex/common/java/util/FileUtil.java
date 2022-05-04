package com.dev7ex.common.java.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Dev7ex
 * @since 25.05.2021
 */
public final class FileUtil {

    private FileUtil() {}

    public static File getFromString(final String s) {
        return new File(s);
    }

    public static boolean containsFile(final File parentFile, final String fileName) {
        final File[] files = parentFile.listFiles();

        if (files == null) {
            return false;
        }

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                continue;
            }
            if(!files[i].getName().equalsIgnoreCase(fileName)) {
                continue;
            }
            return true;
        }
        return false;
    }

    public static List<String> foldersToStringList(final File file) {
        final List<String> folders = new ArrayList<>();

        for(final File files : Objects.requireNonNull(file.listFiles())) {
            if(!files.isDirectory()) {
                continue;
            }
            folders.add(files.getName());
        }
        return folders;
    }

}
