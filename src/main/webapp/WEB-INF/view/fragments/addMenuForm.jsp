<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:if test="${not empty error}">
    <c:set var="visibility" value="flex"/>
</c:if>

<c:if test="${empty error}">
    <c:set var="visibility" value="hidden"/>
</c:if>

<!-- Add Menu Form -->
<div class="form-overlay ${visibility}"></div>
<form:form action="/addmenu " method="post" enctype="multipart/form-data" modelAttribute="menuForm" class="addmenu-form ${visibility}">
    <h1 class="text-3xl font-bold text-center">ADD MENU</h1>
    <c:if test="${not empty error}">
        <div class="text-red-900">
            ${error}
        </div>
    </c:if>
    <form:input type="text" path="name" placeholder="Menu Name"/>
    <form:textarea name="Description" path="description" placeholder="Description" class="" cols="30" rows="5"></form:textarea>
    <form:input type="number" path="price" placeholder="Price"/>
    <form:input type="number" path="quantity" placeholder="Quantity"/>
    <form:select path="category" class="p-2 w-full items-start rounded-2xl border-none">
        <option disabled="" selected="">-Select Categories-</option>
        <option value="appetizer">Appetizer</option>
        <option value="main course">Main Course</option>
        <option value="dessert">Dessert</option>
        <option value="drinks">Drinks</option>
    </form:select>
    <form:select path="status" class="p-2 w-full items-start rounded-2xl border-none">
        <option disabled="" selected="">-Status-</option>
        <option value="live">Live</option>
        <option value="sold out">Sold Out</option>
        <option value="delisted">Delisted</option>
    </form:select>
    <form:input path="image" type="file" value="Choose File" placeholder="Choose file" class=" bg-white"/>

    <input type="submit" value="add menu" class="btn bg-orange-500">
</form:form>