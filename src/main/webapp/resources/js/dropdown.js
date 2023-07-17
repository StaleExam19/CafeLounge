document.addEventListener("click", evt => {
    const target = evt.target;

    if (target.matches("[data-toggle]")) {
        const toggleId = target.getAttribute("data-toggle");
        const targetToggle = document.getElementById(toggleId);

        if (targetToggle.classList.contains("hidden"))
            targetToggle.classList.replace("hidden", "flex");
        else
            targetToggle.classList.replace("flex", "hidden");
    }
});