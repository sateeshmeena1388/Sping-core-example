<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
<c:when test="${not empty result}">
<table>
<tr>
<th>No</th> <th>Name</th> <th>Job</th> <th>Salary</th>
</tr>
<c:forEach var="map" items="${result}">
<tr>
<td> <c:out value="${map.empno}"> </c:out></td>
<td> <c:out value="${map.ename}"> </c:out></td>
<td> <c:out value="${map.job}">   </c:out></td>
<td> <c:out value="${map.salary}"> </c:out></td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>No Employee Found</c:otherwise>
</c:choose>