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
	
	public Producto(ImageIcon imagenProducto, double precio, String nombre, ArrayList<Ingrediente> ingredientes, double proteinas, double grasas) {
		this.imagenProducto = imagenProducto;
		this.precio = precio;
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.proteinas = proteinas;
		this.grasas = grasas;
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
	
	public void setProteinas(int proteinas) {
		this.proteinas = proteinas;
	}
	
	public double getGrasas() {
		return grasas;
	}
	
	public void setGrasas(int grasas) {
		this.grasas = grasas;
	}
	
	
}
