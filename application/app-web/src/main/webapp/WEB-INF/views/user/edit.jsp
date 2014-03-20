<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title><spring:message code="label.user.edit"/></title>
    <link href="<c:url value="/resources/bootstrap/bootstrap.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/resources/bootstrap/bootstrap-responsive.min.css" />" rel="stylesheet"  type="text/css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#createForm').submit(function(event){
                var login = $('#login').val();
                var password = $('#password').val();
                var firstName = $('#firstName').val();
                var lastName = $('#lastName').val();
                var address = $('#address').val();
                var json = { "login" : login,
                    "password" : password,
                    "confirmPassword" : password,
                    "firstName" : firstName,
                    "lastName" : lastName,
                    "address" : address };

                $.ajax({
                    url: $("#createForm").attr("action"),
                    data: JSON.stringify(json),
                    type: "PUT",

                    beforeSend: function(xhr){
                        xhr.setRequestHeader("Accept", "application/json");
                        xhr.setRequestHeader("Content-Type", "application/json");
                    },
                    success: function(user){

                        alert("<spring:message code='label.user.edit.success'/>");
                        window.location.replace('/user/list');
                    },
                    error: function(xhr, status, err) {
                        $("#formResponse").text(xhr.responseText).show().delay(2500).fadeOut(2500);
                    }
                });
                event.preventDefault();
            });
        });
    </script>
</head>
<body>
<div class="container">

    <spring:message code="label.user.edit" var="editUserLabel"/>
    <spring:message code="title.label.user.firstName" var="firstName"/>
    <spring:message code="title.label.user.lastName" var="lastName"/>
    <spring:message code="title.label.user.login"  var="login"/>
    <spring:message code="title.label.user.address" var="address"/>
    <spring:message code="title.label.user.password" var="password"/>
    <spring:message code="button.user.save" var="save"/>
    <spring:message code="label.pizza.list" var="listOfPizzas"/>

    <div class="well">
        <a href="/user/list">${listOfPizzas}</a><br/>
        <h2>${editUserLabel}</h2>
        <div id="formResponse"  style="color: red;"></div>
        <form:form id="createForm" method="PUT" cssClass="form-horizontal" action="${pageContext.request.contextPath}/user/${userID}" modelAttribute="userDTO">
            <div class="form-group">
                <div class="col-lg-12">
                    <label>${login}: </label>${userDTO.login}
                    <form:hidden path="login"/>
                    <br />
                    <form:hidden path="password"/>

            <div class="form-group">
                <div class="col-lg-12">
                    <label>${firstName}</label>
                    <form:input type="text" cssClass="form-control" path="firstName" value="${userDTO.firstName}" />
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-12">
                    <label>${lastName}</label>
                    <form:input type="text" cssClass="form-control" path="lastName" value="${userDTO.lastName}" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-12">
                    <label>${address}</label>
                    <form:input type="text" cssClass="form-control" path="address"  value="${userDTO.address}" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-12 col-lg-offset-2">
                    <input type="submit" class="btn btn-default" value="${save}" />
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>