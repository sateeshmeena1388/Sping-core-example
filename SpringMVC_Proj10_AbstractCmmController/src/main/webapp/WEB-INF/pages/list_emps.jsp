<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
<c:when test="${!empty searchList}">
<table border="1">
<tr style="color:red"><th>EmpNo</th><th> Ename</th><th>Job</th><th>Sal</th>
<th>DeptNo</th><th>MgrNo</th></tr>
<c:forEach var="dto" items="${searchList}">
<tr>
<td>${dto.eno}</td>
<td>${dto.ename}</td>
<td>${dto.job}</td>
<td>${dto.sal}</td>
<td>${dto.deptNo}</td>
<td>${dto.mgrNo}</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1>record Not found</h1>
</c:otherwise>
</c:choose>
<br>
<a href="home.htm">home</a>