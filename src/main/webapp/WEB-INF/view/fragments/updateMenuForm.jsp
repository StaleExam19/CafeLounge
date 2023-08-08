<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:if test="${not empty updateMenuError}">
    <c:set var="updateMenuVisibility" value="flex"/>
</c:if>

<c:if test="${empty updateMenuError}">
    <c:set var="updateMenuVisibility" value="hidden"/>
</c:if>

<div class="updatemenu-form-overlay ${updateMenuVisibility}"></div>

<!-- Add Menu Form -->
<form:form action="/updateMenu/${menuId}" method="post" enctype="multipart/form-data" modelAttribute="menuForm" class="update-form ${updateMenuVisibility}">
    <h1 class="text-3xl font-bold text-center">UPDATE MENU</h1>
    <c:if test="${not empty updateMenuError}">
        <div class="text-red-900">
            ${updateMenuError}
        </div>
    </c:if>
    <div class="w-full">
        <label for="name" class="ml-2">Menu Name</label>
        <form:input type="text" path="name" placeholder="Enter Menu Name" class="menu-name"/>
    </div>
    <div class="w-full">
        <label for="description" class="ml-2">Description</label>
        <form:textarea name="Description" path="description" placeholder="Enter Menu Description" class="description" cols="30" rows="5"></form:textarea>
    </div>

    <div class="w-full">
        <label for="price" class="ml-2">Price</label>
        <form:input type="number" path="price" placeholder="Price" class="price"/>
    </div>

    <div class="w-full">
        <label for="quantity" class="ml-2">Quantity</label>
        <form:input type="number" path="quantity" placeholder="Quantity" class="quantity"/>
    </div>

    <div class="w-full">
        <label for="quantity" class="ml-2">Category</label>
        <form:select path="category" class="p-2 w-full items-start rounded-2xl border-none category">
            <option disabled="" selected="">-Select Categories-</option>
            <option value="appetizer">Appetizer</option>
            <option value="main course">Main Course</option>
            <option value="dessert">Dessert</option>
            <option value="drink">Drinks</option>
        </form:select>
    </div>

    <div class="w-full">
        <label for="status" class="ml-2">Status</label>
        <form:select path="status" class="p-2 w-full items-start rounded-2xl border-none status">
            <option disabled="" selected="">-Status-</option>
            <option value="live">Live</option>
            <option value="delisted">Delisted</option>
        </form:select>
    </div>
    
    <div class="w-full">
        <label for="status" class="ml-2">Menu Image</label>
        <form:input path="image" type="file" class=" bg-white"/>
    </div>
    <br>
    <div class="w-full flex gap-2">
        <input type="submit" value="update" class="btn bg-orange-500">
        <button type="button" class="btn" id="updatemenu-cancel">Cancel</button>
    </div>
</form:form>