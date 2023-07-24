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

        <div class="flex-1 flex flex-col bg-slate-100/50 overflow-y-auto relative">
            <table class="">
                <thead class="sticky top-0 bg-neutral-900 text-white">
                    <tr>
                        <th>Customer Name</th>
                        <th>Date/Time Ordered</th>
                        <th>Payment Method</th>
                        <th class="flex items-center gap-1 justify-center cursor-pointer">Status 
                            <svg xmlns="http://www.w3.org/2000/svg" class="bi
                            bi-chevron-down w-4" viewBox="0 0 16 16">
                                <path class="w-5 fill-white" fill-rule="evenodd"
                                    d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z" />
                            </svg></th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>${order.customerName}</td>
                            <td>${order.dateOrdered}</td>
                            <td>Cash</td>
                            <td style="text-transform: capitalize;">${order.status}</td>
                            <td>
                                <a href="" class="underline">View Details</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
        </div>
    </div>
</body>
</html>