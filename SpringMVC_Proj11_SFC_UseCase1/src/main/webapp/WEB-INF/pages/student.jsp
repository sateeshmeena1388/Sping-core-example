<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="color:red;text-align:center">Registration</h1>
<form:form method="post" commandName="stCmd">
StudentNo:<form:input path="sno"/></br>
StudentName:<form:input path="sname"/></br>
Sadd:<form:input path="sadd"/></br>
<input type="submit" value="submit"/>
</form:form>