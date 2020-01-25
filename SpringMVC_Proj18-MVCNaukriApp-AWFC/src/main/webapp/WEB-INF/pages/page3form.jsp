<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="color:green;text-align: center">Naukri.com Registration From3</h1>
<form:form method="post" commandName="regCmd">
Expected Salary:<form:input path="expSalary"/><br>
PrefferedLocation:<form:input path="location"/><br>

<input type="submit" name="_target1" value="previous">
<input type="submit" name="_finish" value="finish">
<input type="submit" name="_cancel" value="cancel">


</form:form>