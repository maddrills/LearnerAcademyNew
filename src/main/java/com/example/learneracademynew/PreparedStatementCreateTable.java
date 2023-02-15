package com.example.learneracademynew;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementCreateTable extends PrepareStatementz {
    PreparedStatement preparedStatement;

    public PreparedStatementCreateTable() {
        super();
    }

    @Override
    public ResultSet resultSet() throws SQLException {

        ResultSet resultSet;
        preparedStatement = connection.prepareStatement("CREATE TABLE faculty(faculty_id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,\n" +
                "faculty_name VARCHAR(20) UNIQUE,\n" +
                "faculty_age INTEGER UNIQUE,\n" +
                "number_of_periods INTEGER NOT NULL CHECK ( number_of_periods > 0),\n" +
                "PRIMARY KEY (faculty_id));\n" +
                "\n" +
                "\n" +
                "CREATE TABLE students(students_id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,\n" +
                "student_name varchar(20) UNIQUE,\n" +
                "class INTEGER NOT NULL CHECK ( class < 6),\n" +
                "age INTEGER NOT NULL ,\n" +
                "marks INTEGER NOT NULL ,\n" +
                "place VARCHAR(20),\n" +
                "parents_no INTEGER(11),\n" +
                "fees INTEGER,\n" +
                "PRIMARY KEY (students_id));\n" +
                "\n" +
                "CREATE TABLE subjects(subject_id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,\n" +
                "subject_name VARCHAR(20));\n" +
                "\n" +
                "\n" +
                "CREATE TABLE faculty_subject(faculty_id INTEGER NOT NULL,subject_id INTEGER NOT NULL,\n" +
                "                            PRIMARY KEY (faculty_id,subject_id),\n" +
                "                            FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id),\n" +
                "                            FOREIGN KEY (subject_id) REFERENCES subjects(subject_id));\n" +
                "\n" +
                "CREATE TABLE students_subject(students_id INTEGER NOT NULL UNIQUE , subject_id INTEGER NOT NULL UNIQUE,\n" +
                "PRIMARY KEY (students_id,subject_id),\n" +
                "FOREIGN KEY (students_id) REFERENCES  students(students_id),\n" +
                "FOREIGN KEY (subject_id) REFERENCES subjects(subject_id));");

        preparedStatement.execute();
        return null;
    }

    @Override
    void close() throws SQLException {
        this.preparedStatement.close();
        this.connection.close();
    }

}
