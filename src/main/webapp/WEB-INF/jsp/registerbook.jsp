<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lado
  Date: 2019-06-02
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Book</title>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<%--<form:form class="form-horizontal" action='/springlab_war_exploded/login' method="post">--%>
<form:form class="form-horizontal" action="/springlab_war_exploded/login" method="post" modelAttribute="newborrow">
    <fieldset>
        <div id="legend">
            <legend class="">Register Book</legend>
        </div>

        <div class="control-group">
            <!-- id -->
            <%--<label class="control-label"  for="borrowid">Borrow Id:</label>--%>
            <div class="controls">
                <form:label path="id">Borrow Id:</form:label>
                <form:input path="id"/>
                <%--<input type="number" id="borrowid" name="borrowid" placeholder="" class="input-xlarge">--%>
                <p class="help-block">Enter borrow id(it is your id)</p>
            </div>
        </div>

        <div class="control-group">
            <!-- name -->
            <%--<label class="control-label"  for="personid">Person Id:</label>--%>
            <div class="controls">
                <form:label path="studentid">Person Id:</form:label>
                <form:input path="studentid"/>
                <%--<input type="number" id="personid" name="personid" placeholder="" class="input-xlarge">--%>
                <p class="help-block">Eneter person id(it is your id)</p>
            </div>
        </div>

        <div class="control-group">
            <!-- surname -->
            <%--<label class="control-label"  for="bookid">Book Id:</label>--%>
            <div class="controls">
                <form:label path="bookid">Book Id:</form:label>
                <form:input path="bookid"/>
                <%--<input type="number" id="bookid" name="bookid" placeholder="" class="input-xlarge">--%>
                <p class="help-block">Enter book id</p>
            </div>
        </div>

        <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <button class="btn btn-success" name="submit" value="submit">Submit</button>
            </div>
        </div>
    </fieldset>
</form:form>
</body>
</html>

