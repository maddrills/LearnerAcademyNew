package com.example.learneracademynew;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//a strategy pattern for executing different queries
public abstract class PrepareStatementz {
    Connection connection;
    public PrepareStatementz(){
        this.connection = DataBaseConnection3306Proxy.dataBaseConnection3306Proxy();
    }
    abstract ResultSet resultSet() throws SQLException;
    abstract void close() throws SQLException;
}


class PreparedStatementQueryTest extends PrepareStatementz{
    String expression;
    PreparedStatement preparedStatement;
    public PreparedStatementQueryTest(String expression){
        super();
        this.expression = expression;
    }
    @Override
    public ResultSet resultSet() throws SQLException {

        ResultSet resultSet;
        //preparedStatement  = connection.prepareStatement("SELECT * FROM students WHERE first_name LIKE ?");
        preparedStatement.setString(1,expression);
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    void close() throws SQLException {
        this.preparedStatement.close();
        this.connection.close();
    }

}

class PreparedStatementAddSubject extends PrepareStatementz{
    String faculty_id,subject_id;
    PreparedStatement preparedStatement;
    public PreparedStatementAddSubject(String faculty_id,String subject_id){
        super();
        this.faculty_id = faculty_id;
        this.subject_id = subject_id;
    }
    @Override
    public ResultSet resultSet() throws SQLException {

        ResultSet resultSet;
        preparedStatement =  connection.prepareStatement("INSERT INTO faculty_subject(faculty_id,subject_id) VALUE (?,?);");
        preparedStatement.setString(1,faculty_id);
        preparedStatement.setString(2,subject_id);
        preparedStatement.execute();
        return null;
    }

    @Override
    void close() throws SQLException {
        this.preparedStatement.close();
        this.connection.close();
    }

    public static void main(String[] args) throws SQLException{
        PreparedStatementAddSubject preparedStatementAddSubject = new PreparedStatementAddSubject("1","3");

        preparedStatementAddSubject.resultSet();
    }
}


