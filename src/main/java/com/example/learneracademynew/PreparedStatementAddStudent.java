package com.example.learneracademynew;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementAddStudent extends PrepareStatementz {
    String student_name, classes, age, marks, place, parents_no, fees;
    PreparedStatement preparedStatement;

    public PreparedStatementAddStudent(String student_name,
                                       String classes,
                                       String age,
                                       String marks,
                                       String place,
                                       String parents_no,
                                       String fees) {
        super();
        this.student_name = student_name;
        this.classes = classes;
        this.age = age;
        this.marks = marks;
        this.place = place;
        this.parents_no = parents_no;
        this.fees = fees;
    }

    @Override
    public ResultSet resultSet() throws SQLException {

        ResultSet resultSet;
        preparedStatement = connection.prepareStatement("INSERT INTO students(student_name,class,age,marks,place,parents_no,fees)" +
                " VALUE (?,?,?,?,?,?,?);");
        preparedStatement.setString(1, student_name);
        preparedStatement.setString(2, classes);
        preparedStatement.setString(3, age);
        preparedStatement.setString(4, marks);
        preparedStatement.setString(5, place);
        preparedStatement.setString(6, parents_no);
        preparedStatement.setString(7, fees);
        preparedStatement.execute();
        return null;
    }

    @Override
    void close() throws SQLException {
        this.connection.close();
    }

    public static void main(String[] args) throws SQLException {
        PreparedStatementAddStudent preparedStatementAddStudent = new PreparedStatementAddStudent("Mark Twain", "1", "7", "80", "Bangalore", "534345043", "29010");

        preparedStatementAddStudent.resultSet();
    }
}
