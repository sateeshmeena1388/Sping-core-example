<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="color:green;text-align: center">Naukri.com Registration From2</h1>
<form:form method="post" commandName="regCmd">
Experience:<form:input path="exp"/><br>
SkillsDomain:<form:input path="skillDomain"/><br>

<input type="submit" name="_target0" value="previous">
<input type="submit" name="_target2" value="next">
<input type="submit" name="_cancel" value="cancel">


</form:form>