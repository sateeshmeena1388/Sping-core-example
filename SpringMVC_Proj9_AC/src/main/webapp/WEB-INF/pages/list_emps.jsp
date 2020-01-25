<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
<c:when test="${!empty listemps}">
<table border="1" bgcolor="blue">
<tr style="color:red"><th>EmpNo</th><th> Ename</th><th>Job</th><th>Sal</th></tr>
<c:forEach var="dto" items="${listemps }">
<tr>
<td>${dto.eno}</td>
<td>${dto.ename}</td>
<td>${dto.job}</td>
<td>${dto.sal}</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1>Data Not found</h1>
</c:otherwise>
</c:choose>
<br>
<a href="home.htm">home</a>