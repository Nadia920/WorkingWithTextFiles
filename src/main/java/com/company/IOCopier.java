package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IOCopier {

    public static void joinFilesWithDelete(File destination, File[] sources, String str, File file) throws IOException {//Запись данных в общий файл свозможность удалить подстроку
        int number = 0;
        OutputStream output = null;
        try {
            output = createAppendableStream(destination);
            File fileData = new File(String.valueOf(destination));

            for (File source : sources) {

                Scanner s = new Scanner(source);
                FileWriter writer = new FileWriter(source);
                ArrayList<String> list = new ArrayList<String>();
                while (s.hasNextLine()) {
                    list.add(s.nextLine());
                }
                s.close();
                for (String symbols : list) {
                    if (symbols.contains("str")) {
                        symbols = "";
                        number++;
                    }
                }
                writer.write(list.toString());

            }
            System.out.println("Количество удалённых строк в файле " + file + " равно " + number);
        } finally {
            IOUtils.closeQuietly(output);
        }

    }
    public static void joinFilesWithoutDelete(File destination, File[] sources) throws IOException {// Запись данных в общий файл без возможности удаления
        OutputStream output = null;
        try {
            output = createAppendableStream(destination);
            for (File source : sources) {
                appendFile(output, source);
            }
        } finally {
            IOUtils.closeQuietly(output);
        }
    }
    private static BufferedOutputStream createAppendableStream(File destination)
            throws FileNotFoundException {
        return new BufferedOutputStream(new FileOutputStream(String.valueOf(destination), true));
    }

    private static void appendFile(OutputStream output, File source)//Дозапись в файл
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
