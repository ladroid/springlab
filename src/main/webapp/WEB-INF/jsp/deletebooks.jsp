<%--
  Created by IntelliJ IDEA.
  User: lado
  Date: 2019-05-20
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete book</title>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form:form method="post" action="/springlab_war_exploded/nadmin" modelAttribute="deletingbook">
    <fieldset>
        <center>
        <div id="legend">
            <legend class="">Admin</legend>
        </div>
        <h2>Delete book</h2>
        </center>

        <center>
            <div class="control-group">
                <!-- Delete name -->
                <div class="controls">
                    <form:label path="name">Name:</form:label>
                    <form:input path="name"/>
                    <p class="help-block">Name of book can contain only letters</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-success" name="submit" value="submit">Submit</button>
                </div>
            </div>
        </center>
    </fieldset>
</form:form>
</body>
</html>
