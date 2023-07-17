<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="logo" value="/resources/image/logo.png"/>

<!DOCTYPE html>
<html lang="en">

<%@ include file="fragments/head.jsp" %>

<body>
    <div class="h-24 w-full justify-between flex items-center px-12">
        <img src="${logo}" alt="" class="h-56 pt-5">
        <div class="flex gap-5">
        </div>
    </div>

    <div class="h-[calc(97vh-96px)] w-full gap-5 px-12 flex justify-center items-center">
        <form:form action="/signin" method="post" modelAttribute="userForm" class="form w-96">
            <h1 class="text-3xl text-white text-center">Sign In</h1>
            <c:if test="${not empty error}">
                <div class="bg-red-500 text-white rounded p-3">
                    ${error}
                </div>
            </c:if>
            <form:input type="text" path="username" placeholder="Username" class="mt-5"/>
            <form:input type="password" path="password" placeholder="Password" class="mt-5"/>
            <input type="submit" value="Sign In" class="btn bg-orange-500 mt-5">
        </form:form>
    </div>

</body>

</html>