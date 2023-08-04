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


    <div class="h-[calc(97vh-96px)] w-full gap-5 px-12 flex">
        <!-- Sidenav -->
        <%@ include file="fragments/sidenav.jsp" %>

        <div class="flex-1 flex flex-col bg-slate-100/50 overflow-y-auto relative">
            <table class="order-table">
                <thead class="sticky top-0 bg-neutral-900 text-white">
                    <tr>
                        <th>Order #</th>
                        <th>Customer Name</th>
                        <th>Date/Time Ordered</th>
                        <th>Payment Method</th>
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
                            <td><fmt:formatDate value="${order.dateOrdered}" pattern="MMM dd, yyyy HH:mm"/></td>
                            <td>Cash</td>
                            <td>
                                <c:if test="${order.status == 'pending'}">
                                    <span class="capitalize text-amber-500 px-2 rounded-2xl">${order.status}</span>
                                </c:if>
                                <c:if test="${order.status == 'completed'}">
                                    <span class="capitalize text-green-500 px-2 rounded-2xl">${order.status}</span>
                                </c:if>
                                <c:if test="${order.status == 'canceled'}">
                                    <span class="capitalize text-red-500 px-2 rounded-2xl">${order.status}</span>
                                </c:if>
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
                <div class="h-full w-full flex justify-center items-center">No orders</div>
            </c:if>
        </div>
    </div>

    <c:url var="orderSearch" value="/resources/js/orderSearch.js"/>
    <script defer src="${orderSearch}"></script>
</body>
</html>