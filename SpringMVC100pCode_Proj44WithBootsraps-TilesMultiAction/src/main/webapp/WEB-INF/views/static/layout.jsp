<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<body>
<table border="1" cellspacing="2" align="center" width="100%" height="100%">
<tr bgcolor="pink">
<td height="100px" width="10px"><tiles:insertAttribute name="header"/></td>
</tr>
<tr>
<td height="100px" width="10px"><tiles:insertAttribute name="menu"/></td>
<td width="20px"><tiles:insertAttribute name="body"/></td>
</tr>
<tr bgcolor="cyan" height="2">
<td height="100px" colspan="2"><tiles:insertAttribute name="footer"/></td>

</tr>
</table>
</body>
</html>