package ar.edu.unlam.pb2.eva03;

public class HidroAvion extends Vehiculo implements Acuatico, Volador {

	public HidroAvion(Integer id, String nombre) {
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
		return TipoVehiculo.HidroAvion;
	}

	@Override
	public void sumergir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salirDelAgua() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void estacionarEnElAgua() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverseSobreElAgua() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volar() {
		// TODO Auto-generated method stub
		
	}

}
