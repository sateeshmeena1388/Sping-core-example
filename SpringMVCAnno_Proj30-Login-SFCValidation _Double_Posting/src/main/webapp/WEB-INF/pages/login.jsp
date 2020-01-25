<%@page isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color:green;text-align: center;">Login Page</h1>
<form:form method="POST" commandName="userCmd">
 <p style="color:red">
   <form:errors path="*"/>
  </p>
UserName:<form:input path="user"/><br>
password:<form:input path="pwd"/><br>
Age::<form:input path="age"/><br>
Select Domains::<form:checkboxes items="${dmnList }" path="domains"/><br>
DOB::<form:input path="dob"/>(dd-MM-yyyy)<br>
<input type="hidden" name="cToken" value="${sToken}">
<input type="submit" value="login">
</form:form>
