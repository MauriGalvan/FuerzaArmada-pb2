package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class FuerzaArmada {

	private Set<Vehiculo> convoy;
	private Map<String, Batalla> batallas;
	
	

	
	public FuerzaArmada() {
		super();
		this.batallas = new HashMap<>();
		this.convoy = new HashSet<>();
	}





	public void agregarVehiculo(Vehiculo vehiculo) {
		convoy.add(vehiculo);	
	} 






	public Set<Vehiculo> getConvoy() {
		return convoy;
	}

	public void setConvoy(Set<Vehiculo> convoy) {
		this.convoy = convoy;
	}

	public Map<String, Batalla> getBatallas() {
		return batallas;
	}


	public void setBatallas(Map<String, Batalla> batallas) {
		this.batallas = batallas;
	}





	public void crearBatalla(String nombreBatalla, TipoDeBatalla tipoBatalla, Double latitud, Double longitud) {
		
		this.batallas.put(nombreBatalla,  new Batalla(tipoBatalla , latitud , longitud));
	}





	public void presentarBatalla(String nombreBatalla) throws batallaInexistente {
		if(batallas.containsKey(nombreBatalla)) {
			Batalla batalla = batallas.get(nombreBatalla);
			   System.out.println("Detalles de la batalla: " + nombreBatalla);
		        System.out.println("Tipo de batalla: " + batalla.getTipo());
		        System.out.println("Latitud: " + batalla.getLatitud());
		        System.out.println("Longitud: " + batalla.getLongitud());
		} else {
		throw new batallaInexistente();
		}
	}





	public boolean enviarALaBatalla(String nombreBatalla, Integer idVehiculo) throws Exception {
		Batalla batalla = buscarBatallaPorNombre(nombreBatalla);
		Vehiculo vehiculo = buscarVehiculo(idVehiculo);
		batalla.agregarVehiculo(vehiculo);
		return true;
	}





	private Vehiculo buscarVehiculo(Integer idVehiculo) throws VehiculoInexistenteException {
		for (Vehiculo vehiculo : convoy) {
			if(vehiculo.getId().equals(idVehiculo)) {
				return vehiculo;
			}
			
		}
		throw new VehiculoInexistenteException("vehiculo inexistente");
	}





	private Batalla buscarBatallaPorNombre(String nombreBatalla) throws batallaInexistente {
		if(batallas.containsKey(nombreBatalla)) {
			return this.batallas.get(nombreBatalla);
		}
		throw new batallaInexistente();
	}


}
