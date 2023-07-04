<c:url var="dashboard" value="/"/>
<c:url var="menulist" value="/menulist"/>
<c:url var="orderlist" value="/orderlist"/>

<div class="w-52 flex flex-col justify-center items-center gap-16">
    <a href="${dashboard}"
        class="bg-slate-100/50 w-full flex justify-center items-center p-3 rounded-3xl font-semibold hover:bg-orange-500">DASHBOARD</a>
    <a href="${menulist}"
        class=" w-full flex justify-center items-center p-3 rounded-3xl font-semibold bg-orange-500">MENU
        LIST</a>
    <a href="${orderlist}"
        class="bg-slate-100/50 w-full flex justify-center items-center p-3 rounded-3xl font-semibold hover:bg-orange-500">ORDER
        LIST</a>
</div>