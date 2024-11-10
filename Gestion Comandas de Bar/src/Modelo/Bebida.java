package Modelo;

import javax.swing.ImageIcon;

public class Bebida {
	
	private ImageIcon imagenBebida;
	private double precio;
	private String nombre;
	
	public Bebida(ImageIcon imagenBebida, double precio, String nombre) {
		this.imagenBebida = imagenBebida;
		this.precio = precio;
		this.nombre = nombre;
	}

	public ImageIcon getImagenBebida() {
		return imagenBebida;
	}

	public void setImagenBebida(ImageIcon imagenBebida) {
		this.imagenBebida = imagenBebida;
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
