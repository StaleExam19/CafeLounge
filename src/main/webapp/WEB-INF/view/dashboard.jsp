<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="imageFolder" value="/resources/image"/>

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
            <%@include file="fragments/topnav.jsp" %>
            <br>

            <div class="h-[calc(100vh-96px)] w-full flex px-12">
                <%@include file="fragments/sidenav.jsp"  %>
                
                <div class="flex-1 flex pb-12 gap-5 pl-5">
                    <div class="bg-slate-100/50 flex-1 flex flex-col items-center justify-between p-3">
                        <p class="text-3xl font-bold">TOTAL MENU</p>
                        <span class="text-8xl font-bold">15</span>
                        <div>
                        </div>
                    </div>
                    <div class="bg-slate-100/50 flex-1 flex flex-col items-center justify-between p-3">
                        <p class="text-3xl font-bold">TOTAL PENDING</p>
                        <span class="text-8xl font-bold">1</span>
                        <div></div>
                    </div>
                    <div class="bg-slate-100/50 flex-1 flex flex-col items-center justify-between p-3">
                        <p class="text-3xl font-bold">TOTAL COMPLETED</p>
                        <span class="text-8xl font-bold">1</span>
                        <div></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</body>
</html>
