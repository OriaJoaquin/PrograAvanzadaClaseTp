package tp2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPolinomio {
	Polinomio p;
	Polinomio p1;
	Polinomio p2;
	Polinomio p3;
	Polinomio p4;
	Polinomio p5;
	long time_start,time_end;
	
	@Before
	public void setUp() {
		p = new Polinomio(4, new double[]{1,1,5,3,20});
		p1 = new Polinomio(2, new double[]{2,1,3});
		p2 = new Polinomio(8, new double[]{12,10,0,-4,-5,1,3,-5,0});
		p3 = new Polinomio(3, new double[]{2,3,4,2});
		time_start= System.nanoTime();
	}
	
	@Test
	public void probarMSucesivas() {	
		Assert.assertEquals(70, p.evaluarMSucesivas(2),0.001);
		Assert.assertEquals(139, p1.evaluarMSucesivas(8),0.001);
		Assert.assertEquals(4154, p2.evaluarMSucesivas(2),0.001);
		Assert.assertEquals(7487, p3.evaluarMSucesivas(15),0.001);
		time_end = System.nanoTime();
		System.out.println("La tarea de Ejecución MSucesivas ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
	}
	
	@Test
	public void probarRecursiva() {
		Assert.assertEquals(70, p.evaluarRecursiva(2),0.001);
		Assert.assertEquals(139, p1.evaluarRecursiva(8),0.001);
		Assert.assertEquals(4154, p2.evaluarRecursiva(2),0.001);
		Assert.assertEquals(7487, p3.evaluarRecursiva(15),0.001);
		time_end = System.nanoTime();
		System.out.println("La tarea de Ejecución Recursiva ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
	}
	
	@Test
	public void probarRecursivaPar() {
		Assert.assertEquals(70, p.evaluarRecursivaPar(2),0.001);
		Assert.assertEquals(139, p1.evaluarRecursivaPar(8),0.001);
		Assert.assertEquals(4154, p2.evaluarRecursivaPar(2),0.001);
		Assert.assertEquals(7487, p3.evaluarRecursivaPar(15),0.001);
		//Assert.assertEquals(4154, p.evaluarHorner(2),0.001);
		time_end = System.nanoTime();
		System.out.println("La tarea de Ejecución Recursiva Par ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
	}
	
	@Test
	public void probarMejorada() {
		Assert.assertEquals(70, p.evaluarMejorada(2),0.001);
		Assert.assertEquals(139, p1.evaluarMejorada(8),0.001);
		Assert.assertEquals(4154, p2.evaluarMejorada(2),0.001);
		Assert.assertEquals(7487, p3.evaluarMejorada(15),0.001);
		time_end = System.nanoTime();
		System.out.println("La tarea de Ejecución Mejorada ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
	}

	@Test
	public void probarProgDinamica() {
		Assert.assertEquals(70, p.evaluarProgDinamica(2),0.001);
		Assert.assertEquals(139, p1.evaluarProgDinamica(8),0.001);
		Assert.assertEquals(4154, p2.evaluarProgDinamica(2),0.001);
		Assert.assertEquals(7487, p3.evaluarProgDinamica(15),0.001);
		//Assert.assertEquals(7487, p.evaluarHorner(15),300);
		time_end = System.nanoTime();
		System.out.println("La tarea de Ejecución con Progamación dinámica ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
	}

}
