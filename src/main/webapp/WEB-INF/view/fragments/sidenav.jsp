<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- Sidenav -->
<div class="w-60 h-full flex justify-center items-center flex-col gap-16">
    <c:forEach var="item" items="${sideNavBtn}">
        <c:url var="href" value="${item.href}" />
        <c:if test="${item.active}">
            <a href="${href}" class="btn active">${item.label}</a>
        </c:if>
        <c:if test="${not item.active}">
            <a href="${href}" class="btn">${item.label}</a>
        </c:if>
    </c:forEach>
</div>