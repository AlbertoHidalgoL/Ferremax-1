package servlet;
import dao.ProductoDAO;
import modelo.Producto;
import jakarta.servlet.*; import jakarta.servlet.http.*;
import java.io.IOException; import java.util.List;

public class ProductoServlet extends HttpServlet {
    private ProductoDAO dao = new ProductoDAO();

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion"); if(accion==null) accion="listar";
        switch(accion){
           case "listar":
                req.setAttribute("lista", dao.listar());
                req.getRequestDispatcher("productos.jsp").forward(req, resp);
                break;
            case "obtener":
                int id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("producto", dao.obtenerPorId(id));
                req.setAttribute("lista", dao.listar());
                req.getRequestDispatcher("productos.jsp").forward(req, resp);
                break;
            case "eliminar":
                dao.eliminar(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("ProductoServlet?accion=listar");
                break;
            default:
                resp.sendRedirect("ProductoServlet?accion=listar");
        }
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if("agregar".equals(accion)){
            Producto p = new Producto(); p.setNombre(req.getParameter("nombre")); p.setPrecio(Double.parseDouble(req.getParameter("precio"))); p.setCantidad(Integer.parseInt(req.getParameter("cantidad")));
            dao.agregar(p); resp.sendRedirect("ProductoServlet?accion=listar");
        } else if("actualizar".equals(accion)){
            Producto p = new Producto(); p.setId(Integer.parseInt(req.getParameter("id"))); p.setNombre(req.getParameter("nombre")); p.setPrecio(Double.parseDouble(req.getParameter("precio"))); p.setCantidad(Integer.parseInt(req.getParameter("cantidad")));
            dao.actualizar(p); resp.sendRedirect("ProductoServlet?accion=listar");
        }
    }

    private static class request {

        private static void setAttribute(String lista, List<Producto> lista0) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static Object getRequestDispatcher(String productosjsp) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public request() {
        }
    }
}
