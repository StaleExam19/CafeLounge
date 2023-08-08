const addMenuFormOverlay = document.querySelector(".addmenu-form-overlay");
const updateMenuFormOverlay = document.querySelector(".updatemenu-form-overlay");
const addmenuToggler = document.querySelector(".addmenu-toggler");

const addmenuForm = document.querySelector(".addmenu-form");
const updatemenuForm = document.querySelector(".update-form")
const updateMenuCancelBtn = document.getElementById("updatemenu-cancel");
const addMenuCancelBtn = document.getElementById("addmenu-cancel");

function showAddMenuForm() {
    addMenuFormOverlay.classList.remove("hidden");
    addmenuForm.classList.replace("hidden", "flex");
}

function hideAddMenuForm() {
    addMenuFormOverlay.classList.add("hidden");
    addmenuForm.classList.replace("flex", "hidden");
}

/**
 * 
 * @param {Menu} data 
 */
function showUpdateForm(data) {
    updateMenuFormOverlay.classList.remove("hidden");
    updatemenuForm.classList.replace("hidden", "flex");

    const menuName = document.querySelector(".update-form .menu-name");
    const description = document.querySelector(".update-form .description");
    const price = document.querySelector(".update-form .price");
    const quantity = document.querySelector(".update-form .quantity");

    /**@type {HTMLSelectElement} */
    const category = document.querySelector(".update-form .category");
    /**@type {HTMLSelectElement} */
    const status = document.querySelector(".update-form .status");
    
    menuName.value = data.name;
    description.value = data.description;
    price.value = data.price;
    quantity.value = data.quantity;

    category.value = data.category;
    status.value = data.status;
}

function hideUpdateForm() {
    updateMenuFormOverlay.classList.add("hidden");

    updatemenuForm.classList.replace("flex", "hidden");
}


addmenuToggler.addEventListener("click", _ => showAddMenuForm());
addMenuFormOverlay.addEventListener("click", _ => hideAddMenuForm());

updateMenuFormOverlay.addEventListener("click", _ => hideUpdateForm())

// Cancel buttons
addMenuCancelBtn.addEventListener("click", _ => hideAddMenuForm());
updateMenuCancelBtn.addEventListener("click", _ => hideUpdateForm()); 