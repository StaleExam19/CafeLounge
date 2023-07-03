<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
            <div class="flex justify-between items-center h-24  pt-5">
                <div class="pl-12">
                    <img src="resources/image/logo.png" alt="" class="h-56 cursor-pointer">
                </div>
                <div class="flex pr-16 gap-2">
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
                <div class="flex-1">
                    <form:form action="addmenu" method="post" modelAttribute="menuForm" enctype="multipart/form-data" class="flex justify-center items-center my-10">
                        <div class="bg-contain  bg-slate-100/50 rounded-2xl  p-10">
                            <form:input type="text" name="name" path="name" placeholder="Menu Name"
                                class="p-2 w-96 items-start rounded-2xl text-slate-950"/>
                            <br><br>
                            <form:input type="text" name="price" path="price" placeholder="Menu Price" class="p-2 w-96 items-start rounded-2xl"/>
                            <br><br>
                            <form:select name="category" path="category" class="p-2 w-96 items-start rounded-2xl border-none">
                                <option disabled selected>-Select Categories-</option>
                                <option value="appetizer">Appetizer</option>
                                <option value="main-course">Main Course</option>
                                <option value="dessert">Dessert</option>
                                <option value="drinks">Drinks</option>
                            </form:select>
                            <br><br>
                            <form:input type="file" name="image" path="image" value="Choose File" placeholder="Choose file"
                                class="p-2 w-96 items-start rounded-2xl ring-offset-0 ring-0 bg-white"/>
                            <br><br>
                            <div class="flex justify-center">
                                <!-- <button class="font-bold text-center text-black bg-orange-500 hover:bg-orange-400 rounded-3xl p-2 w-56 ">Sign In</button> -->
                                <input type="submit" value="ADD MENU"
                                    class="font-bold text-center text-black bg-orange-500 hover:bg-orange-400 rounded-3xl p-2 w-96">
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

</body>

</html>