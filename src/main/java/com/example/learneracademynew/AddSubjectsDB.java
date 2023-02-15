package com.example.learneracademynew;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddSubjectsDB extends PrepareStatementz{

    PreparedStatement preparedStatement;
    String facultyId;

    public AddSubjectsDB(String facultyId){
        this.facultyId = facultyId;
    }

    @Override
    public ResultSet resultSet() throws SQLException {
        ResultSet resultSet;
        preparedStatement  = connection.prepareStatement("SELECT  DISTINCT s.subject_name ,s.subject_id FROM subjects AS s\n" +
                "    JOIN faculty_subject AS fs on s.subject_id NOT IN (SELECT DISTINCT(fa_sb.subject_id) FROM faculty_subject AS fa_sb\n" +
                "    JOIN faculty AS f on fa_sb.faculty_id = ?);");
        preparedStatement.setString(1,facultyId);
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    void close() throws SQLException {
        this.preparedStatement.close();
        this.connection.close();
    }

    public static void main(String[] args) throws SQLException {
        PrepareStatementz prepareStatementz = new AddSubjectsDB("1");
        ResultSet resultSet = prepareStatementz.resultSet();
        while (resultSet.next()){
            System.out.println(resultSet.getString("subject_name"));
        }
    }
}
