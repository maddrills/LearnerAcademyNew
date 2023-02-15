package com.example.learneracademynew;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyNamesDB extends PrepareStatementz {

    PreparedStatement preparedStatement;


    @Override
    public ResultSet resultSet() throws SQLException {
        ResultSet resultSet;
        preparedStatement  = connection.prepareStatement("SELECT faculty_id,faculty_name,faculty_age,number_of_periods FROM faculty;");
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    void close() throws SQLException {
        this.preparedStatement.close();
        this.connection.close();
    }

    public static void main(String[] args) throws SQLException {
        FacultyNamesDB facultyNamesDB = new FacultyNamesDB();
        ResultSet resultSet = facultyNamesDB.resultSet();
        while (resultSet.next()){
            System.out.println(resultSet.getString("faculty_id"));
        }

    }
}

