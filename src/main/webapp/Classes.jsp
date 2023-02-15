<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.example.learneracademynew.AddSubjectsDB" %><%--
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
<%! String facultyId,info,sub_id,fac_id;
    ResultSet allFacultyData,subjectsNotTaken;
%>
<body>
<nav>
    <h1>Faculty INFO</h1>
</nav>
<% allFacultyData = (ResultSet)request.getAttribute("allFacultyData");
    facultyId = (String)request.getAttribute("f_id");%>
<% AddSubjectsDB addSubjectsDB = new AddSubjectsDB(facultyId);%>

<% try{%>
<%subjectsNotTaken = addSubjectsDB.resultSet();%>
<%}catch (Exception e){ e.printStackTrace();}%>

<table>
    <tr>
        <th>faculty_name</th>
        <th>faculty_age</th>
        <th>number_of_periods</th>
        <th>subject_name</th>
    </tr>
    <%try{%>
    <%while (allFacultyData.next()){%>
    <tr>
        <td><% fac_id = allFacultyData.getString("faculty_name");%><%=fac_id%></td>
        <td><% info = allFacultyData.getString("faculty_age");%><%=info%></td>
        <td><% info = allFacultyData.getString("number_of_periods");%><%=info%></td>
        <td><% info = allFacultyData.getString("subject_name");if(info == null){info = "No subject Added";}%><%=info%></td>
    </tr>
    <%}%>
    <%}catch (Exception e){e.printStackTrace();}%>
</table>

<br>
<br>
<h3>Refresh page to update data</h3>
<br>
<br>
<table>
    <tr>
        <th>Add Subjects Subjects</th>
    </tr>
    <%try{%>
    <%while (subjectsNotTaken.next()){%>
    <tr>
        <% info = subjectsNotTaken.getString("subject_name");%>
        <% sub_id = subjectsNotTaken.getString("subject_id");%>
        <td>
            <form  action="facultyData" method="POST">
                <input type="hidden" value="<%=sub_id%>" name="SubjectId">
                <input type="hidden" value="<%=facultyId%>" name="FacultyId">
                <input type="submit" value="<%=info%>">
            </form>
        </td>
    </tr>
    <%}%>
    <%}catch (Exception e){e.printStackTrace();}%>
</table>
</body>
</html>
