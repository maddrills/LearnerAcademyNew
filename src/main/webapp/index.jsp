<%@ page import="com.example.learneracademynew.PreparedStatementCreateTable" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="stylesz.css">
    <title>JSP - Hello World</title>
</head>
<body>
<nav>
    <h1>Welcome To Learner Academy</h1>
</nav>
<table>
    <tr>
        <a href="Faculty.jsp"><input type = "submit" value="Faculty"></a>
    </tr>
    <tr>
        <a href="StudentClasses.jsp"><input type = "submit" value="Student"></a>
    </tr>
</table>
<%
    PreparedStatementCreateTable preparedStatementCreateTable = new PreparedStatementCreateTable();

    try {
        preparedStatementCreateTable.resultSet();
    } catch (SQLException e) {
        System.out.println("Created Already");
    }
%>
</body>
</html>