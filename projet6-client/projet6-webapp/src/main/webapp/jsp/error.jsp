<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 10/05/2018
  Time: 03:16
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="_include/head.jsp"%>
<body>
<%@ include file="_include/header.jsp" %>
<div class="container" id="main-content">
    <h2><s:text name="error.title" /></h2>

    <s:actionerror />

    <s:bean name="java.util.Date" var="now" />
    <s:text name="error.metadata">
        <s:param value="now" />
    </s:text>
</div>
<%@ include file="_include/footer.jsp" %>
</body>
</html>
