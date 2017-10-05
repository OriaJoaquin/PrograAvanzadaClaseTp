package tp2;

import java.util.Arrays;

public class Polinomio {
	private int grado;
	private double[] coeficientes;

	public Polinomio(int grado, double[] coeficientes) {
		this.grado = grado;
		this.coeficientes = coeficientes;
	}

	public double evaluarMSucesivas(double x) {
		double resultado = 0;

		for (int i = 0; i < coeficientes.length; i++) {
			double resultadoParcial = 1;

			for (int j = 0; j < this.grado - i; j++) {
				resultadoParcial *= x;
			}

			resultado += (this.coeficientes[i] * resultadoParcial);
		}

		return resultado;
	}

	public double evaluarRecursiva(double x) {
		double resultado = 0;

		for (int i = 0; i < coeficientes.length; i++) {

			double resultadoParcial = potenciaRecursiva(x, this.grado - i);

			resultado += (this.coeficientes[i] * resultadoParcial);
		}

		return resultado;
	}

	public double evaluarRecursivaPar(double x) {
		double resultado = 0;

		for (int i = 0; i < coeficientes.length; i++) {

			double resultadoParcial;

			if ((this.grado - i) % 2 == 1)
				resultadoParcial = potenciaRecursiva(x, this.grado - i);
			else {
				resultadoParcial = potenciaRecursiva(x, (this.grado - i) / 2);
				resultadoParcial *= resultadoParcial;
			}
			resultado += (this.coeficientes[i] * resultadoParcial);
		}

		return resultado;
	}

	private double potenciaRecursiva(double x, int n) {
		if (n >= 1)
			return x * potenciaRecursiva(x, n - 1);
		return 1;
	}

	public double evaluarDinamica(double x) {
		double res = 0;
		double[] vPot = new double[this.grado + 1];
		Arrays.fill(vPot, 0);
		vPot[this.coeficientes.length - 1] = 1;
		vPot[this.coeficientes.length - 2] = x;
		res += this.coeficientes[this.coeficientes.length - 1] + x * this.coeficientes[this.coeficientes.length - 2];
		for (int i = this.grado - 2; i >= 0; i--) {

			res += this.coeficientes[i] * potenciaDinamica(x, i, vPot);
		}
		return res;
	}

	public double potenciaDinamica(double x, int n, double[] vPot) {
		if (vPot[n] != 0)
			return vPot[n];
		vPot[n] = vPot[n + 1] * x;
		return vPot[n];
	}

	public double evaluarMejorada(double x) { // O(n)
		double potenciaCalculada = 1;
		double resultado = this.coeficientes[this.grado];

		for (int i = this.grado - 1; i >= 0; i--) {
			potenciaCalculada *= x;
			resultado += (this.coeficientes[i] * potenciaCalculada);
		}

		return resultado;
	}

	public double evaluarPow(double x) {
		double resultado = 0;

		// Math.pow(a, b) complejidad o(1)
		for (int i = 0; i < this.coeficientes.length; i++) {
			resultado += this.coeficientes[i] * Math.pow(x, this.grado - i);
		}

		return resultado;
	}

	public double evaluarHorner(double x) { // O(n)
		double result = 0;
		for (int i = this.coeficientes.length - 1; i >= 0; i--)
			result = this.coeficientes[i] + (x * result);
		return result;

	}

	public static double[] llenarVector(int tam) {
		double[] vec = new double[tam + 1];

		for (int i = 0; i < vec.length; i++) {
			vec[i] = (double) (Math.random() * 50);
		}

		return vec;
	}

	public static void main(String[] args) {

		int i;
		long time_start, time_end;
		Polinomio[] vecPolinomio = new Polinomio[200];

		// vecPolinomio[0] = new Polinomio(1, new double[]{1,2});
		/*
		 * vecPolinomio[0] = new Polinomio(2, new double[]{1,2,5}); vecPolinomio[1] =
		 * new Polinomio(3, new double[]{1,2,5,2}); vecPolinomio[2] = new Polinomio(4,
		 * new double[]{1,2,5,2,6}); vecPolinomio[3] = new Polinomio(5, new
		 * double[]{1,2,5,2,6,8}); vecPolinomio[4] = new Polinomio(6, new
		 * double[]{1,2,5,2,6,8,3}); vecPolinomio[5] = new Polinomio(7, new
		 * double[]{1,2,5,2,6,8,3,7}); vecPolinomio[6] = new Polinomio(8, new
		 * double[]{1,2,5,2,6,8,3,7,9}); vecPolinomio[7] = new Polinomio(9, new
		 * double[]{1,2,5,2,6,8,3,7,9,0}); vecPolinomio[8] = new Polinomio(10, new
		 * double[]{1,2,5,2,6,8,3,7,9,0,1}); vecPolinomio[9] = new Polinomio(20,
		 * llenarVector(20)); vecPolinomio[10] = new Polinomio(30, llenarVector(30));
		 * vecPolinomio[11] = new Polinomio(40, llenarVector(40)); vecPolinomio[12] =
		 * new Polinomio(50, llenarVector(50)); vecPolinomio[13] = new Polinomio(60,
		 * llenarVector(60)); vecPolinomio[14] = new Polinomio(70, llenarVector(70));
		 * vecPolinomio[15] = new Polinomio(80, llenarVector(80)); vecPolinomio[16] =
		 * new Polinomio(90, llenarVector(90)); vecPolinomio[17] = new Polinomio(200,
		 * llenarVector(200));
		 */

		for (i = 1; i < vecPolinomio.length + 1; i++) {
			vecPolinomio[i - 1] = new Polinomio(i, llenarVector(i));
		}

		for (i = 0; i < vecPolinomio.length; i++) {
			//System.out.println("Grado polinomio:" + vecPolinomio[i].grado);
			time_start = System.nanoTime();
			vecPolinomio[i].evaluarMSucesivas(0);
			time_end = System.nanoTime();
			System.out.println(time_end - time_start);

			
		}
		
		System.out.println("===============================================================================");
		
		for (i = 0; i < vecPolinomio.length; i++) {
			time_start = System.nanoTime();
			vecPolinomio[i].evaluarRecursiva(0);
			time_end = System.nanoTime();
			System.out.println(time_end - time_start);
		}
		
		System.out.println("===============================================================================");
		
		for (i = 0; i < vecPolinomio.length; i++) {
			time_start = System.nanoTime();
			vecPolinomio[i].evaluarRecursivaPar(0);
			time_end = System.nanoTime();
			System.out.println(time_end - time_start);
		}
		
		System.out.println("===============================================================================");
		
		for (i = 0; i < vecPolinomio.length; i++) {
			time_start = System.nanoTime();
			vecPolinomio[i].evaluarMejorada(0);
			time_end = System.nanoTime();
			System.out.println(time_end - time_start);
		}
		
		System.out.println("===============================================================================");
		
		for (i = 0; i < vecPolinomio.length; i++) {
			time_start = System.nanoTime();
			vecPolinomio[i].evaluarDinamica(0);
			time_end = System.nanoTime();
			System.out.println(time_end - time_start);
		}
		
		System.out.println("===============================================================================");
		
		for (i = 0; i < vecPolinomio.length; i++) {
			time_start = System.nanoTime();
			vecPolinomio[i].evaluarPow(0);
			time_end = System.nanoTime();
			System.out.println(time_end - time_start);
		}
		
		System.out.println("===============================================================================");
		
		for (i = 0; i < vecPolinomio.length; i++) {
			time_start = System.nanoTime();
			vecPolinomio[i].evaluarHorner(0);
			time_end = System.nanoTime();
			System.out.println(time_end - time_start);
		}
	}

}
