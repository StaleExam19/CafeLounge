<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
    <%@ include file="fragments/head.jsp" %>

<body>
    <!-- Topnav -->
    <%@ include file="fragments/topnav.jsp" %>


    <div class="h-[calc(97vh-96px)] w-full gap-5 px-12 flex">
        <!-- Sidenav -->
        <%@ include file="fragments/sidenav.jsp" %>

        <div class="flex-1 flex flex-col  overflow-y-auto relative justify-center items-center">
            <div class="bg-slate-100/50 p-5 px-8 w-1/2">
                <h3 class="text-3xl">${order.customerName}</h3>
                <p>Status: ${order.status}</p>
                <br>

                <c:forEach var="menu" items="${order.orders}">
                    <div class="flex items-center justify-between">
                        <p class="text-xl">${menu.menuName}</p>
                        <p>Php ${menu.price} (${menu.quantity})</p>
                    </div>
                </c:forEach>

                <div class="w-full bg-neutral-900 h-[2px] mb-3"></div>
                <div class="flex justify-between items-center">
                    <p>Total</p>
                    <p>Php ${total}</p>
                </div>
                <br>
                <div class="flex gap-5">
                    <c:if test="${order.status == 'pending'}">
                        <c:url var="completeOrder" value="/completeOrder/${order.orderNumber}" />
                        <a href="${completeOrder}" class="btn bg-orange-500">Mark as Completed</a>

                        <c:url var="cancelOrder" value="/cancelOrder/${order.orderNumber}" />
                        <a href="${cancelOrder}" class="btn">Cancel Order</a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</body>
</html>