<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/methods.tld" prefix="fct"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet-Example</title>
</head>
<body>
	<form>
		<input type="text" name="type" />
		<br/>
		<input type="submit"/>
	</form>
	<jsp:useBean id="bean" class="demo.Pojo"></jsp:useBean>
	<jsp:setProperty name="bean" property="*"></jsp:setProperty>
	<c:if test="${fct:isAcceptableType(bean.type)}">
		${bean.type} is acceptable.
	</c:if>
	<c:if test="${bean.type ne null && !fct:isAcceptableType(bean.type)}">
		${bean.type} is not acceptable.
	</c:if>
</body>
</html>