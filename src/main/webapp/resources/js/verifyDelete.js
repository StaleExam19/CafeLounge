const verification = document.querySelector(".verification");
const yesBtn = document.querySelector(".verification .yes-btn");
const noBtn = document.querySelector(".verification .no-btn");

document.addEventListener("click", evt => {
    /**@type {HTMLAnchorElement} */
    const target = evt.target;

    if (target.matches("[data-verify-delete]")) {
        evt.preventDefault();
        const href = target.href;
        // show the verification popup
        verification.classList.replace("hidden", "flex");
        // Update the href of the yes anchor
        yesBtn.href = href;
    }
});

noBtn.addEventListener("click", _ => 
    verification.classList.replace("flex", "hidden"));