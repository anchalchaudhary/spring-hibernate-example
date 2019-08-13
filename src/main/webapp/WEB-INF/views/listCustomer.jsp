<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
</head>
<body>
<h3>Customer List</h3>

<h4>Add new? <a href="addCustomerForm">Add New Customer</a>
</h4>
<c:if test="${!empty listCustomers}">
	<table class="tg">
	<tr>
		<th>Customer ID</th>
		<th>Name</th>
		<th>Contact No.</th>
		<th>Street 1</th>
		<th>Street 2</th>
		<th>City</th>
		<th>State</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${listCustomers}" var="customer">
		<tr>
			<td>${customer.customerId}</td>
			<td>${customer.name}</td>
			<td>${customer.contact}</td>
			<td>${customer.street1}</td>
			<td>${customer.street2}</td>
			<td>${customer.city}</td>
			<td>${customer.state}</td>
			<td><a href="<c:url value='/edit/${customer.customerId}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${customer.customerId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>