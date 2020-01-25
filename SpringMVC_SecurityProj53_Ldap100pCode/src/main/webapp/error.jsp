<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

  <h1 style="color:red;text-align:center">
   Mr/Miss.<%=request.getUserPrincipal().getName()%>  u r not authorized 
    </h1>
    
   <a href="home.htm">home</a> 