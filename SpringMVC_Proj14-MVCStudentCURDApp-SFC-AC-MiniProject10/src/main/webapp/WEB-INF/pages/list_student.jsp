<%@ page language="java"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false"  %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:choose>
    <c:when test="${!empty studList}">
    <h1 style="color:red;text-align: center;">Student Details</h1>
    <table border="1" width="100px" height="100px">
    
    <tr>
    <th>sno</th><th>sname</th><th> sadd</th><th><th><th><th></tr>
    <c:forEach var="dto" items="${studList}">
    
    <tr>
    <td>${dto.sno}</td>
    <td>${dto.sname}</td>
    <td>${dto.sadd}</td>
    <td><a href="edit_student.htm?sid=${dto.sno}">Edit</a></td>
    <td><a href="delete_student.htm?sid=${dto.sno}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    </c:when>
    <c:otherwise>
    <h1 style="color:red"><b>No record found</b></h1>
    </c:otherwise>
    </c:choose>
 <h2 style="text-align:center"><a href="insert_students.htm">Register New Student </a></h2>
    <br><br>
    <br>
  ${insert_result}   &nbsp; ${edit_result}
<br>
