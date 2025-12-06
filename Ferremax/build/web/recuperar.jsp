<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Recuperar Contraseña</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="login-container">
    <h2>Recuperar Contraseña</h2>

    <form action="RecuperarClaveServlet" method="post">
        <input type="text" name="usuario" placeholder="Ingrese su usuario" required><br>
        <button type="submit">Recuperar contraseña</button>
    </form>

    <% if (request.getAttribute("mensaje") != null) { %>
        <p style="color:green"><%= request.getAttribute("mensaje") %></p>
    <% } %>

    <% if (request.getAttribute("error") != null) { %>
        <p style="color:red"><%= request.getAttribute("error") %></p>
    <% } %>
</div>

</body>
</html>
