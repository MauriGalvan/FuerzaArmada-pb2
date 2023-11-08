package ar.edu.unlam.pb2.eva03;

public class Camion extends Vehiculo implements Terrestre {

	public Camion(Integer id, String nombre) {
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
	public Integer getVelocidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoVehiculo getTipo() {
		// TODO Auto-generated method stub
		return TipoVehiculo.Camion;
	}

}
