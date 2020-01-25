<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="color:red;text-align:center">Registration</h1>

<form:form method="post" commandName="stCmd">
<p style='color:red'>
<form:errors path="*"/>
</p>
ENo:<form:input path="sno"/><form:errors path="sno"/>&nbsp;
Name:<form:input path="sname"/><form:errors path="sname"/>&nbsp;
Address:<form:input path="sadd"/><form:errors path="sadd"/>&nbsp;
<input type="submit" value="register"/>
</form:form>