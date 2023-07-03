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
            <div class="flex justify-between items-center h-24  pt-5 px-12">
                <div class="">
                    <img src="resources/image/logo.png" alt="" class="h-56 cursor-pointer ">
                </div>
                    <div class="flex gap-2">
                        <img src="resources/image/Notif-removebg-preview.png" alt="" class="h-10 cursor-pointer hover:scale-125 ">
                        <img src="resources/image/Untitled_design__8_-removebg-preview.png" alt="" class="h-10 cursor-pointer hover:scale-125">
                     </div>
            </div> <br>

            <div class="h-[calc(100vh-96px)] w-full flex px-12">
                <div class="w-52 flex flex-col justify-center items-center gap-16">
                    <a href="" class="w-full flex justify-center items-center p-3 rounded-3xl font-semibold bg-orange-500">DASHBOARD</a>
                    <a href="" class="bg-slate-100/50 w-full flex justify-center items-center p-3 rounded-3xl font-semibold hover:bg-orange-500">MENU LIST</a>
                    <a href="" class="bg-slate-100/50 w-full flex justify-center items-center p-3 rounded-3xl font-semibold hover:bg-orange-500">ORDER LIST</a>
                </div>
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
