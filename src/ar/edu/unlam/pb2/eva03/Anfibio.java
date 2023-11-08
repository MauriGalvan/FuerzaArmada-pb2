package ar.edu.unlam.pb2.eva03;

public class Anfibio extends Vehiculo implements Acuatico, Terrestre {

	public Anfibio(Integer id, String nombre) {
		super(id, nombre);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void avanzarSobreTierra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detenerseSobreTierra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverseSobreTierra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TipoVehiculo getTipo() {
		// TODO Auto-generated method stub
		return TipoVehiculo.Anfibio;
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
	public Integer getVelocidad() {
		// TODO Auto-generated method stub
		return null;
	}

}
