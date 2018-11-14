<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 29/04/2018
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse navbar-fixed-bottom footer">
    <div class="container">
        <p>
            ${application.name} - version ${project.version}
            &copy; <a href="${organization.url}">${organization.name}</a>
            Date du build : ${timestamp}
        </p>
        <%--Décommenter la partie en dessous si vous voulez afficher l'aide au debug de struts--%>
        <%--<s:debug/>--%>
    </div>
</nav>

