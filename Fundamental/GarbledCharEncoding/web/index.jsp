<%--
  Created by IntelliJ IDEA.
  User: Sanstwy27
  Date: 8/18/2020
  Time: 8:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/testPOJO" method="post">
      <!-- The attribute of name value should be consistent with the POJO class -->
      id: <input type="text" name="id"><br>
      last name: <input type="text" name="lastName"><br>
      email: <input type="text" name="email"><br>
      dept id: <input type="text" name="dept.id"><br>
      dept name: <input type="text" name="dept.name"><br>
      <input type="submit">
    </form>
  </body>
</html>
