    <%--
      Created by IntelliJ IDEA.
      User: sgahama
      Date: 29/04/2018
      Time: 19:44
      To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ include file="../_include/head.jsp"%>
    <link rel="stylesheet" href="style/about.css" />

    <body>
        <%@ include file="../_include/header.jsp" %>

        <div id="container">
            <div id="num1">
                <video id="vid" src="img/video.mp4" autoplay loop width="100%">
                    Il est temps de mettre à jour votre navigateur !
                </video>
            </div>
            <div id="num2" >
                <h3>Site réalisé par OpenClassrooms. <br>N'hésitez pas à nous contacter en cas de besoin à l'adresse :
                <br> hello@openclassrooms.com<br> ou au numéro : +33 1 80 88 80 30 <br>
                </h3>
            </div>
        </div>

        <%@ include file="../_include/footer.jsp" %>
    </body>
</html>