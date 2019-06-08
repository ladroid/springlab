<%--
  Created by IntelliJ IDEA.
  User: lado
  Date: 2019-05-13
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <form:form method="post" action="/springlab_war_exploded/">
        <fieldset>
            <div id="legend">
                <center>
                    <legend class="">Log in</legend>
                </center>
            </div>

            <center>
                <div class="control-label">
                    <!-- Email -->
                    <label class="control-label" for="email">Email:</label>
                    <div class="controls">
                        <input type="email" id="email" name="email" placeholder="" class="input-xlarge">
                        <p class="help-block">Please provide your Email</p>
                    </div>
                </div>
                <div class="control-group">
                    <!-- Password-->
                    <label class="control-label" for="password">Password:</label>
                    <div class="controls">
                        <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
                        <p class="help-block">Password should be at least 4 characters</p>
                    </div>
                </div>
                <div class="control-group">
                    <!-- Button -->
                    <div class="controls">
                        <button class="btn btn-success">Go</button>
                    </div>
                </div>
            </center>
        </fieldset>

        <center>
            <a href="/springlab_war_exploded/registration"/>Registration
        </center>
    </form:form>
</body>
</html>
