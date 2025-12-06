<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession(false);
    if(sesion==null || sesion.getAttribute("usuario")==null){
        response.sendRedirect("login.jsp"); 
        return;
    }
    String usuario = (String) sesion.getAttribute("usuario");
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
    <h2>Bienvenido a Ferremax</h2>

    <div class="menu-grid">
        <a href="ProductoServlet?accion=listar">📦 Productos</a>
        <a href="ClienteServlet?accion=listar">👥 Clientes</a>
        <a href="ExportarProductosExcelServlet">📊 Exportar Excel</a>
        <a href="ExportarProductosPDFServlet">📄 Exportar PDF</a>
    </div>

    <a class="logout-btn" href="LogoutServlet">⛔ Cerrar sesión</a>
</div>

</body>
</html>
