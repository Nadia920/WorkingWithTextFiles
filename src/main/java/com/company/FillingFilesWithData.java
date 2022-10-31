package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

public class FillingFilesWithData {

    public static String rendi (String a, int n){
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
        System.out.println("строчка символов " + letters);
        return letters;
    }
    public static String getRandomValue(final Random random,
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
        /*String Eng = "^[a-zA-Z]";
        String Rus = "^[а-яА-Я]";*/
       /* List<Character> alphabetEng = Eng.chars().mapToObj(character -> (char) character).collect(Collectors.toList());
        List<Character> alphabetRus = Rus.chars().mapToObj(character -> (char) character).collect(Collectors.toList());*/
        String eng = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
        String rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        for (int i = 1; i <= 3; i++) {
            System.out.println("Зашли в внешний цикл");
            try {
                String filePath = "D:/Test tasks RPA - B1/Task1/Files/File_" + i + ".txt";
                FileWriter fileWriter = new FileWriter(filePath, true);

            /* fileWriter.flush();*/
                for (int j = 1; j <= 3; j++) {

                    LocalDate startDate = LocalDate.of(2017, 1, 1); //start date
                    long start = startDate.toEpochDay();
                    System.out.println(start);

                    LocalDate endDate = LocalDate.now(); //end date
                    long end = endDate.toEpochDay();
                    System.out.println(start);

                    long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
                    System.out.println(LocalDate.ofEpochDay(randomEpochDay));
                    String date = String.valueOf(LocalDate.ofEpochDay(randomEpochDay));
                    String year = date.substring(0, 4);
                    System.out.println(year);
                    String month = date.substring(5, 7);
                    System.out.println(month);
                    String day = date.substring(8, 10);
                    System.out.println(day);
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