<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">

<%@ include file="fragments/head.jsp" %>

<body>
    <!-- Topnav -->
    <%@ include file="fragments/topnav.jsp" %>

    <div class="h-[calc(97vh-96px)] w-full gap-5 px-12 flex">
        <!-- Sidenav -->
        <%@ include file="fragments/sidenav.jsp" %>

        <div class="flex-1">
            <div class="flex gap-2">
                <c:forEach var="item" items="${categories}">
                    <c:url var="href" value="/menulist/${item.href}?status=${status}"/>
                    <c:if test="${item.href == category}">
                        <a href="${href}" class="btn active">${item.label}</a>
                    </c:if>
                    <c:if test="${item.href != category}">
                        <a href="${href}" class="btn">${item.label}</a>
                    </c:if>
                </c:forEach>
                <div class="btn flex justify-between relative active" data-toggle="dropdown">
                    <span class="w-5"></span>
                    <span class="pointer-events-none">${status}</span>
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="pointer-events-none" viewBox="0 0 16 16">
                        <path class="w-5 fill-black pointer-events-none" fill-rule="evenodd"
                            d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z">
                        </path>
                    </svg>

                    <div id="dropdown"
                        class="absolute hidden bg-slate-100/50 items-center w-full top-full left-0 flex-col">
                        <a href="?status=Live" class="hover:bg-orange-500 w-full text-center p-2">Live</a>
                        <a href="?status=Sold Out" class="hover:bg-orange-500 w-full text-center p-2">Sold Out</a>
                        <a href="?status=Delisted" class="hover:bg-orange-500 w-full text-center p-2">Delisted</a>
                    </div>
                </div>
                <div class="btn bg-neutral-100/50 flex gap-2 addmenu-toggler">
                    <svg width="24" height="24" class="inline-flex " fill="none" viewBox="0 0 24 24"
                        xmlns="http://www.w3.org/2000/svg">
                        <path
                            d="M11.883 3.007 12 3a1 1 0 0 1 .993.883L13 4v7h7a1 1 0 0 1 .993.883L21 12a1 1 0 0 1-.883.993L20 13h-7v7a1 1 0 0 1-.883.993L12 21a1 1 0 0 1-.993-.883L11 20v-7H4a1 1 0 0 1-.993-.883L3 12a1 1 0 0 1 .883-.993L4 11h7V4a1 1 0 0 1 .883-.993L12 3l-.117.007Z"
                            fill="#212121"></path>
                    </svg>
                    add menu
                </div>
            </div>
            <!-- Content sa menulist, katung naay mga card ba -->
            <%@ include file="fragments/menulistContent.jsp" %>
        </div>
    </div>

    <!-- Katu ning form sa addmenu, gilahi kay taas kaayo -->
    <%@ include file="fragments/addMenuForm.jsp" %>
    <%@ include file="fragments/updateMenuForm.jsp" %>

    <!-- Menu Info Popup -->
    <%@ include file="fragments/menuInfo.jsp" %>
    <c:url var="js" value="/resources/js/menulist.js"/>
    <script defer="" src="${js}"></script>
    <c:url var="menuSearchJs" value="/resources/js/menuSearch.js"/>
    <script defer src="${menuSearchJs}"></script>

</body>

</html>