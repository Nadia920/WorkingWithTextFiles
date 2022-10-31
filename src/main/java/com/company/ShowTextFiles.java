package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ShowTextFiles {
    public void showFiles(File[] files) throws IOException {
        String filePath = "D:/Test tasks RPA - B1/Task1/Files/Full_file.txt";
        File file_full_inf = new File(filePath);
        FileWriter fullFiles = new FileWriter(filePath, true);
        BufferedWriter bufferWriter = new BufferedWriter(fullFiles);
        /*for (File file : files) {
            if (file.isDirectory()) {
                showFiles(file.listFiles()); // Calls same method again.
            } else {
                System.out.println("Хотите удалить какие - то строки из файлов? \n 1 - Да \n 2 - Нет");
                Scanner in = new Scanner(System.in);
                int chooseDelete = in.nextInt();
                if (chooseDelete == 1 || chooseDelete == 2){
                    switch (chooseDelete) {
                        case 1: {
                            System.out.println("Введите строку, которую хотите удалить");
                            String str = in.nextLine();
                            IOCopier.joinFilesWithDelete(file_full_inf, files, str);
                        }
                        case 2: {IOCopier.joinFilesWithoutDelete(file_full_inf, files);}
                    }
                }

               *//* IOCopier.joinFiles(bufferWriter, file)*//*
            }
        }*/
    }
}
