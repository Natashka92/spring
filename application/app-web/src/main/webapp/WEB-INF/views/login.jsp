<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="app.login.body.title" /></title>
    <link href="<c:url value="/resources/bootstrap/bootstrap.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/resources/bootstrap/bootstrap-responsive.min.css" />" rel="stylesheet"  type="text/css" />
</head>
<body>
<div class="container">
    <spring:message code="app.login.body.title" var="title"/>
    <spring:message code="app.login.user.name" var="name"/>
    <spring:message code="app.login.user.password" var="password"/>
    <spring:message code="app.login.button.enter" var="enter"/>
    <spring:message code="label.user.registration" var="registation"/>

    <div id="login-body-panel" class="well">
        <h3>${title}</h3>
        <form action="j_spring_security_check" method="post" class="form-horizontal">
            <div id="login-panel">
                <div class="form-group">
                    <div class="col-lg-12">
                        <input class="form-control" name="j_username" type="text" value="" placeholder="${name}" /><br />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-12">
                        <input class="form-control" name="j_password" type="password" value="" placeholder="${password}"/>
                    </div>
                </div>
            </div>
            <div style="padding: 7px 0;">
                <c:if test="${not empty errorMessage}">
                    <div style="color: red;">
                        ${errorMessage}
                    </div>
                </c:if>
                <input type="submit" name="submit" value="${enter}" class="btn btn-success" />
            </div>
        </form>
        <a href="/registration">${registation}</a>
    </div>
</div>
</body>
</html>
