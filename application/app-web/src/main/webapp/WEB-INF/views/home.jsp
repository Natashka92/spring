<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true"%>
<html>
<head>
    <title><spring:message code="page.home"/></title>
    <link href="<c:url value="/resources/bootstrap/bootstrap.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/resources/bootstrap/bootstrap.min.css" />" rel="stylesheet"  type="text/css" />
</head>
<body>

<spring:message code="label.hello" var="hello"/>
<spring:message code="label.logout" var="logout"/>
<spring:message code="page.home" var="home"/>
<spring:message code="title.label.pizza" var="pizza"/>
<spring:message code="title.label.user" var="user"/>

<div class="container">

    <%@ include file="common/hello.jsp"%>

    <div class="tabbable">
        <ul class="nav nav-pills">
            <li class="active"><a href="#">${home}</a></li>
            <li><a href="/pizza/list">${pizza}</a></li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li><a href="/user/list">${user}</a></li>
            </sec:authorize>
        </ul>
        <div class ="tab-content">
            ${hello}
        </div>
    </div>

</div>
</body>
</html>