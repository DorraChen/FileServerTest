package com.example.demo;

import java.io.*;
import java.nio.file.Files;

/**
 * @author clz
 * @date 2020/12/10 17:42
 * @description
 */
public class InputGenerator {

    private static final String JAVADOC_PATH = "your_path_to_JDK/docs";

    public static final File FILE_PATH = new File("your_output_file_path");


    static {

        try {

            if (!FILE_PATH.exists()) {
                makeJavadocFile();
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


    private static void makeJavadocFile() throws IOException {

        try (OutputStream os = new BufferedOutputStream(new FileOutputStream(FILE_PATH), 65536)) {

            appendDir(os, new File(JAVADOC_PATH));

        }

        System.out.println("Javadoc file created");

    }


    private static void appendDir(final OutputStream os, final File root) throws IOException {

        for (File f : root.listFiles()) {

            if (f.isDirectory()) {
                appendDir(os, f);
            } else {
                Files.copy(f.toPath(), os);
            }

        }

    }

}