const formOverlay = document.querySelector(".form-overlay");
const addmenuForm = document.querySelector(".addmenu-form");
const addmenuToggler = document.querySelector(".addmenu-toggler");
const infoPopup = document.querySelector(".info-popup");

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
function showInfoPopup(data) {
    const image = document.querySelector(".info-popup img.menu-image");
    const menuName = document.querySelector(".info-popup .menu-name");
    const addedBy = document.querySelector(".added-by");
    const menuDescription = document.querySelector(".menu-description");

    const imageUrl = generateBlobUrl(data.image);

    image.src = imageUrl;
    menuName.innerText = data.name;
    addedBy.innerText = data.addedBy;
    menuDescription.innerText = data.description;

    infoPopup.classList.replace("hidden", "flex");
}

function hideInfoPopup() {
    infoPopup.classList.replace("flex", "hidden");
}


/**
 * 
 * @param {string} base64String 
 */
function generateBlobUrl(base64String) {
    const byteChars = atob(base64String);
    const byteNumbers = new Array(byteChars.length);

    for (let i = 0; i < byteChars.length; i++)
        byteNumbers[i] = byteChars.charCodeAt(i);
    
    const bytes = new Uint8Array(byteNumbers);
    const blob = new Blob([bytes]);
    const blobUrl = URL.createObjectURL(blob);

    return blobUrl;
}

addmenuToggler.addEventListener("click", _ => showAddMenuForm());
formOverlay.addEventListener("click", _ => hideAddMenuForm());

document.addEventListener("click", async evt => {
    const target = evt.target;

    if (target.matches("[data-info-toggle]")) {
        const menuId = target.getAttribute("data-info-toggle");
        const response = await fetch(`/api/menu/${menuId}`);

        /**@type {Menu} */
        const data = await response.json();

        showInfoPopup(data);
    }

    if (target.matches("[data-close-info]")) hideInfoPopup();
});
