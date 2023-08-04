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
                <p class="mt-2">Status: 
                    <c:if test="${order.status == 'pending'}">
                        <span class="capitalize bg-amber-500/50 px-2 rounded-2xl">${order.status}</span>
                    </c:if>
                    <c:if test="${order.status == 'completed'}">
                        <span class="capitalize bg-green-500/50 px-2 rounded-2xl">${order.status}</span>
                    </c:if>
                    <c:if test="${order.status == 'canceled'}">
                        <span class="capitalize bg-red-500/50 px-2 rounded-2xl">${order.status}</span>
                    </c:if>
                </p>
                <br>
                    <table class="w-full">
                        <tr>
                            <td class="font-semibold">Menu name</td>
                            <td class="text-center font-semibold">Base price</td>
                            <td class="text-center font-semibold">Quantity</td>
                        </tr>
                        
                        <c:forEach var="menu" items="${order.orders}">
                        <tr>
                            <td>${menu.menuName}</td>
                            <td class="text-center">Php ${menu.price}</td>
                            <td class="text-center">${menu.quantity}</td>
                        </tr>
                        </c:forEach>
                    </table>

                <div class="w-full bg-neutral-900 h-[2px] mb-3"></div>
                <div class="flex justify-between items-center">
                    <p class="font-semibold">Total</p>
                    <p>Php ${total}</p>
                </div>
                <br>
                <div class="flex gap-5">
                    <c:if test="${order.status == 'pending'}">
                        <c:url var="completeOrder" value="/completeOrder/${order.orderNumber}" />
                        <a href="${completeOrder}" class="btn bg-orange-500">Mark as Completed</a>

                        <c:url var="cancelOrder" value="/cancelOrder/${order.orderNumber}" />
                        <a href="${cancelOrder}" class="btn" data-verify-delete>Cancel Order</a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

    <!-- Verification popup -->
<div class="fixed top-0 left-0 h-screen w-full hidden items-center verification justify-center bg-neutral-900/50">
    <div class="bg-neutral-900 p-5 text-white rounded-md ">
        <p class="text-xl">Are you sure you want to cancel this order?</p>
        <div class="flex mt-4 gap-4">
            <a href="" class="p-3 text-center bg-red-500 flex-1 rounded-md yes-btn">Yes</a>

            <button class="flex-1 bg-neutral-500 rounded-md no-btn">No</button>
        </div>
    </div>
</div>


    <c:url var="verifyDeleteJs" value="/resources/js/verifyDelete.js"/>
    <script defer src="${verifyDeleteJs}"></script>
</body>
</html>