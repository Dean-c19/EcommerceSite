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

<h1>Profile Page, Viewing and Managing</h1>
Logged in as <s:property value="username" />! <br/>

<s:form action="logoff">
  <s:submit value="Logoff"/>
</s:form>
<h3> add an item for sale </h3>
<s:form action="getProductForSale">
  <s:textfield name="productName" label="Product Name" />
  <s:textfield name="price" label="Price" />
  <s:textfield name="sellerName" label="Seller Name" />
  <s:submit value="Add Product" />
</s:form>


<h3>Place a bid</h3>
<s:form action="placeBid">
  <s:textfield name="productName" label="Product Name" />
  <s:textfield name="biddersName" label="Your Name" />
  <s:textfield name="bidAmount" label="Bid Amount" />
  <s:submit value="Place Bid" />
</s:form>

<h3>View another Users Profile</h3>
<s:form action="viewOtherProfile">
  <s:textfield name="username" label="Enter Another Username" />
  <s:submit value="View Others Profile" />
</s:form>


<h3>View my Profile or Another Users</h3>
<table>
  <tr>
    <td>Username</td>
    <td><s:property value="username" /></td>
  </tr>
  <tr>
    <td>Password</td>
    <td><s:property value="password" /></td>
  </tr>
</table>
<h3>All Users</h3>

<table>
  <tr>
    <th>Username</th>
    <th>Password</th>
  </tr>
  <s:iterator value="allUsers">
    <tr>
      <td><s:property value="username" /></td>
      <td><s:property value="password" /></td>
    </tr>
  </s:iterator>
</table>
<s:form action="viewAllUsers">
  <s:submit value="View All Users" />
</s:form>

<h3>All Items</h3>


<table>
  <tr>
    <th>Product Name</th>
    <th>Price</th>
    <th>Seller Name</th>
  </tr>
  <s:iterator value="allItems">
    <tr>
      <td><s:property value="productName" /></td>
      <td><s:property value="price" /></td>
      <td><s:property value="sellerName" /></td>
    </tr>
  </s:iterator>
</table>
<s:form action="viewAllItems">
  <s:submit value="View All Items" />
</s:form>

<s:form action="getProductForSale">
  <s:textfield name="productName" label="Product Name" />
  <s:textfield name="price" label="Price" />
  <s:textfield name="sellerName" label="Seller Name" />
  <s:submit value="Add Product" />
</s:form>

<s:form action="placeBid">
  <s:textfield name="productName" label="Product Name" />
  <s:textfield name="biddersName" label="Your Name" />
  <s:textfield name="bidAmount" label="Bid Amount" />
  <s:textfield name="sellerName" label="Seller Name" />
  <s:submit value="Place Bid" />
</s:form>






</body>
</html>

