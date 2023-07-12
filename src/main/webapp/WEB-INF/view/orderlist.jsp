<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="fragments/vars.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://cdn.tailwindcss.com"></script>
    
</head>
<body>
    <div class="bg-[url('resources/image/background.jpg')] bg-cover bg-no-repeat ">
        <div class="bg-zinc-950/40 min-h-screen ">
            <%@ include file="fragments/topnav.jsp"  %> <br>
                <div class="h-[calc(100vh-96px)] w-full flex px-12">
                    <div class="w-52 flex flex-col justify-center items-center gap-16">
                        <a href="${dashboardRoute}" class="bg-slate-100/50 w-full flex justify-center items-center p-3 rounded-3xl font-semibold hover:bg-orange-500">DASHBOARD</a>
                        <a href="${menulistRoute}" class="bg-slate-100/50 w-full flex justify-center items-center p-3 rounded-3xl font-semibold bg-orange-500">MENU LIST</a>
                        <a href="${orderlistRoute}" class="w-full flex justify-center items-center p-3 rounded-3xl font-semibold bg-orange-500">ORDER LIST</a>
                    </div>
                    <div class="flex flex-1 justify-center  my-10  pl-3  pt-5 text-left">
                        <div class="bg-slate-100/50 bg-contain p-10 font-bold rounded-2xl text-left text-lg">
                            <h1 class="text-left font-bold text-3xl ">Customer ID:1</h1><br>
                            <h1 >Date/Time Placed on: 2023-06-11 10:16:02</h1>
                            <h1>Customer Name: Louie Abad</h1>
                            <h1>Total Dish:</h1>
                            <h1 class="pl-5">Cedar-Plank Salmon ( ₱150 x 1)</h1>
                            <h1 class="pl-5">Seabreeze Cocktail   ( ₱150 x 1)</h1><br>
                            <h1>Total: ₱300.00 </h1>
                            <h1>Payment Method: CASH</h1><br>
                            <div class="flex justify-center">
                                <a href="dashboard2.html" class="font-bold text-center justify-center text-black bg-orange-500 hover:bg-orange-400 rounded-3xl p-2 w-48" >COMPLETE</a>
                            </div>
                        </div>
                    </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
   
</body>
</html>