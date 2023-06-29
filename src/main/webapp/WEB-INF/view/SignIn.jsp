<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body >
    <div class="bg-[url('resources/image/bg.png')] bg-cover bg-no-repeat ">
        <div class="bg-neutral-950/80 min-h-screen ">
            <div class="flex items-center h-24 pt-5">
                <nav class="">
                    <img class="h-56 cursor-pointer" src="image/logo.png" alt="">
                </nav>
            </div>
            <form:form action="signin" class="flex justify-center items-center pt-32" modelAttribute="userForm" method="post">
                <div>
                    <h1 class="text-white text-center text-3xl font-semibold">SIGN IN / CHEF</h1>
					<c:if test="${not empty error}">
						<div class="bg-red-500 text-white rounded p-3">
                    		${error}
                    	</div>
					</c:if>
                    <br>
                    <form:input type="text" name="username" path="username" placeholder="Username" class="p-2 w-96 items-start rounded-2xl"/>
                    <br><br>    
                    <form:input type="password" name="password" path="password" placeholder="Password" class="p-2 w-96 items-start rounded-2xl border-none" />
                    <br><br>
                    <div class="flex justify-center">
                        <button class="font-bold text-center text-black bg-orange-500 hover:bg-orange-400 rounded-3xl p-2 w-56 ">Sign In</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    
</body>
</html>