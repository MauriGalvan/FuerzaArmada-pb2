package ar.edu.unlam.pb2.eva03;

public class Avion extends Vehiculo implements Volador {

	public Avion(Integer id, String nombre) {
		super(id, nombre);
		// TODO Auto-generated constructor stub
	}

	

	



	@Override
	public Integer getVelocidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoVehiculo getTipo() {
		// TODO Auto-generated method stub
		return TipoVehiculo.Avion;
	}

	@Override
	public void volar() {
		// TODO Auto-generated method stub
		
	}

}
