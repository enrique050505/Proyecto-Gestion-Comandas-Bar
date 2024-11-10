package Modelo;

import javax.swing.ImageIcon;

public class Comida {
	
	private ImageIcon imagenComida;
	private double precio;
	private String nombre;
	
	public Comida(ImageIcon imagenComida, double precio, String nombre) {
		this.imagenComida = imagenComida;
		this.precio = precio;
		this.nombre = nombre;
	}

	public ImageIcon getImagenComida() {
		return imagenComida;
	}

	public void setImagenComida(ImageIcon imagenComida) {
		this.imagenComida = imagenComida;
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
