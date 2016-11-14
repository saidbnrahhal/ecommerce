<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
	<div style="width:80%;margin: auto;">
	<table style="width: 100%;" border="1">
		<tr>
			<th>order id </th>
			<th>actual state </th>
			<th> new state </th>
		</tr>
		<c:forEach items="${listofStat}" var="stat">
		<tr>
			<td>${stat.id}</td>
			<td>${stat.state}</td>
			<td style="width: 400px;">
			<form action="Test" method="post" >
				<input type="hidden" name="id" value="${stat.id}">
				<input type="submit" name="action" value="Pending" />
				<input type="submit" name="action" value="Finalized" />
				<input type="submit" name="action" value="Aborted" />
				<input type="submit" name="action" value="Waiting" />
				<input type="submit" name="action" value="Started" />
			</form>
			</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	
</body>
</html>