<%--
  Created by IntelliJ IDEA.
  User: lado
  Date: 2019-05-19
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Borrow</title>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form:form method="post" action="/springlab_war_exploded/res" modelAttribute="borrowing">
    <fieldset>
        <div id="legend">
            <center>
                <legend class="">Borrow</legend>
            </center>
        </div>

        <center>
            <div class="control-group">
                <!-- Email -->
                <div class="controls">
                    <form:input path="email"/>
                    <%--<input type="borrow" id="borrow" name="borrow" placeholder="Search borrow" class="input-xlarge">--%>
                    <p class="help-block">Enter a borrow</p>
                </div>
            </div>
            <div class="control-group">
                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-success" name="submit" value="submit">Go</button>
                </div>
            </div>
            <%
                com.lab.lado.dbconnect.dbconnection.DBConnect connect = new com.lab.lado.dbconnect.dbconnection.DBConnect();
                for(int i=0; i<connect.getBorrowsStudent().size(); i++) {
                    out.println(connect.getBorrowsStudent().get(i) + "<br>");
                }
            %>
        </center>
    </fieldset>
</form:form>
</body>
</html>
