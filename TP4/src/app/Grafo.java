package app;

public class Grafo {
	private int[][] nodos;

	public Grafo generarGrafoAleatorioProbabilidad(final int cantNodos, final double probabilidad) {

		this.nodos = new int[cantNodos][cantNodos];

		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				double nroAleatorio = Math.random();

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
	
	public Grafo generarGrafoRegular(final int cantNodos, final int grado) {
		this.nodos = new int[cantNodos][cantNodos];
		
		if(grado > (cantNodos-1)) {
			return null;	
		}
		
	}

	public int calcularMaxNroAristas(int cantNodos) {
		return (cantNodos * (cantNodos - 1)) / 2;
	}

}
