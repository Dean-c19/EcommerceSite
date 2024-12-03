<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>E-Commerce site</title>
</head>
<body>
<h1>Home Page</h1>
Login or register below
<s:form action="login">
    <s:textfield name="username" label="Username"/>
    <s:textfield name="password" label="Password"/>
    <s:submit/>
</s:form>

</body>
</html>




















