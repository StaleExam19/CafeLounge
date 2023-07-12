const addmenuForm = document.getElementById("addmenuForm");
const overlay = document.getElementById("overlay");
const addmenuToggle = document.getElementById("addmenuToggle");

let formIsHidden = true;

function toggleForm() {
    if (formIsHidden) {
        addmenuForm.classList.replace("hidden", "flex");
        overlay.classList.remove("hidden");
        formIsHidden = false;
    } else {
        addmenuForm.classList.replace("flex", "hidden");
        overlay.classList.add("hidden");
        formIsHidden = true;
    }
}

addmenuToggle.addEventListener("click", evt => toggleForm());
overlay.addEventListener("click", evt => toggleForm());