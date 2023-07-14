

document.addEventListener("click", async evt => {
    const target = evt.target;

    if (!target.matches("[data-info-id]")) return;

    const targetId = target.getAttribute("data-info-id");

    const response = await fetch(`/api/menu/${targetId}`);
    const data = await response.json();

    console.log(data);
})