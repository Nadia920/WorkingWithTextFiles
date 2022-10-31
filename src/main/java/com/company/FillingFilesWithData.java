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
    public static <T> List<T> getRandomElement(List<T> list, int n) {
        if (n > list.size()) {
            throw new IndexOutOfBoundsException();
        }
        List<T> copy = new ArrayList<>(list);
        Collections.shuffle(copy);
        return copy.subList(0, n);
    }
    public static String rendi (String a, int n){
        List<Character> list = new ArrayList<>();
        Random random = new Random();
        final int randomInt = random.nextInt(0, a.length());
/*        final int randomInt = random.nextInt(0, a.length()) % 25;*/
        System.out.println("индекс" + randomInt);
        for(int i=0; i<n ;i++){
            char c = a.charAt(randomInt);
            list.add(c);
        }
        String a1 = String.valueOf(list);
        System.out.println(a1);
        return String.valueOf(list);
    }
    public static String getRandomValue(final Random random,
                                        final int lowerBound,
                                        final int upperBound,
                                        final int decimalPlaces) {

        if (lowerBound < 0 || upperBound <= lowerBound || decimalPlaces < 0) {
            throw new IllegalArgumentException("Put error message here");
        }

        final double dbl =
                ((random == null ? new Random() : random).nextDouble() //
                        * (upperBound - lowerBound))
                        + lowerBound;
        return String.format("%." + decimalPlaces + "f", dbl);

    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public void addingDataToFiles() {

        String separator = "||";
        String Eng = "^[a-zA-Z]";
        String Rus = "^[а-яА-Я]";
        List<Character> alphabetEng = Eng.chars().mapToObj(character -> (char) character).collect(Collectors.toList());
        List<Character> alphabetRus = Rus.chars().mapToObj(character -> (char) character).collect(Collectors.toList());
        String dist = "abc...xyz";
        for (int i = 1; i <= 3; i++) {
            System.out.println("Зашли в внешний цикл");
            try {
                String filePath = "D:/Test tasks RPA - B1/Task1/Files/File_" + i + ".txt";
                FileWriter fileWriter = new FileWriter(filePath, true);

            /* fileWriter.flush();*/
                for (int j = 1; j <= 3; j++) {
                    /*String date = randBetween()
                    System.out.println("Зашли в внутренний цикл");
                    GregorianCalendar gc = new GregorianCalendar();
                    int year = randBetween(2017, 2022);
                    gc.set(gc.YEAR, year);
                    int m = randBetween(1, gc.getActualMaximum((gc.MONTH) + 1));
                    gc.set((gc.MONTH) + 1, m);
                    int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
                    gc.set(gc.DAY_OF_YEAR, dayOfYear);
                    String a = Integer.toString((gc.get(gc.MONTH) + 1));*/
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
                    String randomEng = rendi(dist, 10);
                    fileWriter.write(randomEng);
                    fileWriter.write("\n");
                    List<Integer> l = new ArrayList<>();

                    String Eng1 = "\\^[a-z]";

                   // fileWriter.write("231232");

//                    bufferWriter.write(day + "." + month +  "." + year);
////                    char[] month = a.toCharArray();
////                    char[] str = new char[2];
////                    for(int k=0; k<2; k++){
////                        str[k] = month[k];
////                        System.out.println(str[k]);
////                    }
//                   /* if(a.length() == 1) {
//                        a = '0' + a;
//                        System.out.println("авыаыв");
////                        System.out.println(str [0]);
////                        System.out.println(month [1]);
//                    }
//                    String monthStr = a;
//                    System.out.println(gc.get(gc.DAY_OF_MONTH) + "." + monthStr + "." + gc.get(gc.YEAR));
//                    bufferWriter.write("111");
//                    bufferWriter.write(gc.get(gc.YEAR) + "." + (gc.get(gc.MONTH) + 1) + "." + gc.get(gc.DAY_OF_MONTH));*/
//                    bufferWriter.write(separator);
//                    List<Character> randomEng = getRandomElement(alphabetEng, 10);
//                    bufferWriter.write(String.valueOf(randomEng));
//                    bufferWriter.write(separator);
//                    List<Character> randomRus = getRandomElement(alphabetRus, 10);
//                    bufferWriter.write(String.valueOf(randomRus));
//                    bufferWriter.write(separator);
//                    int randomNum = ThreadLocalRandom.current().nextInt(1, 100000000 + 1);
//                    bufferWriter.write(randomNum);
//                    bufferWriter.write(separator);
//                    final Random rnd = new Random();
//                    bufferWriter.write(getRandomValue(rnd, 1, 20, 8));
//                    bufferWriter.write(separator);
//
//                }
//                System.out.println("Внутренний цикл отработал");
//                bufferWriter.flush();
//                bufferWriter.close();
//                writer.close();


                }
                fileWriter.flush();
                fileWriter.close();
                System.out.println("Внешний цикл отработал");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}