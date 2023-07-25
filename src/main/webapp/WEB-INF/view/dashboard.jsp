<!DOCTYPE html>
<html lang="en">

<%@ include file="fragments/head.jsp" %>
    <body>
        <%@ include file="fragments/topnav.jsp" %>
            <div class="h-[calc(97vh-96px)] w-full gap-5 px-12 flex">
                <%@ include file="fragments/sidenav.jsp" %>
                    <div class="flex-1 dashboard">
                        <div class="dashboard-card">
                            <h1 class="title">Total Menu</h1>
                            <span class="text-8xl font-bold">${liveMenu}</span>
                            <a href="/menulist" class="text-xl underline">See more</a>
                        </div>
                        <div class="dashboard-card">
                            <h1 class="title">Total Pending</h1>
                            <span class="text-8xl font-bold">${pendingOrder}</span>
                            <a href="" class="text-xl underline">See more</a>
                        </div>
                        <div class="dashboard-card">
                            <h1 class="title">Total Completed</h1>
                            <span class="text-8xl font-bold">${completedOrder}</span>
                            <a href="" class="text-xl underline">See more</a>
                        </div>
                    </div>
            </div>
    </body>

</html>