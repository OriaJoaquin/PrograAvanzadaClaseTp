package tp2;

import org.junit.Assert;
import org.junit.Test;

public class TestPolinomio {
	Polinomio p;
	
	
	@Test
	public void caso1() {
		p = new Polinomio(4, new double[]{1,1,5,3,20});
		
		Assert.assertEquals(70, p.evaluarMSucesivas(2),0.001);
		Assert.assertEquals(70, p.evaluarRecursiva(2),0.001);
		Assert.assertEquals(70, p.evaluarRecursivaPar(2),0.001);
		Assert.assertEquals(70, p.evaluarProgDinamica(2),0.001);
		Assert.assertEquals(70, p.evaluarMejorada(2),0.001);
	}
	
	@Test
	public void caso2() {
		p = new Polinomio(2, new double[]{2,1,3});
		
		Assert.assertEquals(139, p.evaluarMSucesivas(8),0.001);
		Assert.assertEquals(139, p.evaluarRecursiva(8),0.001);
		Assert.assertEquals(139, p.evaluarRecursivaPar(8),0.001);
		Assert.assertEquals(139, p.evaluarProgDinamica(8),0.001);
		Assert.assertEquals(139, p.evaluarMejorada(8),0.001);
	}
	
	@Test
	public void caso3() {
		p = new Polinomio(8, new double[]{12,10,0,-4,-5,1,3,-5,0});
		
		Assert.assertEquals(4154, p.evaluarMSucesivas(2),0.001);
		Assert.assertEquals(4154, p.evaluarRecursiva(2),0.001);
		Assert.assertEquals(4154, p.evaluarRecursivaPar(2),0.001);
		Assert.assertEquals(4154, p.evaluarProgDinamica(2),0.001);
		Assert.assertEquals(4154, p.evaluarMejorada(2),0.001);
		//Assert.assertEquals(4154, p.evaluarHorner(2),0.001);
	}

	@Test
	public void caso4() {
		p = new Polinomio(3, new double[]{2,3,4,2});
		
		Assert.assertEquals(7487, p.evaluarMSucesivas(15),0.001);
		Assert.assertEquals(7487, p.evaluarRecursiva(15),0.001);
		Assert.assertEquals(7487, p.evaluarRecursivaPar(15),0.001);
		Assert.assertEquals(7487, p.evaluarProgDinamica(15),0.001);
		Assert.assertEquals(7487, p.evaluarMejorada(15),0.001);
		//Assert.assertEquals(7487, p.evaluarHorner(15),300);
	}
}
