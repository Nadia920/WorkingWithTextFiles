package com.company;

import java.io.*;
import java.util.Scanner;

public class ShowTextFiles {
    public void showFiles(File[] files) throws IOException { //Функция по выбору желаемого варианта записи в общий файл
        String filePath = "D:/Test tasks RPA - B1/Task1/Files/Full_file.txt";
        File fileSource = new File(filePath);
        FileWriter fullFiles = new FileWriter(filePath, true);
        System.out.println("Хотите удалить какие - то строки из файлов? \n 1 - Да \n 2 - Нет");
        Scanner in = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int chooseDelete = in.nextInt();
        if (chooseDelete == 1 || chooseDelete == 2) {
            switch (chooseDelete) {
                case 1: {
                    System.out.println("Введите строку, которую хотите удалить");
                    String str = reader.readLine();
                    for (File file : files) {
                        if (file.isDirectory()) {
                            showFiles(file.listFiles()); // Calls same method again.
                        } else {
                           IOCopier.joinFilesWithDelete(fileSource, files, str, file);
                        }
                    }
                    break;
                }
                case 2: {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            showFiles(file.listFiles()); // Calls same method again.
                        } else {
                            IOCopier.joinFilesWithoutDelete(fileSource, files);
                        }
                    }
                    break;
                }

            }
        }
        else {
            System.out.println("Выберите желаемый вариант");
        }

    }
}
