<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="formOverlay.jsp" %>

<c:if test="${not empty addMenuError}">
    <c:set var="addMenuVisibility" value="flex"/>
</c:if>

<c:if test="${empty addMenuError}">
    <c:set var="addMenuVisibility" value="hidden"/>
</c:if>
<div class="addmenu-form-overlay ${addMenuVisibility}"></div>

<form:form action="/addmenu " method="post" enctype="multipart/form-data" modelAttribute="menuForm" class="addmenu-form ${addMenuVisibility}">
    <h1 class="text-3xl font-bold text-center">ADD MENU</h1>
    <c:if test="${not empty addMenuError}">
        <div class="bg-red-500 p-2 rounded">
            ${addMenuError}
        </div>
    </c:if>
    <div class="w-full">
        <label for="name" class="ml-2">Menu Name</label>
        <form:input type="text" path="name" placeholder="Enter Menu Name"/>
    </div>
    <div class="w-full">
        <label for="description" class="ml-2">Description</label>
        <form:textarea name="Description" path="description" placeholder="Enter Menu Description" class="" cols="30" rows="5"></form:textarea>
    </div>

    <div class="w-full">
        <label for="price" class="ml-2">Price</label>
        <form:input type="number" path="price" placeholder="Price"/>
    </div>

    <div class="w-full">
        <label for="quantity" class="ml-2">Quantity</label>
        <form:input type="number" path="quantity" placeholder="Quantity"/>
    </div>

    <div class="w-full">
        <label for="quantity" class="ml-2">Category</label>
        <form:select path="category" class="p-2 w-full items-start rounded-2xl border-none">
            <option disabled="" selected="">-Select Categories-</option>
            <option value="appetizer">Appetizer</option>
            <option value="main course">Main Course</option>
            <option value="dessert">Dessert</option>
            <option value="drink">Drinks</option>
        </form:select>
    </div>

    <div class="w-full">
        <label for="status" class="ml-2">Status</label>
        <form:select path="status" class="p-2 w-full items-start rounded-2xl border-none">
            <option disabled="" selected="">-Status-</option>
            <option value="live">Live</option>
            <option value="delisted">Delisted</option>
        </form:select>
    </div>
    
    <div class="w-full">
        <label for="status" class="ml-2">Menu Image</label>
        <form:input path="image" type="file" placeholder="Choose file" class=" bg-white"/>
    </div>
    <br>
    <div class="w-full flex gap-2">
        <input type="submit" value="add" class="btn bg-orange-500">
        <button type="button" class="btn" id="addmenu-cancel">Cancel</button>
    </div>
</form:form>