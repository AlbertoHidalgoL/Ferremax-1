package servlet;
import dao.UsuarioDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        UsuarioDAO dao = new UsuarioDAO();
        if (dao.validar(usuario, clave)) {
    HttpSession sesion = request.getSession();
    sesion.setAttribute("usuario", usuario);
    response.sendRedirect("index.jsp");
} else {
    request.setAttribute("error", "Usuario o contraseña incorrectos");
    request.getRequestDispatcher("login.jsp").forward(request, response);
}

    }
}
