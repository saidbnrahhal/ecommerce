<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>name</th>
			<th>money</th>
			<th>code</th>
			<th>actions</th>
		</tr>
		<c:forEach items="${comptes}" var="compte">
		<tr>	
			<td>${compte.name}</td>
			<td>${compte.money}</td>
			<td>${compte.codeBancaire}</td>
			<td>
			<form action="AddCompte" method="post"><input type="submit" value="delet" title="delet">
			<input type="hidden" name="id" value="${compte.id}">
			<input type="hidden" name="action" value="delet">
			</form>
			</td>
		</tr>
		</c:forEach>
		<tr>
		<form action="AddCompte" method="post">
		<td><input type="text" name="name"></td>
		<td><input type="text" name="money"></td>
		<td><input type="text" name="code"></td>
		<td><input type="hidden" name="action" value="add"><input type="submit" value="add account">
		</td>
		</form>
		</tr>
	</table>
	
</body>
</html>