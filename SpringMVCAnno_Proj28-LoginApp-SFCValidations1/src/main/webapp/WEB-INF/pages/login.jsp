<%@page isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color:green;text-align: center;">Login Page</h1>
<form:form method="POST" commandName="userCmd">
 <p style="color:red">
   <form:errors path="*"/>
  </p>
UserName:<form:input path="user"/><br>
password:<form:input path="pwd"/>
<input type="submit" value="login">
</form:form>
<h1>${result} </h1>