package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Grafo;

public class TestGrafo {

	@Test
	public void test100() {
		System.out.println("Test grafo aleatorio probabilidad 100");
		Grafo grafito = new Grafo();
		grafito.generarGrafoAleatorioProbabilidad(10, 100);
		System.out.println(grafito.toString());
	}
	
	@Test
	public void test50() {
		System.out.println("Test grafo aleatorio probabilidad 50");
		Grafo grafito2 = new Grafo();
		grafito2.generarGrafoAleatorioProbabilidad(10, 50);
		System.out.println(grafito2.toString());
	}
	
	@Test
	public void testGrafoRegular() {
		System.out.println("Test grafo regular");
		Grafo grafito3 = new Grafo();
		grafito3.generarGrafoRegular(4, 3);
		System.out.println(grafito3.toString());
	}
	
	@Test
	public void testGrafoRegularAdyacencia() {
		System.out.println("Test grafo regular porcentaje adyacencia");
		Grafo grafito3 = new Grafo();
		grafito3.generarGrafoRegularPorcentajeAdyacencia(4, 1);
		System.out.println(grafito3.toString());
	}
	
	@Test
	public void testGrafoNPartito() {
		System.out.println("Test grafo regular N Partito");
		Grafo grafito3 = new Grafo();
		grafito3.generarGrafoNPartito(4, 3);
		System.out.println(grafito3.toString());
	}
}
