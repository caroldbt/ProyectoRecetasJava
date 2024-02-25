package model;


import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

public class ModeloProductos {

	private DataSource origenDatos;
	
	public ModeloProductos(DataSource origenDatos) {
		
		this.origenDatos=origenDatos;
	}
	
	public List<Productos2> getProductos() throws Exception{
		
		List<Productos2> productos= new ArrayList<>();
		Connection conn= null;
		Statement stm= null;
		ResultSet rs= null;
		//Establecer conexion
		conn = origenDatos.getConnection();
		//Crear sentencia sql
		String sql= "SELECT * FROM PRODUCTOS";
		stm= conn.createStatement();
		//ejecutar sql
		rs=stm.executeQuery(sql);
		//recorrer el resulset obtenido
		while(rs.next()) {
			int codigo = rs.getInt("codigo");
			String producto=rs.getString("producto");
    		int unidad=rs.getInt("unidad");
    		Productos2 p2= new Productos2(codigo, producto, unidad); 
    		productos.add(p2);
		}
		return productos;		
	}
	public String getProductos2() throws Exception{
		
		String productos= "";
		Connection conn= null;
		Statement stm= null;
		ResultSet rs= null;
		//Establecer conexion
		conn = origenDatos.getConnection();
		//Crear sentencia sql
		String sql= "SELECT * FROM PRODUCTOS";
		stm= conn.createStatement();
		//ejecutar sql
		rs=stm.executeQuery(sql);
		//recorrer el resulset obtenido
		while(rs.next()) {
			int codigo = rs.getInt("codigo");
			String producto=rs.getString("producto");
    		int unidad=rs.getInt("unidad");
    		productos+= producto+",";
		}
		return productos;		
	}

	public void agregarNuevoProductos(Productos2 nuevo) throws Exception{
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement smt= null;
		//Obtener la conexion
		try {
			conn= origenDatos.getConnection();
			//Crear instruccion sql que inserte el producto
			String sql="INSERT INTO PRODUCTOS (codigo,producto,unidad) VALUES(?,?,?)";
			smt=conn.prepareStatement(sql);

			//Establecer parametros para el producto
			smt.setInt(1,nuevo.getCodigo());
			smt.setString(2,nuevo.getProducto());
			smt.setInt(3,nuevo.getUnidad());
			//ejecutar la instruccion sql
			
			smt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			smt.close();
			conn.close();
		}
		
		
		
		
	}

	public Productos2 getProducto(String codigoArticulo) {
		// TODO Auto-generated method stub
		Productos2 pro= null;
		Connection conn= null;
		PreparedStatement stm=null;
		ResultSet rs= null;
		String articulo = codigoArticulo;
		try {
			//Establecer conexion con la BBDD
			conn= origenDatos.getConnection();
			//Crear sql que busque el producto
			String sql="SELECT * from productos WHERE codigo=?";
			//Crear la consulta preparada
			stm= conn.prepareStatement(sql);			
			//Establecer los parametros
			stm.setString(1, articulo);			
			//Ejecutar la consulta
			rs= stm.executeQuery();
			//Obtener los datos de respuesta
			if(rs.next()) {
				int cod=rs.getInt("codigo"); 
				String producto=rs.getString("producto");
	    		int precio=rs.getInt("unidad");
	    		pro= new Productos2(cod, producto, precio); 
			}else {
				throw new Exception("No hemos encontrado el producto con codigo articulo="+articulo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return pro;
	}

	public void actualizarProductos(Productos2 actualizar)throws Exception {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement smt=null;
		//Establecer la conexion
		conn= origenDatos.getConnection();
		//Crear sentencia SQL
		String sql="UPDATE PRODUCTOS SET producto=?, unidad=? WHERE codigo=?";
		//Crear la consulta preparada
		smt= conn.prepareStatement(sql);		
		//Establecer los parametros
		smt.setString(1,  actualizar.getProducto());
		smt.setInt(2,  actualizar.getUnidad());
		smt.setInt(3,  actualizar.getCodigo());
		//Ejecutar la instruccion sql
		smt.execute();
	}

	public void eliminado(int codigo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn= null;
		PreparedStatement pst=null;
		try {
			//Establecer la conexion con BBDD
			conn= origenDatos.getConnection();
			//Crear instruccion SQL de eliminacion
			String sql= "DELETE FROM PRODUCTOS WHERE codigo=?";
			//Preparar parametros de consulta
			pst=conn.prepareStatement(sql);
			//Establecer parametros de consulta
			pst.setInt(1, codigo);
			//Ejecutar sentencia sql
			pst.execute();
		} finally {
			// TODO: handle exception
			pst.close();
			conn.close();
		}
	}
	
	
}
