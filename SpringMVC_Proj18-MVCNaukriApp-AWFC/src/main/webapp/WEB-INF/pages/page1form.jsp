<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="color:green;text-align: center">Naukri.com Registration From1</h1>
<form:form method="post" commandName="regCmd">
Name:<form:input path="name"/><br>
Address:<form:input path="addrs"/><br>
Age:<form:input path="age"/><br>
<input type="submit" name="_target1" value="next">

<input type="submit" name="_cancel" value="cancel">


</form:form>