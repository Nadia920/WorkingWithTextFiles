package com.company;

        import com.company.model.TextFiles;

        import java.io.*;
        import java.util.*;
        import java.util.concurrent.ThreadLocalRandom;

        import com.company.ShowTextFiles;

public class Main {

    public static void main(String[] args) throws IOException {
        ShowTextFiles stf = new ShowTextFiles();
        Map<Long, TextFiles> textfiles = new HashMap<>();
        FillingFilesWithData filling_files = new FillingFilesWithData();
        filling_files.addingDataToFiles();
        File dir = new File("D:/Test tasks RPA - B1/Task1/Files");
        stf.showFiles(dir.listFiles());

    }
}
