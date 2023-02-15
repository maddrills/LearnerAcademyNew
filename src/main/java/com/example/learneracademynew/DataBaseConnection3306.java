package com.example.learneracademynew;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection3306{

    private Connection connection;
    public DataBaseConnection3306(){
        databaseConnection();
    }
    //database connection

    private void databaseConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learner_academy_db", "root", "root");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }

/*    //used to test
    public static void main(String[] args){

        DataBaseConnection3306 dataBaseConnection = new DataBaseConnection3306();

        dataBaseConnection.databaseConnection();

        System.out.println(dataBaseConnection.getConnection());
    }*/
}
