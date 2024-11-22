package Modelo;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Producto {
	
	private ImageIcon imagenProducto;
	private double precio;
	private String nombre;
	private ArrayList<Ingrediente> ingredientes;
	private double proteinas;
	private double grasas;
	private int cantidadStock;
	private int stockMaximo;
	
	public Producto(ImageIcon imagenProducto, double precio, String nombre, ArrayList<Ingrediente> ingredientes,
			double proteinas, double grasas, int stockMaximo) {
		this.imagenProducto = imagenProducto;
		this.precio = precio;
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.proteinas = proteinas;
		this.grasas = grasas;
		this.cantidadStock = stockMaximo;
		this.stockMaximo = stockMaximo;
	}

	public ImageIcon getImagenProducto() {
		return imagenProducto;
	}

	public void setImagenProducto(ImageIcon imagenProducto) {
		this.imagenProducto = imagenProducto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public double getProteinas() {
		return proteinas;
	}

	public void setProteinas(double proteinas) {
		this.proteinas = proteinas;
	}

	public double getGrasas() {
		return grasas;
	}

	public void setGrasas(double grasas) {
		this.grasas = grasas;
	}

	public int getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}

	public int getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	@Override
	public String toString() {
		return "Producto [imagenProducto=" + imagenProducto + ", precio=" + precio + ", nombre=" + nombre
				+ ", ingredientes=" + ingredientes + ", proteinas=" + proteinas + ", grasas=" + grasas
				+ ", cantidadStock=" + cantidadStock + ", stockMaximo=" + stockMaximo + "]";
	}
	
	
}
