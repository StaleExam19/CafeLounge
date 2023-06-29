<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="<c:url value="/resources/jquery/jquery-3.7.0.min.js" />"></script>
    <script src="https://cdn.tailwindcss.com"></script>
    <title>${bodyContent}</title>
   
</head>
<body class="">

   <div class="bg-[url('\/CafeLounge/resources/image/bg.png')] bg-cover bg-no-repeat justify-items-center">
        <div class="bg-neutral-950/80 min-h-screen ">
            <div class="flex justify-between items-center h-24 pt-5">
                <div>
                    <img src="<c:url value="/resources/image/logo.png" />" alt="" class="h-56 cursor-pointer">
                </div>
               <div class="flex pr-16 gap-2">
	             <div class="relative group">
                    <img src="resources/image/Notif-removebg-preview.png" alt="" id="notifBell" class="h-10 cursor-pointer">
                    <!-- Notification container -->
                   <%@include file="notifWindow.jsp"%>
                  </div>
				<img src="<c:url value="/resources/image/Untitled_design__7_-removebg-preview.png"/>" alt="" class="h-10 cursor-pointer">
               </div>
            </div>
           <br>                    
   	<div class="flex w-full gap-20">
   	
       <div class="mt-14 ml-10">
           <button class="bg-slate-100/50 hover:bg-orange-500 p-3 rounded-3xl font-semibold w-52 nav-btn" id="CafeLoungedashboard">DASHBOARD</button><br><br><br>
           <button class="bg-slate-100/50 hover:bg-orange-500 p-3 rounded-3xl font-semibold w-52 nav-btn" id="CafeLoungemenulist">MENU LIST</button><br><br><br>
           <button class="bg-slate-100/50 hover:bg-orange-500 p-3 rounded-3xl font-semibold w-52 nav-btn" id="CafeLoungeorderlist" >ORDER LIST</button><br><br><br>
           <a href="logout" class="bg-slate-100/50 hover:bg-orange-500 p-3 rounded-3xl font-semibold w-52">LOGOUT</a><br><br><br>
        </div>
               
           