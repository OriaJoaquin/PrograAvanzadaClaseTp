package tp2;

public class BinomioDeNewton {
	
	private int n;
    private double a;
    private double b;
    
    public  BinomioDeNewton(double a, double b, int n){
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
		BinomioDeNewton [] vecBinomioDeNewton = new BinomioDeNewton[12];

		vecBinomioDeNewton[0] = new BinomioDeNewton(1,1,2);//x^2+2x+1
		vecBinomioDeNewton[1] =  new BinomioDeNewton(1,-3,5);//x^5 - 15x^4 + 90x^3 - 270x^2 + 405x - 243
		vecBinomioDeNewton[2] = new BinomioDeNewton(3,2,2);// 9x^2 + 12x +4
		vecBinomioDeNewton[3] = new BinomioDeNewton(2,-3,7);  // 128 x^7 - 1344 x^6 + 6048 x^5 - 15120 x^4 + 22680 x^3 - 20412 x^2 + 10206 x - 2187
		vecBinomioDeNewton[4] = new BinomioDeNewton(-1,-4,9); // -x^9 - 36 x^8 - 576 x^7 - 5376 x^6 - 32256 x^5 - 129024 x^4 - 344064 x^3 - 589824 x^2 - 589824 x - 262144
		vecBinomioDeNewton[5] = new BinomioDeNewton(-3,2,15); //-14348907 x^15 + 143489070 x^14 - 669615660 x^13 + 1934445240 x^12 - 3868890480 x^11 + 5674372704 x^10 - 6304858560 x^9 + 5404164480 x^8 - 3602776320 x^7 + 1868106240 x^6 - 747242496 x^5 + 226437120 x^4 - 50319360 x^3 + 7741440 x^2 - 737280 x + 32768
		vecBinomioDeNewton[6] = new BinomioDeNewton(-4,3,17);
		vecBinomioDeNewton[7] = new BinomioDeNewton(-4,3,19);
		vecBinomioDeNewton[8] = new BinomioDeNewton(-4,3,25);
		vecBinomioDeNewton[9] = new BinomioDeNewton(-4,3,30);
		vecBinomioDeNewton[10] = new BinomioDeNewton(-4,3,35);
		vecBinomioDeNewton[11] = new BinomioDeNewton(11,6,50);

		
		for(i=0;i<vecBinomioDeNewton.length;i++) {
			
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
