package ar.edu.unlam.pb2.eva03;

import static org.junit.Assert.*;

import org.junit.Test;





public class TestCases {

	@Test
	public void queSePuedaCrearUnObjetoVolador() {
		Volador avion = new Avion(1, "A-10");

	
		
		assertNotNull(avion);
	}

	@Test
	public void queSePuedaCrearUnObjetoTerrestre() {
		Terrestre tanque = new Tanque(5, "Renault FT");


		
		assertNotNull(tanque);
	}

	@Test
	public void queSePuedaCrearUnObjetoAcuatico() {
		Acuatico submarino = new Submarino(8, "ARA - San Juan");

	
//		assertEquals(0.0, submarino.getProfundidad(), 0.01);
		
		assertNotNull(submarino);
	}
//
	@Test
	public void queSePuedaCrearUnObjetoAnfibio() {
		Anfibio var = new Anfibio(12, "LARC-5");

		

		assertNotNull(var);
	}
//
	@Test
	public void queSePuedaCrearUnHidroavion() {
		HidroAvion ag600 = new HidroAvion(12, "AG600");

		assertNotNull(ag600);
	}

	@Test
	public void queSePuedaArmarElConvoy() {
		FuerzaArmada argentina = new FuerzaArmada();

		
		argentina.agregarVehiculo(new Avion(1, "A-10"));
		argentina.agregarVehiculo(new Avion(2, "A-10"));
		argentina.agregarVehiculo(new Avion(3, "F-102"));
		argentina.agregarVehiculo(new Avion(4, "F-15"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Submarino(8, "ARA - San Juan"));

		argentina.agregarVehiculo(new HidroAvion(12, "Mitsubishi F1M"));
		argentina.agregarVehiculo(new Anfibio(13, "LARC-5"));

//		assertEquals(12, argentina.getCapacidadDeDefensa());
//		assertEquals((Integer)12, argentina.getCapacidadDeDefensa());
		Integer ve = 10;
		Integer cantidad = argentina.getConvoy().size(); 
		assertEquals(ve, cantidad);
	}
//
	@Test
	public void queSePuedaCrearUnaBatalla() {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
	

		assertTrue( argentina.getBatallas().get("San Lorenzo").getLatitud()==100.5);
		assertTrue(argentina.getBatallas().get("San Lorenzo").getLongitud()==20.3);

	}

	
	@Test
	public void queSePuedaPlanearLaBatallaSobreElOceano() {
		FuerzaArmada batallaOceano = new FuerzaArmada();
		
		batallaOceano.crearBatalla("batalla del oceano", TipoDeBatalla.ACUATICA, 200.2, 30.3);
		
		assertTrue(batallaOceano.getBatallas().get("batalla del oceano").getLatitud() == 200.2);
		assertTrue(batallaOceano.getBatallas().get("batalla del oceano").getLongitud()== 30.3);
	}
	
	@Test
	public void queSePuedaPresentarBatallaTerrestre() throws Exception {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Avion(0001, "A-10"));
		argentina.agregarVehiculo(new Avion(0002, "A-10"));
		argentina.agregarVehiculo(new Avion(0003, "F-102"));
		argentina.agregarVehiculo(new Avion(0004, "F-15"));
		argentina.agregarVehiculo(new Tanque(0005, "Renault FT"));
		argentina.agregarVehiculo(new Camion(0006, "T-72"));
		argentina.agregarVehiculo(new Camion(0007, "T-72"));
		argentina.agregarVehiculo(new Submarino(8, "ARA - San Juan"));
		
		argentina.agregarVehiculo(new HidroAvion(12, "A-10"));
		argentina.agregarVehiculo(new Anfibio(001, "A-10"));

		argentina.crearBatalla("Terrestre",TipoDeBatalla.TERRESTRE ,100.5, 20.3);

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));

		argentina.presentarBatalla("Terrestre");
		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 5));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 6));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 7));		
	}
	@Test
	public void queSePuedaPresentarUnaBatalla() throws Exception {
		FuerzaArmada fuerzaArmada = new FuerzaArmada();
		// Agregar batallas a la fuerzaArmada
		fuerzaArmada.crearBatalla("Batalla1", TipoDeBatalla.ACUATICA, 12.34, 56.78);
		fuerzaArmada.crearBatalla("Batalla2", TipoDeBatalla.ACUATICA, 23.45, 67.89);

		// Presentar una batalla
		fuerzaArmada.presentarBatalla("Batalla1");

	}

	@Test 
	public void queSePuedaPresentarBatallaNaval() throws Exception {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new Submarino(9, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(10, "A-10"));
		argentina.agregarVehiculo(new Anfibio(11, "A-10"));
		argentina.agregarVehiculo(new Avion(12, "A-10"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
	//	assertEquals(12, argentina.getCapacidadDeDefensa());
		argentina.crearBatalla("Pacifico", TipoDeBatalla.NAVAL, 200.5, 45.8);

	assertTrue(argentina.enviarALaBatalla("Pacifico", 8));
			
		assertTrue(argentina.enviarALaBatalla("Pacifico", 12));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 11));		
	}

	@Test (expected = VehiculoIncompatible.class)
	public void queSiNoSePuedeEnviarUnVehiculoAcuaticoArrojeExcepcion() throws Exception {

		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new Submarino(9, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(10, "A-10"));
		argentina.agregarVehiculo(new Anfibio(11, "A-10"));
		argentina.agregarVehiculo(new Avion(12, "A-10"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
	//	assertEquals(12, argentina.getCapacidadDeDefensa());
		argentina.crearBatalla("Pacifico", TipoDeBatalla.ACUATICA, 200.5, 45.8);

	assertTrue(argentina.enviarALaBatalla("Pacifico", 5));
			
		assertTrue(argentina.enviarALaBatalla("Pacifico", 10));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 11));	

	}

	@Test (expected = VehiculoInexistenteException.class)
	public void queSeNoSePuedaEnviarAUnaBatallaUnVehiculoQueNoExista() throws Exception {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertFalse(argentina.enviarALaBatalla("San Lorenzo", 4));
	}
	 @Test
	    public void testCompareTo() {
	        // Crear instancias de diferentes vehículos
	        Vehiculo vehiculo1 = new Tanque(10, "Tanque A");
	        Vehiculo vehiculo2 = new Camion(23, "Camión B");
	        Vehiculo vehiculo3 = new HidroAvion(3, "Hidroavión C");
	        
	        // Prueba de comparación
	        assertTrue(vehiculo1.compareTo(vehiculo2) < 0); // vehiculo1 < vehiculo2
	        assertTrue(vehiculo2.compareTo(vehiculo1) > 0); // vehiculo2 > vehiculo1
	        assertEquals(0, vehiculo2.compareTo(vehiculo2)); // vehiculo2 == vehiculo2
	    }
}
