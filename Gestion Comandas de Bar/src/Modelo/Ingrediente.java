package Modelo;

public class Ingrediente {
	
	private String nombreIngrediente;
	private int cantidad;
	private String unidad;
	private int caloriasPorUnidad;
	private double caloriasTotalesPorIngrediente;
	
	public Ingrediente(String nombreIngrediente, int cantidad, String unidad, int caloriasPorUnidad, double caloriasTotalesPorIngrediente) {
		this.nombreIngrediente = nombreIngrediente;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.caloriasPorUnidad = caloriasPorUnidad;
		this.caloriasTotalesPorIngrediente = caloriasTotalesPorIngrediente;
	}

	public String getNombreIngrediente() {
		return nombreIngrediente;
	}

	public void setNombreIngrediente(String nombreIngrediente) {
		this.nombreIngrediente = nombreIngrediente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public int getCaloriasPorUnidad() {
		return caloriasPorUnidad;
	}

	public void setCaloriasPorUnidad(int caloriasPorUnidad) {
		this.caloriasPorUnidad = caloriasPorUnidad;
	}

	public double getCaloriasTotalesPorIngrediente() {
		return caloriasTotalesPorIngrediente;
	}

	public void setCaloriasTotalesPorIngrediente(double caloriasTotalesPorIngrediente) {
		this.caloriasTotalesPorIngrediente = caloriasTotalesPorIngrediente;
	}

	@Override
	public String toString() {
		return "Ingrediente [nombreIngrediente=" + nombreIngrediente + ", cantidad=" + cantidad + ", unidad=" + unidad
				+ ", caloriasPorUnidad=" + caloriasPorUnidad + ", caloriasTotalesPorIngrediente="
				+ caloriasTotalesPorIngrediente + "]";
	}
	
}
