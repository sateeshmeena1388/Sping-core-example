
    <?xml version="1.0" encoding="UTF-8"?>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<a href="home.htm">English</a>&nbsp;&nbsp;
<a href="home.htm?language=fr_FR">French</a>&nbsp;&nbsp;
<a href="home.htm?language=de_DE">German</a>&nbsp;&nbsp;
<a href="home.htm?language=zh_CN">Chinees</a>&nbsp;&nbsp;

<form action="login.htm" method="post">
<spring:message code="form.uname" text="provide username"/><input type="text" name="uname"><br>
<spring:message code="form.pwd" text="provide password"/><input type="text" name="pwd"><br>
<input type="submit" value="<spring:message code="from.button"/>"/>

</form>
