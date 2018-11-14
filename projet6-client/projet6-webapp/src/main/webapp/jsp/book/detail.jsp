<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 10/05/2018
  Time: 03:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../_include/head.jsp"%>
<body>
<%@ include file="../_include/header.jsp" %>
<div class="container" id="main-content">
    <s:actionmessage />
    <h2>Détail de l'ouvrage</h2>
    <ul>
        <li>ID : <s:property value="book.id" /></li>
        <li>Nom : <s:property value="book.nom" /></li>
        <li>ISBN : <s:date name="book.ISBN" /></li>
        <li>
            Auteur :
            <s:a action="user_detail">
                <s:param name="id" value="book.user.id" />
                <s:property value="book.user.prenom"/> <s:property value="book.user.nom"/>
            </s:a>
        </li>
        <li>Cloturé : <s:property value="book.cloture" /></li>
    </ul>
</div>
<%@ include file="../_include/footer.jsp" %>
</body>
</html>
