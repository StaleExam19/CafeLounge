const menuSearchInput = document.getElementById("menu-search-input");
const searchResult = document.getElementById("search-result");

menuSearchInput.addEventListener("focus", _ => 
    searchResult.classList.replace("hidden", "flex"))

menuSearchInput.addEventListener("blur", _ => 
    searchResult.classList.replace("flex", "hidden"));

menuSearchInput.addEventListener("change", async evt => {
    const value = evt.target.value;
    
    const response =  await fetch(`/api/menu?search=${value}`);
    const data = await response.json();

    searchResult.innerHTML = "";
    for (let i = 0; i < data.length; i++) {
        const result = data[i];

        searchResult.innerHTML += `
        <div class="flex justify-between items-center p-5 h-20 hover:bg-neutral-800">
         <h3 class="text-white">${result.name}</h3>
        <p class="text-neutral-400 text-sm">Category: ${result.category}</p>
        </div>
        `
    }
})