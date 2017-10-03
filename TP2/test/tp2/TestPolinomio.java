package tp2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPolinomio {
	Polinomio p0;
	Polinomio p;
	Polinomio p1;
	Polinomio p2;
	Polinomio p3;
	Polinomio p4;
	Polinomio p5;
	Polinomio p6;
	Polinomio p7;
	Polinomio p8;
	long time_start,time_end;
	
	@Before
	public void setUp() {
		p0 = new Polinomio(1, new double[] {1,2});
		p = new Polinomio(4, new double[]{1,1,5,3,20});
		p1 = new Polinomio(2, new double[]{2,1,3});
		p2 = new Polinomio(8, new double[]{12,10,0,-4,-5,1,3,-5,0});
		p3 = new Polinomio(3, new double[]{2,3,4,2});
		p4 = new Polinomio(50, new double[] {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10});
		p5 = new Polinomio(10, new double[] {1,2,3,4,5,6,7,8,9,1,12});
		p6 = new Polinomio(100, new double[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,1});
		p7 = new Polinomio(150, new double[] {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10});
		p8 = new Polinomio(300, new double[] {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10});
		time_start= System.nanoTime();
	}
	
	@Test
	public void probarMSucesivas() {
		//Assert.assertEquals(4, p0.evaluarMSucesivas(2),0.001);
		//Assert.assertEquals(70, p.evaluarMSucesivas(2),0.001);
		//Assert.assertEquals(139, p1.evaluarMSucesivas(8),0.001);
		//Assert.assertEquals(4154, p2.evaluarMSucesivas(2),0.001);
		//Assert.assertEquals(7487, p3.evaluarMSucesivas(15),0.001);
		//Assert.assertEquals(1.6443389523899227E78, p4.evaluarMSucesivas(35),0.001);
		//Assert.assertEquals(3.5615972910604776E16, p5.evaluarMSucesivas(45),0.001);
		//Assert.assertEquals(1.2325951644078318E70, p6.evaluarMSucesivas(5),0.001);
		//Assert.assertEquals(8.758115402030113E105, p7.evaluarMSucesivas(5),0.001);
		Assert.assertEquals(6.136366831622157E210, p8.evaluarMSucesivas(5),0.001);
		time_end = System.nanoTime();
		System.out.println("La tarea de Ejecución MSucesivas ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
	}
	
	@Test
	public void probarRecursiva() {
		//Assert.assertEquals(4, p0.evaluarRecursiva(2),0.001);
		//Assert.assertEquals(70, p.evaluarRecursiva(2),0.001);
		//Assert.assertEquals(139, p1.evaluarRecursiva(8),0.001);
		//Assert.assertEquals(4154, p2.evaluarRecursiva(2),0.001);
		//Assert.assertEquals(7487, p3.evaluarRecursiva(15),0.001);
		//Assert.assertEquals(1.6443389523899227E78, p4.evaluarRecursiva(35),0.001);
		//Assert.assertEquals(3.5615972910604776E16, p5.evaluarRecursiva(45),0.001);
		//Assert.assertEquals(1.2325951644078318E70, p6.evaluarRecursiva(5),0.001);
		//Assert.assertEquals(8.758115402030113E105, p7.evaluarRecursiva(5),0.001);
		Assert.assertEquals(6.136366831622157E210, p8.evaluarRecursiva(5),0.001);
		time_end = System.nanoTime();
		System.out.println("La tarea de Ejecución Recursiva ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
	}
	
	@Test
	public void probarRecursivaPar() {
		//Assert.assertEquals(4, p0.evaluarRecursivaPar(2),0.001);
//		Assert.assertEquals(70, p.evaluarRecursivaPar(2),0.001);
		//Assert.assertEquals(139, p1.evaluarRecursivaPar(8),0.001);
		//Assert.assertEquals(4154, p2.evaluarRecursivaPar(2),0.001);
		//Assert.assertEquals(7487, p3.evaluarRecursivaPar(15),0.001);
		//Assert.assertEquals(1.644338952389924E78, p4.evaluarRecursivaPar(35),0.001);
		//Assert.assertEquals(3.5615972910604776E16, p5.evaluarRecursivaPar(45),0.001);
		//Assert.assertEquals(1.2325951644078314E70, p6.evaluarRecursivaPar(5),0.001);
		//Assert.assertEquals(8.758115402030113E105, p7.evaluarRecursivaPar(5),0.001);
		Assert.assertEquals(6.136366831622162E210, p8.evaluarRecursivaPar(5),0.001);
		time_end = System.nanoTime();
		System.out.println("La tarea de Ejecución Recursiva Par ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
	}
	
	@Test
	public void probarMejorada() {
		//Assert.assertEquals(4, p0.evaluarMejorada(2),0.001);
		//Assert.assertEquals(70, p.evaluarMejorada(2),0.001);
		//Assert.assertEquals(139, p1.evaluarMejorada(8),0.001);
		//Assert.assertEquals(4154, p2.evaluarMejorada(2),0.001);
		//Assert.assertEquals(7487, p3.evaluarMejorada(15),0.001);
		//Assert.assertEquals(1.6443389523899237E78, p4.evaluarMejorada(35),0.001);
		//Assert.assertEquals(3.5615972910604776E16, p5.evaluarMejorada(45),0.001);
		//Assert.assertEquals(1.232595164407831E70, p6.evaluarMejorada(5),0.001);
		//Assert.assertEquals(8.75811540203011E105, p7.evaluarMejorada(5),0.001);
		Assert.assertEquals(6.136366831622155E210, p8.evaluarMejorada(5),0.001);
		time_end = System.nanoTime();
		System.out.println("La tarea de Ejecución Mejorada ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
	}

	@Test
	public void probarProgDinamica() {
		//Assert.assertEquals(4, p0.evaluarProgDinamica(2),0.001);
		//Assert.assertEquals(70, p.evaluarProgDinamica(2),0.001);
		//Assert.assertEquals(139, p1.evaluarProgDinamica(8),0.001);
		//Assert.assertEquals(4154, p2.evaluarProgDinamica(2),0.001);
		//Assert.assertEquals(7487, p3.evaluarProgDinamica(15),0.001);
		//Assert.assertEquals(1.6443389523899223E78, p4.evaluarProgDinamica(35),0.001);
		//Assert.assertEquals(3.561597291060478E16, p5.evaluarProgDinamica(45),0.001);
		//Assert.assertEquals(1.2325951644078317E70, p6.evaluarProgDinamica(5),0.001);
		//Assert.assertEquals(8.758115402030111E105, p7.evaluarProgDinamica(5),0.001);
		Assert.assertEquals(6.136366831622159E210, p8.evaluarProgDinamica(5),0.001);
		time_end = System.nanoTime();
		System.out.println("La tarea de Ejecución con Progamación dinámica ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
	}

}
