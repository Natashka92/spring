<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="app.login.body.title" /></title>
    <link href="<c:url value="/resources/bootstrap/bootstrap.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/resources/bootstrap/bootstrap-responsive.min.css" />" rel="stylesheet"  type="text/css" />
    <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <style>
        label, input { display:block; }
        input.text { margin-bottom:12px; width:95%; padding: .4em; }
        fieldset { padding:0; border:0; margin-top:25px; }
        h1 { font-size: 1.2em; margin: .6em 0; }
    </style>
    <script type="text/javascript">
        $(function() {
            $("#dialog-form").dialog({
                autoOpen: false,
                height: 700,
                width: 700,
                modal: true,
                buttons: {"<spring:message code="button.user.create"/>": function() {
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
                            $("#dialog-form").dialog("close");
                        },
                        error: function(xhr, status, err) {
                            $("#formResponse").text(xhr.responseText).show().delay(1500).fadeOut(1500);
                        }
                    })
                },
                    "<spring:message code="button.cancel"/>": function(){
                        $(this).dialog("close");
                    }
                }
            });
            $("#create-user")
                    .button()
                    .click(function() {
                        $("#dialog-form").dialog("open");
                    });
        });
    </script>
</head>
<body>
<div class="container">
    <spring:message code="app.login.body.title" var="title"/>
    <spring:message code="app.login.user.name" var="name"/>
    <spring:message code="app.login.user.password" var="password"/>
    <spring:message code="app.login.button.enter" var="enter"/>
    <spring:message code="label.user.registration" var="registation"/>
    <spring:message code="label.user.create"  var="create" />
    <spring:message code="title.label.user.login" var="login" />
    <spring:message code="title.label.user.password" var="password" />
    <spring:message code="title.label.user.conf.password" var="confirmPassword" />
    <spring:message code="title.label.user.firstName" var="firstName" />
    <spring:message code="title.label.user.lastName" var="lastName" />
    <spring:message code="title.label.user.address" var="address" />
    <spring:message code="button.user.create" var="createButton" />

    <div id="dialog-form" title="${create}">
        <div id="formResponse"  style="color: red;"></div>
        <form>
            <fieldset>
                <label for="login">${login}</label>
                <input type="text" class="form-control" placeholder="${login}" id="login">

                <label for="password">${password}</label>
                <input type="password" class="form-control" placeholder="${password}" id="password">

                <label for="confirmPassword">${confirmPassword}</label>
                <input type="password" class="form-control" placeholder="${confirmPassword}" id="confirmPassword">

                <label for="firstName">${firstName}</label>
                <input type="text" class="form-control" placeholder="${firstName}" id="firstName">

                <label for="lastName">${lastName}</label>
                <input type="text" class="form-control" placeholder="${lastName}" id="lastName">

                <label for="address">${address}</label>
                <input type="text" class="form-control" placeholder="${address}" id="address" />
            </fieldset>
        </form>
    </div>
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
        <button id="create-user">${registation}</button>
    </div>
</div>
</body>
</html>
