<%@ page import="com.example.learneracademynew.PreparedStatementAllStudents" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 04-02-2023
  Time: 07:31 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link type="text/css" rel="stylesheet" href="stylesz.css">
  <title>Faculty</title>
</head>
<body>
<nav>
  <h1>Student Info</h1>
</nav>
<%! String students_id,info,classNumber;
ResultSet allStudentUnderClassNumber;
%>
<%%>
<%classNumber =  request.getParameter("classNumber");
  allStudentUnderClassNumber = (ResultSet)request.getAttribute("student_data");
%>
<table>
  <tr>
    <th>student_name</th>
    <th>class</th>
    <th>age</th>
    <th>marks</th>
    <th>place</th>
    <th>parents_no</th>
    <th>fees</th>
  </tr>
<%try{%>
  <%while(allStudentUnderClassNumber.next()){%>
  <tr>
    <%students_id = allStudentUnderClassNumber.getString("students_id");%>
    <td><%info = allStudentUnderClassNumber.getString("student_name");%><%=info%></td>
    <td><%info = allStudentUnderClassNumber.getString("class");%><%=info%></td>
    <td><%info = allStudentUnderClassNumber.getString("age");%><%=info%></td>
    <td><%info = allStudentUnderClassNumber.getString("marks");%><%=info%></td>
    <td><%info = allStudentUnderClassNumber.getString("place");%><%=info%></td>
    <td><%info = allStudentUnderClassNumber.getString("parents_no");%><%=info%></td>
    <td><%info = allStudentUnderClassNumber.getString("fees");%><%=info%></td>
  </tr>
  <%}%>
  <%}catch (Exception e){e.printStackTrace();}%>
</table>
</body>
</html>
