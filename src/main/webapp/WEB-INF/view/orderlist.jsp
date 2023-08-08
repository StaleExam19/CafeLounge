<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!-- Replace "en_US" with your desired locale -->
<fmt:setLocale value="en_US" />
<fmt:setBundle basename="com.syntaxerror.cafelounge" />


<!DOCTYPE html>
<html lang="en">
    <%@ include file="fragments/head.jsp" %>

<body>
    <!-- Topnav -->
    <%@ include file="fragments/topnav.jsp" %>


    <div class="h-[calc(97vh-96px)] w-full gap-5 px-12 flex flex-col mb-10">
        <!-- Sidenav -->
        <div class="flex gap-5 h-full">
            <%@ include file="fragments/sidenav.jsp" %>

            <div class="flex-1 flex flex-col bg-slate-100/50 overflow-y-auto relative">
                <table class="order-table">
                    <thead class="sticky top-0 bg-neutral-900 text-white">
                        <tr>
                            <th>Order #</th>
                            <th>Customer Name</th>
                            <th>Time Ordered</th>
                            <th class="flex items-center gap-1 justify-center cursor-pointer relative" data-toggle="status-dropdown">Status 
                                <svg xmlns="http://www.w3.org/2000/svg" class="bi
                                bi-chevron-down w-4 pointer-events-none" viewBox="0 0 16 16">
                                    <path class="w-5 fill-white" fill-rule="evenodd"
                                        d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z" />
                                </svg>
                                <div id="status-dropdown"
                                class="absolute hidden bg-neutral-900 items-center w-full top-full left-0 flex-col">
                                <c:url var="orderStatusLink" value="/orderlist"/>
                                <a href="${orderStatusLink}" class="hover:bg-orange-500 w-full text-center p-2">All</a>
                                <a href="${orderStatusLink}/pending" class="hover:bg-orange-500 w-full text-center p-2">Pending</a>
                                <a href="${orderStatusLink}/canceled" class="hover:bg-orange-500 w-full text-center p-2">Canceled</a>
                                <a href="${orderStatusLink}/completed" class="hover:bg-orange-500 w-full text-center p-2">Completed</a>
                            </div>
                            </th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${orders}">
                            <tr>
                                <td>${order.orderNumber}</td>
                                <td>${order.customerName}</td>
                                <td><fmt:formatDate value="${order.dateOrdered}" pattern="HH:mm"/></td>
                                <td>
                                    <span class="capitalize px-2 rounded-2xl">${order.status}</span>
                                </td>
                                <td>
                                    <c:url var="orderDetail" value="/order/${order.orderNumber}"/>
                                    <a href="${orderDetail}" class="underline">View Details</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
    
    
                <c:if test="${empty orders}">
                    <div class="h-full w-full flex justify-center items-center">No ${status} orders</div>
                </c:if>
            </div>
        </div>

        <div class="w-[calc(100%-240px)] flex justify-center items-center ml-60 gap-2">

            <c:if test="${currentPage == 1}">
                <a href="" class="page-button disabled"><</a>
            </c:if>
            <c:if test="${currentPage > 1}">
                <a href="/orderlist?page=${currentPage - 1}" class="page-button"><</a>
            </c:if>

            <c:forEach var="num" begin="1" end="${numOfPages}">
                <c:url var="nextPage" value="/orderlist?page=${num}"/>
                <c:if test="${currentPage == num}">
                    <a href="${nextPage}" class="page-button active">${num}</a>
                </c:if>
                <c:if test="${currentPage != num}">
                    <a href="${nextPage}" class="page-button">${num}</a>
                </c:if>
            </c:forEach>

            <c:if test="${currentPage == numOfPages}">
                <a href="" class="page-button disabled">></a>
            </c:if>

            <c:if test="${currentPage < numOfPages}">
                <a href="/orderlist?page=${currentPage + 1}" class="page-button">></a>
            </c:if>
        </div>
    </div>
    
    <c:url var="orderSearch" value="/resources/js/orderSearch.js"/>
    <script defer src="${orderSearch}"></script>
</body>
</html>