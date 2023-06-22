<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="">
   <div class="bg-[url('\/CafeLounge/resources/image/bg.png')] bg-cover bg-no-repeat justify-items-center">
        <div class="bg-neutral-950/80 min-h-screen ">
            <div class="flex justify-between items-center h-24  pt-5">
                <div >
                    <img src="<c:url value="/resources/image/logo.png" />" alt="" class="h-56 cursor-pointer">
                </div>
                    <div class="flex pr-16 gap-2">
                        <img src="<c:url value="/resources/image/Notif-removebg-preview.png"/>" alt="" class="h-10 cursor-pointer">
                        <img src="<c:url value="/resources/image/Untitled_design__7_-removebg-preview.png"/>" alt="" class="h-10 cursor-pointer">
                     </div>
            </div> <br>
            <div class="flex justify-between   w-2 gap-32 ml-8">
                <div class="mt-14 ml-10">
                    <button class="bg-slate-100/50 hover:bg-orange-500 p-3 rounded-3xl font-semibold w-52">DASHBOARD</button><br><br><br>
                    <button class="bg-slate-100/50 hover:bg-orange-500 p-3 rounded-3xl font-semibold w-52">MENU LIST</button><br><br><br>
                    <button class="bg-slate-100/50 hover:bg-orange-500 p-3 rounded-3xl font-semibold w-52">ORDER LIST</button><br><br><br>
                </div>
                <div class="flex justify-center gap-4 h-96 ">
                    <div class="bg-slate-100/50 h-96 w-60 text-center font-bold text-2xl p-2">TOTAL MENU</div><br>
                    <div class="bg-slate-100/50 h-96 w-60 text-center font-bold text-2xl p-2">TOTAL PENDING</div><br>
                    <div class="bg-slate-100/50 h-96 w-60 text-center font-bold text-2xl p-2">TOTAL COMPLETED</div><br>
                </div>
            </div>
        
        </div>
    </div>
    
</body>

</html>
