<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Add Menu Form -->
<form:form action="/update" method="post" enctype="multipart/form-data" modelAttribute="menuForm" class="update-form hidden gap-5">
    <h1 class="text-3xl font-bold text-center">UPDATE MENU</h1>
    <form:input type="text" path="name" placeholder="Menu Name" class="menu-name"/>
    <form:textarea name="Description" path="description" placeholder="Description" class="description" cols="30" rows="5"></form:textarea>
    <form:input type="number" path="price" placeholder="Price" class="price"/>
    <form:input type="number" path="quantity" placeholder="Quantity" class="quantity"/>
    <form:select path="category" class="p-2 w-full items-start rounded-2xl border-none category">
        <option disabled="" selected="">-Select Categories-</option>
        <option value="appetizer">Appetizer</option>
        <option value="main course">Main Course</option>
        <option value="dessert">Dessert</option>
        <option value="drinks">Drinks</option>
    </form:select>
    <form:select path="status" class="p-2 w-full items-start rounded-2xl border-none status">
        <option disabled="" selected="">-Status-</option>
        <option value="live">Live</option>
        <option value="sold out">Sold Out</option>
        <option value="delisted">Delisted</option>
    </form:select>
    <form:input path="image" type="file" value="Choose File" placeholder="Choose file" class=" bg-white"/>

    <input type="submit" value="Update" class="btn bg-orange-500">
</form:form>