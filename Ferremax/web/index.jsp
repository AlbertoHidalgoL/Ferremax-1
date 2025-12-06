<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    // Validación de sesión
    HttpSession sesion = request.getSession(false);

    if(sesion == null || sesion.getAttribute("usuario") == null){
        response.sendRedirect("login.jsp");
        return;
    }

    String usuario = (String) sesion.getAttribute("usuario");
    String rol = (String) sesion.getAttribute("rol"); // OBTENER ROL
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Panel</title>
    <link rel="stylesheet" href="indexStyle.css">
</head>
<body>

<div class="panel">
    <h2>Bienvenido <%= usuario %> (Rol: <%= rol %>)</h2>

    <div class="menu-grid">

        <%-- MENU PARA ADMINISTRADOR --%>
        <% if ("administrador".equalsIgnoreCase(rol)) { %>

            <a href="ProductoServlet?accion=listar">📦 Productos</a>
            <a href="ClienteServlet?accion=listar">👥 Usuarios</a>
            <a href="AgregarUsuario.jsp">➕ Agregar usuario</a>
            <a href="AdminReportes.jsp">📊 Reportes Admin</a>

        <% } %>

        <%-- MENU PARA EMPLEADO --%>
        <% if ("empleado".equalsIgnoreCase(rol)) { %>

            <a href="InventarioServlet?accion=listar">📦 Inventario</a>
            <a href="ClienteServlet?accion=listar">👥 Usuarios</a>
            <a href="VentasServlet?accion=listar">🛒 Ventas</a>

        <% } %>

    </div>

    <a class="logout-btn" href="LogoutServlet">⛔ Cerrar sesión</a>
</div>

</body>
</html>
