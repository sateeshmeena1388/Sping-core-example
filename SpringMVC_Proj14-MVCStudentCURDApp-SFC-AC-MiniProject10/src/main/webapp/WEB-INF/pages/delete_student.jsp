
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1 style="color:aqua;text-align: center;">Delete Student By No</h1>

<form:form method="POST" commandName="stCmd">

Number:<form:input path="sno"/><br>
Name:<form:input path="sname"/><form:errors cssStyle="color:red" path="sname"/><br>
Address:<form:input path="sadd"/><form:errors path="sadd"/><br>
<input type="submit" value="Delete">
</form:form>
<br>
<a href="studLists.htm">ListStudents</a>