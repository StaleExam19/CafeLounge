<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="css" value="/resources/css/style.css"/>
<c:url var="js" value="/resources/js/dropdown.js"/>
<c:url var="bgImage" value="/resources/image/background.jpg"/>


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <link rel="preload" as="image" href="${bgImage}">
    <link rel="stylesheet" href="${css}">
    <style>
        body {
            background-color: #0000004d;
            background-image: url(${bgImage});
            background-size: cover;
            background-blend-mode: multiply
        }
    </style>

    <script defer src="${js}"></script>
</head>