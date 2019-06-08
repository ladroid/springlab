<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lado
  Date: 2019-06-07
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Leave book</title>
</head>
<body>
    <form:form class="form-horizontal" action='/springlab_war_exploded/nmain' method="POST" modelAttribute="leaving">
        <fieldset>
            <div id="legend">
                <legend class="">Leave book</legend>
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
