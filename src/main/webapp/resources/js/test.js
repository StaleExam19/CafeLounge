const image = document.querySelector("img");

async function init() {
    const response = await fetch("/api/menu/1");
    const data = await response.json();

    console.log(data);

    const base64String = data["image"];
    const byteChar = atob(base64String);
    const byteArrays = [];

    for (let i = 0; i < byteChar.length; i++) 
        byteArrays.push(byteChar.charCodeAt(i));

    const blob = new Blob([new Uint8Array(byteArrays)]);
    const imageUrl = URL.createObjectURL(blob);

    image.src = imageUrl;
}

init();