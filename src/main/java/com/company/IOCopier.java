package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class IOCopier {
    public static void joinFilesWithDelete(File destination, File[] sources, String str)
            throws IOException {
        OutputStream output = null;
        try {
            output = createAppendableStream(destination);
            File fileData = new File(String.valueOf(destination));
            String readData = null;
            for (File source : sources) {
                char[] buf = new char[1024];
                int numRead=0;
                FileReader fileReader = new FileReader(source);
                while((numRead=fileReader.read(buf)) != -1){
                    readData = String.valueOf(buf, 0, numRead);
                }

                readData.replace(str,"");
                Files.write(Paths.get(String.valueOf(destination)), readData.getBytes(), StandardOpenOption.APPEND);

            }
        } finally {
            IOUtils.closeQuietly(output);
        }
    }
    public static void joinFilesWithoutDelete(File destination, File[] sources) throws IOException {
        OutputStream output = null;
        try {
            output = createAppendableStream(destination);
            for (File source : sources) {
                appendFile(output, source);
                System.out.println(output);
            }
        } finally {
            IOUtils.closeQuietly(output);
        }
    }
    private static BufferedOutputStream createAppendableStream(File destination)
            throws FileNotFoundException {
        return new BufferedOutputStream(new FileOutputStream(String.valueOf(destination), true));
    }

    private static void appendFile(OutputStream output, File source)
            throws IOException {
        InputStream input = null;
        try {
            input = new BufferedInputStream(new FileInputStream(source));
            IOUtils.copy(input, output);
        } finally {
            IOUtils.closeQuietly(input);
        }
    }
}
