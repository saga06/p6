<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 10/05/2018
  Time: 03:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>${application.name}</title>
    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous" />
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous" />

    <%--Datatables --%>
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="//datatables.net/download/build/nightly/jquery.dataTables.js"></script>
    <link rel="stylesheet" href="style/style.css" />
    <link rel="stylesheet" href="style/style2.css" />


</head>
<body>
<%@ include file="../_include/header.jsp" %>
<script>
    $(document).ready( function () {
        var GARBAGE = "!)!%&-15-85--)!%&%!*9%&";

        var table = $('#table_id').DataTable( {
            dom: 'l<"custom-search"f>tip'
        });
        table.search( GARBAGE ).draw();

        var newSearch = $('<input type="text">');
        newSearch.on('keyup', function() {
            if ($(this).val().toString().trim() === "")
                table.search( GARBAGE ).draw();
            else
                table.search( $(this).val() ).draw();
        });

        $('.custom-search input').replaceWith( newSearch );

    } );
</script>
<div class="container" id="main-content">
    <h2><s:text name="listBook"/></h2>
    <table id="table_id" class="display">
        <thead>
        <tr>
            <th>Titre</th>
            <th>Auteur</th>
            <th>Editeur</th>
            <th scope="col">Thème(s)</th>
            <th scope="col">Nombre d'exemplaire(s) disponible(s)</th>
            <th scope="col">ISBN</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="listBook">
            <tr>
                <td><s:property value="title"/></td>
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
                        <td style="text-align: center">
                            <s:property value="nbOfCopiesAvailable"/>
                        </td>
                        <td>
                            <s:property value="isbn"/>
                        </td>
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
                                    <p>Plus aucun exemplaire disponible</p>
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
</div>
<%@ include file="../_include/footer.jsp" %>
</body>
</html>
