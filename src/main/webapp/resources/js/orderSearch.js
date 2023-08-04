const orderSearchInput = document.getElementById("order-search-input");
const searchResult = document.getElementById("search-result");


/**
 * 
 * @param {any[]} data 
 * @param {string} query 
 */
function filterData(data, query) {
    const result = data.filter(val =>
        val.customerName
            .toLowerCase()
            .includes(query.toLowerCase()));
    return result;
}

const showSearchResult = () => searchResult.classList.replace("hidden", "flex");
const hideSearchResult = () => searchResult.classList.replace("flex", "hidden");

window.addEventListener("load", async _ => {
    const response = await fetch("/api/orders");
    const data = await response.json();


    orderSearchInput.addEventListener("focus", showSearchResult);
    orderSearchInput.addEventListener("blur", hideSearchResult);

    searchResult.addEventListener("mouseover", _ => orderSearchInput.removeEventListener("blur", hideSearchResult));
    searchResult.addEventListener("mouseleave", _ => orderSearchInput.addEventListener("blur", hideSearchResult))

    orderSearchInput.addEventListener("keyup", evt => {
        const value = evt.target.value;
        const result = filterData(data, value);

        searchResult.innerHTML = "";

        if (value == "") return;
        
        for (let i = 0; i < result.length; i++) {
            searchResult.innerHTML += `
            <a href="/order/${result[i].orderNumber}" 
            class="flex justify-between items-center p-5 h-20 hover:bg-neutral-800">
                <h3 class="text-white">${result[i].customerName}</h3>
                <div>
                    <p class="text-neutral-400 text-sm">Order #: 
                        <span style="text-transform: capitalize">${result[i].orderNumber}</span>
                    </p>
                    <p class="text-neutral-400 text-sm">Status: 
                        <span style="text-transform: capitalize">${result[i].status}</span>
                    </p>
                </div>
            </a>
            `;
        }
    });
});