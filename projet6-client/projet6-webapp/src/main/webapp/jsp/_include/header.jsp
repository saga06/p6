<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 29/04/2018
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="library-webapp">${application.name}</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <script type="text/javascript">
                    $(document).ready(function () {
                        if(window.location.href.indexOf("library-webapp/library-webapp") > -1) {
                            $('ul li:not(:nth-child(2))').removeClass('active');
                        }
                        if(window.location.href.indexOf("book_list") > -1) {
                            $('ul li:not(:nth-child(3))').removeClass('active');
                        }
                        if(window.location.href.indexOf("book_search") > -1) {
                            $('ul li:not(:nth-child(4))').removeClass('active');
                        }
                        if(window.location.href.indexOf("about") > -1) {
                            $('ul li:not(:nth-child(5))').removeClass('active');
                        }
                        if(window.location.href.indexOf("profil") > -1) {
                            $('ul li:not(:nth-child(99))').removeClass('active');
                        }
                    });
                </script>
                <li class="active">
                    <s:a href="library-webapp">
                        <s:text name="nav.homepage" />
                    </s:a>
                </li>
                <li class="active">
                    <s:a action="book_list">
                        <s:text name="nav.listBook" />
                    </s:a>
                </li>
                <li class="active">
                    <s:a action="book_search">
                        <s:text name="nav.searchBook" />
                    </s:a>
                </li>
                <li class="active">
                    <s:a action="about">
                        <s:text name="nav.about" />
                    </s:a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown language-selector">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" data-close-others="true">
                        <span class="glyphicon glyphicon-globe"></span>  <s:text name="nav.language" />
                    </a>
                    <ul class="dropdown-menu pull-right">
                        <li>
                            <s:a action="index">
                                <img src="img/ico/en.ico" class="limit-width" />
                                <s:param name="request_locale">en</s:param>
                                <span><s:text name="lang.en" /></span>
                            </s:a>
                        </li>
                        <li>
                            <s:a action="index">
                                <img src="img/ico/fr.ico" class="limit-width" />
                                <s:param name="request_locale">fr</s:param>
                                <span><s:text name="lang.fr" /></span>
                            </s:a>
                        </li>
                        <li>
                            <s:a action="index">
                                <img src="img/ico/sp.ico" class="limit-width" />
                                <s:param name="request_locale">fr</s:param>
                                <span><s:text name="lang.sp" /></span>
                            </s:a>
                        </li>
                    </ul>
                </li>
                <s:if test="#session.user">
                    <li class ="my-profil dropdown white">
                        <s:a action="profil" class="dropdown-toogle" data-toggle="dropdown" role="button" aria-expanded="false">
                            <span class="glyphicon glyphicon-user"></span>
                            <s:property value="#session.user.surname"  />
                            <span class="caret"></span>
                        </s:a>
                        <ul class="dropdown-menu black" role="menu">
                            <li>
                                <s:a action="profil">
                                    <s:param name="id" value="#session.user.id"/>
                                    <s:text name="nav.profil" />
                                </s:a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <s:a action="logout"><s:text name="nav.logout" /></s:a>
                            </li>
                        </ul>
                    </li>
                </s:if>
                <s:else>
                    <li class ="my-profil white">
                        <s:a action="login">
                             <span class="glyphicon glyphicon-user"></span> <s:text name="nav.login" />
                        </s:a>
                    </li>
                </s:else>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<s:actionerror/>
<s:actionmessage/>