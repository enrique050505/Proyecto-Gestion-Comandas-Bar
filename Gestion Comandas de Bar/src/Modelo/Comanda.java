package Modelo;

import java.util.HashMap;

public class Comanda {
	
	private int id;
	private HashMap<String, Integer> productos;
	private double precioTotal;
	
	public Comanda(int id) {
		this.id = id;
		this.productos = new HashMap<>();
		this.precioTotal = 0.0;
	}


	public void añadirProducto(String nombreProducto, double precio) {
		if(productos.containsKey(nombreProducto)) {
			productos.put(nombreProducto, productos.get(nombreProducto) + 1);
		}else {
			productos.put(nombreProducto, 1);
		}
		precioTotal = precioTotal + precio;
		precioTotal = Math.round(precioTotal*100.0)/100.0;
	}
	
	public void eliminarProducto(String nombreProducto, double precio) {
		if(productos.containsKey(nombreProducto)) {
			if(productos.get(nombreProducto)>1) {
				productos.put(nombreProducto, productos.get(nombreProducto)-1);
			}else {
				productos.remove(nombreProducto);
			}
			
			if(precioTotal - precio < 0) {
				precioTotal = 0;
			}else {
				precioTotal = precioTotal - precio;
			}
			precioTotal = Math.round(precioTotal*100.0)/100.0;
		}
	}
	
	public void actualizarPrecioProducto(String nombreProducto, double precioNuevo, double precioAnterior) {
		if(productos.containsKey(nombreProducto)) {
			int cantidad = productos.get(nombreProducto);
			
			precioTotal = precioTotal + (precioNuevo - precioAnterior) * cantidad;
			precioTotal = Math.round(precioTotal*100.0)/100.0;
		}
	}
	
	public int getId() {
		return id;
	}

	public HashMap<String, Integer> getProductos() {
		return productos;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProductos(HashMap<String, Integer> productos) {
		this.productos = productos;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
}
