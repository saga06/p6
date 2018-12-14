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
                <th scope="col">Id</th>
                <th scope="col">Titre</th>
                <th scope="col" style="min-width: 150px">Auteur(s)</th>
                <th scope="col">Editeur</th>
                <th scope="col" style="min-width: 150px">Thème(s)</th>
                <th scope="col">ISBN</th>
                <th scope="col">Nb d'exemplaire(s) total</th>
                <th scope="col">Nb d'exemplaire(s) déjà emprunté(s)</th>
                <th scope="col">Nb d'exemplaire(s) disponible(s)</th>
                <th scope="col">Nb de réservation(s)</th>
                <th scope="col" style="text-align:center">Vous souhaitez l'emprunter ?</th>
            </tr>
        </thead>
        <tbody>
        <div>
            <span style="text-align: center;"><s:fielderror fieldName="statusBorrow" cssClass="col-xs-12 errorMessage"/></span>
        </div>
        <s:iterator value="listBook">
            <tr class="table-primary">
                <td>
                    <s:property value="id"/>
                </td>
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
                    <s:property value="nbOfActiveReservation"/>
                </td>
                <td style="text-align: center; vertical-align: middle">
                    <s:if test="#session.user">
                        <s:if test="%{nbOfCopiesAvailable!=0}">
                            <s:set var="idBookOftheList" value="id"/>
                            <s:set var="presentInBoorowedList" value="0"/>
                            <s:iterator value="listBookBorrowedByUser">
                                <s:set var="idBookAlreadyBorrowed" value="id"/>
                                <s:if test="%{#idBookOftheList==#idBookAlreadyBorrowed}">
                                    <s:set var="presentInBoorowedList" value="1"/>
                                </s:if>
                            </s:iterator>
                            <s:if test="%{#presentInBoorowedList==1}">
                                <p>Vous avez déjà emprunté ce livre</p>
                            </s:if>
                            <s:else>
                                <s:a cssClass="btn btn-info" action="borrow_new" data-toggle="modal">
                                    <s:param name="id" value="id" />
                                    <s:param name="idUser" value="#session.user.id" />
                                    Emprunter
                                </s:a>
                            </s:else>
                        </s:if>
                        <s:else>
                            <s:if test="(2*numberOfCopies) > nbOfActiveReservation ">
                                <s:a cssClass="btn btn-warning" action="reservation_new">
                                    <s:param name="id" value="id" />
                                    <s:param name="idUser" value="#session.user.id" />
                                    Réserver *
                                </s:a>
                                <p>Date du prochain retour :</p>
                                <s:date name="dateReturn.toGregorianCalendar.time" format="dd/MM/yyyy" />
                            </s:if>
                            <s:else>
                                Nb de réservation max atteint.</br>
                                Date prochain retour :
                                <s:date name="dateReturn.toGregorianCalendar.time" format="dd/MM/yyyy" />
                            </s:else>
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
