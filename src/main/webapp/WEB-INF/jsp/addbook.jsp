<%--
  Created by IntelliJ IDEA.
  User: lado
  Date: 2019-05-20
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book</title>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form:form method="post" action="/springlab_war_exploded/admin" modelAttribute="addingbook">
    <fieldset>
        <div id="legend">
            <center>
                <legend class="">Admin</legend>
            </center>
        </div>
        <center><h2>Add book</h2></center>
        <center>
            <div class="control-group">
                <!-- E-mail -->
                <div class="controls">
                    <form:label path="id">Id:</form:label>
                    <form:input path="id"/>
                    <p class="help-block">Id of book can contain only numbers</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Password-->
                <div class="controls">
                    <form:label path="name">Name:</form:label>
                    <form:input path="name"/>
                    <p class="help-block">Name of book can contain only letters</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Date -->
                <div class="controls">
                    <form:label path="pagecount">Pagecount:</form:label>
                    <form:input path="pagecount"/>
                    <p class="help-block">Page of book can contain only numbers</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Sex -->
                <div class="controls">
                    <form:label path="point">Point:</form:label>
                    <form:input path="point"/>
                    <p class="help-block">Point(book's location) can contain only numbers</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Class -->
                <div class="controls">
                    <form:label path="authorid">Author ID:</form:label>
                    <form:input path="authorid"/>
                    <p class="help-block">Author id can contain only numbers</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Point -->
                <div class="controls">
                    <form:label path="typeid">Type ID:</form:label>
                    <form:input path="typeid"/>
                    <p class="help-block">Type(genre of book) id(1-18) can contain only numbers</p>
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    <form:label path="fragment">Fragment of book:</form:label>
                    <form:input path="fragment"/>
                    <p class="help-block">Fragment of book 1000 strokes</p>
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
