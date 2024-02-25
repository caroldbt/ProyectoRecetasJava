package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usu");
        String contrasena = request.getParameter("pass");

        Usuario modelo = new Usuario("admin", "123456"); // Reemplaza con tu lógica de obtención de datos del modelo

        if (usuario.equals(modelo.getNombreUsuario()) && contrasena.equals(modelo.getContrasena())) {
            request.getSession().setAttribute("login", true);
            if (usuario.equals("admin")) {
                response.sendRedirect("inicio.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }
        } else {
            request.setAttribute("respuesta", "Identificación incorrecta");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
