package app;

import java.util.Arrays;

public class Grafo {
	private int[][] nodos;
	private int vectorVertices[];

	public int[][] getMatriz() {
		return this.nodos;
	}

	public Grafo generarGrafoAleatorioProbabilidad(final int cantNodos, final double probabilidad) {

		this.nodos = new int[cantNodos][cantNodos];

		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				double nroAleatorio = this.randomWithRange(1, 100);

				if (probabilidad > nroAleatorio) {
					this.nodos[i][j] = 1;
					this.nodos[j][i] = 1;
				}
			}
		}

		return this;
	}

	public Grafo generarGrafoAleatorioPorcentajeAdyacencia(final int cantNodos, final double adyacencia) {
		this.nodos = new int[cantNodos][cantNodos];
		int cantMaximaAristas = calcularMaxNroAristas(cantNodos);
		int aristasGeneradas = 0;

		cantMaximaAristas *= adyacencia;

		for (int i = 0; i < cantNodos && aristasGeneradas < cantMaximaAristas; i++) {
			for (int j = i + 1; j < cantNodos; j++) {

				this.nodos[i][j] = 1;
				this.nodos[j][i] = 1;
				aristasGeneradas++;
			}
		}

		return this;
	}

	public Grafo generarGrafoRegularPorcentajeAdyacencia(final int cantNodos, final double adyacencia) {
		this.nodos = new int[cantNodos][cantNodos];

		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				// Condicion: que no haya pasado por la arista,
				// No sea el valor de la diagonal
				// y el porcentaje de adyacencia no este dentro del rango
				if (this.nodos[i][j] == 0 && i != j && adyacencia / 2 > this.randomWithRange(1, 100)) {
					this.nodos[i][j] = 1;
					this.nodos[j][i] = 1;
					this.nodos[cantNodos - 1 - i][cantNodos - 1 - j] = 1;
					this.nodos[cantNodos - 1 - j][cantNodos - 1 - i] = 1;
				}
			}
		}
		return this;
	}

	public Grafo generarGrafoRegular(final int cantNodos, final int grado) {
		this.nodos = new int[cantNodos][cantNodos];

		if (grado > (cantNodos - 1)) {
			return null;
		}

		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				// Condicion: que no haya pasado por la arista,
				// No sea el valor de la diagonal
				// y la cantidad de aristas del vertice no supere al grado dado
				if (this.nodos[i][j] == 0 && i != j && getCantidadAristas(i) < grado) {
					this.nodos[i][j] = 1;
					this.nodos[j][i] = 1;
					this.nodos[cantNodos - 1 - i][cantNodos - 1 - j] = 1;
					this.nodos[cantNodos - 1 - j][cantNodos - 1 - i] = 1;
				}
			}
		}
		return this;
	}

	public Grafo generarGrafoNPartito(final int cantNodos, final int particiones) {
		this.nodos = new int[cantNodos][cantNodos];
		int particion = 0;

		int[] vectorParticiones = new int[cantNodos];
		for (int i = 0; i < cantNodos; i++) {
			vectorParticiones[i] = particion;
			particion++;
			if (particion == particiones) {
				particion = 0;
			}
		}

		if (particiones > (cantNodos - 1)) {
			return null;
		}

		for (int i = 0; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				// Condicion: que no haya pasado por la arista,
				// No sea el valor de la diagonal
				// y la cantidad de aristas del vertice no supere al grado dado
				if (this.nodos[i][j] == 0 && i != j && vectorParticiones[j] != vectorParticiones[i]) {
					this.nodos[i][j] = 1;
					this.nodos[j][i] = 1;
					this.nodos[cantNodos - 1 - i][cantNodos - 1 - j] = 1;
					this.nodos[cantNodos - 1 - j][cantNodos - 1 - i] = 1;
				}
			}
		}

		return this;
	}

	public int calcularMaxNroAristas(int cantNodos) {
		return (cantNodos * (cantNodos - 1)) / 2;
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < this.nodos.length; i++) {
			for (int j = 0; j < this.nodos.length; j++) {
				str += "[" + this.nodos[i][j] + "]";
			}
			str += "\n";
		}
		return str;
	}

	int randomWithRange(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	int getCantidadAristas(int arista) {
		int ret = 0;
		for (int i = 0; i < this.nodos.length; i++) {
			if (this.nodos[arista][i] == 1)
				ret++;
		}
		return ret;
	}

	public void resolverGrafoPorSecuencialAleatorio(int cantNodos, int cantParticiones) {
		this.generarGrafoNPartito(cantNodos, cantParticiones);

		vectorVertices = new int[cantNodos];
		boolean coloreado = false;

		for (int i = 0; i < cantNodos; i++) {
			vectorVertices[i] = 0;
		}

		vectorVertices[0] = 1;

		for (int i = 1; i < cantNodos; i++) {
			for (int j = 0; j < cantNodos; j++) {
				if (i != j && nodos[i][j] == 1 && !coloreado) {
					if(vectorVertices[i] <= vectorVertices[j]) {
						vectorVertices[i] = this.getMinColor()+1;
					} else {
						vectorVertices[i] = vectorVertices[j];
					}
					
					coloreado = true;
				}
			}
			coloreado = false;
		}
	}

	public String getVectorColoreo() {
		String str = "";
		for (int i = 0; i < vectorVertices.length; i++) {
			str += "Nodo: " + (i + 1) + " Color: " + vectorVertices[i] + " \n";
		}

		return str;
	}
	
	public int getMinColor() {
		int min=999;
		for(int i=0; i<vectorVertices.length; i++) {
			if(min>vectorVertices[i])
				min = vectorVertices[i];
		}
		return min;
			
	}
}
