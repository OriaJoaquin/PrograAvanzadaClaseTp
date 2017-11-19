package unidad;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import items.Capa;
import items.Escudo;
import items.Punial;

public class TestArquero {

	Soldado soldado;
	Unidad arquero;

	@Before
	public void setUp() {
		soldado = new Soldado(new Punto(1, 1));
		arquero = new Arquero(new Punto(1, 1));
	}

	@Test
	public void estadoInicial() {
		Assert.assertEquals(50, (int)arquero.salud);
		Assert.assertEquals(5, (int) arquero.getAtaque());
		Assert.assertEquals(50, (int)arquero.salud);
		Assert.assertEquals(200, (int)soldado.salud);
	}

	@Test
	public void ataques() {

		//ARQUERO defends himself from a SOLDADO.
		soldado.atacar(arquero);
		Assert.assertEquals(40, (int)arquero.salud);
		
		//ARQUERO attacks to SOLDADO body to body
		arquero.atacar(soldado);
		Assert.assertEquals(200, (int)soldado.salud);//He continues with the same health, because the distance does not allow it.
		
		//ARQUERO attacks to SOLDADO with distance of 2 to 5
		arquero.setUbicacion(new Punto(2,3));
		arquero.atacar(soldado);
		Assert.assertEquals(195, (int)soldado.salud);
		
		//SOLDADO attacks to ARQUERO with distance of 2 to 5
		soldado.atacar(arquero);
		Assert.assertEquals(40, (int)arquero.salud); //He continues with the same health, because the distance does not allow it.
		
		//Add item to ARQUERO.
		arquero = new Punial(arquero);
		
		//ARQUERO attacks to SOLDADO with distance of 2 to 5
		arquero.atacar(soldado);
		Assert.assertEquals(187, (int)soldado.salud);
		
		//SOLDADO attacks to ARQUERO body to body
		soldado.setUbicacion(new Punto(2,3));
		soldado.atacar(arquero);
		Assert.assertEquals(27, (int)arquero.salud);
		
		//AÑADIR DOS PUÑALES.
		arquero = new Punial(arquero);
		soldado.atacar(arquero);
		Assert.assertEquals(11, (int)arquero.salud);
		
		//AÑADIR TRES PUÑALES.
		arquero = new Punial(arquero);
		soldado.atacar(arquero);
		Assert.assertEquals(0, (int)arquero.salud);
		
	}

}
