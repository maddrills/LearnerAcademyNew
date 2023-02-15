<%@ page import="com.example.learneracademynew.PreparedStatementAddStudent" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 04-02-2023
  Time: 07:09 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link type="text/css" rel="stylesheet" href="stylesz.css">
  <title>classes</title>
</head>
<body>
<%!String student_name,classes,age,marks,place,parents_no,fees;%>
<nav>
  <h1>Classes >> <a href="index.jsp">Home</a></h1>
</nav>

<table>
  <tr>
    <th>Class Number</th>
  </tr>
  <tr>
    <td>
      <form action="studentDetails" method="POST">
        <input type="hidden" value="1" name="ClassNumber">
        <input type="submit" value="1">
      </form>
    </td>
    <td>
      <form action="studentDetails" method="POST">
        <input type="hidden" value="2" name="ClassNumber">
        <input type="submit" value="2">
      </form>
    </td>
    <td>
      <form action="studentDetails" method="POST">
        <input type="hidden" value="3" name="ClassNumber">
        <input type="submit" value="3">
      </form>
    </td>
    <td>
      <form action="studentDetails" method="POST">
        <input type="hidden" value="4" name="ClassNumber">
        <input type="submit" value="4">
      </form>
    </td>
    <td>
      <form action="studentDetails" method="POST">
        <input type="hidden" value="5" name="ClassNumber">
        <input type="submit" value="5">
      </form>
    </td>
  </tr>
</table>
<br>
<br>
<br>
<br>

<%try{%>
<form action="StudentClasses.jsp" method="POST">
  <tag>Student name</tag>
  <input type = "text" name="student_name"><br>
  <tag>class</tag>
  <input type = "text" name="class"><br>
  <tag>age</tag>
  <input type = "text" name="age"><br>
  <tag>marks</tag>
  <input type = "text" name="marks"><br>
  <tag>place</tag>
  <input type = "text" name="place"><br>
  <tag>parents_no</tag>
  <input type = "text" name="parents_no"><br>
  <tag>fees</tag>
  <input type = "text" name="fees"><br>
  <input type="submit" value="Add Student">
</form>
<%student_name = request.getParameter("student_name");
classes= request.getParameter("class");
age = request.getParameter("age");
marks = request.getParameter("marks");
place = request.getParameter("place");
parents_no = request.getParameter("parents_no");
fees = request.getParameter("fees");

System.out.println(student_name+classes+age+marks+place+parents_no+fees);%>
<%if(student_name == null || classes == null || age == null || marks == null || place == null || parents_no == null || fees == null){%>
<p> error while entering data</p>
<%}else {
  PreparedStatementAddStudent preparedStatementAddStudent = new PreparedStatementAddStudent(student_name,classes,age,marks,place,parents_no,fees);
  preparedStatementAddStudent.resultSet();
}%>
<%}catch (Exception e){System.out.println(e);}%>
</body>
</html>
