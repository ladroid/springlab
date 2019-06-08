<%--
  Created by IntelliJ IDEA.
  User: lado
  Date: 2019-05-19
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete author</title>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form:form method="post" action="/springlab_war_exploded/admins" modelAttribute="deletingauthor">
    <fieldset>
        <center>
        <div id="legend">
            <legend class="">Admin</legend>
        </div>
        <h2>Delete author</h2>
        </center>

        <center>
            <div class="control-group">
                <!--delete id -->
                <div class="control-group">
                    <!-- name -->
                    <div class="controls">
                        <form:label path="surname">Delete name:</form:label>
                        <form:input path="surname"/>
                        <p class="help-block">First name can contain any letters or numbers, without spaces</p>
                    </div>
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
