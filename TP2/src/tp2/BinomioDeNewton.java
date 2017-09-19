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
	
}
