<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title><spring:message code="label.user.list"/></title>
    <link href="<c:url value="/resources/bootstrap/bootstrap.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/resources/bootstrap/bootstrap.min.css" />" rel="stylesheet"  type="text/css" />
    <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script type="text/javascript">
        var Delete = function(event){
            $.ajax({
                url: $(event.target).attr("href"),
                type: "DELETE",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function() {
                    var respContent = "";
                    var rowToDelete = $(event.target).closest("tr");
                    rowToDelete.remove();
                    respContent += "<spring:message code='label.user.delete.success'/>";
                    $("#formResponse").text(respContent).show().delay(2500).fadeOut(2500);
                },
                error: function(xhr, status, err) {
                    $("#formResponse").text(xhr.responseText).show().delay(3500).fadeOut(2500);
                }
            });
            event.preventDefault();
        }
    </script>
</head>

<body>
<div class="container">
    <spring:message code="label.user.list" var="listUserLabel"/>
    <spring:message code="title.label.user.firstName" var="firstName"/>
    <spring:message code="title.label.user.lastName" var="lastName"/>
    <spring:message code="title.label.user.login"  var="login"/>
    <spring:message code="title.label.user.address" var="address"/>
    <spring:message code="title.label.user.id" var="id"/>
    <spring:message code="label.delete" var="delete"/>
    <spring:message code="label.edit" var="edit"/>
    <spring:message code="page.home" var="home"/>
    <spring:message code="title.label.pizza" var="pizza"/>
    <spring:message code="title.label.user" var="user"/>
    <spring:message code="label.user.edit" var="editUserLabel"/>
    <spring:message code="title.label.user.password" var="password"/>
    <spring:message code="button.user.save" var="save"/>
    <spring:message code="label.pizza.list" var="listOfPizzas"/>
    <%@ include file="../common/hello.jsp"%>

    <div class="tabbable">
        <ul class="nav nav-pills">
            <li><a href="/">${home}</a></li>
            <li><a href="/pizza/list">${pizza}</a></li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li class="active"><a href="#">${user}</a></li>
            </sec:authorize>
        </ul>
           <div class ="tab-content">
            <h2>${listUserLabel}</h2>
            <div id="formResponse" style="color: darkgreen;"></div>
            <table class="table table-bordered table-hover table-striped">
                <thead class="success">
                    <tr class="success">
                        <td>${id}</td>
                        <td>${login}</td>
                        <td>${firstName}</td>
                        <td>${lastName}</td>
                        <td>${address}</td>
                        <td></td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.login}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.address}</td>
                            <td>
                                <a href="edit/${user.id}">
                                    <img src="<c:url value='/resources/images/edit.png'/>" width="25px" height="25px" alt="${edit}"/>
                                </a>
                            </td>
                            <td>
                                <img style="cursor: hand;" href="${pageContext.request.contextPath}/user/${user.id}" onclick="Delete(event)" src="<c:url value='/resources/images/delete.png'/>" width="25px" height="25px" alt="${delete}" />
                            </td>
                        </tr>
                    </c:forEach>
                <tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>  