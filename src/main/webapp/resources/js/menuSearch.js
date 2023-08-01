const menuSearchInput = document.getElementById("menu-search-input");
const searchResult = document.getElementById("search-result");

const showSearchResult = _ => searchResult.classList.replace("hidden", "flex");
const hideSearchResult = _ => {
    searchResult.innerHTML = "";
    searchResult.classList.replace("flex", "hidden")
};

menuSearchInput.addEventListener("focus", showSearchResult)
menuSearchInput.addEventListener("blur", hideSearchResult);

searchResult.addEventListener("mouseover", _ => menuSearchInput.removeEventListener("blur", hideSearchResult));
searchResult.addEventListener("mouseleave", _ => menuSearchInput.addEventListener("blur", hideSearchResult));

menuSearchInput.addEventListener("keyup", async evt => {
    const value = evt.target.value;

    if (value == "") return;

    const response = await fetch(`/api/menu?search=${value}`);
    const data = await response.json();
    
    searchResult.innerHTML = "";
    for (let i = 0; i < data.length; i++) {
        const result = data[i];

        searchResult.innerHTML += `
        <a href="/menulist/${result.category}?id=${result.id}&status=${result.status}" 
        class="flex justify-between items-center p-5 h-20 hover:bg-neutral-800">
            <h3 class="text-white">${result.name}</h3>
            <div>
                <p class="text-neutral-400 text-sm">Category: ${result.category}</p>
                <p class="text-neutral-400 text-sm">Status: ${result.status}</p>
            </div>
        </a>
        `
    }
});
