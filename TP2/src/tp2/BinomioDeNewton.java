package tp2;

public class BinomioDeNewton {
	
	private int n;
    private double a;
    private double b;
    
    public BinomioDeNewton(double a, double b, int n){
        this.n = n;
        this.a = a;
        this.b = b;
    }
    
    private double factorial(int n){
        double cont = 1;
        if(n == 0){
            return 1;
        }
        for(int i = 1; i <= n; i++){
            cont *= i;
        }
        return cont;
    }
    
    private double factorialStirling(int n){
        if(n < 2){
            return 1;
        }
        return Math.sqrt(2*Math.PI*n)*Math.pow(n/Math.E, n);
    }
    
    private double combinatoria(int n, int k) {
    	return factorial(n)/(factorial(k)*(factorial(n-k)));
    }
    
    private double combinatoriaStirling(int n, int k) {
    	return factorialStirling(n)/(factorialStirling(k)*(factorialStirling(n-k)));
    }
    
    public double obtenerCoeficiente(int k) {
    	return combinatoria(this.n,k) * Math.pow(a, k) * Math.pow(b, this.n-k);
    }
    
    public double obtenerCoeficienteStirling(int k) {
    	return combinatoriaStirling(this.n,k) * Math.pow(a, k) * Math.pow(b, this.n-k);
    }
    
    public double[] obtenerPolinomio(){
    	double[] resultado= new double[this.n + 1];
    	
    	for(int i=0;i<=this.n;i++) {
    		resultado[i]= this.obtenerCoeficiente(n-i);
    	}
    	
    	return resultado;
    }
    
    public double[] obtenerPolinomioStirling(){
    	double[] resultado= new double[this.n + 1];
    	
    	for(int i=0;i<=this.n;i++) {
    		resultado[i]= this.obtenerCoeficienteStirling(n-i);
    	}
    	
    	return resultado;
    }
	
	public static void main(String[] args) {
        
		int i;
		long time_start,time_end;
		BinomioDeNewton [] vecBinomioDeNewton = new BinomioDeNewton[17];

		vecBinomioDeNewton[0] = new BinomioDeNewton(4,7,3);
		vecBinomioDeNewton[1] = new BinomioDeNewton(4,7,4);
		vecBinomioDeNewton[2] = new BinomioDeNewton(4,7,5);
		vecBinomioDeNewton[3] = new BinomioDeNewton(4,7,6);
		vecBinomioDeNewton[4] = new BinomioDeNewton(4,7,7);
		vecBinomioDeNewton[5] = new BinomioDeNewton(4,7,8);
		vecBinomioDeNewton[6] = new BinomioDeNewton(4,7,9);
		vecBinomioDeNewton[7] = new BinomioDeNewton(4,7,10);
		vecBinomioDeNewton[8] = new BinomioDeNewton(4,7,20);
		vecBinomioDeNewton[9] = new BinomioDeNewton(4,7,30);
		vecBinomioDeNewton[10] = new BinomioDeNewton(4,7,40);
		vecBinomioDeNewton[11] = new BinomioDeNewton(4,7,50);
		vecBinomioDeNewton[12] = new BinomioDeNewton(4,7,60);
		vecBinomioDeNewton[13] = new BinomioDeNewton(4,7,70);
		vecBinomioDeNewton[14] = new BinomioDeNewton(4,7,80);
		vecBinomioDeNewton[15] = new BinomioDeNewton(4,7,90);
		vecBinomioDeNewton[16] = new BinomioDeNewton(4,7,200);
		
		for(i=0;i<vecBinomioDeNewton.length;i++) {
			System.out.println("Grado del Binomio de Newton:" + vecBinomioDeNewton[i].n);
			
			time_start= System.nanoTime();
			vecBinomioDeNewton[i].obtenerCoeficiente(0);
			time_end = System.nanoTime();
			System.out.println("La tarea de Ejecución con Factorial normal ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
			
			time_start= System.nanoTime();
			vecBinomioDeNewton[i].obtenerCoeficienteStirling(0);
			time_end = System.nanoTime();
			System.out.println("La tarea de Ejecución con Factorial Stirling ha tomado "+ ( time_end - time_start ) +" nanosegundos.");
			
			System.out.println("===============================================================================");
		}
		
    }
	
}
