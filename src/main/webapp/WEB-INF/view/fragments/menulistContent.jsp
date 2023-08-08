<c:if test="${not empty menuList}">
    <div class="menulist">
        <!-- Javascript ra ang magbutang sa content diri -->

        <c:forEach var="item" items="${menuList}">
            <div class="menu-card" data-menu-card-id="${item.id}">
                <div class="flex justify-between">
                    <div class="w-6"></div>
                    <div class="uppercase">${item.category}</div>
                    <svg class="group" data-info-toggle="${item.id}"="" width="24" height="24" fill="none"
                        viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                        <path data-info-toggle="${item.id}" class="fill-white group-hover:fill-orange-500"
                            d="M12 9.005a4 4 0 1 1 0 8 4 4 0 0 1 0-8ZM12 5.5c4.613 0 8.596 3.15 9.701 7.564a.75.75 0 1 1-1.455.365 8.503 8.503 0 0 0-16.493.004.75.75 0 0 1-1.455-.363A10.003 10.003 0 0 1 12 5.5Z"
                            fill="#212121" />
                    </svg>
                </div>

                <c:url var="imageController" value="/images" />

                <div class="h-52 flex justify-center items-center bg-neutral-800">
                    <img src="${imageController}?id=${item.id}" class="h-full">
                </div>
                <div class="flex flex-col items-center">
                    <span>${item.name}</span>
                    <span>Php ${item.price}</span>
                    <span>Servings left: <span class="capitalize">${item.quantity}</span></span>
                </div>
                <c:if test="${user.role == 'headchef'}">
                    <div class="w-full flex justify-between px-5">
                        <div class="group" data-update-menu-id="${item.id}">
                            <svg width="24" height="24" fill="none" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"
                                data-update-menu-id="${item.id}">
                                <path class="fill-white group-hover:fill-orange-500" data-update-menu-id="${item.id}"
                                    d="M13.94 5 19 10.06 9.062 20a2.25 2.25 0 0 1-.999.58l-5.116 1.395a.75.75 0 0 1-.92-.921l1.395-5.116a2.25 2.25 0 0 1 .58-.999L13.938 5Zm7.09-2.03a3.578 3.578 0 0 1 0 5.06l-.97.97L15 3.94l.97-.97a3.578 3.578 0 0 1 5.06 0Z" />
                            </svg>
                        </div>

                        <c:url var="delete" value="/deleteMenu" />
                        <a href="${delete}/${item.id}" data-verify-delete>
                            <c:if test="${item.status != 'delisted'}">
                                <svg width="24" height="24" fill="none" viewBox="0 0 24 24" class="pointer-events-none"
                                    xmlns="http://www.w3.org/2000/svg">
                                    <path class="fill-white group-hover:fill-orange-500 pointer-events-none"
                                        d="M21.5 6a1 1 0 0 1-.883.993L20.5 7h-.845l-1.231 12.52A2.75 2.75 0 0 1 15.687 22H8.313a2.75 2.75 0 0 1-2.737-2.48L4.345 7H3.5a1 1 0 0 1 0-2h5a3.5 3.5 0 1 1 7 0h5a1 1 0 0 1 1 1Zm-7.25 3.25a.75.75 0 0 0-.743.648L13.5 10v7l.007.102a.75.75 0 0 0 1.486 0L15 17v-7l-.007-.102a.75.75 0 0 0-.743-.648Zm-4.5 0a.75.75 0 0 0-.743.648L9 10v7l.007.102a.75.75 0 0 0 1.486 0L10.5 17v-7l-.007-.102a.75.75 0 0 0-.743-.648ZM12 3.5A1.5 1.5 0 0 0 10.5 5h3A1.5 1.5 0 0 0 12 3.5Z"
                                        fill="#212121" />
                                </svg>

                            </c:if>
                        </a>
                    </div>
                </c:if>
            </div>
        </c:forEach>
    </div>
</c:if>

<!-- Verification popup -->
<div class="fixed top-0 left-0 h-screen w-full hidden items-center verification justify-center bg-neutral-900/50">
    <div class="bg-neutral-900 p-5 text-white rounded-md ">
        <p class="text-xl">Are you sure you want to delist this item?</p>
        <div class="flex mt-4 gap-4">
            <a href="" class="p-3 text-center bg-red-500 flex-1 rounded-md yes-btn">Yes</a>

            <button class="flex-1 bg-neutral-500 rounded-md no-btn">No</button>
        </div>
    </div>
</div>

<c:if test="${empty menuList}">
    <div class="empty-menulist">
        <p>
            No <span style="text-transform: lowercase;">${status}</span> menu for today
        </p>
    </div>
</c:if>