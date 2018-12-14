<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 10/05/2018
  Time: 05:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../_include/head.jsp"%>
<div>
<%@ include file="../_include/header.jsp" %>
<div class="container" id="main-content">
    <s:actionmessage />

<div style="font-size: 0.8em">
    <h5>Le saviez-vous ? :</h5>
    <p>Vous avez la possibilité d'activer ou non, un email de rappel lorsque vous vous approchez de la date limite de vos prêts.
       Ceci vous permet de ne pas vous souciez de cette date, et d'être rappelé automatiquement, par email, 5 jours avant la date butoire.
       Cette option est activée par défault pour chaque utilisateur.
    Vous pouvez modifier cette option ici :
            <s:a cssClass="btn btn-success btn-xs" action="change_reminder_status_to_true"  data-toggle="modal" data-target="#myModalActivation">
                <s:param name="idUser" value="#session.user.id" />
                Activer
            </s:a>
            <s:a cssClass="btn btn-danger btn-xs" action="change_reminder_status_to_false" data-toggle="modal" data-target="#myModalDesactivation">
                <s:param name="idUser" value="#session.user.id" />
            Désactiver
            </s:a>

        <!-- Modal activer -->
        <div class="modal fade" id="myModalActivation" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-c" style="background-color: whitesmoke">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Validation modification </h4>
                    </div>
                    <div class="modal-body">
                        <p>Souhaitez-vous activer le rappel par email ?</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger btn-xs" data-dismiss="modal">Annuler</button>
                        <s:a cssClass="btn btn-success btn-xs" action="change_reminder_status_to_true" >
                            <s:param name="idUser" value="#session.user.id" />
                            Activer
                        </s:a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal désactvier -->
        <div class="modal fade" id="myModalDesactivation" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-c" style="background-color: whitesmoke">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Validation modification </h4>
                    </div>
                    <div class="modal-body">
                        <p>Souhaitez-vous désactiver le rappel par email ?</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger btn-xs" data-dismiss="modal">Annuler</button>
                        <s:a cssClass="btn btn-primary btn-xs" action="change_reminder_status_to_false">
                            <s:param name="idUser" value="#session.user.id" />
                            Désactiver
                        </s:a>
                    </div>
                </div>
            </div>
        </div>
    </p>
</div>


    <h3><s:text name="myListBook"/></h3>
    <table id="table" class="table table-dark">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Titre</th>
            <th scope="col">Auteur(s)</th>
            <th scope="col">Editeur</th>
            <th scope="col">Thème(s)</th>
            <th scope="col" style="text-align: center">Date début d'emprunt</th>
            <th scope="col" style="text-align: center">Date limite de retour</th>
            <th scope="col" style="text-align: center; min-width:80px">État du prêt</th>
            <th scope="col" style="text-align: center">Vous souhaitez prolonger votre prêt ?</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="listBookBorrowedByUser">
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
                <td style="text-align: center">
                    <s:date name="dateStart.toGregorianCalendar.time" format="dd/MM/yyyy"/>
                </td>
                <td style="text-align: center">
                    <s:date name="dateEnd.toGregorianCalendar.time" format="dd/MM/yyyy" />
                </td>
                <td style="text-align: center">
                    <s:set var="currentDate" value="currentDate"/>
                    <s:set var="dateEnd" value="dateEnd"/>
                    <s:if test="%{returned==false}">
                        <s:if test="%{#dateEnd.toGregorianCalendar.time > #currentDate.toGregorianCalendar.time}">
                            <div>En cours</div>
                        </s:if>
                        <s:else>
                            <div style="color:red"><b>En retard !</b></div>
                        </s:else>
                    </s:if>
                    <s:else>
                        <p>Ouvrage rendu
                        <s:if test="%{returnedOnTime==false}">
                            (en retard)</p>
                        </s:if>
                        <s:else>
                            (dans les temps)</p>
                        </s:else>
                    </s:else>
                </td>
                <td style="text-align: center">
                    <s:if test="%{alreadyExtended==false}">
                        <s:if test="%{returned==false}">

                            <s:if test="%{#dateEnd.toGregorianCalendar.time >= #currentDate.toGregorianCalendar.time}">
                                <s:a cssClass="btn btn-info" action="borrow_extend">
                                    <s:param name="id" value="idBorrow" />
                                    Prolonger
                                </s:a>
                            </s:if>
                            <s:else>
                                <div style="color:red"><b>Impossible, vous avez dépassé la date limite</b></div>
                            </s:else>
                        </s:if>
                        <s:else>
                            <span>Vous avez déjà rendu votre prêt</span>
                        </s:else>
                    </s:if>
                    <s:else>
                        <span>Vous avez déjà prolongé votre prêt une fois</span>
                    </s:else>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>





    <h3 style="margin-top: 60px;"><s:text name="myListReservedBook"/></h3>


    <table id="table" class="table table-dark">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Titre</th>
            <th scope="col">Statut Réservation</th>
            <th scope="col" style="text-align: center">Date de la réservation</th>
            <th scope="col" style="text-align: center">Date de retour prévu</th>
            <th scope="col" style="text-align: center">Position liste d'attente</th>
            <th scope="col" style="text-align: center">Vous souhaitez annuler votre réservation ?</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="listBookReservedByUser">
            <tr class="table-primary">
                <td>
                    <s:property value="title"/>
                </td>
                <td>
                    <s:if test="%{active==true}">
                    <p>Active</p>
                    </s:if>
                    <s:else>
                        <p>Annulée</p>
                    </s:else>
                </td>
                <td style="text-align: center">
                    <s:date name="dateOfReservation.toGregorianCalendar.time" format="dd/MM/yyyy" />
                </td>
                <td style="text-align: center">
                    <s:date name="dateReturn.toGregorianCalendar.time" format="dd/MM/yyyy" />
                </td>
                <td style="text-align: center">
                        <s:property value="position + 1"/>
                </td>
                <td style="text-align: center">
                    <s:a cssClass="btn btn-danger" action="reservation_cancel">
                        <s:param name="id" value="idReservation" />
                        Annuler
                    </s:a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</div>
<%@ include file="../_include/footer.jsp" %>
</body>
</html>
