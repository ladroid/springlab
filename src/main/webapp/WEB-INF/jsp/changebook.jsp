<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lado
  Date: 2019-05-27
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change book</title>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <form:form class="form-horizontal" action='/springlab_war_exploded/changebook' method="POST" modelAttribute="changing">
        <fieldset>
            <div id="legend">
                <legend class="">Change book</legend>
            </div>

            <div class="control-group">
                <!-- id -->
                <label class="control-label"  for="point">Choose a new book:</label>
                <div class="controls">
                    <input type="text" id="point" name="point" placeholder="Enter point of book" class="input-xlarge">
                    <p class="help-block">Choose a book</p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="email">Email:</label>
                <div class="controls">
                    <input type="email" id="email" name="email" placeholder="Enter your email again" class="input-xlarge">
                    <p class="help-block">Enter your email again</p>
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
