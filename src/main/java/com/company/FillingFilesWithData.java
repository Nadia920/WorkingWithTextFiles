package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

public class FillingFilesWithData {
    public static<T> List<T> getRandomElement(List<T> list, int n) {
        if (n > list.size()) {
            throw new IndexOutOfBoundsException();
        }
        List<T> copy = new ArrayList<>(list);
        Collections.shuffle(copy);
        return copy.subList(0, n);
    }
    public static String getRandomValue(final Random random,
                                        final int lowerBound,
                                        final int upperBound,
                                        final int decimalPlaces){

        if(lowerBound < 0 || upperBound <= lowerBound || decimalPlaces < 0){
            throw new IllegalArgumentException("Put error message here");
        }

        final double dbl =
                ((random == null ? new Random() : random).nextDouble() //
                        * (upperBound - lowerBound))
                        + lowerBound;
        return String.format("%." + decimalPlaces + "f", dbl);

    }
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
    public void addingDataToFiles() {

        String separator = "||";
        String Eng = "\\[a-zA-Z]";
        String Rus = "\\[а-яА-Я]";
        List<Character> alphabetEng = Eng.chars().mapToObj(character -> (char) character).collect(Collectors.toList());
        List<Character> alphabetRus = Rus.chars().mapToObj(character -> (char) character).collect(Collectors.toList());
        for (int i = 1; i <= 3; i++) {
            System.out.println("Зашли в внешний цикл");
            try {
                String filePath = "D:/Test tasks RPA - B1/Task1/Files/File"+ i + ".txt";
                FileWriter writer = new FileWriter(filePath, false);
                BufferedWriter bufferWriter = new BufferedWriter(writer);
                writer.write("222");
                for (int j = 1; j <= 3; j++) {
                    System.out.println("Зашли в внутренний цикл");
                    GregorianCalendar gc = new GregorianCalendar();
                    int year = randBetween(2017, 2022);
                    gc.set(gc.YEAR, year);
                    int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
                    gc.set(gc.DAY_OF_YEAR, dayOfYear);
                    int m = randBetween(1, gc.getActualMaximum((gc.MONTH) + 1));
                    gc.set((gc.MONTH) + 1, m);
                    String a = Integer.toString((gc.get(gc.MONTH) + 1));
                    System.out.println("строка " + a);
                    char[] month = a.toCharArray();
                    char[] str = new char[2];
                    for(int k=0; k<2; k++){
                        str[k] = month[k];
                        System.out.println(str[k]);
                    }
                    System.out.println(str[0]);
                    System.out.println(str[1]);
                    if((month[0] == '1' || month[0] == '2' || month[0] == '3' || month[0] == '4' || month[0] == '5' || month[0] == '6' || month[0] == '7' || month[0] == '8' || month[0] == '9') && (month[1] != '1' && month[1] != '2') ) {
                        month [1] = month [0];
                        month [0] = '0';
                        System.out.println("авыаыв");
                        System.out.println(month [1]);
                        System.out.println(month [0]);
                    }
                    String monthStr = new String(month);
                    System.out.println(gc.get(gc.DAY_OF_MONTH) + "." + monthStr + "." + gc.get(gc.YEAR));
                    bufferWriter.write("111");
                    bufferWriter.write(gc.get(gc.YEAR) + "." + (gc.get(gc.MONTH) + 1) + "." + gc.get(gc.DAY_OF_MONTH));
                    bufferWriter.write(separator);
                    List<Character> randomEng = getRandomElement(alphabetEng, 10);
                    bufferWriter.write(String.valueOf(randomEng));
                    bufferWriter.write(separator);
                    List<Character> randomRus = getRandomElement(alphabetRus, 10);
                    bufferWriter.write(String.valueOf(randomRus));
                    bufferWriter.write(separator);
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 100000000 + 1);
                    bufferWriter.write(randomNum);
                    bufferWriter.write(separator);
                    final Random rnd = new Random();
                    bufferWriter.write(getRandomValue(rnd, 1, 20, 8));
                    bufferWriter.write(separator);

                }
                System.out.println("Внутренний цикл отработал");
                bufferWriter.close();
            } catch (Exception e) {
            }

        }
        System.out.println("Внешний цикл отработал");
    }
}
