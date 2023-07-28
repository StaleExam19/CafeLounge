const formOverlay = document.querySelector(".form-overlay");
const addmenuToggler = document.querySelector(".addmenu-toggler");
const infoPopup = document.querySelector(".info-popup");

const addmenuForm = document.querySelector(".addmenu-form");
const updatemenuForm = document.querySelector(".update-form")

function showAddMenuForm() {
    formOverlay.classList.remove("hidden");
    addmenuForm.classList.replace("hidden", "flex");
}

function hideAddMenuForm() {
    formOverlay.classList.add("hidden");
    addmenuForm.classList.replace("flex", "hidden");
}

/**
 * 
 * @param {Menu} data 
 */
function showUpdateForm(data) {
    formOverlay.classList.remove("hidden");
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
    formOverlay.classList.add("hidden");
    updatemenuForm.classList.replace("flex", "hidden");
}



/**
 * 
 * @param {Menu} data 
 */
function showInfoPopup(data) {
    const image = document.querySelector(".info-popup img.menu-image");
    const menuName = document.querySelector(".info-popup .menu-name");
    const addedBy = document.querySelector(".added-by");
    const menuDescription = document.querySelector(".menu-description");
    const remainingServings = document.querySelector(".remaining-servings");

    const imageUrl = `/myImage?id=${data.id}`;

    image.src = imageUrl;
    menuName.innerText = data.name;
    addedBy.innerText = data.addedBy;
    menuDescription.innerText = data.description;
    remainingServings.innerText = data.quantity;

    infoPopup.classList.replace("hidden", "flex");
}

function hideInfoPopup() {
    infoPopup.classList.replace("flex", "hidden");
}


/**
 * 
 * @param {string} base64String 
 */
// function generateBlobUrl(base64String) {
//     const byteChars = atob(base64String);
//     const byteNumbers = new Array(byteChars.length);

//     for (let i = 0; i < byteChars.length; i++)
//         byteNumbers[i] = byteChars.charCodeAt(i);

//     const bytes = new Uint8Array(byteNumbers);
//     const blob = new Blob([bytes]);
//     const blobUrl = URL.createObjectURL(blob);

//     return blobUrl;
// }

addmenuToggler.addEventListener("click", _ => showAddMenuForm());
formOverlay.addEventListener("click", _ => {
    hideAddMenuForm();
    hideUpdateForm();
});


document.addEventListener("click", async evt => {
    const target = evt.target;
    const url = location.host;

    if (target.matches("[data-info-toggle]")) {
        const menuId = target.getAttribute("data-info-toggle");
        const response = await fetch(`/api/menu/${menuId}`);

        /**@type {Menu} */
        const data = await response.json();

        showInfoPopup(data);
    }

    if (target.matches("[data-close-info]")) hideInfoPopup();

    if (target.matches("[data-menu-delete]")) {
        const menuId = target.getAttribute("data-menu-delete");
        await fetch(`/api/menu/${menuId}`, {
            method: "delete"
        });
        location.reload();
    }

    if (target.matches("[data-update-menu-id]")) {
        /**@type {HTMLFormElement} */
        const form = document.querySelector(".update-form");
        const id = target.getAttribute("data-update-menu-id");
        const response = await fetch(`/api/menu/${id}`);

        /**@type {Menu} */
        const data = await response.json();

        form.action = `/updateMenu/${id}`;
        showUpdateForm(data);
    }
});
