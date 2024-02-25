package controlador;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.ModeloProductos;
import model.Productos2;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModeloProductos modeloProductos;
	@Resource(name="jdbc/Productos")
	private DataSource miPool;

	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			modeloProductos = new ModeloProductos(miPool);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Leer el parametro del formulario
		String elComando= request.getParameter("instruccion");
		//Si no se envia el parametro, listar productos
		if(elComando==null) elComando="listar";
		//Redirigir el flujo de ejecucion  al metodo adecuado
		switch (elComando) {
		case "listar": 
			obtenerProductos(request, response);
			break;
		case "insertarBBDD":
			agregarProducto(request, response);
			break;
		case "cargar":
			try {
				cargaProductos(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "updateBBDD":
			try {
				actualizarProductos(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "eliminar":
			try {
				eliminarProductos(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "creador":
			obtener(request, response);
			break;
		default:
			obtenerProductos(request, response);
		}
		
		
		
	}


	private void eliminarProductos(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		//Capturar el codigo articulo
		int codigo=Integer.parseInt(request.getParameter("articulo"));
		//Borrar producto de la base de datos
		modeloProductos.eliminado(codigo);
		//Volver al listado de productos
		obtenerProductos(request, response);
	}


	private void actualizarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		
		//Leer los datos que le vienen del formulario actualizar
		int codigo= Integer.parseInt(request.getParameter("codigo"));
		String producto= request.getParameter("producto");
		int unidad= Integer.parseInt(request.getParameter("unidad"));
		//Crear un objeto de tipo Producto con la info del formulario
		Productos2 actualizar= new Productos2(codigo,producto,unidad);
		//Enviar el objeto al modelo y despues insertar el objeto Producto en la BBDD
		modeloProductos.actualizarProductos(actualizar);
		//Volver al listado de Productos
		obtenerProductos(request, response);
		
	}


	private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		
		//Leer el codigo articulo que viene del listado
		String codigoArticulo= request.getParameter("articulo");
		//Enviar codigo articulo a modelo
		Productos2 pro = modeloProductos.getProducto(codigoArticulo);
		//Colocar atributo correspondiente al codigo articulo
		request.setAttribute("actualiza", pro);
		//Enviar producto al formulario de actualizar(jsp)
		RequestDispatcher miDispatcher = request.getRequestDispatcher("/update.jsp");
		miDispatcher.forward(request, response);
	}


	private void agregarProducto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//leer la informacion que viene del formulario
		//int codigo= Integer.parseInt(request.getParameter("codigo"));
		String producto= request.getParameter("producto");
		int unidad= Integer.parseInt(request.getParameter("unidad"));
		//Crear un objeto de tipo Producto
		Productos2 nuevo= new Productos2(producto,unidad);
		//Enviar el objeto al modelo y despues insertar el objeto Producto en la BBDD
		try {
			modeloProductos.agregarNuevoProductos(nuevo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Volver al listado de Productos
		obtenerProductos(request, response);
	}


	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//Obtener la lista de productos desde el modelo
		List<Productos2> productos;
		try {
			productos = modeloProductos.getProductos();
			//agregar lista de productos al request
			request.setAttribute("lista", productos);
			//enviar ese request a la pagina JSP
			RequestDispatcher miDispatcher = request.getRequestDispatcher("/index.jsp");
			miDispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private void obtener(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//Obtener la lista de productos desde el modelo
		String productos;
		try {
			productos = modeloProductos.getProductos2();
			//agregar lista de productos al request
			request.setAttribute("lista2", productos);
			//enviar ese request a la pagina JSP
			RequestDispatcher miDispatcher = request.getRequestDispatcher("/creadorRecetas.jsp");
			miDispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
