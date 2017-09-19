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
        int cont = 1;
        if(n == 0){
            return 1;
        }
        for(int i = 1; i <= n; i++){
            cont = cont * i;
        }
        return cont;
    }
    
    private double combinatoria(int n, int k) {
    	return factorial(n)/(factorial(k)*(factorial(n-k)));
    }
    
    public double obtenerCoeficiente(int k) {
    	return combinatoria(this.n,k) * Math.pow(a, k) * Math.pow(b, this.n-k);
    }
    
    public double[] obtenerBinomio(){
    	double[] resultado= new double[this.n + 1];
    	
    	for(int i=0;i<=this.n;i++) {
    		resultado[i]= this.obtenerCoeficiente(n-i);
    	}
    	
    	return resultado;
    }
    
    public static void main(String args[]) {
        //BinomioDeNewton bi = new BinomioDeNewton(3,2,2);
    	BinomioDeNewton bi = new BinomioDeNewton(1,-3,5);
        //bi.mostratTodosLosTerminos();
        //System.out.println(bi.obtenerCoeficiente(2));
        
        double[] expandido = bi.obtenerBinomio();
        
        for(int i=0;i<expandido.length;i++) {
        	System.out.println(expandido[i]);
        }
    } 
	
}
