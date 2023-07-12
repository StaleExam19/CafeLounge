<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="fragments/vars.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="">
   <div class="bg-[url('resources/image/background.jpg')] bg-cover bg-no-repeat justify-items-center ">
        <div class="bg-zinc-950/40 min-h-screen ">
            <%@ include file="fragments/topnav.jsp"  %>
            <br>

            <div class="h-[calc(100vh-96px)] w-full flex px-12">
                <div class="w-52 flex flex-col justify-center items-center gap-16">
                    <a href="${dashboardRoute}" class="w-full flex justify-center items-center p-3 rounded-3xl font-semibold bg-orange-500">DASHBOARD</a>
                    <a href="${menulistRoute}" class="bg-slate-100/50 w-full flex justify-center items-center p-3 rounded-3xl font-semibold hover:bg-orange-500">MENU LIST</a>
                    <a href="${orderlistRoute}" class="bg-slate-100/50 w-full flex justify-center items-center p-3 rounded-3xl font-semibold hover:bg-orange-500">ORDER LIST</a>
                </div>
                <div class="flex-1 flex pb-12 gap-5 pl-5 ">
                    <div class="bg-slate-100/50 flex-1 flex flex-col items-center justify-between p-3">
                        <p class="text-3xl font-bold">TOTAL MENU</p>
                        <span class="text-8xl font-bold">15</span>
                        <div class="pb-3 hover:scale-125">
                            <a href="#" class="text-xl font-semibold"><u>See More</u></a>
                        </div>
                    </div>
                    <div class="bg-slate-100/50 flex-1 flex flex-col items-center justify-between p-3">
                        <p class="text-3xl font-bold">TOTAL PENDING</p>
                        <span class="text-8xl font-bold">1</span>
                        <div class="pb-3 hover:scale-125">
                            <a href="#" class="text-xl font-semibold"><u>See More</u></a>
                        </div>
                    </div>
                    <div class="bg-slate-100/50 flex-1 flex flex-col items-center justify-between p-3">
                        <p class="text-3xl font-bold">TOTAL COMPLETED</p>
                        <span class="text-8xl font-bold">1</span>   
                        <div class="pb-3 hover:scale-125">
                            <a href="#" class="text-xl font-semibold"><u>See More</u></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script defer src="${jsRoute}/toggler.js"></script>
    
</body>
</html>
