<%--
  Created by IntelliJ IDEA.
  User: macnaer
  Date: 09.07.2020
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp"%>
<!-- Start Contact Us  -->
<div class="container-wrapper">
    <div class="container col-md-4">
        <div id="login-box" class="login-box">

            <h2 class="login-head" style="text-align: center"><b>Login</b></h2>

            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
                <c:if test="${not empty error}">
                    <div class="" style="color: #ff0000;">${error}</div>
                </c:if>
                <div class="form-group">
                    <label for="username">User: </label>
                    <input type="text" id="username" name="username" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" class="form-control" />
                </div>

                <input type="submit" value="Login" class="btn btn-success btn-login">

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>

        </div>
    </div>
</div>
<!-- End Cart -->
<%@include file="templates/footer.jsp"%>