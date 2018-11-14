<%--
  Created by IntelliJ IDEA.
  User: sgahama
  Date: 11/05/2018
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_include/head.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<body>
<%@ include file="_include/header.jsp" %>
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="style/util.css">
<link rel="stylesheet" type="text/css" href="style/main.css">
<!--===============================================================================================-->


<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100 p-b-160 p-t-50">
            <s:form action="login" class="login100-form validate-form">
                <span class="login100-form-title p-b-43">
                    Account Login
                </span>
                <div class="wrap-input100 rs1 validate-input" data-validate = "Username is required">
                    <s:textfield theme="simple" name="email" cssClass="input100" label="Identifiant" requiredLabel="true" required="true" />
                    <span class="label-input100">Username</span>
                </div>
                <div class="wrap-input100 rs2 validate-input" data-validate="Password is required">
                    <s:password  theme="simple" class="input100" type="password" name="password" requiredLabel="true" required="true" />
                    <span class="label-input100">Password</span>
                </div>
                <div class="container-login100-form-btn">
                    <s:submit theme="simple" class="login100-form-btn" value="Sign in"/>
                </div>
            </s:form>
            <span style="text-align: center;"><s:fielderror fieldName="login.name" cssClass="col-xs-12 errorMessage"/></span>
        </div>
    </div>
</div>

<script src="js/main.js"></script>
<%@ include file="_include/footer.jsp" %>
</body>
</html>