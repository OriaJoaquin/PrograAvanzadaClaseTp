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
	
	public double evaluarProgDinamica(double x ) { //O(n)
		double potenciaCalculada = 1;
	    double resultado = this.coeficientes[this.grado];
	    
	    for(int i=this.grado-1;i>=0;i--) {
	    	potenciaCalculada*=x;
	    	resultado+=(this.coeficientes[i]* potenciaCalculada);
	    }
	    
		return resultado;
	}
	
	public double evaluarMejorada(double x) { //O(n)
		double resultado=0;
		
		//Math.pow(a, b) complejidad o(1)
		for(int i=0;i < this.coeficientes.length;i++) {
			resultado+= this.coeficientes[i] * Math.pow(x, this.grado - i);
		}
		
		return resultado;
	}
	
	public double evaluarHorner(double x) { //O(n)
        double result = 0;
        for (int i = this.coeficientes.length - 1; i >= 0; i--)
            result = this.coeficientes[i] + (x * result);
        return result;

	}

	public static void main(String[] args) {
        
		int i;
		long time_start,time_end;
		Polinomio [] vecPolinomio = new Polinomio[10];

		vecPolinomio[0] = new Polinomio(1, new double[]{2});
		vecPolinomio[1] = new Polinomio(2, new double[]{2,5});
		vecPolinomio[2] = new Polinomio(3, new double[]{2,5,2});
		vecPolinomio[3] = new Polinomio(4, new double[]{2,5,2,6});
		vecPolinomio[4] = new Polinomio(5, new double[]{2,5,2,6,8});
		vecPolinomio[5] = new Polinomio(6, new double[]{2,5,2,6,8,3});
		vecPolinomio[6] = new Polinomio(7, new double[]{2,5,2,6,8,3,7});
		vecPolinomio[7] = new Polinomio(8, new double[]{2,5,2,6,8,3,7,9});
		vecPolinomio[8] = new Polinomio(9, new double[]{2,5,2,6,8,3,7,9,0});
		vecPolinomio[9] = new Polinomio(10, new double[]{2,5,2,6,8,3,7,9,0,1});

		for(i=0;i<vecPolinomio.length;i++) {
			
			time_start= System.nanoTime();
			vecPolinomio[i].evaluarMSucesivas(0);
			time_end = System.nanoTime();
			System.out.println("La tarea de Ejecución MSucesivas ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
			
			time_start= System.nanoTime();
			vecPolinomio[i].evaluarRecursiva(0);
			time_end = System.nanoTime();
			System.out.println("La tarea de Ejecución Recursiva ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
			
			time_start= System.nanoTime();
			vecPolinomio[i].evaluarRecursivaPar(0);
			time_end = System.nanoTime();
			System.out.println("La tarea de Ejecución RecursivaPar ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
			
			time_start= System.nanoTime();
			vecPolinomio[i].evaluarMejorada(0);
			time_end = System.nanoTime();
			System.out.println("La tarea de Ejecución Mejorada ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
			
			/*time_start= System.nanoTime();
			vecPolinomio[i].evaluarProgDinamica(0);
			time_end = System.nanoTime();
			System.out.println("La tarea de Ejecución ProgDinamica ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
			*/
			System.out.println("===============================================================================");
		}
		
    }
	
}
