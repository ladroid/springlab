<%--
  Created by IntelliJ IDEA.
  User: lado
  Date: 2019-05-13
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>
<h2>Result</h2>
<c:forEach items="${borrow}" var="borrow">
    <table>
        <tr>
            <td>${borrow.name}</td>
            <td>${borrow.surname}</td>
            <td>${borrow.email}</td>
        </tr>
    </table>
</c:forEach>
</body>
</html>
