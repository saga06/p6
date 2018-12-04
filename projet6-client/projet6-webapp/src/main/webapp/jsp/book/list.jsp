<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 10/05/2018
  Time: 03:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../_include/head.jsp"%>
<body>
<%@ include file="../_include/header.jsp" %>
<div class="container" id="main-content">
    <h2><s:text name="listBook"/></h2>
    <table id="table" class="table table-dark">
        <thead class="thead-dark">
            <tr>
                <th scope="col">Titre</th>
                <th scope="col">Auteur(s)</th>
                <th scope="col">Editeur</th>
                <th scope="col">Thème(s)</th>
                <th scope="col">ISBN</th>
                <th scope="col">Nb d'exemplaire(s) total</th>
                <th scope="col">Nb d'exemplaire(s) déjà emprunté(s)</th>
                <th scope="col">Nb d'exemplaire(s) disponible(s)</th>
                <th scope="col" style="text-align:center">Vous souhaitez l'emprunter ?</th>
            </tr>
        </thead>
        <tbody>
        <s:iterator value="listBook">
            <tr class="table-primary">
                    <td>
                        <s:property value="title"/>
                    </td>
                    <td>
                          <s:iterator value="authors" status="loop">
                              <s:if test="#loop.last == true ">
                                  <s:property value="name" />
                              </s:if>
                              <s:else>
                                  <s:property value="name" />,
                              </s:else>
                          </s:iterator>
                    </td>
                    <td>
                        <s:property value="editorName"/>
                    </td>
                    <td>
                        <s:iterator value="themes" status="loop">
                            <s:if test="#loop.last == true ">
                                <s:property value="name" />
                            </s:if>
                            <s:else>
                                <s:property value="name" />,
                            </s:else>
                        </s:iterator>
                    </td>
                    <td>
                        <s:property value="isbn"/>
                    </td>
                    <td style="text-align: center">
                         <s:property value="numberOfCopies"/>
                    </td>
                    <td style="text-align: center">
                        <s:property value="nbOfCopiesAlreadyBorrowed"/>
                    </td>
                    <s:if test="nbOfCopiesAvailable >= 4">
                        <td style="text-align: center; color:limegreen">
                            <b><s:property value="nbOfCopiesAvailable"/></b>
                        </td>
                    </s:if>
                    <s:elseif test="nbOfCopiesAvailable >= 3 && nbOfCopiesAvailable < 4">
                        <td style="text-align: center; color:gold">
                            <b><s:property value="nbOfCopiesAvailable"/></b>
                        </td>
                    </s:elseif>
                    <s:elseif test="nbOfCopiesAvailable > 0 && nbOfCopiesAvailable < 3">
                        <td style="text-align: center; color:orange">
                            <b><s:property value="nbOfCopiesAvailable"/></b>
                        </td>
                    </s:elseif>
                    <s:elseif test="nbOfCopiesAvailable == 0">
                        <td style="text-align: center; color:red">
                            <b><s:property value="nbOfCopiesAvailable"/></b>
                        </td>
                    </s:elseif>
                    <td style="text-align: center">
                        <s:if test="#session.user">
                            <s:if test="%{nbOfCopiesAvailable!=0}">
                                <s:a cssClass="btn btn-info" action="borrow_new">
                                    <s:param name="id" value="id" />
                                    <s:param name="idUser" value="#session.user.id" />
                                    Emprunter
                                </s:a>
                            </s:if>
                            <s:else>
                                <s:a cssClass="btn btn-warning" action="reservation_new">
                                    <s:param name="id" value="id" />
                                    <s:param name="idUser" value="#session.user.id" />
                                    Réserver*
                                </s:a>
                            </s:else>
                        </s:if>
                        <s:else>
                            <p>Vous devez vous identifiez d'abord !</p>
                        </s:else>
                    </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
    <div>* = Cet ouvrage n'est actuellement pas disponible, mais vous pouvez le réserver et ainsi vous inscrire dans une liste d'attente.</br>
    Vous serez alors averti dès qu'il sera disponible par email, et vous aurez 48H pour venir le récupérer</div>
</div>
<%@ include file="../_include/footer.jsp" %>
</body>
</html>
