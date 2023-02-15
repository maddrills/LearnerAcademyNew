<%@ page import="com.example.learneracademynew.FacultyNamesDB" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 03-02-2023
  Time: 08:22 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="stylesz.css">
    <title>Faculty</title>
</head>
<%!FacultyNamesDB facultyNamesDB = new FacultyNamesDB();
ResultSet allTeachersNames;
String nameOfFaculty,FacultyId;
%>
<body>
<nav>
    <h1>Faculty</h1>
</nav>
<% try {
    allTeachersNames = facultyNamesDB.resultSet();
} catch (SQLException e) {
    throw new RuntimeException(e);
}%>

<table>
    <tr>
        <th>teacher name</th>
    </tr>
    <%try{%>
    <% while(allTeachersNames.next()){%>
    <tr>
        <td>
            <%FacultyId = allTeachersNames.getString("faculty_id");%>
            <%nameOfFaculty = allTeachersNames.getString("faculty_name");%>
            <form action="facultyData" method="POST">
                <input type="hidden" value="<%=FacultyId%>" name="FacultyId">
                <input type="submit" value="<%=nameOfFaculty%>">
            </form>
        </td>
    </tr>
    <%}%>
    <%}catch (Exception e){}%>
</table>
</body>
</html>
