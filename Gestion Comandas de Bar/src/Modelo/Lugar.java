package Modelo;

import java.util.ArrayList;

public class Lugar {
	
	private String nombreLugar;
	private ArrayList<Comanda> comandas;
	private int numeroComanda;
	
	public Lugar(String nombreLugar) {
		this.nombreLugar = nombreLugar;
		this.comandas = new ArrayList<>();
		this.numeroComanda = 1;
	}

	public String getNombreLugar() {
		return nombreLugar;
	}

	public ArrayList<Comanda> getComandas() {
		return comandas;
	}
	
	public void añadirNuevaComanda() {
		Comanda nuevaComanda = new Comanda(numeroComanda);
		comandas.add(nuevaComanda);
		numeroComanda++;
	}
	
	public Comanda obtenerComanda(int num) {
		for(Comanda comanda:comandas) {
			if(comanda.getId()==num) {
				return comanda;
			}
		}
		return null;
	}
	
}
