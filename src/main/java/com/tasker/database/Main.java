package com.tasker.database;


import java.io.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        boolean exists = new File("DBCreated").exists();
        if (!exists) {
            DataBase dataBase = new DataBase();
            dataBase.createDB();
            dataBase.createTables();
            new PrintWriter("DBCreated");
        }
        InputWindow.runWindow();

    }
}


