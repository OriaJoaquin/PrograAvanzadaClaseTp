package unidad;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import items.Capa;
import items.Escudo;
import items.Punial;

public class TestSoldado {

	Soldado soldado;
	Unidad arquero;

	@Before
	public void setUp() {
		soldado = new Soldado(new Punto(1, 1));
		arquero = new Arquero(new Punto(1, 1));
	}

	@Test
	public void estadoInicial() {
		Assert.assertEquals(10, (int) soldado.getAtaque());
		Assert.assertEquals(100, (int) soldado.getEnergia());
		Assert.assertEquals(200, (int)soldado.salud);
		Assert.assertEquals(50, (int)arquero.salud);
	}

	@Test
	public void ataques() {

		//SOLDADO attack to ARQUERO body to body
		soldado.atacar(arquero);
		Assert.assertEquals(40, (int)arquero.salud);//VERIFICAR DAÑO DE ATAQUE DEL SOLDADO.
		Assert.assertEquals(90, (int)soldado.getEnergia());//VERIFICAR ENERGIA
		
		//SOLDADO defends himself from a ARQUERO with distance of 2 to 5.
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
		Assert.assertEquals(27, (int)arquero.salud);//EN VEZ DE SACARLE 10 Y TENER 30, LE SACA 13 DE SALUD POR EL PUÑAL
		
		//Add new item to ARQUERO.
		arquero = new Escudo(arquero);
		
		//SOLDADO attacks to ARQUERO body to body
		soldado.atacar(arquero);
		Assert.assertEquals(20, arquero.salud, 0000.1);
		
		//Add new item to ARQUERO.
		arquero = new Capa(arquero);
		
		//ARQUERO attacks to SOLDADO with distance of 2 to 5
		soldado.setUbicacion(new Punto(1,1));
		arquero.atacar((Unidad) soldado);
		Assert.assertEquals(179.8, soldado.salud, 0000.1);
		
		//arquero = new Escudo(arquero);
	}

}
