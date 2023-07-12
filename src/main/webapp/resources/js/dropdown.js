const dropdown = document.getElementById("dropdown");


let hidden = true;
dropdown.addEventListener("click", evt => {
    const list = document.getElementById("list");
    if (hidden) {
        list.classList.replace("hidden", "flex")
        hidden = false;
    } else {
        list.classList.replace("flex", "hidden");
        hidden = true;
    }
})