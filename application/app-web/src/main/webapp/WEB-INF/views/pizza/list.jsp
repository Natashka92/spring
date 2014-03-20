<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title><spring:message code="label.pizza.list"/></title>
    <link href="<c:url value="/resources/bootstrap/bootstrap.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/resources/bootstrap/bootstrap.min.css" />" rel="stylesheet"  type="text/css" />
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
                height: 350,
                width: 400,
                modal: true,
                buttons: {"<spring:message code="button.pizza.create"/>": function() {
                        var name = $('#name').val();
                        var price = $('#price').val();
                        var json = { "name" : name, "price" : price };
                        $.ajax({
                            url: "/pizza",
                            data: JSON.stringify(json),
                            type: "POST",

                            beforeSend: function(xhr){
                                xhr.setRequestHeader("Accept", "application/json");
                                xhr.setRequestHeader("Content-Type", "application/json");
                            },
                            success: function(pizza){
                                $("#pizzas tbody").append("<tr>" +
                                    "<td>" + pizza.id + "</td>" +
                                    "<td>" + pizza.name + "</td>" +
                                    "<td>" + pizza.price + "</td>" +
                                    "</tr>");
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
            $("#create-pizza")
                .button()
                .click(function() {
                    $("#dialog-form").dialog("open");
                });
        });
    </script>
</head>
<body>

<div class="container">
    <spring:message code="label.pizza.list" var="listPizzaLabel"/>
    <spring:message code="title.label.pizza.name" var="name"/>
    <spring:message code="title.label.pizza.price" var="price"/>
    <spring:message code="title.label.pizza.id" var="id"/>
    <spring:message code="label.pizza.create" var="createPizzaLabel"/>
    <spring:message code="title.label.pizza.name" var="name"/>
    <spring:message code="title.label.pizza.price" var="price"/>
    <spring:message code="title.label.pizza.id" var="id"/>
    <spring:message code="label.pizza.list" var="listPizza"/>
    <spring:message code="button.pizza.create" var="AddPizza"/>

    <spring:message code="label.back.home" var="BackHome"/>
    <spring:message code="label.hello" var="hello"/>
    <spring:message code="label.logout" var="logout"/>
    <spring:message code="page.home" var="home"/>
    <spring:message code="title.label.pizza" var="pizza"/>
    <spring:message code="title.label.user" var="user"/>

    <%@ include file="../common/hello.jsp"%>

    <div class="tabbable">
        <ul class="nav nav-pills">
            <li><a href="/">${home}</a></li>
            <li class="active"><a href="#">${pizza}</a></li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li><a href="/user/list">${user}</a></li>
            </sec:authorize>
        </ul>

        <div id="dialog-form" title="${createPizzaLabel}">
            <div id="formResponse" style="color: red;" ></div>
            <form>
                <fieldset>
                    <label for="name">${name}</label>
                    <input type="text" name="name" id="name" class="text ui-widget-content ui-corner-all">
                    <label for="price">${price}</label>
                    <input type="text" name="price" id="price" value="0.0" class="text ui-widget-content ui-corner-all">
                </fieldset>
            </form>
        </div>

        <div class ="tab-content" id="pizzas-contain">

            <h2>${listPizzaLabel}</h2>
            <table id="pizzas" class="table table-bordered table-hover table-striped">
              <thead class="success">
                  <tr class="success">
                      <td>${id}</td>
                      <td>${name}</td>
                      <td>${price}</td>
                  </tr>
              </thead>
              <tbody>
                  <c:forEach var="pizza" items="${pizzaList}">
                      <tr>
                          <td>${pizza.id}</td>
                          <td>${pizza.name}</td>
                          <td>${pizza.price}</td>
                      </tr>
                  </c:forEach>
              </tbody>
            </table>
            <button id="create-pizza">${AddPizza}</button>
        </div>
    </div>
</div>
</body>
</html>