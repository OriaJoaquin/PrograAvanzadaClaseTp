package tp2;

public class Polinomio {
	private int grado;
	private double [ ] coeficientes;
	
	public Polinomio(int grado, double[] coeficientes) {
		this.grado=grado;
		this.coeficientes=coeficientes;
	}
	
	public double evaluarMSucesivas(double x) {
		double resultado=0;
		
		
		for(int i=0;i < coeficientes.length;i++) {
			double resultadoParcial=1;
			
			for(int j=0;j< this.grado-i;j++) {
				resultadoParcial*=x;
			}
			
			resultado+=(this.coeficientes[i]*resultadoParcial);
		}
		
		return resultado;
	}
	
	public double evaluarRecursiva(double x) {
		double resultado=0;
		
		for(int i=0;i < coeficientes.length;i++) {
			
			double resultadoParcial = potenciaRecursiva(x, this.grado - i);
			
			resultado+=(this.coeficientes[i]*resultadoParcial);
		}
		
		return resultado;
	}
	
	public double evaluarRecursivaPar(double x ) {
		double resultado=0;
		
		for(int i=0;i < coeficientes.length;i++) {
			
			double resultadoParcial;
			
			if((this.grado - i)%2==1)
				resultadoParcial= potenciaRecursiva(x, this.grado - i);
			else {
				resultadoParcial= potenciaRecursiva(x, (this.grado - i)/2);
				resultadoParcial*=resultadoParcial;
			}
			resultado+=(this.coeficientes[i]*resultadoParcial);
		}
		
		return resultado;
	}
	
	private double potenciaRecursiva(double x, int n) {
		if(n>=1)
			return x * potenciaRecursiva(x, n-1);
		return 1;
	}
	
	public double evaluarProgDinamica(double x ) {
		double potenciaCalculada = 1;
	    double resultado = this.coeficientes[this.grado];
	    
	    for(int i=this.grado-1;i>=0;i--) {
	    	potenciaCalculada*=x;
	    	resultado+=(this.coeficientes[i]* potenciaCalculada);
	    }
	    
		return resultado;
	}
	
	public double evaluarMejorada(double x) {
		double resultado=0;
		
		//Math.pow(a, b) complejidad o(1)
		for(int i=0;i < this.coeficientes.length;i++) {
			resultado+= this.coeficientes[i] * Math.pow(x, this.grado - i);
		}
		
		return resultado;
	}
	
	public double evaluarHorner(double x) {
        double result = 0;
        for (int i = this.coeficientes.length - 1; i >= 0; i--)
            result = this.coeficientes[i] + (x * result);
        return result;

	}

}
