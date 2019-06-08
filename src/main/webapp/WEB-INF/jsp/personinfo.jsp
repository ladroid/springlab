<%--
  Created by IntelliJ IDEA.
  User: lado
  Date: 2019-05-21
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Personinfo</title>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form class="form-horizontal" action='' method="POST">
    <fieldset>
        <div id="legend">
            <legend class="">Person Info</legend>
        </div>
        <div class="img">

            <img th:src="@{/resources/images/person.png}"/>
        </div>
        <div class="container">
            <div class="alert alert-success alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                <%
                    com.lab.lado.dbconnect.dbconnection.DBConnect dbConnect = new com.lab.lado.dbconnect.dbconnection.DBConnect();
                    String email1 = request.getParameter("email");
                    Date today = new Date();
                    Calendar cal = new GregorianCalendar();
                    cal.setTime(today);
                    cal.add(Calendar.DAY_OF_MONTH, -30);
                    Date today30 = cal.getTime();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                    Timestamp time = dbConnect.getTimeTakeBook(email1);
                    Date date = new Date();
                    date.setTime(time.getTime());

                    String formattedday = new SimpleDateFormat("yyyy-MM-dd").format(date);

                    if(dateFormat.format(today30).equals(formattedday)) {
                %>
                <div class="alert alert-warning alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <%
                        out.println("Please choose new book");
                    %>
                </div>
                <%
                    } else {
                        out.print("Days to bring " + dateFormat.format(today30));
                    }
                %>
            </div>
        </div>

        <div class="control-group">
            <!-- get name -->
            <div class="controls">
                <c:forEach items="${info}" var="personinfo">
                    <table>
                    <tr>
                        <td>${personinfo.name}</td>
                        <td>${personinfo.surname}</td>
                        <td>${personinfo.email}</td>
                        <td>${personinfo.phonenumber}</td>
                    </tr>
                    </table>
                </c:forEach>
            </div>
        </div>
        <div class="control-group">
            <!-- taken book-->
            <div class="controls">
                <%
                    com.lab.lado.dbconnect.dbconnection.DBConnect connect = new com.lab.lado.dbconnect.dbconnection.DBConnect();
                %>
                <table>
                    <tr>
                        <td>
                            <%out.println("Taken book is " + '"' + connect.taken_book(request.getParameter("email")) + '"');%>
                            <a href="changebook">Change book</a>
                            <a href="leavebook">Leave book</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="container">
            <p>Books:</p>
            <ol>
                <%
                    for(int i =0; i<connect.getBook().size(); i++) {
                        out.println("<ul>" + "<li>" + connect.getBook().get(i) + "<br>" + "</li>" + "</ul>");
                    }
                %>
            </ol>
        </div>
    </fieldset>
</form>
</body>
</html>
