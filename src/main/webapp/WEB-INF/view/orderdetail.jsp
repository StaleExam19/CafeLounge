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
                <p class="text-xl">${order.menuName}</p>
                <br>

                <p class="">Order summary</p>
                <div class="bg-black mb-3 h-[2px] w-full"></div>

                <div class="flex justify-between">
                    <p>Base Price: </p>
                    <div>Php ${order.menuPrice}</div>
                </div>

                <div class="flex justify-between">
                    <p>Quantity: </p>
                    <p>${order.quantity}</p>
                </div>

                <div class="flex justify-between">
                    <p>Total: </p>
                    <p>Php ${order.menuPrice * order.quantity}</p>
                </div>
                <br>    
                <div class="flex">
                    <c:if test="${order.status == 'pending'}">
                        <c:url var="updateOrder" value="/updateOrder/${order.id}" />
                        <a href="${updateOrder}" class="btn">Mark as Completed</a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</body>
</html>