package Modelo;

import javax.swing.ImageIcon;

public class Producto {
	
	private ImageIcon imagenProducto;
	private double precio;
	private String nombre;
	
	public Producto(ImageIcon imagenProducto, double precio, String nombre) {
		this.imagenProducto = imagenProducto;
		this.precio = precio;
		this.nombre = nombre;
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
	
	
	
}
