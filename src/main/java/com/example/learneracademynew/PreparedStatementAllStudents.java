package com.example.learneracademynew;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementAllStudents extends PrepareStatementz {
    String class_number;
    PreparedStatement preparedStatement;

    public PreparedStatementAllStudents(String class_number) {
        super();
        this.class_number = class_number;
    }

    @Override
    public ResultSet resultSet() throws SQLException {

        ResultSet resultSet;
        preparedStatement = connection.prepareStatement("SELECT students_id,student_name,class,age,marks,place,parents_no,fees FROM students WHERE class = ?;");
        preparedStatement.setString(1, class_number);
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    void close() throws SQLException {
        this.preparedStatement.close();
        this.connection.close();
    }

    public static void main(String[] args) throws SQLException {
        PreparedStatementAllStudents preparedStatementAllStudents = new PreparedStatementAllStudents("1");

        ResultSet resultSet = preparedStatementAllStudents.resultSet();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("students_id"));
            System.out.println(resultSet.getString("student_name"));
            System.out.println(resultSet.getString("class"));
            System.out.println(resultSet.getString("age"));
            System.out.println(resultSet.getString("marks"));
            System.out.println(resultSet.getString("place"));
            System.out.println(resultSet.getString("parents_no"));
            System.out.println(resultSet.getString("fees"));
        }
    }
}
