<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lado
  Date: 2019-05-19
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <div id="legend">
        <center>
            <legend class="">Admin</legend>
        </center>
    </div>
    <center><h2>Main Menu Admin</h2></center>
    <center>
        <li><a href="addauth">Add author</a></li>
        <li><a href="addbooks">Add book</a></li>
        <li><a href="deleteauth">Delete author</a></li>
        <li><a href="deletebooks">Delete book</a> </li>
        <li><a href="borrow">Borrow</a></li>
    </center>
</body>
</html>
