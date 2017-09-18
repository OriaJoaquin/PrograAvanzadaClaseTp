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
    
    public double factorial(int n){
        int cont = 1;
        if(n == 0){
            return 1;
        }
        for(int i = 1; i <= n; i++){
            cont = cont * i;
        }
        return cont;
    }
    
    
    public void mostrarTermino(int k){
        double termino = this.factorial(n)/(this.factorial(k)*this.factorial(n-k));
        System.out.println(termino +"("+this.a+"x)^"+(n-k)+" "+this.b+"^"+(k));
    }
     
    public double valorParaUn(double x){
    	double valor = 0;
    	double termino;
    	for(int k=0;k<n;k++){
    		termino = this.factorial(n)/(this.factorial(k)*this.factorial(n-k));
    		valor += termino*Math.pow(this.a*x,n-k)*Math.pow(this.b, k);
    	}
    	return valor;
    }
    
    public double[] expandirBinomio() {
    	
    	return new double[4];
    }
    
    public void mostratTodosLosTerminos(){
        for(int  i = 0;i<=n;i++){
            this.mostrarTermino(i);
        }
    }
    public static void main(String args[]) {
        BinomioDeNewton bi = new BinomioDeNewton(1,-3,5);
        //bi.mostratTodosLosTerminos();
        System.out.println(bi.valorParaUn(2));
    } 
	
}
