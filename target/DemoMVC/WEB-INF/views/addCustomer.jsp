<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="addCustomer" modelAttribute="customer">
		<table>
			<tr>
				<td><form:label path="fname">
						<spring:message text="First Name" />
					</form:label></td>
				<td><form:input path="fname" /></td>
			</tr>
			<tr>
				<td><form:label path="lname">
						<spring:message text="Last Name" />
					</form:label></td>
				<td><form:input path="lname" /></td>
			</tr>
		</table>
		<input type="submit" value="Add Customer" />
	</form:form>
</body>
</html>