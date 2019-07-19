<%--
  Created by IntelliJ IDEA.
  User: valentin
  Date: 19/07/19
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Yoda</title>
    </head>
    <body>
        <p>JDBC</p>
        <ul>
            <c:forEach items="${jedi}" var="jedi">
               <li>${jedi}</li>
            </c:forEach>
        </ul>
    </body>
</html>
