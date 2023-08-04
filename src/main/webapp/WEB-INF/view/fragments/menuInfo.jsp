<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:url var="closeIcon" value="/resources/image/circle-close.png" />

<div class="info-popup fixed top-0 left-0 h-screen w-full bg-black/50 hidden justify-center items-center">
    <div class="w-7/12 h-96 flex relative rounded-xl bg-neutral-900 z-10 text-white">
        <div class="absolute top-1 right-1 w-10 hover:scale-110 cursor-pointer" data-close-info>
            <img src="${closeIcon}" alt="" data-close-info>
        </div>
        <img src="" alt="" class="menu-image h-full flex-1 rounded-tl-xl rounded-bl-xl">
        <div class="flex-1 p-6">
            <h1 class="text-3xl menu-name">Ginamos</h1>
            <br>
            <p>Added by: <span class="added-by">Jacklord Bongo</span></p>
            <br>
            <p>Servings Left: <span class="remaining-servings"></span></p>
            <br>
            <p class="menu-description">Ginamos is a Filipino style of fermented fish. Ginamos is typically made with anchovies or lancelet. Ginamos has a great fishy and salty flavor, making it the perfect condiment or side for sweet and spicy food alike!</p>
        </div>
    </div>
</div>