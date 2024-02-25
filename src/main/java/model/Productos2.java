package model;

public class Productos2 {
	
	private int codigo;
	private String producto;
	private int unidad;
	public Productos2(int codigo, String producto, int unidad) {
		super();
		this.codigo = codigo;
		this.producto = producto;
		this.unidad = unidad;
	}
	
	public Productos2(String producto, int unidad) {
		super();
		this.producto = producto;
		this.unidad = unidad;
	}

	public Productos2() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getUnidad() {
		return unidad;
	}
	public void setUnidad(int unidad) {
		this.unidad = unidad;
	}
	@Override
	public String toString() {
		return "Productos2 [codigo=" + codigo + ", producto=" + producto + ", unidad=" + unidad + "]\n";
	}
	

}
