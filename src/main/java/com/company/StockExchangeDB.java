package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StockExchangeDB {
    public  static final String DB_URL = "jdbc:h2:/C:/Users/kabak/OneDrive/Документы/Test tasks RPA - B1/Task1/Program/db/stockExchange";
    public  static final String DB_Driver = "org.h2.Driver";
    public void connectWithBD() {
        try{
            Class.forName(DB_Driver);
            Connection сonnection = DriverManager.getConnection(DB_URL);
            System.out.println("Соединение с СУБД выполнено");
            сonnection.close();
            System.out.println("Отключение от СУБД выполнено");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL !");
        }

    }

}
