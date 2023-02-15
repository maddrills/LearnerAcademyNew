package com.example.learneracademynew;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementAllFacultyData extends PrepareStatementz{
    String Id;
    PreparedStatement preparedStatement;
    public PreparedStatementAllFacultyData(String Id){
        super();
        this.Id = Id;
    }
    @Override
    public ResultSet resultSet() throws SQLException {

        ResultSet resultSet;
        preparedStatement  = connection.prepareStatement("SELECT faculty_name,faculty_age,number_of_periods,subjects.subject_name FROM faculty\n" +
                "    LEFT JOIN faculty_subject ON faculty.faculty_id = faculty_subject.faculty_id\n" +
                "    LEFT JOIN subjects ON faculty_subject.subject_id = subjects.subject_id WHERE faculty.faculty_id = ?;");
        preparedStatement.setString(1,Id);
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    void close() throws SQLException {
        this.preparedStatement.close();
        this.connection.close();
    }

    public static void main(String[] args) throws SQLException{
        PreparedStatementAllFacultyData preparedStatementAllFacultyData = new PreparedStatementAllFacultyData("1");

        ResultSet resultSet = preparedStatementAllFacultyData.resultSet();

        while(resultSet.next()){
            System.out.println(resultSet.getString("faculty_name"));
            System.out.println(resultSet.getString("subject_name"));
        }
    }
}
