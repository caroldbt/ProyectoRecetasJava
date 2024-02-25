package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class procesarDatos
 */
@WebServlet("/procesarDatos")
public class procesarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public procesarDatos() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("search");
        String tipoCocina = request.getParameter("tipoCocina"); // Obtén el valor seleccionado del select "tipoCocina"
        String tipoDieta = request.getParameter("tipoDieta");
        String intolerancia = request.getParameter("intolerancia");
        String ordenar = request.getParameter("ordenar");
        // Establece los datos del resultado en el objeto request
        request.setAttribute("container",nombre);
        request.setAttribute("container2", tipoCocina);
        request.setAttribute("container3", tipoDieta);
        request.setAttribute("container4", intolerancia);
        request.setAttribute("container5", ordenar);
        RequestDispatcher dispatcher = request.getRequestDispatcher("filtros.jsp"); // Reenvía la solicitud al mismo formulario JSP
        dispatcher.forward(request, response);
	}

}
