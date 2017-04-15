<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet-Practices</title>
<style type="text/css">
.pane {
	width: 300px;
	margin: 20px auto;
	padding: 50px;
	-webkit-box-shadow: 10px 10px 5px 0px rgba(198, 222, 192, 0.75);
	-moz-box-shadow: 10px 10px 5px 0px rgba(198, 222, 192, 0.75);
	box-shadow: 10px 10px 5px 0px rgba(198, 222, 192, 0.75);
}

.pane input {
	width: 85%;
	padding: 6px;
	margin: 10px 0px;
	text-align: center;
}
</style>
</head>
<body class="pane">
	<jsp:useBean id="pojo" class="demo.Pojo"></jsp:useBean>
	<jsp:setProperty property="*" name="pojo" />
	<form>
		<input type="text" name="prop" placeholder="Prop"/> 
		<input type="text" name="name" placeholder="Name"/>
		<input type="text" name="no" placeholder="int no"/> 
		<input type="submit" />
	</form>
	<h5>The value entered :</h5>
	<div><jsp:getProperty name="pojo" property="prop"></jsp:getProperty></div>
	<div><jsp:getProperty name="pojo" property="name"></jsp:getProperty></div>
	<div><jsp:getProperty name="pojo" property="no"></jsp:getProperty></div>
</body>
</html>