<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 11/05/2018
  Time: 04:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../_include/head.jsp"%>

<body>
<%@ include file="../_include/header.jsp" %>
<s:actionerror />
<s:actionmessage />

<div class="container" id="main-content">
    <h2>Formulaire d'inscription</h2>
    <s:form action="book_new">
        <s:textfield name="book.nom" label="Nom" requiredLabel="true" />
        <s:select name="book.user.id" label="User"
                  list="listUser" listKey="id" listValue="prenom"
                  emptyOption="true"
                  requiredLabel="true" />
        <s:checkbox name="book.cloture" label="Cloturé" />
        <s:submit value="OK" />
    </s:form>

</div>

<%@ include file="../_include/footer.jsp" %>
</body>
</html>
