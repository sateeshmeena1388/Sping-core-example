<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:red;text-align:center"> Order Details </h1>

<c:choose>
  <c:when test="${!empty orders }">
   <table>
     <c:forEach var="order" items="${orders}">
       <tr>
        <td>${order}</td>
       </tr> 
     </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    <h1 style='color:red'> No items found</h1>
  </c:otherwise>
</c:choose>
 <br>
  <a href='home.htm'>home</a>
  <br>
  <a href="j_spring_security_logout">logout</a>



