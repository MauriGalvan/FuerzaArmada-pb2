package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Set;




public class Batalla {
	
	private Double latitud;
	private Double longitud;
	private TipoDeBatalla tipo;
	Set<Vehiculo> vehiculosEnLaBatalla;
	
	public Batalla(TipoDeBatalla tipoBatalla, Double latitud, Double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
		this.tipo = tipoBatalla;
		this.vehiculosEnLaBatalla = new HashSet<Vehiculo>();
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public TipoDeBatalla getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeBatalla tipo) {
		this.tipo = tipo;
	}

	public Set<Vehiculo> getVehiculosEnLaBatalla() {
		return vehiculosEnLaBatalla;
	}

	public void setVehiculosEnLaBatalla(Set<Vehiculo> vehiculosEnLaBatalla) {
		this.vehiculosEnLaBatalla = vehiculosEnLaBatalla;
	}

	public void agregarVehiculo(Vehiculo vehiculo) throws VehiculoIncompatible {
		validarVehiculo(vehiculo);
		vehiculosEnLaBatalla.add(vehiculo);
		
	}

	private boolean validarVehiculo(Vehiculo vehiculo) throws VehiculoIncompatible {
		
		switch(tipo) {
		
		case TERRESTRE: {
			if(vehiculo.getTipo().equals(TipoVehiculo.Camion) || (vehiculo.getTipo().equals(TipoVehiculo.TANQUE))) 
				return true;
			
		}
		case ACUATICA:{
			if(vehiculo.getTipo().equals(TipoVehiculo.Submarino) || (vehiculo.getTipo().equals(TipoVehiculo.HidroAvion)||(vehiculo.getTipo().equals(TipoVehiculo.Anfibio))))
				return true;
		}
		case NAVAL:{
			if(vehiculo.getTipo().equals(TipoVehiculo.Submarino) || (vehiculo.getTipo().equals(TipoVehiculo.HidroAvion)||(vehiculo.getTipo().equals(TipoVehiculo.Anfibio)|| (vehiculo.getTipo().equals(TipoVehiculo.Avion)))))
				return true;
		}
		}
		throw new VehiculoIncompatible();
		
	}
}
