<spring:message code="label.hello" var="hello"/>
<spring:message code="label.logout" var="logout"/>

<sec:authorize access="isAuthenticated()">
    <div class="navbar navbar-right">
        <div class="navbar-inner">
            <a href="#" class="brand">${hello}, <sec:authentication property="name"/></a>
            <ul class="nav">
                <li class="active"><a href="/logout">${logout}</a></li>
            </ul>
        </div>
    </div>
</sec:authorize>