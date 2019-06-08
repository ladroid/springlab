<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lado
  Date: 2019-05-19
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<center><h2>Person Information</h2></center>
<%--<form:form method = "post" action = "/springlab_war_exploded/admin" modelAttribute="person">--%>
<form:form method ="post" modelAttribute="person">
    <fieldset>
        <center>
            <div id="legend">
                <legend class="">Registration</legend>
            </div>
        </center>
        <center>
            <div class="control-group">
                <!-- id -->
                <label class="control-label"  for="id">Id:</label>
                <div class="controls">
                    <input type="number" id="id" name="id" placeholder="" class="input-xlarge">
                    <p class="help-block">Id can contain only numbers</p>
                </div>
            </div>

            <div class="control-group">
                <!-- name -->
                <label class="control-label"  for="name">First name:</label>
                <div class="controls">
                    <input type="text" id="name" name="name" placeholder="" class="input-xlarge">
                    <p class="help-block">First name can contain any letters or numbers, without spaces</p>
                </div>
            </div>

            <div class="control-group">
                <!-- surname -->
                <label class="control-label"  for="surname">Last name:</label>
                <div class="controls">
                    <input type="text" id="surname" name="surname" placeholder="" class="input-xlarge">
                    <p class="help-block">Last name can contain any letters or numbers, without spaces</p>
                </div>
            </div>

            <div class="control-group">
                <!-- E-mail -->
                <label class="control-label" for="email">Email:</label>
                <div class="controls">
                    <input type="email" id="email" name="email" placeholder="" class="input-xlarge">
                    <p class="help-block">Please provide your Email</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Password-->
                <label class="control-label" for="pass">Password:</label>
                <div class="controls">
                    <input type="password" id="pass" name="pass" placeholder="" class="input-xlarge">
                    <p class="help-block">Password should be at least 4 characters</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Date -->
                <label class="control-label"  for="birthdate">Date:</label>
                <div class="controls">
                    <input type="datetime" id="birthdate" name="birthdate" placeholder="" class="input-xlarge">
                    <p class="help-block">Please enter your birthdate</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Sex -->
                <label class="control-label"  for="gender">Sex:</label>
                <div class="controls">
                    <input type="text" id="gender" name="gender" placeholder="" class="input-xlarge">
                    <p class="help-block">Please enter your gender only M or F</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Class -->
                <label class="control-label"  for="job">Job:</label>
                <div class="controls">
                    <input type="text" id="job" name="job" placeholder="" class="input-xlarge">
                    <p class="help-block">Job can contain any letters or numbers, without spaces</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Point -->
                <label class="control-label"  for="point">Point:</label>
                <div class="controls">
                    <input type="number" id="point" name="point" placeholder="" class="input-xlarge">
                    <p class="help-block">Point can contain only numbers</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Phone number -->
                <label class="control-label"  for="phonenumber">Phone number:</label>
                <div class="controls">
                    <input type="tel" id="phonenumber" name="phonenumber" placeholder="" class="input-xlarge">
                    <p class="help-block">Please enter your phone number</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-success" name="submit" value="submit">Next</button>
                </div>
            </div>
        </center>
    </fieldset>
</form:form>
</body>
</html>
