<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.user.create"/></title>
    <link href="<c:url value="/resources/bootstrap/bootstrap.css" />" rel="stylesheet"  type="text/css" />
    <script src="<c:url value="/resources/js/jquery.js"/>" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#create').click(function(){
                var login = $('#login').val();
                var password = $('#password').val();
                var confirmPassword = $('#confirmPassword').val();
                var firstName = $('#firstName').val();
                var lastName = $('#lastName').val();
                var address = $('#address').val();
                var json = { "login" : login,
                "password" : password,
                "confirmPassword" : confirmPassword,
                "firstName" : firstName,
                "lastName" : lastName,
                "address" : address };

                $.ajax({
                    url: "${pageContext.request.contextPath}/user",
                    data: JSON.stringify(json),
                    type: "POST",

                    beforeSend: function(xhr){
                        xhr.setRequestHeader("Accept", "application/json");
                        xhr.setRequestHeader("Content-Type", "application/json");
                    },
                    success: function(user){
                        alert("<spring:message code='label.registration.success'/>");
                        window.location.replace('/login');
                    },
                    error: function(xhr, status, err) {
                        $("#formResponse").text(xhr.responseText).show().delay(1500).fadeOut(1500);
                    }
                });
            });
        });
    </script>
</head>
<body>
<div class="container">
    <spring:message code="label.user.create"  var="create" />
    <spring:message code="title.label.user.login" var="login" />
    <spring:message code="title.label.user.password" var="password" />
    <spring:message code="title.label.user.conf.password" var="confirmPassword" />
    <spring:message code="title.label.user.firstName" var="firstName" />
    <spring:message code="title.label.user.lastName" var="lastName" />
    <spring:message code="title.label.user.address" var="address" />
    <spring:message code="button.user.create" var="createButton" />

    <div class="well">
        <h3>${create}</h3>
        <div id="formResponse"  style="color: red;"></div>
        <div class="form-horizontal">
            <div class="form-group">
                <div class="col-lg-12">
                    <label for="login">${login}</label>
                    <input type="text" class="form-control" placeholder="${login}" id="login">
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-12">
                    <label for="password">${password}</label>
                    <input type="password" class="form-control" placeholder="${password}" id="password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-12">
                    <label for="confirmPassword">${confirmPassword}</label>
                    <input type="password" class="form-control" placeholder="${confirmPassword}" id="confirmPassword">
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-12">
                    <label for="firstName">${firstName}</label>
                    <input type="text" class="form-control" placeholder="${firstName}" id="firstName">
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-12">
                    <label for="lastName">${lastName}</label>
                    <input type="text" class="form-control" placeholder="${lastName}" id="lastName">
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-10">
                    <label for="address">${address}</label>
                    <input type="text" class="form-control" placeholder="${address}" id="address" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-12">
                    <button id="create" class="btn btn-success">${createButton}</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>