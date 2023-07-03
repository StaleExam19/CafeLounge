<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menulist</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="">
    <div class="bg-[url('resources/image/background.jpg')] bg-cover bg-no-repeat justify-items-center ">
        <div class="bg-zinc-950/40 min-h-screen ">
            <div class="flex justify-between items-center h-24  pt-5 px-12">
                <div class="">
                    <img src="resources/image/logo.png" alt="" class="h-56 cursor-pointer ">
                </div>
                <div class="flex gap-2">
                    <img src="resources/image/Notif-removebg-preview.png" alt="" class="h-10 cursor-pointer hover:scale-125 ">
                    <img src="resources/image/Untitled_design__8_-removebg-preview.png" alt=""
                        class="h-10 cursor-pointer hover:scale-125">
                </div>
            </div> <br>

            <div class="h-[calc(100vh-96px)] w-full flex px-12">
                <div class="w-52 flex flex-col justify-center items-center gap-16">
                    <a href=""
                        class="bg-slate-100/50 w-full flex justify-center items-center p-3 rounded-3xl font-semibold hover:bg-orange-500">DASHBOARD</a>
                    <a href=""
                        class=" w-full flex justify-center items-center p-3 rounded-3xl font-semibold bg-orange-500">MENU
                        LIST</a>
                    <a href=""
                        class="bg-slate-100/50 w-full flex justify-center items-center p-3 rounded-3xl font-semibold hover:bg-orange-500">ORDER
                        LIST</a>
                </div>
                <div class="flex gap-5 ml-12 flex-col">
                    <div class="w-full">
                        <button class="bg-orange-500 p-3 rounded-3xl font-semibold w-40"><a
                                href="menulist.html">APPETIZERS</a></button>
                        <button class="bg-slate-100/50   p-3 rounded-3xl font-semibold w-40"><a
                                href="maincourse.html">MAIN COURSE</a></button>
                        <button class="bg-slate-100/50   p-3 rounded-3xl font-semibold w-40"><a
                                href="desserts.html">DESSERTS</a></button>
                        <button class="bg-slate-100/50   p-3 rounded-3xl font-semibold w-40"><a
                                href="drinks.html">DRINKS</a></button>
                        <select name="" id=""
                            class="text-lg  bg-slate-100/50   p-3 rounded-3xl font-semibold w-32 text-center">
                            <option value="Live">Live</option>
                            <option value="Sold out">Sold Out</option>
                            <option value="Deleted">Deleted</option>
                        </select>
                        <button class="bg-slate-100/50   p-3 rounded-3xl font-semibold w-40"><a
                            href="addmenu.html">ADD MENU</a></button>
                    </div>
                    <div class="bg-slate-100/50 flex-1  grid grid-cols-4  p-8 h-96 gap-5 rounded-2xl font-semibold">
                        <c:forEach var="menu" items="${menuList}">
                            <div class="w-48 bg-zinc-950/75 flex flex-col justify-evenly text-white p-3 rounded-3xl text-center">
                                <u class="uppercase">${menu.category}</u>
                                <div class="flex items-center justify-center">
                                    <img src="/myImage?id=${menu.id}" alt="" class="w-full h-full">
                                </div>
                                <div>
                                    <p>${menu.name}</p>
                                    <p>Php ${menu.price}</p>
                                    <p>Status: ${menu.status}</p>
                                    <br>
                                    <div class="flex items-center justify-center gap-8">
                                        <button
                                            class="font-bold text-center text-white border border-white px-2 hover:bg-orange-400 rounded-3xl p-1">Update</button>
                                        <button
                                            class="font-bold text-center text-white border border-white px-2 hover:bg-orange-400 rounded-3xl p-1">Delete</button>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>