<%@ page isELIgnored="false"%>

<h1 style="color:green;text-align: center">Result</h1>
Upload File::${file1}<br>
Uploade File2::${file2}<br>
<br><a href="register.htm">home</a>
<% response.setContentType("application/vnd.ms-excel"); %>
<% response.addHeader("Content-Disposition", "attachment;fileName=tile.xls");%>
