<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:url var="dashboardRoute" value="/" />

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <script src="https://cdn.tailwindcss.com"></script>

    </head>

    <body>
        <div class="bg-[url('resources/image/background.jpg')] bg-cover bg-no-repeat ">
            <div class="bg-zinc-950/40 min-h-screen ">
                <%@include file="fragments/topnav.jsp" %>
                    <br>

                    <div class="h-[calc(100vh-96px)] w-full flex px-12">
                        <%@include file="fragments/sidenav.jsp" %>

                        <div class="flex-1 pl-12">
                            <table class="text-white w-full">
                                <thead>
                                    <tr class="border">
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>Orders</th>
                                        <th>Total</th>
                                        <th>Payment Method</th>
                                    </tr>
                                </thead>

                                <tbody class="border">
                                    <a href="/adsfdf">
                                        <tr class="h-10">
                                            <td class="text-center">1</td>
                                            <td class="text-center">Louie Abad</td>
                                            <td class="text-center">Cedar-Plank Salmon ( ₱150 x 1)</td>
                                            <td class="text-center">150</td>
                                            <td class="text-center">Cash</td>
                                        </tr>

                                        <tr class="h-10">
                                            <td class="text-center">2</td>
                                            <td class="text-center">Pualina</td>
                                            <td class="text-center">Cedar-Plank Salmon ( ₱150 x 2)</td>
                                            <td class="text-center">300</td>
                                            <td class="text-center">Cash</td>
                                        </tr>

                                        <tr class="h-10">
                                            <td class="text-center">3</td>
                                            <td class="text-center">Paulino</td>
                                            <td class="text-center">Seabreeze Cocktail ( ₱150 x 1)</td>
                                            <td class="text-center">150</td>
                                            <td class="text-center">Cash</td>
                                        </tr>
                                    </a>

                                </tbody>
                            </table>
                        </div>
                    </div>

            </div>
        </div>

    </body>

    </html>