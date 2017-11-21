package app;

import java.util.Arrays;

public class Grafo {
	private int[][] nodos;

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
				
		for(int i=0; i<cantNodos; i++) {
			for(int j=0; j<cantNodos;j++) {
				if (this.nodos[i][j] == 0 && i != j && adyacencia > this.randomWithRange(1, 100)) {
					this.nodos[i][j] = 1;
					this.nodos[j][i] = 1;
					this.nodos[cantNodos-1-i][cantNodos-1-j]=1;
					this.nodos[cantNodos-1-j][cantNodos-1-i]=1;
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
		
		for(int i=0; i<cantNodos; i++) {
			for(int j=0; j<cantNodos;j++) {
				if (this.nodos[i][j] == 0 && i != j && getCantidadAristas(i) < grado) {
					this.nodos[i][j] = 1;
					this.nodos[j][i] = 1;
					this.nodos[cantNodos-1-i][cantNodos-1-j]=1;
					this.nodos[cantNodos-1-j][cantNodos-1-i]=1;
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
}
