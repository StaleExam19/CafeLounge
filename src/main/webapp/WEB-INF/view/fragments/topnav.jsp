<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <c:url var="logo" value="/resources/image/logo.png" />
        <c:url var="notifIcon" value="/resources/image/Notif-removebg-preview.png" />
        <c:url var="profileIcon" value="/resources/image/Untitled_design__8_-removebg-preview.png" />

        <!-- Topnav -->
        <div class="h-24 w-full justify-between flex items-center px-12">
            <img src="${logo}" alt="" class="h-56 pt-5">

            <div class="flex gap-5">

                <!-- Search section -->
                <c:if test="${naaySearch}">
                    <div>
                        <div class="bg-white border-2 flex items-center relative  px-2 border-black rounded-2xl">
                                <input type="text" placeholder="Search" id="menu-search-input"
                                class="p-2 w-96 rounded-2xl outline-none placeholder:text-black">
                            <div>
                                <svg width="24" height="24" fill="none" viewBox="0 0 24 24"
                                    xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M10 2.5a7.5 7.5 0 0 1 5.964 12.048l4.743 4.745a1 1 0 0 1-1.32 1.497l-.094-.083-4.745-4.743A7.5 7.5 0 1 1 10 2.5Zm0 2a5.5 5.5 0 1 0 0 11 5.5 5.5 0 0 0 0-11Z"
                                        fill="#212121" />
                                </svg>
                            </div>

                            <div id="search-result" class="w-full max-h-72 overflow-auto z-30 left-0 absolute top-full bg-neutral-900 hidden flex-col">
                                
                            </div>
                        </div>
                    </div>
                </c:if>

                <!-- Notification section -->
                <div class="relative">
                    <img src="${notifIcon}" alt="" class="h-10 cursor-pointer hover:scale-105" data-toggle="notification">

                    <div class="absolute top-full right-0  z-30 hidden flex-col max-h-80 overflow-y-auto overflow-x-hidden" id="notification">
                        <div class="w-80 p-3 bg-white hover:bg-neutral-200">
                            <p class="font-bold">New order from</p>
                            <div class="flex justify-between">
                                <p>John Ryan Baculpo</p>
                                <p class="text-neutral-500">Jul 30, 2023 18:27</p>
                            </div>                            
                        </div>

                        <div class="w-80 p-3 bg-white hover:bg-neutral-200">
                            <p class="font-bold">New order from</p>
                            <div class="flex justify-between">
                                <p>Louie Abad</p>
                                <p class="text-neutral-500">Jul 30, 2023 18:27</p>
                            </div>                            
                        </div>

                        <div class="w-80 p-3 bg-white hover:bg-neutral-200">
                            <p class="font-bold">Out of Stock</p>
                            <div class="flex justify-between">
                                <p>Ginamos with Lemonsito</p>
                                <p class="text-neutral-500">Jul 30, 2023 18:27</p>
                            </div>                            
                        </div>

                        <div class="w-80 p-3 bg-white hover:bg-neutral-200">
                            <p class="font-bold">New order from</p>
                            <div class="flex justify-between">
                                <p>John Ryan Baculpo</p>
                                <p class="text-neutral-500">Jul 30, 2023 18:27</p>
                            </div>                            
                        </div>

                        <div class="w-80 p-3 bg-white hover:bg-neutral-200">
                            <p class="font-bold">New order from</p>
                            <div class="flex justify-between">
                                <p>John Ryan Baculpo</p>
                                <p class="text-neutral-500">Jul 30, 2023 18:27</p>
                            </div>                            
                        </div>

                        <div class="w-80 p-3 bg-white hover:bg-neutral-200">
                            <p class="font-bold">Out of Stock</p>
                            <div class="flex justify-between">
                                <p>John Ryan Baculpo</p>
                                <p class="text-neutral-500">Jul 30, 2023 18:27</p>
                            </div>                            
                        </div>
                    </div>
                </div>

                <div class="relative">
                    <img src="${profileIcon}" alt="" class="h-10 cursor-pointer hover:scale-105"
                        data-toggle="profile-dropdown">

                    <div class="bg-white w-40 absolute top-full right-0 z-30 p-2 hidden flex-col" id="profile-dropdown">
                        <p>${user.firstname} ${user.lastname}</p>
                        <hr>
                        <c:url var="logout" value="/logout" />
                        <a href="${logout}" class="flex gap-2 p-2 hover:bg-orange-500 hover:text-white group">
                            <svg width="24" height="24" fill="none" viewBox="0 0 24 24"
                                xmlns="http://www.w3.org/2000/svg">
                                <path d="M8.502 11.5a1.002 1.002 0 1 1 0 2.004 1.002 1.002 0 0 1 0-2.004Z"
                                    class="fill-neutral-900 group-hover:fill-white" />
                                <path
                                    d="M12 4.354v6.651l7.442-.001L17.72 9.28a.75.75 0 0 1-.073-.976l.073-.084a.75.75 0 0 1 .976-.073l.084.073 2.997 2.997a.75.75 0 0 1 .073.976l-.073.084-2.996 3.004a.75.75 0 0 1-1.134-.975l.072-.085 1.713-1.717-7.431.001L12 19.25a.75.75 0 0 1-.88.739l-8.5-1.502A.75.75 0 0 1 2 17.75V5.75a.75.75 0 0 1 .628-.74l8.5-1.396a.75.75 0 0 1 .872.74Zm-1.5.883-7 1.15V17.12l7 1.236V5.237Z"
                                    class="fill-neutral-900 group-hover:fill-white" />
                                <path
                                    d="M13 18.501h.765l.102-.006a.75.75 0 0 0 .648-.745l-.007-4.25H13v5.001ZM13.002 10 13 8.725V5h.745a.75.75 0 0 1 .743.647l.007.102.007 4.251h-1.5Z"
                                    class="fill-neutral-900 group-hover:fill-white" />
                            </svg>
                            Sign Out
                        </a>
                    </div>
                </div>
            </div>
        </div>