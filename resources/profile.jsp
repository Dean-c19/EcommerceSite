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

<h1>Profile Page, view bids and an item</h1>
Logged in as <s:property value="username" />! <br/>

<s:form action="logoff">
  <s:submit value="Logoff"/>
</s:form>




</body>
</html>

