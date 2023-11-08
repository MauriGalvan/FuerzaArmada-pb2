package ar.edu.unlam.pb2.eva03;

import java.util.Objects;

public abstract class Vehiculo implements Comparable<Vehiculo>{
	Integer id;
	String nombre;
	
	public Vehiculo(Integer id,String nombre){
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public abstract Integer getVelocidad();
	
	public abstract TipoVehiculo getTipo();
	
	public int compareTo(Vehiculo o) {
		return this.id.compareTo(o.getId());
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(id, other.id);
	}

	
}
