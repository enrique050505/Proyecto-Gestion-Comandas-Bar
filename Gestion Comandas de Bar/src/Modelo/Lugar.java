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
	
	public Comanda obtenerComanda(int num) {
		Comanda comanda = null;
		for(Comanda comandaActual:comandas) {
			if(comandaActual.getId()==num) {
				comanda = comandaActual;
			}
		}
		return comanda;
	}
	
	public Comanda aumentarNumeroComanda() {
		Comanda nuevaComanda = new Comanda(numeroComanda);
		comandas.add(nuevaComanda);
		numeroComanda++;
		return nuevaComanda;
	}
	
	public Comanda obtenerUltimaComanda() {
		Comanda ultimaComanda;
		
		if(comandas.isEmpty()) {
			ultimaComanda=null;
		}else {
			ultimaComanda = comandas.get(comandas.size()-1);
		}
		return ultimaComanda;
	}
	
}
