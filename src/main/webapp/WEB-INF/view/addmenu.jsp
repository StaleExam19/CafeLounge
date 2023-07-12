<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:url var="imageFolder" value="/resources/image"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body>
    <div class="bg-[url('resources/${imageFolder}/background.jpg')] bg-cover bg-no-repeat ">
        <div class="bg-zinc-950/40 min-h-screen ">
            <div class="flex justify-between items-center h-24  pt-5">
                <div class="pl-12">
                    <img src="${imageFolder}/logo.png" alt="" class="h-56 cursor-pointer">
                </div>
                <div class="flex pr-16 gap-2">
                    <img src="${imageFolder}/Notif-removebg-preview.png" alt="" class="h-10 cursor-pointer hover:scale-125 ">
                    <img src="${imageFolder}/Untitled_design__8_-removebg-preview.png" alt=""
                        class="h-10 cursor-pointer hover:scale-125">
                </div>
            </div> <br>
            <div class="h-[calc(100vh-96px)] w-full flex px-12">
                <%@ include file="fragments/sidenav.jsp"  %>
                <div class="flex-1">
                    <form class="flex justify-center items-center">
                        <div class="bg-contain  bg-slate-100/50 rounded-2xl w-1/2 p-10">
                            <input type="text" placeholder="Menu Name"
                                class="p-2 w-full items-start rounded-2xl text-slate-950">
                            <br><br>
                            <input type="text" placeholder="Description"
                            class="p-2 w-full items-start rounded-2xl text-slate-950">
                        <br><br>
                            <input type="text" placeholder="Menu Price" class="p-2 w-full items-start rounded-2xl">
                            <br><br>
                            <select class="p-2 w-full items-start rounded-2xl border-none">
                                <option disabled selected>-Select Categories-</option>
                                <option value="appetizer">Appetizer</option>
                                <option value="main-course">Main Course</option>
                                <option value="dessert">Dessert</option>
                                <option value="drinks">Drinks</option>
                            </select>
                            <br><br>
                            <select class="p-2 w-full items-start rounded-2xl border-none">
                                <option disabled selected>-Status-</option>
                                <option value="Live">Live</option>
                                <option value="Sold Out">Sold Out</option>
                                <option value="Delisted">Delisted</option>
                            </select>
                            <br><br>
                            <input type="file" value="Choose File" placeholder="Choose file"
                                class="p-2 w-full items-start rounded-2xl ring-offset-0 ring-0 bg-white">
                            <br><br>
                            <div class="flex justify-center">
                                <!-- <button class="font-bold text-center text-black bg-orange-500 hover:bg-orange-400 rounded-3xl p-2 w-56 ">Sign In</button> -->
                                <a href="menulist2.html"
                                    class="font-bold text-center text-black bg-orange-500 hover:bg-orange-400 rounded-3xl p-2 w-96">ADD
                                    MENU</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</body>

</html>