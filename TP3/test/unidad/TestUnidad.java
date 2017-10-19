package unidad;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import items.Capa;
import items.Escudo;
import items.Punial;

public class TestUnidad {

	Soldado soldado;
	Unidad arquero;

	@Before
	public void setUp() {
		soldado = new Soldado(new Punto(1, 1));
		arquero = new Arquero(new Punto(1, 1));
	}

	@Test
	public void estadoInicial() {
		Assert.assertEquals(200, (int)soldado.salud);
		Assert.assertEquals(50, (int)arquero.salud);
		Assert.assertEquals(10, (int) soldado.getAtaque());
		Assert.assertEquals(5, (int) arquero.getAtaque());
		Assert.assertEquals(100, (int) soldado.getEnergia());
	}

	@Test
	public void ataques() {

		Assert.assertEquals(200, (int)soldado.salud);
		Assert.assertEquals(50, (int)arquero.salud);

		//SOLDADO attack to ARQUERO body to body
		arquero = soldado.atacar(arquero);
		Assert.assertEquals(40, (int)arquero.salud);
		
		//ARQUERO attacks to SOLDADO body to body
		soldado = (Soldado)arquero.atacar((Unidad) soldado);
		Assert.assertEquals(200, (int)soldado.salud);//He continues with the same health, because the distance does not allow it.
		
		//ARQUERO attacks to SOLDADO with distance of 2 to 5
		arquero.setUbicacion(new Punto(2,3));
		soldado = (Soldado)arquero.atacar((Unidad) soldado);
		Assert.assertEquals(195, (int)soldado.salud);
		
		//SOLDADO attacks to ARQUERO with distance of 2 to 5
		arquero = soldado.atacar(arquero);
		Assert.assertEquals(40, (int)arquero.salud); //He continues with the same health, because the distance does not allow it.
		
		//Add item to ARQUERO.
		arquero = new Punial(arquero);
		
		//ARQUERO attacks to SOLDADO with distance of 2 to 5
		soldado = (Soldado)arquero.atacar((Unidad) soldado);
		Assert.assertEquals(187, (int)soldado.salud);
		
		//SOLDADO attacks to ARQUERO body to body
		soldado.setUbicacion(new Punto(2,3));
		arquero = soldado.atacar(arquero);
		Assert.assertEquals(27, (int)arquero.salud);
		
		//Add new item to ARQUERO.
		arquero = new Escudo(arquero);
		
		//SOLDADO attacks to ARQUERO body to body
		arquero = soldado.atacar(arquero);
		Assert.assertEquals(21.8, arquero.salud, 0000.1);
		
		//Add new item to ARQUERO.
		arquero = new Capa(arquero);
		
		//ARQUERO attacks to SOLDADO with distance of 2 to 5
		soldado.setUbicacion(new Punto(1,1));
		soldado = (Soldado)arquero.atacar((Unidad) soldado);
		Assert.assertEquals(179.8, soldado.salud, 0000.1);
	}

}
