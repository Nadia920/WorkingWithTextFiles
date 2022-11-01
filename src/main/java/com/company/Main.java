package com.company;


import java.io.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        ShowTextFiles stf = new ShowTextFiles();
        FillingFilesWithData filling_files = new FillingFilesWithData();
        filling_files.addingDataToFiles();
        File dir = new File("D:/Test tasks RPA - B1/Task1/Files");
        stf.showFiles(dir.listFiles());

    }
}
