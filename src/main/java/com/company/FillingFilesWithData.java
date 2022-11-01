package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FillingFilesWithData {//Заполнение файла данными

    public static String rendi (String a, int n){//Получение определённого количества символов из строки
        List<Character> list = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i<n ;i++){
            int randomInt = random.nextInt(0, a.length());
            char c = a.charAt(randomInt);
            list.add(c);
        }
        String letters = list.toString()
                .substring(1, 3 * list.size() - 1)
                .replaceAll(", ", "");
        return letters;
    }
    public static String getRandomValue(final Random random, //Получение рандомное число
                                        final int lowerBound,
                                        final int upperBound,
                                        final int decimalPlaces) {

        if (lowerBound < 0 || upperBound <= lowerBound || decimalPlaces < 0) {
            throw new IllegalArgumentException("Error");
        }

        final double dbl =
                ((random == null ? new Random() : random).nextDouble() //
                        * (upperBound - lowerBound))
                        + lowerBound;
        return String.format("%." + decimalPlaces + "f", dbl);

    }


    public void addingDataToFiles() {

        String separator = "||";
        String eng = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
        String rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        for (int i = 1; i <= 100; i++) {
            try {
                String filePath = "D:/Test tasks RPA - B1/Task1/Files/File_" + i + ".txt";
                FileWriter fileWriter = new FileWriter(filePath, true);
                for (int j = 1; j <= 100; j++) {

                    LocalDate startDate = LocalDate.of(2017, 1, 1); //start date
                    long start = startDate.toEpochDay();

                    LocalDate endDate = LocalDate.now(); //end date
                    long end = endDate.toEpochDay();

                    long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
                    String date = String.valueOf(LocalDate.ofEpochDay(randomEpochDay));
                    String year = date.substring(0, 4);
                    String month = date.substring(5, 7);
                    String day = date.substring(8, 10);
                    fileWriter.write(day + "." +  month + "." + year);
                    fileWriter.write(separator);
                    String randomEng = rendi(eng, 10);
                    fileWriter.write(randomEng);
                    fileWriter.write(separator);
                    String randomRus = rendi(rus, 10);
                    fileWriter.write(randomRus);
                    fileWriter.write(separator);
                    String randomNum = Integer.toString(ThreadLocalRandom.current().nextInt(1, 100000000));
                    fileWriter.write(randomNum);
                    fileWriter.write(separator);
                    Random rnd = new Random();
                    fileWriter.write(getRandomValue(rnd, 1, 20, 8));
                    fileWriter.write(separator);
                    fileWriter.write("\n");

                }
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}