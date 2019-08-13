<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<form:form action="editCustomerDetails" modelAttribute="customer">
		<table>
			<tr>
				<td><form:label path="customerId">
						<spring:message text="Customer ID" />
					</form:label></td>
				<td><form:input path="customerId" readonly="true"
						disabled="true" /> <form:hidden path="customerId" /></td>
			</tr>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="contact">
						<spring:message text="Contact" />
					</form:label></td>
				<td><form:input path="contact" /></td>
			</tr>
			<tr>
				<td><form:label path="street1">
						<spring:message text="Street 1" />
					</form:label></td>
				<td><form:input path="street1" /></td>
			</tr>
			<tr>
				<td><form:label path="street2">
						<spring:message text="Street 2" />
					</form:label></td>
				<td><form:input path="street2" /></td>
			</tr>
			<tr>
				<td><form:label path="city">
						<spring:message text="City" />
					</form:label></td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td><form:label path="state">
						<spring:message text="State" />
					</form:label></td>
				<td><form:input path="state" /></td>
			</tr>
			<tr>
				<td><input type="submit"
					value="<spring:message text="Edit Person"/>" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>