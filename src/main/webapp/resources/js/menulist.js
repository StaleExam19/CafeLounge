const infoPopup = document.querySelector(".info-popup");

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

    const imageUrl = `/images?id=${data.id}`;

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
