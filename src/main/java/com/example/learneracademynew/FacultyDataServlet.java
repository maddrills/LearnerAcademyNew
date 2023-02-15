package com.example.learneracademynew;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "FacultyDataServlet",value = "/facultyData")
public class FacultyDataServlet extends HttpServlet {

    ResultSet allFacultyData;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String facultyId = request.getParameter("FacultyId");

        System.out.println(facultyId);

        try{
            PrepareStatementz prepareStatementz = new PreparedStatementAllFacultyData(facultyId);
            allFacultyData = prepareStatementz.resultSet();
        }catch (Exception e){
            System.out.println(e);
        }

        String SubjectId = request.getParameter("SubjectId");

        System.out.println("SubjectId "+SubjectId);
        System.out.println("facultyId "+facultyId);


        if(SubjectId != null) {
            PrepareStatementz prepareStatementz = new PreparedStatementAddSubject(facultyId, SubjectId);

            try {
                prepareStatementz.resultSet();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        request.setAttribute("f_id",facultyId);
        request.setAttribute("allFacultyData",allFacultyData);
        request.getRequestDispatcher("Classes.jsp").forward(request,response);
    }
}
