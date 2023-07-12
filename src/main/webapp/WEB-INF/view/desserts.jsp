<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Desserts</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script defer src="./js/dropdown.js"></script>
</head>

<body class="">
    <div class="bg-[url('image/background.jpg')] bg-cover bg-no-repeat justify-items-center ">
        <div class="bg-zinc-950/40 min-h-screen ">
            <div class="flex justify-between items-center h-24  pt-5 px-12">
                <div class="">
                    <img src="image/logo.png" alt="" class="h-56 cursor-pointer ">
                </div>
                <div class="flex gap-2">
                    <img src="image/Notif-removebg-preview.png" alt="" class="h-10 cursor-pointer hover:scale-125 ">
                    <img src="image/Untitled_design__8_-removebg-preview.png" alt=""
                        class="h-10 cursor-pointer hover:scale-125">
                </div>
            </div> <br>

            <div class="h-[calc(100vh-96px)] w-full flex px-12">
                <div class="w-52 flex flex-col justify-center items-center gap-16">
                    <a href="dashboard2.html"
                        class="bg-slate-100/50 w-full flex justify-center items-center p-3 rounded-3xl font-semibold hover:bg-orange-500">DASHBOARD</a>
                    <a href="menulist2.html"
                        class=" w-full flex justify-center items-center p-3 rounded-3xl font-semibold bg-orange-500">MENU
                        LIST</a>
                    <a href="orderlist.html"
                        class="bg-slate-100/50 w-full flex justify-center items-center p-3 rounded-3xl font-semibold hover:bg-orange-500">ORDER
                        LIST</a>
                </div>
                <div class="flex gap-5 ml-12 flex-col">
                    <div class="w-full">
                        <button class="bg-slate-100/50 p-3 rounded-3xl font-semibold w-40"><a
                                href="menulist2.html">APPETIZERS</a></button>
                        <button class="bg-slate-100/50   p-3 rounded-3xl font-semibold w-40"><a
                                href="maincourse2.html">MAIN COURSE</a></button>
                        <button class="bg-orange-500 p-3 rounded-3xl font-semibold w-40"><a
                                href="desserts2.html">DESSERTS</a></button>
                        <button class="bg-slate-100/50   p-3 rounded-3xl font-semibold w-40"><a
                                href="drinks2.html">DRINKS</a></button>
                        <button name="" id="dropdown" 
                            class="text-lg  bg-slate-100/50   p-3 rounded-3xl font-semibold w-32 relative ">
                            <span class="flex pl-7"><div>LIVE</div><div class="pl-5 pt-2"> <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-chevron-down" viewBox="0 0 16 16">
                                 <path class="w-5 fill-black" fill-rule="evenodd" d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/> </svg></div></span>
                            <div class=" flex-col absolute left-0 top-full bg-slate-100/50 w-full hidden" id="list">
                                <a href="" value="Live">Live</a>
                                <a href="" value="Sold out">Sold Out</a>
                                <a href="" value="Delisted">Delisted</a>
                            </div>
                        </button>
                        <button id="addmenuToggle" class="bg-slate-100/50  relative p-3 rounded-3xl font-semibold w-40">
                            <svg width="24" height="24" class="inline-flex " fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                <path d="M11.883 3.007 12 3a1 1 0 0 1 .993.883L13 4v7h7a1 1 0 0 1 .993.883L21 12a1 1 0 0 1-.883.993L20 13h-7v7a1 1 0 0 1-.883.993L12 21a1 1 0 0 1-.993-.883L11 20v-7H4a1 1 0 0 1-.993-.883L3 12a1 1 0 0 1 .883-.993L4 11h7V4a1 1 0 0 1 .883-.993L12 3l-.117.007Z" fill="#212121"/></svg><span>  ADD MENU</span>
                    </button>
                    </div>
                    <div class="bg-slate-100/50 flex-1 overflow-auto grid grid-cols-4 p-8  h-96 gap-4 rounded-2xl font-semibold ">
                        <div
                            class="w-48 bg-zinc-950/75 flex flex-col justify-evenly flex-1 text-white p-3 pt-1 rounded-3xl text-center">
                            <u class="flex justify-between pl-11 pr-1 ">DESSERTS <svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                <path class="fill-white hover:fill-orange-500" d="M12 9.005a4 4 0 1 1 0 8 4 4 0 0 1 0-8ZM12 5.5c4.613 0 8.596 3.15 9.701 7.564a.75.75 0 1 1-1.455.365 8.503 8.503 0 0 0-16.493.004.75.75 0 0 1-1.455-.363A10.003 10.003 0 0 1 12 5.5Z" fill="#212121"/></svg>
                            </u>
                            <div class="flex items-center justify-center">
                                <img src="image/dessert1.jpg" alt="" class="w-full h-full">
                            </div>
                            <div>
                                <p>
                                    Chocolate Sheet Cake
                                </p>
                                <p>
                                    ₱ 150.00
                                </p>
                                <p>
                                    Status: Live
                                </p>
                                <br>
                                <div class="flex items-center justify-center gap-20 ">
                                    <a href="#">
                                        <svg  width="24" height="24" fill="none" viewBox="0 0 24 24"
                                            xmlns="http://www.w3.org/2000/svg">
                                            <path class="fill-white hover:fill-orange-500"
                                                d="M13.94 5 19 10.06 9.062 20a2.25 2.25 0 0 1-.999.58l-5.116 1.395a.75.75 0 0 1-.92-.921l1.395-5.116a2.25 2.25 0 0 1 .58-.999L13.938 5Zm7.09-2.03a3.578 3.578 0 0 1 0 5.06l-.97.97L15 3.94l.97-.97a3.578 3.578 0 0 1 5.06 0Z"
                                                fill="#212121" />
                                        </svg>
                                    </a>
                                    <a href="#">
                                        <svg width="24" height="24" fill="none" viewBox="0 0 24 24"
                                            xmlns="http://www.w3.org/2000/svg">
                                            <path class="fill-white hover:fill-orange-500"
                                                d="M21.5 6a1 1 0 0 1-.883.993L20.5 7h-.845l-1.231 12.52A2.75 2.75 0 0 1 15.687 22H8.313a2.75 2.75 0 0 1-2.737-2.48L4.345 7H3.5a1 1 0 0 1 0-2h5a3.5 3.5 0 1 1 7 0h5a1 1 0 0 1 1 1Zm-7.25 3.25a.75.75 0 0 0-.743.648L13.5 10v7l.007.102a.75.75 0 0 0 1.486 0L15 17v-7l-.007-.102a.75.75 0 0 0-.743-.648Zm-4.5 0a.75.75 0 0 0-.743.648L9 10v7l.007.102a.75.75 0 0 0 1.486 0L10.5 17v-7l-.007-.102a.75.75 0 0 0-.743-.648ZM12 3.5A1.5 1.5 0 0 0 10.5 5h3A1.5 1.5 0 0 0 12 3.5Z"
                                                fill="#212121" />
                                        </svg>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div
                            class="w-48 bg-zinc-950/75 flex flex-col justify-evenly flex-1 text-white p-3 pt-1 rounded-3xl text-center">
                            <u class="flex justify-between pl-11 pr-1 ">DESSERTS <svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                <path class="fill-white hover:fill-orange-500" d="M12 9.005a4 4 0 1 1 0 8 4 4 0 0 1 0-8ZM12 5.5c4.613 0 8.596 3.15 9.701 7.564a.75.75 0 1 1-1.455.365 8.503 8.503 0 0 0-16.493.004.75.75 0 0 1-1.455-.363A10.003 10.003 0 0 1 12 5.5Z" fill="#212121"/></svg>
                            </u>
                            <div class="flex items-center justify-center">
                                <img src="image/dessert1.jpg" alt="" class="w-full h-full">
                            </div>
                            <div>
                                <p>
                                    Chocolate Sheet Cake
                                </p>
                                <p>
                                    ₱ 150.00
                                </p>
                                <p>
                                    Status: Live
                                </p>
                                <br>
                                <div class="flex items-center justify-center gap-20 ">
                                    <a href="#">
                                        <svg  width="24" height="24" fill="none" viewBox="0 0 24 24"
                                            xmlns="http://www.w3.org/2000/svg">
                                            <path class="fill-white hover:fill-orange-500"
                                                d="M13.94 5 19 10.06 9.062 20a2.25 2.25 0 0 1-.999.58l-5.116 1.395a.75.75 0 0 1-.92-.921l1.395-5.116a2.25 2.25 0 0 1 .58-.999L13.938 5Zm7.09-2.03a3.578 3.578 0 0 1 0 5.06l-.97.97L15 3.94l.97-.97a3.578 3.578 0 0 1 5.06 0Z"
                                                fill="#212121" />
                                        </svg>
                                    </a>
                                    <a href="#">
                                        <svg width="24" height="24" fill="none" viewBox="0 0 24 24"
                                            xmlns="http://www.w3.org/2000/svg">
                                            <path class="fill-white hover:fill-orange-500"
                                                d="M21.5 6a1 1 0 0 1-.883.993L20.5 7h-.845l-1.231 12.52A2.75 2.75 0 0 1 15.687 22H8.313a2.75 2.75 0 0 1-2.737-2.48L4.345 7H3.5a1 1 0 0 1 0-2h5a3.5 3.5 0 1 1 7 0h5a1 1 0 0 1 1 1Zm-7.25 3.25a.75.75 0 0 0-.743.648L13.5 10v7l.007.102a.75.75 0 0 0 1.486 0L15 17v-7l-.007-.102a.75.75 0 0 0-.743-.648Zm-4.5 0a.75.75 0 0 0-.743.648L9 10v7l.007.102a.75.75 0 0 0 1.486 0L10.5 17v-7l-.007-.102a.75.75 0 0 0-.743-.648ZM12 3.5A1.5 1.5 0 0 0 10.5 5h3A1.5 1.5 0 0 0 12 3.5Z"
                                                fill="#212121" />
                                        </svg>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div
                            class="w-48 bg-zinc-950/75 flex flex-col justify-evenly flex-1 text-white p-3 pt-1 rounded-3xl text-center">
                            <u class="flex justify-between pl-11 pr-1 ">DESSERTS <svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                <path class="fill-white hover:fill-orange-500" d="M12 9.005a4 4 0 1 1 0 8 4 4 0 0 1 0-8ZM12 5.5c4.613 0 8.596 3.15 9.701 7.564a.75.75 0 1 1-1.455.365 8.503 8.503 0 0 0-16.493.004.75.75 0 0 1-1.455-.363A10.003 10.003 0 0 1 12 5.5Z" fill="#212121"/></svg>
                            </u>
                            <div class="flex items-center justify-center">
                                <img src="image/dessert2.jpg" alt="" class="w-full h-full">
                            </div>
                            <div>
                                <p>
                                    Caramel Pretzel Skillet
                                </p>
                                <p>
                                    ₱ 100.00
                                </p>
                                <p>
                                    Status: Live
                                </p>
                                <br>
                                <div class="flex items-center justify-center gap-20 ">
                                    <a href="#">
                                        <svg  width="24" height="24" fill="none" viewBox="0 0 24 24"
                                            xmlns="http://www.w3.org/2000/svg">
                                            <path class="fill-white hover:fill-orange-500"
                                                d="M13.94 5 19 10.06 9.062 20a2.25 2.25 0 0 1-.999.58l-5.116 1.395a.75.75 0 0 1-.92-.921l1.395-5.116a2.25 2.25 0 0 1 .58-.999L13.938 5Zm7.09-2.03a3.578 3.578 0 0 1 0 5.06l-.97.97L15 3.94l.97-.97a3.578 3.578 0 0 1 5.06 0Z"
                                                fill="#212121" />
                                        </svg>
                                    </a>
                                    <a href="#">
                                        <svg width="24" height="24" fill="none" viewBox="0 0 24 24"
                                            xmlns="http://www.w3.org/2000/svg">
                                            <path class="fill-white hover:fill-orange-500"
                                                d="M21.5 6a1 1 0 0 1-.883.993L20.5 7h-.845l-1.231 12.52A2.75 2.75 0 0 1 15.687 22H8.313a2.75 2.75 0 0 1-2.737-2.48L4.345 7H3.5a1 1 0 0 1 0-2h5a3.5 3.5 0 1 1 7 0h5a1 1 0 0 1 1 1Zm-7.25 3.25a.75.75 0 0 0-.743.648L13.5 10v7l.007.102a.75.75 0 0 0 1.486 0L15 17v-7l-.007-.102a.75.75 0 0 0-.743-.648Zm-4.5 0a.75.75 0 0 0-.743.648L9 10v7l.007.102a.75.75 0 0 0 1.486 0L10.5 17v-7l-.007-.102a.75.75 0 0 0-.743-.648ZM12 3.5A1.5 1.5 0 0 0 10.5 5h3A1.5 1.5 0 0 0 12 3.5Z"
                                                fill="#212121" />
                                        </svg>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div
                            class="w-48 bg-zinc-950/75 flex flex-col justify-evenly flex-1 text-white p-3 pt-1 rounded-3xl text-center">
                            <u class="flex justify-between pl-11 pr-1 ">DESSERTS <svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                <path class="fill-white hover:fill-orange-500" d="M12 9.005a4 4 0 1 1 0 8 4 4 0 0 1 0-8ZM12 5.5c4.613 0 8.596 3.15 9.701 7.564a.75.75 0 1 1-1.455.365 8.503 8.503 0 0 0-16.493.004.75.75 0 0 1-1.455-.363A10.003 10.003 0 0 1 12 5.5Z" fill="#212121"/></svg>
                            </u>
                            <div class="flex items-center justify-center   ">
                                <img src="image/dessert3.jpg" alt="" class="w-full h-full">
                            </div>
                            <div>
                                <p>
                                    Mint Oreo Cake
                                </p>
                                <p>
                                    ₱ 100.00
                                </p>
                                <p>
                                    Status: Live
                                </p>
                                <br>
                                <div class="flex items-center justify-center gap-20 ">
                                    <a href="#">
                                        <svg  width="24" height="24" fill="none" viewBox="0 0 24 24"
                                            xmlns="http://www.w3.org/2000/svg">
                                            <path class="fill-white hover:fill-orange-500"
                                                d="M13.94 5 19 10.06 9.062 20a2.25 2.25 0 0 1-.999.58l-5.116 1.395a.75.75 0 0 1-.92-.921l1.395-5.116a2.25 2.25 0 0 1 .58-.999L13.938 5Zm7.09-2.03a3.578 3.578 0 0 1 0 5.06l-.97.97L15 3.94l.97-.97a3.578 3.578 0 0 1 5.06 0Z"
                                                fill="#212121" />
                                        </svg>
                                    </a>
                                    <a href="#">
                                        <svg width="24" height="24" fill="none" viewBox="0 0 24 24"
                                            xmlns="http://www.w3.org/2000/svg">
                                            <path class="fill-white hover:fill-orange-500"
                                                d="M21.5 6a1 1 0 0 1-.883.993L20.5 7h-.845l-1.231 12.52A2.75 2.75 0 0 1 15.687 22H8.313a2.75 2.75 0 0 1-2.737-2.48L4.345 7H3.5a1 1 0 0 1 0-2h5a3.5 3.5 0 1 1 7 0h5a1 1 0 0 1 1 1Zm-7.25 3.25a.75.75 0 0 0-.743.648L13.5 10v7l.007.102a.75.75 0 0 0 1.486 0L15 17v-7l-.007-.102a.75.75 0 0 0-.743-.648Zm-4.5 0a.75.75 0 0 0-.743.648L9 10v7l.007.102a.75.75 0 0 0 1.486 0L10.5 17v-7l-.007-.102a.75.75 0 0 0-.743-.648ZM12 3.5A1.5 1.5 0 0 0 10.5 5h3A1.5 1.5 0 0 0 12 3.5Z"
                                                fill="#212121" />
                                        </svg>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div
                            class="w-48 bg-zinc-950/75 flex flex-col justify-evenly flex-1 text-white p-3 pt-1 rounded-3xl text-center">
                            <u class="flex justify-between pl-11 pr-1 ">DESSERTS <svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                <path class="fill-white hover:fill-orange-500" d="M12 9.005a4 4 0 1 1 0 8 4 4 0 0 1 0-8ZM12 5.5c4.613 0 8.596 3.15 9.701 7.564a.75.75 0 1 1-1.455.365 8.503 8.503 0 0 0-16.493.004.75.75 0 0 1-1.455-.363A10.003 10.003 0 0 1 12 5.5Z" fill="#212121"/></svg>
                            </u>
                            <div class="flex items-center justify-center">
                                <img src="image/dessert4.jpg" alt="" class="w-full h-full">
                            </div>
                            <div>
                                <p>
                                    Gooey Brownies
                                </p>
                                <p>
                                    ₱ 150.00
                                </p>
                                <p>
                                    Status: Sold Out
                                </p>
                                <br>
                                <div class="flex items-center justify-center gap-20 ">
                                    <a href="#">
                                        <svg  width="24" height="24" fill="none" viewBox="0 0 24 24"
                                            xmlns="http://www.w3.org/2000/svg">
                                            <path class="fill-white hover:fill-orange-500"
                                                d="M13.94 5 19 10.06 9.062 20a2.25 2.25 0 0 1-.999.58l-5.116 1.395a.75.75 0 0 1-.92-.921l1.395-5.116a2.25 2.25 0 0 1 .58-.999L13.938 5Zm7.09-2.03a3.578 3.578 0 0 1 0 5.06l-.97.97L15 3.94l.97-.97a3.578 3.578 0 0 1 5.06 0Z"
                                                fill="#212121" />
                                        </svg>
                                    </a>
                                    <a href="#">
                                        <svg width="24" height="24" fill="none" viewBox="0 0 24 24"
                                            xmlns="http://www.w3.org/2000/svg">
                                            <path class="fill-white hover:fill-orange-500"
                                                d="M21.5 6a1 1 0 0 1-.883.993L20.5 7h-.845l-1.231 12.52A2.75 2.75 0 0 1 15.687 22H8.313a2.75 2.75 0 0 1-2.737-2.48L4.345 7H3.5a1 1 0 0 1 0-2h5a3.5 3.5 0 1 1 7 0h5a1 1 0 0 1 1 1Zm-7.25 3.25a.75.75 0 0 0-.743.648L13.5 10v7l.007.102a.75.75 0 0 0 1.486 0L15 17v-7l-.007-.102a.75.75 0 0 0-.743-.648Zm-4.5 0a.75.75 0 0 0-.743.648L9 10v7l.007.102a.75.75 0 0 0 1.486 0L10.5 17v-7l-.007-.102a.75.75 0 0 0-.743-.648ZM12 3.5A1.5 1.5 0 0 0 10.5 5h3A1.5 1.5 0 0 0 12 3.5Z"
                                                fill="#212121" />
                                        </svg>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Addmenu Form -->
    <div class="fixed top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 h-screen w-full bg-neutral-950/60 hidden" id="overlay"></div>
    <form id="addmenuForm" class="hidden fixed top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 justify-center items-center w-1/2">
        <div class="bg-contain  bg-slate-100/50 rounded-2xl w-full p-10">
            <h1 class="text-3xl font-bold text-center">ADD MENU</h1><br>
            <input type="text" placeholder="Menu Name"
                class="p-2 w-full items-start rounded-2xl text-slate-950">
            <br><br>
            <textarea name="Description" placeholder="Description" class="p-2 w-full items-start rounded-2xl text-slate-950"
             cols="30" rows="5"></textarea>
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

<script defer src="./js/popup.js"></script>
</body>
</html>