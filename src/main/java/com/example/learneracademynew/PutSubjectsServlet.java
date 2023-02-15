package com.example.learneracademynew;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "PutSubjectsServlet", value = "/studentDetails")
public class PutSubjectsServlet extends HttpServlet {

    ResultSet resultSet;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String classNumber = request.getParameter("ClassNumber");


        PreparedStatementAllStudents preparedStatementAllStudents = new PreparedStatementAllStudents(classNumber);

        try {
            resultSet = preparedStatementAllStudents.resultSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("student_data",resultSet);
        request.setAttribute("classNumber",classNumber);
        request.getRequestDispatcher("StudentData.jsp").forward(request,response);

        System.out.println(classNumber);
    }
}
