<div class="flex justify-center gap-2 sm:gap-20">
  <button class="bg-slate-100/50 focus:bg-orange-500 hover:bg-orange-500 p-3 rounded-3xl font-semibold w-40">
    <a href="appetizers">APPETIZERS</a>
  </button>
  <button class="bg-slate-100/50 focus:bg-orange-500 hover:bg-orange-500 p-3 rounded-3xl font-semibold w-40">
    <a href="mainCourse">MAIN COURSE</a>
  </button>
  <button class="bg-slate-100/50 focus:bg-orange-500 hover:bg-orange-500 p-3 rounded-3xl font-semibold w-40">
    <a href="desserts">DESSERTS</a>
  </button>
  <button class="bg-slate-100/50 focus:bg-orange-500 hover:bg-orange-500 p-3 rounded-3xl font-semibold w-40">
    <a href="drinks">DRINKS</a>
  </button>
</div>
<br>

<div class="bg-neutral-950/80 min-h-screen min-w-full">
  <div class="flex items-end space-x">
    <div class="relative inline-block text-left flex w-1/2">
      <div>
        <button type="button" class="inline-flex justify-center w-32 rounded-3xl shadow-sm px-3 py-2 bg-slate-100 text-sm font-semibold text-gray-700 hover:bg-orange-500 hover:text-white focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-orange-500" id="dropdown-button">
          <span class="mr-1" id="dropdown-selection">Live</span>
          <svg class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
            <path fill-rule="evenodd" d="M6.293 6.707a1 1 0 010-1.414l3-3a1 1 0 011.414 0l3 3a1 1 0 01-1.414 1.414L11 5.414V15a1 1 0 11-2 0V5.414L6.707 6.707a1 1 0 01-1.414 0z" clip-rule="evenodd" />
          </svg>
        </button>
      </div>

      <div class="origin-top-left absolute right-0 mt-10 w-32 rounded-md shadow-lg bg-white ring-1 ring-black ring-opacity-5 hidden" id="dropdown-menu">
        <div class="py-1" role="menu" aria-orientation="vertical" aria-labelledby="dropdown-button">
          <a href="menulist/live" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900" role="menuitem" onclick="updateSelection('Live')">Live</a>
          <a href="menulist/soldout" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900" role="menuitem" onclick="updateSelection('Sold out')">Sold out</a>
          <a href="menulist/deleted" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 hover:text-gray-900" role="menuitem" onclick="updateSelection('Deleted')">Deleted</a>
        </div>
      </div>
      
    </div>
    <div class="w-1/2 ">
     <button class=" relative bg-slate-100 text-gray-700 hover:bg-orange-600 hover:text-gray-900 font-semibold py-2 px-4 rounded-xl inline-flex ">
        Add Menu
      </button>
      </div>
  </div>

  <div class="flex justify-between items-center h-24 pt-5"></div>
  <br>

  <div class="flex justify-between ml-8 sm:ml-8">
    <div class="pt-9">
      <div class="bg-slate-100/50 flex p-8 h-96 rounded-2xl gap-6 font-semibold relative">
        <div class="w-48 bg-zinc-950/75 text-white p-3 rounded-3xl text-center">
          <u>CATEGORY</u>
          <div class="flex items-center justify-center">
            <img src="" alt="food_img" class="w-28 h-32">
          </div>
          <div>
            <p>FOOD NAME</p>
            <p>PRICE</p>
            <p>Status: "STATUS"</p>
            <br>
            <div class="flex items-center justify-center gap-8">
              <button class="font-semibold text-center text-black bg-slate-100 hover:bg-orange-500 focus:bg-orange-500 focus:ring-orange-500 p-2 rounded-2xl w-35">Update</button>
              <button class="font-semibold text-center text-black bg-slate-100 hover:bg-orange-500 focus:bg-orange-500 focus:ring-orange-500 p-2 rounded-2xl w-35">Delete</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="<c:url value="/resources/js/menuButtons.js" />"></script>
