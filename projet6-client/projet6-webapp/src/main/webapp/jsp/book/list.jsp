<%--
  created by intellij idea.
  user: sgahama
  date: 10/05/2018
  time: 03:20
  to change this template use file | settings | file templates.
--%>
<%@ page contenttype="text/html;charset=utf-8" language="java" %>
<%@ include file="../_include/head.jsp"%>
<body>
<%@ include file="../_include/header.jsp" %>
<div class="container" id="main-content">
    <h2><s:text name="listbook"/></h2>
    <table id="table" class="table table-dark">
        <thead class="thead-dark">
            <tr>
                <th scope="col">titre</th>
                <th scope="col">auteur(s)</th>
                <th scope="col">editeur</th>
                <th scope="col">thème(s)</th>
                <th scope="col">nb d'exemplaire(s) total</th>
                <th scope="col">nb d'exemplaire(s) déjà emprunté(s)</th>
                <th scope="col">nb d'exemplaire(s) disponible(s)</th>
                <th scope="col">isbn</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
        <s:iterator value="listbook">
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
                        <s:property value="editorname"/>
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
                    <td style="text-align: center">
                         <s:property value="numberofcopies"/>
                    </td>
                    <td style="text-align: center">
                        <s:property value="nbofcopiesalreadyborrowed"/>
                    </td>
                    <td style="text-align: center">
                        <s:property value="nbofcopiesavailable"/>
                    </td>
                    <td>
                        <s:property value="isbn"/>
                    </td>
                    <td style="text-align: center">
                        <s:if test="#session.user">
                            <s:if test="%{nbofcopiesavailable!=0}">
                                <s:a cssclass="btn btn-info" action="borrow_new">
                                    <s:param name="id" value="id" />
                                    <s:param name="iduser" value="#session.user.id" />
                                    emprunter
                                </s:a>
                            </s:if>
                            <s:else>
                                <s:a cssclass="btn btn-warning" action="reservation_new">
                                    <s:param name="id" value="id" />
                                    <s:param name="iduser" value="#session.user.id" />
                                    réserver *
                                </s:a>
                            </s:else>
                        </s:if>
                        <s:else>
                            <p>vous devez vous identifiez d'abord !</p>
                        </s:else>
                    </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</div>
<%@ include file="../_include/footer.jsp" %>
</body>
</html>
