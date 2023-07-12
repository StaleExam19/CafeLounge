
document.addEventListener("click", evt => {
    if (!evt.target.matches("[data-toggle]")) return;

    const toggle = evt.target;
    const target = toggle.getAttribute("data-toggle");

    const targetElement = document.getElementById(target);

    if (targetElement.classList.contains("hidden"))
        targetElement.classList.replace("hidden", "flex");
    else
        targetElement.classList.replace("flex", "hidden");
});